package com.sds.icto.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysitedao.memberdao;
import com.sds.icto.mysitevo.membervo;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
			String name = request.getParameter("name" );
			String email = request.getParameter("email" );
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			
			membervo vo = new membervo();
			vo.setName(name);
			vo.setEmail(email);
			vo.setPassword(password);
			vo.setGender(gender);
			
			memberdao dao = new memberdao();
			dao.insert(vo);
			
			response.sendRedirect("/mysite/member?a=joinsuccess");
	}

}
