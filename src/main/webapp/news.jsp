<%@page import="net.yamang.vo.NewsVO"%>
<%@page import="java.util.List"%>
<%@page import="net.yamang.dao.NewsDao"%>
<%@page import="net.yamang.dao.NewsDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   NewsDao dao = new NewsDaoImpl();
   int categoryId = 10;
   List<NewsVO> newses = dao.getNewsesOf(categoryId);
 %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>NEWS</h1>
	<hr/>
	
	<table style="width: 100%; border-collapse: collapse; border: 1px solid #000000;
	">
	 
		<tr style="height: 50px">
			<th>NEWS_ID</th>
			<th>SBJ</th>
			<th>CONT</th>
			<th>RCMD_CNT</th>
			<th>JRNLST_ID</th>
			<th>CTGR_ID</th>
			<th>CRT_DT</th>
		</tr>
		
<%
		int newsSize = newses.size();
		NewsVO newse = null;
		
		for(int i=0; i<newsSize; i++){
			newse = newses.get(i);
		
%>
		<tr style="text-align: center">
				<td><%out.print(newse.getNewsId()); %></td>
				<td><%= newse.getSubject() %></td>
				<td><%= newse.getContent() %></td>
				<td><%= newse.getRecommendCount() %></td>
				<td><%= newse.getJournalistId() %></td>
				<td><%= newse.getCategoryId() %></td>
				<td><%= newse.getCreatedDate() %></td>
		</tr>
<%
		}
%>
	</table>
</body>
</html>