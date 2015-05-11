package com.sds.icto.mysitservlet.action_main;

import com.sds.icto.web.Action;
import com.sds.icto.web.IndexAction;

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

	public Action getAction(String a) {
		Action action = new IndexAction();
		return action;
	}
}