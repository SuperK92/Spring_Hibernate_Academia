<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Person Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>

<c:url var="addAction" value="/profesor/add" ></c:url>

<form:form action="${addAction}" commandName="profesor">
<table>
	
	<c:if test="${!empty profesor.dni}">
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
			<form:label path="dni">
				<spring:message text="DNI"/>
			</form:label>
		</td>
		<td>
			<form:input path="dni" />
		</td> 
	</tr>
	
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
		<td>
			<form:label path="apellidos">
				<spring:message text="Apellidos"/>
			</form:label>
		</td>
		<td>
			<form:input path="apellidos" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="direccion">
				<spring:message text="Direccion"/>
			</form:label>
		</td>
		<td>
			<form:input path="direccion" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="email">
				<spring:message text="Email"/>
			</form:label>
		</td>
		<td>
			<form:input path="email" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="telefono">
				<spring:message text="Telefono"/>
			</form:label>
		</td>
		<td>
			<form:input path="telefono" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty profesor.dni}">
				<input type="submit"
					value="<spring:message text="Editar Profesor"/>" />
			</c:if>
			<c:if test="${empty profesor.dni}">
				<input type="submit"
					value="<spring:message text="Insertar Profesor"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>


<c:if test="${!empty listProfesores}">
<h3>Lista de Profesores</h3>
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="80">DNI</th>
		<th width="120">Nombre</th>
		<th width="120">Apellidos</th>
		<th width="120">Direccion</th>
		<th width="120">Email</th>
		<th width="120">Telefono</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listProfesores}" var="profesor">
		<tr>
			<td>${profesor.id}</td>
			<td>${profesor.dni}</td>
			<td>${profesor.nombre}</td>
			<td>${profesor.apellidos}</td>
			<td>${profesor.direccion}</td>
			<td>${profesor.email}</td>
			<td>${profesor.telefono}</td>
			<td><a href="<c:url value='/edit/${profesor.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${profesor.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>