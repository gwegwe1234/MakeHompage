package cnt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.DeleteFreeboardBiz;
import biz.MemberScoringBiz;

@WebServlet("/deleteContext")
public class DeleteFreeboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteFreeboardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginName") == null){
			return;
		}
		
		String boardId = request.getParameter("boardId");
		String loginId = (String) session.getAttribute("loginId");
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		System.out.println("게시글 번호 : " + boardNo);
		System.out.println("게시자 아이디 : " + boardId);
		int score = (int) session.getAttribute("score");
		
		if(!boardId.equals(loginId))
		{
			response.sendRedirect("/MakeHompage/index.jsp");
		}
		else
		{
			if(score > 0)
			{
				MemberScoringBiz biz = new MemberScoringBiz();
				try {
					score = biz.deleteScore(loginId);
					if(score == -5)
						score = 0;
					session.setAttribute("score", score);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			DeleteFreeboardBiz biz2 = new DeleteFreeboardBiz(); 
			
			try {
				biz2.DeleteFreeboard(boardNo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			response.sendRedirect("/MakeHompage/index.jsp");
		}
	}

}
