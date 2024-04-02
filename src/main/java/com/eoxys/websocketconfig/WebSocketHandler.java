package com.eoxys.websocketconfig;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
    
    private List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	System.out.println("session"+session);
        sessions.add(session);
    	System.out.println("session"+sessions.size());
    }
    
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Handle incoming messages from clients if needed
    }
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        System.out.println("sessions in remove"+sessions.size());
    }
    
    // Method to broadcast messages to all connected clients
    public void broadcastMessage(String message) throws IOException {
        TextMessage textMessage = new TextMessage(message);
    	System.out.println("textMessage"+textMessage+sessions.size());
        for (WebSocketSession session : sessions) {
        	System.out.println("textMessage in side"+textMessage);
            session.sendMessage(textMessage);
        }
    }
}
