package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class Detail
 */
@WebServlet("/notice/detail.do")
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Detail() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//SELECT * FROM NOTICE_TBL WHERE  NoticeNo=noticeNo
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int noticeNo= 
				Integer.parseInt(request.getParameter("noticeNo"));
				
		NoticeService service = new NoticeService();
		Notice notice = service.detatilNotice(noticeNo);
		if(notice!=null) {
			//상세 페이지 이동
			request.setAttribute("notice", notice);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/detail.jsp");
			view.forward(request, response);
		}else {

			request.setAttribute("msg", "메세지가 존재하지 않습니다.");
			request.getRequestDispatcher("/WEB-INF/view/common/serviceFailed.jsp").forward(request, response);
			
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
