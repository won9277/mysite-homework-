package com.sds.icto.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws 
	SQLException,
	ClassNotFoundException,
	ServletException,
	IOException
	{
		WebUtil.forward("/views/main/index.jsp", request, response);
	}

}
