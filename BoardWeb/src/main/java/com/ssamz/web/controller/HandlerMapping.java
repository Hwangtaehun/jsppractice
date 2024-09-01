package com.ssamz.web.controller;

import java.util.HashMap;
import java.util.Map;

import com.ssamz.web.controller.user.InsertUserViewController;
import com.ssamz.web.controller.user.InsertUserController;
import com.ssamz.web.controller.user.LoginViewController;
import com.ssamz.web.controller.user.LoginController;
import com.ssamz.web.controller.user.GetBoardListController;
import com.ssamz.web.controller.user.GetBoardController;
import com.ssamz.web.controller.user.InsertBoardViewController;
import com.ssamz.web.controller.user.InsertBoardController;
import com.ssamz.web.controller.user.UpdateBoardController;
import com.ssamz.web.controller.user.DeleteBoardController;
import com.ssamz.web.controller.user.LogoutController;

public class HandlerMapping {
	// Controller를 구현한 객체들을 저장하는 Map
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		// Key-Value 형태로 수많은 Controller를 등록한다.
		mappings = new HashMap<String, Controller>();
		mappings.put("/insertUserView.do", new InsertUserViewController());
		mappings.put("/insertUser.do", new InsertUserController());
		mappings.put("/loginView.do", new LoginViewController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoardView.do", new InsertBoardViewController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
	}
	
	public Controller getController(String path) {
		// Map에 등록된 Controller들 중에서
		// 특정 경로(path)에 해당하는 Controller를 리턴한다.
		return mappings.get(path);
	}
}
