<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Familia</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff; text-align: center;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>

<c:url var="addAction" value="/familia/add" ></c:url>

<form:form action="${addAction}" commandName="familia">
<table>
	
	<c:if test="${!empty familia.nombre}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	
	<tr>
		<td>
			<form:label path="nombre">
				<spring:message text="Nombre"/>
			</form:label>
		</td>
		<td>
			<form:input path="nombre" />
		</td> 
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${familia.id != 0}">
				<input type="submit"
					value="<spring:message text="Editar Familia"/>" />
			</c:if>
			<c:if test="${familia.id == 0}">
				<input type="submit"
					value="<spring:message text="Insertar Familia"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>


<c:if test="${!empty listFamilias}">
<h3>Lista de Familas Profesionales</h3>
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">Nombre</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listFamilias}" var="familia">
		<tr>
			<td>${familia.id}</td>
			<td>${familia.nombre}</td>
			<td><a href="<c:url value='/familia/edit/${familia.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/familia/remove/${familia.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<br>
<a href="">Volver al Inicio</a>
</body>
</html>