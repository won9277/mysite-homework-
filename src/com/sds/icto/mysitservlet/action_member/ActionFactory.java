package com.sds.icto.mysitservlet.action_member;

import com.sds.icto.web.Action;
import com.sds.icto.web.IndexAction;
import com.sds.icto.web.JoinAction;
import com.sds.icto.web.JoinFormAction;
import com.sds.icto.web.JoinSuccessAction;
import com.sds.icto.web.LoginAction;
import com.sds.icto.web.LoginFormAction;
import com.sds.icto.web.LogoutAction;
import com.sds.icto.web.UinfoAction;


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
		if ("joinform".equals(a)) {
			action = new JoinFormAction();
		}else if ("join".equals(a)){
			action = new JoinAction();
		}else if ("joinsuccess".equals(a)){
			action = new JoinSuccessAction();
		}else if ("loginform".equals(a)){
			action = new LoginFormAction();
		}else if ("login".equals(a)){
			action = new LoginAction();
		}else if ("logout".equals(a)){
			action = new LogoutAction();
		}else if ("uinfo".equals(a)){
			action = new UinfoAction();
		}
		
		
		if(action == null){
			action = new IndexAction();
		}
		return action;
	}
}