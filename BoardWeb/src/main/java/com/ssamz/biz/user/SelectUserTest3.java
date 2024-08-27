package com.ssamz.biz.user;

public class SelectUserTest3 {

	public static void main(String[] args) {
		// 1. UserDAO 객체 생성한다.
		UserDAO dao = new UserDAO();
		
		// 2. 목록을 조회한다.
		dao.getUserList();
	}

}
