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

@WebServlet("/enroll.do")
public class EnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/member_Registration.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String memberId = request.getParameter("username");
		String memberEmail = request.getParameter("email");
		String memberPw = request.getParameter("password");
		String memberName = request.getParameter("member-name");
		String memberAddres = request.getParameter("member-address");
		String memberPhone = request.getParameter("member-phone");
		int memberAge = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(memberId, memberPw, memberName, memberAge, memberEmail, memberPhone, memberAddres);
		MemberService service = new MemberService();
		int result = service.insertMember(member);
		if(result > 0) {
			request.setAttribute("msg", "회원가입이 완료되었습니다.");
			request.setAttribute("url", "/index.jsp");
			request.getRequestDispatcher("/member/login.jsp")
			.forward(request, response);
			
		}else {
			request.getRequestDispatcher("/member/member_Registration.jsp")
			.forward(request, response);
		}
	}

}