package com.chat.chatroom.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.chat.chatroom.controller.ChatController;
import com.chat.chatroom.controller.ChatDTO;
import com.chat.chatroom.controller.ChatService;

@Component
public class SocketHandler extends TextWebSocketHandler {
	
	HashMap<String, WebSocketSession> sessionMap = new HashMap<>();
	
	@Autowired
	@Qualifier("chatServiceImpl")
	ChatService service;
	
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) {
		//send message
		String msg = message.getPayload();
		JSONObject obj = jsonToObjectParser(msg);
		ChatDTO dto = new ChatDTO();
		String result = "";
		if (obj.get("type").equals("img")) {
			dto.setUser_id((String) obj.get("user_id"));
			result = "img+" + dto.getUser_id();
		} else {
			dto.setChat_list_id((String) obj.get("chat_list_id"));
			dto.setUser_id((String) obj.get("user_id"));
			dto.setContent((String) obj.get("content"));
			dto.setType((String) obj.get("type"));
			int insertCount = service.insertChat(dto);
			result = "msgok";
		}
		for (String key : sessionMap.keySet()) {
			WebSocketSession wss = sessionMap.get(key);
			try {
				wss.sendMessage(new TextMessage(result));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//socket connect
		super.afterConnectionEstablished(session);
		sessionMap.put(session.getId(), session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//socket disconnect
		sessionMap.remove(session.getId());
		super.afterConnectionClosed(session, status);
	}
	
	private static JSONObject jsonToObjectParser(String jsonStr) {
		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(jsonStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
