package com.example.messagingstompwebsocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfigDefault implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new BinaryWebSocketHandler(){
			@Override
			public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
				super.handleMessage(session, message);
				System.out.println("handleMessage");
			}

			@Override
			protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
				super.handleBinaryMessage(session, message);
				System.out.println("handleBinaryMessage");
			}

			@Override
			public void afterConnectionEstablished(WebSocketSession session) throws Exception {
				super.afterConnectionEstablished(session);
				System.out.println("afterConnectionEstablished");
			}
		},"/greeting");
	}
}