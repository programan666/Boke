<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%

    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");
	
	String rootPath = application.getRealPath( "/" );
//    String rootPath = "http://localhost:7777/Boke/";
/* 	System.out.println("rootPath:---" + rootPath);
	System.out.println("request.getContextPath():---" + request.getContextPath()); */
	out.write( new ActionEnter( request, rootPath ).exec() );
	
%>