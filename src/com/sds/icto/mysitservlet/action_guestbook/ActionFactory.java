package com.sds.icto.mysitservlet.action_guestbook;

import com.sds.icto.web.Action;
import com.sds.icto.web.GuestbookAction;
import com.sds.icto.web.IndexAction;
import com.sds.icto.web.JoinFormAction;


public class ActionFactory {
	private static ActionFactory instance;
	static {
		instance = new ActionFactory(); // 무조건 생성한다 이런의미
	}

	private ActionFactory() {
	}

	public static ActionFactory getInstance() {
		
		return instance;
	}
	public Action getAction (String a){
		Action action = null;
		if ("guestbook".equals(a)) {
			action = new GuestbookAction();
		}
		return action;
	}
}