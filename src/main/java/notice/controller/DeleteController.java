package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet(name = "NoticeDeleteController", urlPatterns = { "/notice/delete.do" })
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
			//DELETE FROM NOTICE_TBL WHERE NOTICE_NO=?
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			NoticeService service = new NoticeService();
			int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
			int result = service.deleteNoticeByNo(noticeNo);
			if(result>0) {
				//성공하면 공지사항 목록
				response.sendRedirect("/notice/list.do");
			}else {
				//실패하면 에러페이지로 이동
				request.setAttribute("msg", "삭제되지 않았습니다.");
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/ServiceFailed.jsp");
				view.forward(request, response);
				
			}
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	}

