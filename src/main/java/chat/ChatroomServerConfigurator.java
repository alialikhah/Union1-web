/*package chat;
import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.*;
public class ChatroomServerConfigurator extends ServerEndpointConfig.Configurator{
public void modifyHandShake(ServerEndpointConfig sec,HandshakeRequest request,HandshakeResponse response) {
	sec.getUserProperties().put("username",(String)((HttpSession)request.getHttpSession()).getAttribute("username")); 
}
}
*/