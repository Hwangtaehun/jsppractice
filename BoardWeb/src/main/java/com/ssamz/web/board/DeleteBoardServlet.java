package com.ssamz.web.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssamz.biz.board.BoardDAO;
import com.ssamz.biz.board.BoardVO;

@WebServlet("/deleteBoard.do")
public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 0. 상태 정보 체크
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		if(userId == null) {
			response.sendRedirect("/");
		}
		
		// 1. 사용자 입력 정보 추출
		String seq = request.getParameter("seq");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);
		
		// 3. 화면 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("/getBoardList.do");
		dispatcher.forward(request, response);
	}
}
