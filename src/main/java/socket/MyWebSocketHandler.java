package socket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class MyWebSocketHandler implements WebSocketHandler
{

	public static final Map<String, WebSocketSession> userSocketSessionMap;  
	  
    static {  
        userSocketSessionMap = new HashMap<String, WebSocketSession>();  
    }  
    
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception
	{
		 System.out.println("Websocket:" + session.getId() + "已经关闭");  
	        Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap  
	                .entrySet().iterator();  
	        // 移除Socket会话  
	        while (it.hasNext()) {  
	            Entry<String, WebSocketSession> entry = it.next();  
	            if (entry.getValue().getId().equals(session.getId())) {  
	                userSocketSessionMap.remove(entry.getKey());  
	                System.out.println("Socket会话已经移除:用户ID" + entry.getKey());  
	                break;  
	            }  
	        }  
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception
	{
		String username=(String)session.getAttributes().get("username");
		if (userSocketSessionMap.get(username)==null)
		{
			userSocketSessionMap.put(username, session);
			
		}
	}

	@Override
	public void handleMessage(WebSocketSession arg0, WebSocketMessage<?> message) throws Exception
	{
		// TODO 自动生成的方法存根
		
		
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception
	{
		if (session.isOpen()) {  
            session.close();  
        }  
        Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap  
                .entrySet().iterator();  
        // 移除Socket会话  
        while (it.hasNext()) {  
            Entry<String, WebSocketSession> entry = it.next();  
            if (entry.getValue().getId().equals(session.getId())) {  
                userSocketSessionMap.remove(entry.getKey());  
                System.out.println("Socket会话已经移除:用户ID" + entry.getKey());  
                break;  
            }  
        }  
		
	}

	@Override
	public boolean supportsPartialMessages()
	{
		// TODO 自动生成的方法存根
		return false;
	}

	public void broadcast(final TextMessage message) throws IOException {  
        Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap  
                .entrySet().iterator();  
  
        // 多线程群发  
        while (it.hasNext()) {  
  
            final Entry<String, WebSocketSession> entry = it.next();  
  
            if (entry.getValue().isOpen()) {  
                new Thread(new Runnable() {  
  
                    public void run() {  
                        try {  
                            if (entry.getValue().isOpen()) {  
                                entry.getValue().sendMessage(message);  
                            }  
                        } catch (IOException e) {  
                            e.printStackTrace();  
                        }  
                    }  
  
                }).start();  
            }  
  
        }  
    }  
	public void sendMessageToJsp(final TextMessage message,String type) throws IOException {  
        Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap  
                .entrySet().iterator();  
  
        // 多线程群发  
        while (it.hasNext()) {  
  
            final Entry<String, WebSocketSession> entry = it.next();  
            if (entry.getValue().isOpen() && entry.getKey().contains(type)) {  
                new Thread(new Runnable() {  
  
                    public void run() {  
                        try {  
                            if (entry.getValue().isOpen()) {  
                                entry.getValue().sendMessage(message);  
                            }  
                        } catch (IOException e) {  
                            e.printStackTrace();  
                        }  
                    }  
  
                }).start();  
            }  
  
        }  
    }  
}
