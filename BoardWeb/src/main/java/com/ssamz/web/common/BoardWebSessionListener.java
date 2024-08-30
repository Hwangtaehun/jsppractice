package com.ssamz.web.common;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class BoardWebSessionListener
 *
 */
@WebListener
public class BoardWebSessionListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public BoardWebSessionListener() {
        // TODO Auto-generated constructor stub
    	System.out.println("===> BoardWebSessionListener 생성");
    }

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("---> 세션에 정보를 등록함");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("---> 세션에 등록된 정보를 덮어씀");
	}
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("---> 세션에 등록된 정보를 삭제됨");
	}
}
