package cnt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/writeReply")
public class WriteReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WriteReplyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("loginName") == null) {
			return;
		}

		String boardReRef = request.getParameter("boardReRef");
		
		try {
			request.setAttribute("boardReRef", boardReRef);
			RequestDispatcher rd = request.getRequestDispatcher("/writeReply.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
