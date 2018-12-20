package cnt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.MemberBiz;
import entity.MemberEntity;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "로그인서블릿", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");

		MemberEntity member = new MemberEntity();

		member.setMemberId(memberId);
		member.setMemberPw(memberPw);

		MemberBiz biz = new MemberBiz();
		try {
			member = biz.login(member);
			session.setAttribute("loginName", member.getMemberName());
			session.setAttribute("memberNo", member.getMemberNo());
			session.setAttribute("score", member.getMemberScore());
			session.setAttribute("loginId", member.getMemberId());
			response.sendRedirect("/MakeHompage/index.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
