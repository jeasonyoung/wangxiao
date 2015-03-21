package com.changh.eschool.action.user;

import com.changh.eschool.action.BaseAction;

public class LoginOutAction extends BaseAction{
	private boolean ok;

	public boolean isOk() {
		return ok;
	}
	public String execute()throws Exception
	{
		ok = session.remove("student")!=null;
		return "success";
	}
}
