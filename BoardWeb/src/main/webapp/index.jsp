<%@ page import="java.util.List" %>
<%@ page import="com.ssamz.biz.board.BoardDAO" %>
<%@ page import="com.ssamz.biz.board.BoardVO" %>
<%@ page contentType="text/html; charset=UTF-8" errorPage="errors/boardError.jsp" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TITLE</title>
</head>
<body>

<%@ include file="../layout/header.jsp" %>

<%
	// 1. DB 연동 처리
	BoardVO vo = new BoardVO();
	vo.setSearchCondition("TITLE");
	vo.setSearchKeyword("");
	
	BoardDAO dao = new BoardDAO();
	List<BoardVO> boardList = dao.getBoardList(vo);
	
	// 2. 화면 이동
%>

<center>
<!-- HTML 주석입니다. -->
<%-- JSP 주석입니다. --%>
<h1><font color='green'>게스트</font>님 환영합니다.</h1>
<%
	for(BoardVO board : boardList){
		out.print(board.getSeq() + " : " + board.getTitle() + " : " + board.getContent() + "<br>");
	}
%>
</center>

<%@ include file="../layout/footer.jsp" %>

</body>
</html>