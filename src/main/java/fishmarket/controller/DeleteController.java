package fishmarket.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fishmarket.model.service.MemberService;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/delete.do")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MemberService service = new MemberService();
		String memberId = request.getParameter("memberId");
		int result = service.deleteMemeber(memberId);
		if(result>0) {
			response.sendRedirect("/member/logout.do");
		}
		else {
			request.setAttribute("msg", "회원탈퇴 실패");
			request.setAttribute("url","/index.jsp");
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/member_Registration.jsp");
		view.forward(request, response);
		doGet(request, response);
		
		
	}

}



