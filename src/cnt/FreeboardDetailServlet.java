package cnt;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.MemberScoringBiz;

@WebServlet("/freeboardDetail")
public class FreeboardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FreeboardDetailServlet() {
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
		
		int score = 0;
		
		String boardReRef = request.getParameter("freeboardReRef");
		String freeboardContext = request.getParameter("freeboardContext");					
		String boardId = request.getParameter("boardId");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		String loginId = (String) session.getAttribute("loginId");
		request.setAttribute("freeboardContext", freeboardContext);
		request.setAttribute("boardReRef", boardReRef);
		request.setAttribute("boardId", boardId);		
		request.setAttribute("boardNo", boardNo);
		
		MemberScoringBiz biz = new MemberScoringBiz();
		
		try {                                                      // 점수 갱신해주는 Logic
			score = biz.readScore(loginId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("score", score);    // 갱신된 점수를 설정해준다.
		
		RequestDispatcher rd = request.getRequestDispatcher("/freeboardDetail.jsp");

		rd.forward(request, response);
	}

}
