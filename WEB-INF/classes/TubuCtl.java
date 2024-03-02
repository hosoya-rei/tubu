import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import beans.*;
import models.*;


@WebServlet("/tubuCtl")
public class TubuCtl extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		String	action = null;
		String	forwardPath = "";

		request.setCharacterEncoding("UTF-8");
		action = request.getParameter("action");

		if (action == null || action.equals("back")) {
			forwardPath = "WEB-INF/jsp/loginForm.jsp";
		}else if (action.equals("go")) {
			forwardPath = "WEB-INF/jsp/tubuMain.jsp";
		}else {
			forwardPath = "WEB-INF/jsp/loginForm.jsp";
		}
		RequestDispatcher disp = request.getRequestDispatcher(forwardPath);
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		String		name = null;
		String		pwd = null;
		String		forwardPath = "";
		ArrayList<User>	usrs;
		User		newUsr;

		request.setCharacterEncoding("UTF-8");
		name = request.getParameter("name");
		pwd = request.getParameter("pwd");

		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();

		newUsr = new User(name, pwd);
		session.setAttribute("usr",newUsr);
		usrs = (ArrayList<User>)application.getAttribute("usrs");

		if (usrs == null) {
			usrs = new ArrayList<User>();
			usrs.add(newUsr);
			application.setAttribute("usrs",usrs);
			forwardPath = "WEB-INF/jsp/loginSuccess.jsp";
		}else {
			if (LoginCheck.checkName(usrs,newUsr)) {
				//名前がある→パスワードチェック。
				if (LoginCheck.execute(usrs,newUsr)) {
					forwardPath = "WEB-INF/jsp/loginSuccess.jsp";
				}else {
					forwardPath = "WEB-INF/jsp/loginFailure.jsp";
				}
			}else {
				//名前がない→即登録。
				usrs.add(newUsr);
				application.setAttribute("usrs",usrs);
				forwardPath = "WEB-INF/jsp/loginSuccess.jsp";
			}
		}
		RequestDispatcher disp = request.getRequestDispatcher(forwardPath);
		disp.forward(request, response);
	}
}
