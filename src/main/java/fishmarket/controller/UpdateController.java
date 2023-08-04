package fishmarket.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fishmarket.model.service.MemberService;
import fishmarket.model.vo.Member;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/update.do")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String memberEmail = request.getParameter("member-email");
		String memberPhone = request.getParameter("member-phone");
		String memberAddress = request.getParameter("member-address");
		MemberService service = new MemberService();
		Member member = new Member(memberId, memberPw, memberEmail, memberPhone, memberAddress);
		int result = service.updateMember(member);
		if(result > 0) {
			response.sendRedirect("/WEB-INF/views/member/login.jsp");
		}else {
			request.setAttribute("msg", "회원 수정이 완료되지 않았습니다.");
			request.getRequestDispatcher("/WEB-INF/views/member/myinfo.jsp").forward(request, response);
		}
	}

}







