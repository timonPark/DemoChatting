package me.park.chatting.demochatting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // "/topic"으로 시작하는 메시지는 메시지 브로커가 처리
        config.enableSimpleBroker("/topic");
        // 클라이언트에서 "/app"으로 시작하는 메시지는 메시지 처리 메서드로 라우팅
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // "/ws" 엔드포인트로 클라이언트가 WebSocket에 연결
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }
}
