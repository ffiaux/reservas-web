<%@include file="connection.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%! 
	public JSONObject listarReservas(HttpServletRequest req) throws Exception
	{
		JSONObject json = new JSONObject();
		JSONObject reserva = new JSONObject();
		JSONArray reservas = new JSONArray();		
	
		reserva.put("nome", "Fernando");
		reserva.put("email", "abc@gmail.com");
		reserva.put("start_date", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("29/05/2019 10:00"));
		reserva.put("end_date", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("29/05/2019 11:00"));
		reservas.add(reserva);	
		
		reserva = new JSONObject();
		reserva.put("nome", "Ariana");
		reserva.put("email", "123@gmail.com");
		reserva.put("start_date", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("29/05/2019 13:00"));
		reserva.put("end_date", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("29/05/2019 14:00"));
		reservas.add(reserva);	
		
		json.put("reservas", reservas);	
		
		return json;
	}
%>	
	
<%
	String opc = request.getParameter("opc");
	if ("listar".equals(opc))
	{
		JSONObject json = listarReservas(request);
		response.getWriter().write(json.toString());		
	}	
%>