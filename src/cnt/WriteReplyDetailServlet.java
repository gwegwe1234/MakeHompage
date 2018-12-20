package cnt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.MemberScoringBiz;
import biz.WriteReplyBiz;
import entity.FreeboardEntity;

/**
 * Servlet implementation class WriteReplyDetailServlet
 */
@WebServlet("/writeReplyDetail")
public class WriteReplyDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WriteReplyDetailServlet() {
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
		
		request.setCharacterEncoding("utf-8");

		List<FreeboardEntity> freeboardList = (List<FreeboardEntity>) session.getAttribute("sessionFreeboardlist");
		
		int writeNo = freeboardList.size() + 1;
		
		String replySubject = request.getParameter("replySubject");
		String replyContext = request.getParameter("replyContext");
		
		int boardReRef = Integer.parseInt(request.getParameter("boardReRef"));
		
		String memberId = (String)session.getAttribute("loginId");
		
		FreeboardEntity reply = new FreeboardEntity();
		reply.setBoardContext(replyContext);
		reply.setBoardId(memberId);
		reply.setBoardNo(writeNo);
		reply.setBoardSubject(replySubject);
		reply.setBoardReRef(boardReRef);
		
		WriteReplyBiz biz = new WriteReplyBiz();
		
		MemberScoringBiz biz2 = new MemberScoringBiz();
		
		try{
			biz.WriteReply(reply);
			score = biz2.writeScore(memberId);
			session.setAttribute("score", score);
			response.sendRedirect("/MakeHompage/index.jsp");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
