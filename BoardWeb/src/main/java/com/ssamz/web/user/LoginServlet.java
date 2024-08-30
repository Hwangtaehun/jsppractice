package com.ssamz.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import com.ssamz.biz.user.UserDAO;
import com.ssamz.biz.user.UserVO;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        // super();
        // TODO Auto-generated constructor stub
    	System.out.println("===> LoginServlet 생성");
    }
    
    public void init() throws ServletException{
    	System.out.println("---> init() 호출");
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 1. 사용자 입력 정보 추출
    	String id = request.getParameter("id");
    	String password = request.getParameter("password");
    	
    	// 2. DB 연동 처리
    	UserVO vo = new UserVO();
    	vo.setId(id);
    	
    	UserDAO dao = new UserDAO();
    	UserVO user = dao.getUser(vo);
    	
    	// 3. 응답 화면 구성
    	// 응답 메시지에 대한 인코딩 설정
    	response.setContentType("text/html;charset=UTF-8");
    	// HTTP 응답 프로토콜 message-body와 연결된 출력 스트림 획득
    	PrintWriter out = response.getWriter();
    	
    	// 메시지 출력
    	if(user != null) {
    		if(user.getPassword().equals(password)) {
    			// 상태 정보를 세션에 저장하여 전송한다.
    			HttpSession session = request.getSession();
    			session.setMaxInactiveInterval(10);
    			session.setAttribute("userId", user.getId());
    			session.setAttribute("userName", user.getName());
    			session.setAttribute("userRole", user.getRole());
    			
    			// 글 목록 화면으로 리디렉트하다.
    			ServletContext context = getServletContext();
    			context.setAttribute("welcomeMessage", "님 환영합니다.");
    			response.sendRedirect("getBoardList.do");
    		} else {
    			out.println("비밀번호 오류입니다.<br>");
    			out.println("<a href='/'>다시 로그인</a>");
    		}
    	}else {
    		out.println("아이디 오류입니다.<br>");
			out.println("<a href='/'>다시 로그인</a>");
    	}
    	
    	/*
		 * System.out.println("-------Start Line-------"); String method =
		 * request.getMethod(); String uri = request.getRequestURI(); String protocol =
		 * request.getProtocol(); System.out.println(method + " " + uri + " " +
		 * protocol);
		 * 
		 * System.out.println("-------Message Header-------");
		 * System.out.println("Host : "+ request.getHeader("host"));
		 * System.out.println("Connection : "+ request.getHeader("connection"));
		 * System.out.println("User-Agent : "+ request.getHeader("user-agent"));
		 * System.out.println("Accept : "+ request.getHeader("accpet"));
		 * System.out.println("Accept-Encoding : "+
		 * request.getHeader("accpet-encoding"));
		 * System.out.println("Accept-Language : "+
		 * request.getHeader("accpet-language"));
		 */
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("---> doGet() 호출");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.println("---> doPost() 호출");
	}

	public void destroy() {
		System.out.println("---> destroy() 호출");
	}
}
