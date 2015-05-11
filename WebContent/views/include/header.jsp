<%@page import="com.sds.icto.mysitevo.membervo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>

<%
	//HttpSession session = request.getSession(false);
	//membervo authmember = (membervo) session.getAttribute("authmember");
%>
${sessionScope.authmember }
<h1>MySite</h1>
<ul>
	<br>
	<c:choose>
	<c:when test = "${empty authmember }">
	<li><a href="/mysite/member?a=loginform">로그인</a>	<li>
	<li><a href="/mysite/member?a=joinform">회원가입</a>	<li>
	</c:when>
	<c:otherwise>
	<li><a href="/mysite/member?a=uinfo">회원정보수정</a><li>
	<li><a href="/mysite/member?a=logout">로그아웃</a><li>
	<li>${authmember.name }님 안녕하세요 ^^;</li>
	</c:otherwise>
	</c:choose>


</ul>