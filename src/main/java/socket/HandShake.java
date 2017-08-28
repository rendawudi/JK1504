package socket;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import com.jk1504.fuzhu.Tokenmg;
import com.jk1504.fuzhu.redisdao;


public class HandShake	implements	HandshakeInterceptor
{

	@Autowired
	private redisdao redis;
	
	@Override
	public void afterHandshake(ServerHttpRequest arg0, ServerHttpResponse arg1, WebSocketHandler arg2, Exception arg3)
	{
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception
	{
		String sessionid =((ServletServerHttpRequest)request).getServletRequest().getParameter("sessionid");
		 if (sessionid==null)
			{
				return false;
			}
	        Integer userId=0;
	        String username="";
		 userId = Tokenmg.getUserdbId((HttpServletRequest)request);  
	        username=Tokenmg.getUsername((HttpServletRequest)request);
	       if (sessionid!=null&&username!=null&userId!=null)
		{
			 if (redis.pdxg(sessionid, username)&&!userId.equals(0))
			{
				 attributes.put("username", username);
				return true;
			}
		}
		return false;
	}
		
}
