package cnt;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.MemberScoringBiz;
import biz.WriteFreeboardBiz;
import entity.FreeboardEntity;

/**
 * Servlet implementation class WriteFreeboardServlet
 */
@WebServlet("/writeFreeboard")
public class WriteFreeboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteFreeboardServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("loginName") == null) {
			return;
		}
		
		request.setCharacterEncoding("utf-8");
		
		int score = 0;
		
		List<FreeboardEntity> freeboardList = (List<FreeboardEntity>)session.getAttribute("sessionFreeboardlist");				
		
		String freeboardSubject = request.getParameter("freeboardSubject");
		String freeboardContext = request.getParameter("freeboardContext");
		
		int writeNo = freeboardList.size() + 1;
		String memberId = (String)session.getAttribute("loginId");
		
		FreeboardEntity entity = new FreeboardEntity();
		entity.setBoardContext(freeboardContext);
		entity.setBoardId(memberId);
		entity.setBoardNo(writeNo);
		entity.setBoardSubject(freeboardSubject);
		
		WriteFreeboardBiz biz = new WriteFreeboardBiz();
		
		MemberScoringBiz biz2 = new MemberScoringBiz();
		
		try {
			biz.WriteFreeboard(entity);
			score = biz2.writeScore(memberId);
			session.setAttribute("score", score);
			response.sendRedirect("/MakeHompage/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}

}
