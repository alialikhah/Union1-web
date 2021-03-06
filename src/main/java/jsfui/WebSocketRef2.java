package jsfui;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/WebSocketRef2/{user1}")
public class WebSocketRef2 {
	/*
	 * static Set<Session> chatroomUsers=Collections.synchronizedSet(new
	 * HashSet<Session>()) ;
	 * 
	 * @OnOpen public void handleOpen(Session userSession,@PathParam("user1") String
	 * user){ //if(chatroomBean.getName().equals()) chatroomUsers.add(userSession);
	 * System.err.println(user); }
	 * 
	 * @OnMessage public void handleMessage(String message, Session userSession)
	 * throws IOException{ String username=(String)
	 * userSession.getUserProperties().get("username"); if(username==null){
	 * userSession.getUserProperties().put("username", message);
	 * userSession.getBasicRemote().sendText(buildJsonData("System",
	 * "you are connected as" + message)); }else{ Iterator<Session>
	 * iterator=chatroomUsers.iterator(); while (iterator.hasNext()) {
	 * iterator.next().getBasicRemote().sendText(buildJsonData(username, message));
	 * //iterator.next().getBasicRemote().sendText("{\"name\":\"ali\"}"); } } }
	 * 
	 * 
	 * @OnClose public void handleClose(Session userSession){
	 * chatroomUsers.remove(userSession); }
	 * 
	 * private String buildJsonData(String username,String message){ JsonObject
	 * jsonObject=Json.createObjectBuilder().add("messag", username + ":" +
	 * message).build(); StringWriter stringWriter=new StringWriter();
	 * try(JsonWriter jsonWriter=Json.createWriter(stringWriter)) {
	 * jsonWriter.write(jsonObject); } return stringWriter.toString(); }
	 */

	static Set<Session> chatroomUsers = Collections.synchronizedSet(new HashSet<Session>());

	@OnOpen
	public void handleOpen(Session userSession, @PathParam("user1") String user) {
		// if(chatroomBean.getName().equals())
		chatroomUsers.add(userSession);
		System.err.println(user);
	}

	@OnMessage
	public void handleMessage(String message, Session userSession) throws IOException {
		String username = (String) userSession.getUserProperties().get("username");
		if (username == null) {
			userSession.getUserProperties().put("username", message);
			userSession.getBasicRemote().sendText(buildJsonData("System", "you are connected as" + message));
		} else {
			Iterator<Session> iterator = chatroomUsers.iterator();
			while (iterator.hasNext()) {
				iterator.next().getBasicRemote().sendText(buildJsonData(username, message));
				// iterator.next().getBasicRemote().sendText("{\"name\":\"ali\"}");
			}
		}
	}

	@OnClose
	public void handleClose(Session userSession) {
		chatroomUsers.remove(userSession);
	}

	private String buildJsonData(@PathParam("user1") String username, String message) {
		JsonObject jsonObject = Json.createObjectBuilder().add("messag", username + ":" + message).build();
		StringWriter stringWriter = new StringWriter();
		try (JsonWriter jsonWriter = Json.createWriter(stringWriter)) {
			jsonWriter.write(jsonObject);
		}
		return stringWriter.toString();
	}

}
