<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Matriculas</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
	text-align: center;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>

	<c:url var="addAction" value="/matricula/add"></c:url>

	<form:form action="${addAction}" commandName="matricula">
		<table>

			<c:if test="${matricula.id != 0}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>


			<tr>
				<td><form:label path="curso">
						<spring:message text="Curso" />
					</form:label></td>
				<td><form:select path="curso.id" var="curso">
						<form:option value="0" label="-- Elegir Curso--" />
						<form:options items="${listaCursos}" itemValue="id"
							itemLabel="nombre" />
					</form:select></td>
			</tr>

			<tr>
				<td><form:label path="alumno">
						<spring:message text="Alumno" />
					</form:label></td>
				<td><form:select path="alumno.id" var="alumno">
						<form:option value="0" label="-- Elegir Alumno--" />
						<form:options items="${listaAlumnos}" itemValue="id"
							itemLabel="nombre" />
					</form:select></td>
			</tr>


			<tr>
				<td colspan="2"><c:if test="${matricula.id != 0}">
						<input type="submit"
							value="<spring:message text="Editar Matricula"/>" />
					</c:if> <c:if test="${matricula.id == 0}">
						<input type="submit"
							value="<spring:message text="Insertar Matricula"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>


	<c:if test="${!empty listMatriculas}">
		<h3>Lista de Matriculas</h3>
		<table class="tg">
			<tr>
				<th width="80">ID</th>
				<th width="120">Curso</th>
				<th width="120">Alumno</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listMatriculas}" var="matricula">
				<tr>
					<td>${matricula.id}</td>
					<td>${matricula.curso.nombre}</td>
					<td>${matricula.alumno.nombre}</td>
					<td><a
						href="<c:url value='/matricula/edit/${matricula.id}' />">Edit</a></td>
					<td><a
						href="<c:url value='/matricula/remove/${matricula.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br>
	<a href="">Volver al Inicio</a>
</body>
</html>