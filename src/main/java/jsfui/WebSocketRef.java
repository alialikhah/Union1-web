package jsfui;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/muend")
public class WebSocketRef {

	
	@OnOpen
	public void handleOpen(){
		System.err.println("client is now connected.....");
	}
	@OnMessage
	public String handleMessage(String message) throws WsExcep{
		System.err.println("client : " + message);
		return "in az sever";
	} 
	@OnClose
	public void handleClase(){
		System.err.println("client is now disconnected.....");
	}
	@OnError
	public void handleError(Throwable t){
		System.err.println("an error ocurred........");
	}
	
	
}
