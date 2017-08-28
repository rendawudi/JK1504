package socket;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Component  
@EnableWebMvc  
@EnableWebSocket  
public class MyWebSocketConfig implements WebSocketConfigurer
{
	@Resource
	private MyWebSocketHandler handler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry)
	{
		registry.addHandler(handler, "/ws").addInterceptors(new HandShake());
	}
	
}
