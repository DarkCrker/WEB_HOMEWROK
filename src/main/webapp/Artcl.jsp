<%@page import="net.yamangs.dao.ArtclDaoImpl"%>
<%@page import="net.yamangs.vo.ArtclVO"%>
<%@page import="java.util.List"%>
<%@page import="net.yamangs.dao.ArtclDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   ArtclDao dao = new ArtclDaoImpl();
   List<ArtclVO> artcls = dao.getArtclOf();
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>ARTCL</h1>
		<hr/>
		
		<table style="width: 100%; border-collapse: collapse; border: 1px solid #000000; ">
			<tr>
				<th>ARTCL_ID</th>
				<th>SBJ</th>
				<th>CONT</th>
				<th>CRT_DT</th>
			</tr>
			
<%
	int artclSize = artcls.size();
	ArtclVO artclVO = null;
	for(int i=0; i<artclSize; i++){
	artclVO = artcls.get(i);
	
%>

	<tr style="text-align: center">
		<td><%out.print(artclVO.getArtcl_Id());%></td>
		<td><%= artclVO.getSubject()%></td>
		<td><%= artclVO.getContent()%></td>
		<td><%= artclVO.getCreatedDate()%></td>
	</tr>
		
<%
		}
%>
		</table>
</body>
</html>