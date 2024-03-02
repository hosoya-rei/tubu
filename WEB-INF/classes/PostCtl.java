import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import beans.*;
import models.*;


@WebServlet("/postCtl")
public class PostCtl extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		String	action = null;
		String	forwardPath = "";

		request.setCharacterEncoding("UTF-8");
		action = request.getParameter("action");

		if (action == null)
			forwardPath = "WEB-INF/jsp/loginForm.jsp";
		if (action.equals("update") || action.equals("go")) {
			forwardPath = "WEB-INF/jsp/tubuMain.jsp";
		}
		if (action.equals("logout"))
			forwardPath = "WEB-INF/jsp/logout.jsp";

		RequestDispatcher disp = request.getRequestDispatcher(forwardPath);
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		String			text;
		String			forwardPath = "";
		User			usr;
		Tweet			tweet;
		ArrayList<Tweet>	tweets;

		request.setCharacterEncoding("UTF-8");
		text = request.getParameter("text");

		HttpSession session = request.getSession();
		ServletContext application = request.getServletContext();

		usr = (User)session.getAttribute("usr");
		tweet = new Tweet(usr,text);
		tweets = new ArrayList<Tweet>();
		tweets.add(tweet);
		application.setAttribute("tweets",tweets);

		forwardPath = "WEB-INF/jsp/tubuMain.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forwardPath);
		disp.forward(request, response);
	}
}
