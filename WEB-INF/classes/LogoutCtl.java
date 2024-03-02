import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import beans.*;
import models.*;


@WebServlet("/logoutCtl")
public class LogoutCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		String			action = null;
		String			forwardPath = "";
		HttpSession		session;
		ServletContext		application;
		User			user;

		request.setCharacterEncoding("UTF-8");
		action = request.getParameter("action");

		if (action == null)
			forwardPath = "WEB-INF/jsp/loginForm.jsp";
		if (action.equals("logout")) {
			forwardPath = "WEB-INF/jsp/loginForm.jsp";
			session = request.getSession();
			session.removeAttribute("usr");
		}

		RequestDispatcher disp = request.getRequestDispatcher(forwardPath);
		disp.forward(request, response);
	}

}
