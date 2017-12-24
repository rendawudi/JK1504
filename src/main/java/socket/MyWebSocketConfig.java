package socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebMvc  
@EnableWebSocket  
public class MyWebSocketConfig implements WebSocketConfigurer
{
	
	@Autowired
	private MyWebSocketHandler handler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry)
	{
		registry.addHandler(handler, "/ws").addInterceptors(new HandShake());
	}
	
}
