package cnt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.FreeboardBiz;
import entity.FreeboardEntity;

/**
 * Servlet implementation class FreeboardServlet
 */
@WebServlet("/freeboard")
public class FreeboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeboardServlet() {
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
		
		List<FreeboardEntity> freeboardlist = new ArrayList<FreeboardEntity>();
		FreeboardBiz biz = new FreeboardBiz();
		try {
			freeboardlist = biz.showFreeboardList();
			
			session.setAttribute("sessionFreeboardlist", freeboardlist);
			request.setAttribute("freeboardlist", freeboardlist);
			RequestDispatcher rd = request.getRequestDispatcher("/freeboard.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
