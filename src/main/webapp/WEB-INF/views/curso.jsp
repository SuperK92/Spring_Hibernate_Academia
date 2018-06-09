<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Cursos</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>

<c:url var="addAction" value="/curso/add" ></c:url>

<form:form action="${addAction}" commandName="curso">
<table>
	
	<c:if test="${!empty curso.nombre}">
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
		<td>
			<form:label path="familia">
				<spring:message text="Familia"/>
			</form:label>
		</td>
		<td>
			<form:input path="familia" />
		</td>
	</tr>
<!-- 	<tr> -->
<!-- 		<td> -->
<%-- 			<form:label path="profesor.id"> --%>
<%-- 				<spring:message text="Profesor"/> --%>
<%-- 			</form:label> --%>
<!-- 		</td> -->
<!-- 		<td> -->
<%-- 			<form:input path="profesor.id" /> --%>
<!-- 		</td> -->
<!-- 	</tr> -->
	
	<tr>
				<td><form:label path="profesor"><spring:message text="Profesor"/></form:label></td>
				<td>
					<form:select path="profesor.id" var="profesor" >
						<form:option value="0" label="-- Elegir Profesor--" />
						<form:options items="${listaProfesores}" itemValue="id" itemLabel="nombre" />
					</form:select>
				</td>
			</tr>
	
	<tr>
		<td colspan="2">
			<c:if test="${curso.id != 0}">
				<input type="submit"
					value="<spring:message text="Editar Curso"/>" />
			</c:if>
			<c:if test="${curso.id == 0}">
				<input type="submit"
					value="<spring:message text="Insertar Curso"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>


<c:if test="${!empty listCursos}">
<h3>Lista de Cursos</h3>
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">Nombre</th>
		<th width="120">Familia</th>
		<th width="120">Profesor</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listCursos}" var="curso">
		<tr>
			<td>${curso.id}</td>
			<td>${curso.nombre}</td>
			<td>${curso.familia}</td>
			<td>${curso.profesor.nombre}</td>
			<td><a href="<c:url value='/curso/edit/${curso.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/curso/remove/${curso.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>