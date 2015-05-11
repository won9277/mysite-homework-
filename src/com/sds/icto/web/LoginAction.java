package com.sds.icto.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.sds.icto.mysitedao.memberdao;
import com.sds.icto.mysitevo.membervo;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		membervo vo = new membervo();
		vo.setEmail(email);
		vo.setPassword(password);
		
		memberdao dao = new memberdao();
		membervo authmember = dao.getMember(vo);
		
		if(authmember == null)
		{ response.sendRedirect("/mysite/member?a=loginform&result=fail ");
			return;}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("authmember", authmember);
		
		response.sendRedirect("/mysite/");
		}

}
