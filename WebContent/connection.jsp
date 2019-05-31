<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" %>    
<%
	String url = "jdbc:mysql://DB_URL:3306/";
	String dbSchema = "";
	String user = "";
	String password = "";

	Connection conn = null;
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url + dbSchema, user, password);		
	} catch (ClassNotFoundException | SQLException e)
	{
		e.printStackTrace();
	}
%>