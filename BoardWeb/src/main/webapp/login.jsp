<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<center>
<h1>로그인</h1>
<img src = "image/orange.png" width = "100" height = "80">
<hr>
<form action = "login_proc.jsp" method = "POST">
	  <table border = "1" cellpadding = "0" cellspacing = "0">
	  		<tr>
	  			<td bgcolor = "orange">아이디</td>
	  			<td><input type = "text" name = "id"></td>
	  		</tr>
	  		<tr>
	  			<td bgcolor = "orange">비밀번호</td>
	  			<td><input type = "password" name = "password"></td>
	  		</tr>
	  		<tr>
	  			<td colspan = "2" align = "center">
	  				<input type = "submit" value = "로그인" />
	  			</td>
	  		</tr>
	  </table>
</form>
<br>
<a href= "insertUser.html">회원 가입</a>
<hr>
</center>

<%@ include file="../layout/footer.jsp" %>

</body>
</html>