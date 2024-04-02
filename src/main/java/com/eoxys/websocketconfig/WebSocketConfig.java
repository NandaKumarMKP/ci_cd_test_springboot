package com.eoxys.websocketconfig;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//	@Override
//	public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
//		stompEndpointRegistry.addEndpoint("/websocket").setAllowedOrigins("*");
////		.withSockJS();
//	}
//
//	@Override
//	public void configureMessageBroker(MessageBrokerRegistry registry) {
//		registry.enableSimpleBroker("/topic/message");
////		registry.setApplicationDestinationPrefixes("/app");
//	}
//}

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
//	private TaskScheduler messageBrokerTaskScheduler;

//	@Autowired
//	public void setMessageBrokerTaskScheduler(@Lazy TaskScheduler taskScheduler) {
//		this.messageBrokerTaskScheduler = taskScheduler;
//	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
//		.setHeartbeatValue(new long[] {10000, 20000})
//		.setTaskScheduler(this.messageBrokerTaskScheduler);
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/mywebsocket").setAllowedOriginPatterns("*");
	}

}