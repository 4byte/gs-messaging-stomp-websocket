package com.example.messagingstompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.util.HtmlUtils;

@Controller("/")
public class GreetingController {

	@MessageMapping("/greeting")
	public BinaryMessage greeting2(WebSocketMessage<BinaryMessage> data) {
		System.out.println("RECEIVED!!");
		return data.getPayload();
	}

}
