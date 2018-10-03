/*package chat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

*//**
 * Servlet implementation class UserNameServlet
 *//*
@WebServlet("/UserNameServlet")
public class UserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("username");
		PrintWriter printWriter = response.getWriter();
		if (username != null)
			generateChatroomPage(printWriter, username, request);
		else
			generateUsernamePage(printWriter);
	}

	private void generateChatroomPage(PrintWriter printWriter, String username, HttpServletRequest request) {
		HttpSession session=request.getSession(true);
		String roomName=request.getParameter("roomSelect");
		if((roomName!=null)&&(roomName.equals("newRoomOption")))
			roomName=request.getParameter("newRoomName");
		session.setAttribute("username", username);
		printWriter.println("<!DOCTYPE html>");
		printWriter.println("<html>");
		printWriter.println("<head><title>chatroom</title>");
		printWriter.println(" <meta charset=\"UTF-8\"> ");
		printWriter.println("</head>");
		printWriter.println("<body>");
		printWriter.println("<mark>User: "+username+" | Room: " +roomName+"</mark><br/>");
		printWriter.println("<textarea id=\"messagesTextArea\" readonly=\"readonly\" rows=\"10\" cols=\"45\"></textarea><br/> ");
		printWriter.println("<input type=\"button\" value=\"Send\" onclick=\"sendMessage();\" />");
		printWriter.println("<script>");
		printWriter.println("var websocket = new WebSocket(\"ws://\""+"+document.location.host+"
		+"document.location.pathname+"+"\"chatroomServerEndpoint/"+roomName+"\")");
		printWriter.println("websocket.onmessage=function processMessage(message) {");
		printWriter.println("var jsonData = JSON.parse(message.data);");
		printWriter.println("if(jsonData.message !=null) messagesTextArea.value += jsonData.message + \"\\n\";");
		printWriter.println("}");
		printWriter.println("function sendMessage() {");
		printWriter.println("websocket.send(messageText.value);");
		printWriter.println("messageText.value = \"\";");
		printWriter.println("}");
		printWriter.println("</script>");
		printWriter.println("</body>");
		printWriter.println("</html>");

	}

	private void generateUsernamePage(PrintWriter printWriter) {
		printWriter.println("<!DOCTYPE html>");
		printWriter.println("<html>");
		printWriter.println("<head><title>chatroom</title>");
		printWriter.println(" <meta charset=\"UTF-8\"> ");
		printWriter.println("</head>");
		printWriter.println("<body>");
		printWriter.println("<form name=\"submitForm\">");
		printWriter.println("<mark>please select a room:</mark><br/>");
		printWriter.println("<select id=\"roomSelect\" name=\"roomSelect\" onchange=\"handleNewRoom()\">");
		printWriter.println("<option value=\"room1\">Room 1</option>");
		printWriter.println("<option value=\"room2\">Room 2</option>");
		printWriter.println("<option value=\"room3\">Room 3</option>");
		printWriter.println("<option value=\"newRoomOption\">New Room<option>");
		printWriter.println("</select>");
		printWriter.println("<br/>");
		printWriter.println("<div id=\"newRoomDivId\" style=\"display:none\">");
		printWriter.println("<mark>Please enter a room name:</mark><br/>");
		printWriter.println("<input type=\"text\" name=\"newRoomName\" size=\"20\" />");
		printWriter.println("</div>");
		printWriter.println("<mark>Please suply a UserName:</mark><br/>");
		printWriter.println("<input type=\"text\" name=\"username\" size=\"20\" />");
		printWriter.println("<input type=\"submit\" value=\"Enter\" />");
		printWriter.println("</form>");
		printWriter.println("<script>");
		printWriter.println("function handleNewRoom(){");
		printWriter.println("var roomSelect = document.getElementById(\"roomSelect\");");
		printWriter.println("var roomSelectOption = roomSelect.options[roomSelect.selectedIndex].value;");
		printWriter.println("if(roomSelectOption=='newRoomOption')"
				+ "document.getElementById(\"newRoomDivId\").style.display='block';");
		printWriter.println("else document.getElementById(\"newRoomDivId\").style.display='none';");
		printWriter.println("}");
		printWriter.println("window.onload=function() {document.submitForm.action = submitAction();}");
		printWriter.println("function submitAction(){return document.location.pathname;}");
		printWriter.println("</script>");
		printWriter.println("</body>");
		printWriter.println("</html>");

	}

}
*/