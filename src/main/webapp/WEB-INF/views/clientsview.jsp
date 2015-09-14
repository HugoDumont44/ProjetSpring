<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bankonet</title>
</head>
<body>
	<h1><spring:message code="page.home.title" /></h1>
	<span style="float: right">
		<a href="?lang=fr">fr</a>
		<a href="?lang=en">en</a>
	</span>
	<f:form action="/spring/BankonetSpringMVC/saveClient" modelAttribute="client">
		<spring:message code="page.home.id" /> : <f:hidden path="id" />${client.id}<br>
		<spring:message code="page.home.lastname" /> : <f:input path="nom"/><f:errors path="nom" /><br>
		<spring:message code="page.home.firstname" /> : <f:input path="prenom"/><f:errors path="prenom" /><br>
		<spring:message code="page.home.login" /> : <f:input path="login"/><f:errors path="login" /><br>
		<spring:message code="page.home.password" /> : <f:input path="motDePasse"/><f:errors path="motDePasse" /><br>
		<input type="submit" value='<spring:message code="page.home.save" />'/> <input type="reset" value="Suppression"/>
	</f:form>
	<br>
	<br>
	<table border="1" width="80%">
		<thead>
			<tr>
				<td><spring:message code="page.home.id" /></td>
				<td><spring:message code="page.home.lastname" /></td>
				<td><spring:message code="page.home.firstname" /></td>
				<td><spring:message code="page.home.login" /></td>
				<td><spring:message code="page.home.password" /></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${clients}" var="client">
				<tr>
					<td>${client.id}</td>
					<td>${client.nom}</td>
					<td>${client.prenom}</td>
					<td>${client.login}</td>
					<td>${client.motDePasse}</td>
					<td><a href="/spring/BankonetSpringMVC/deleteClient?id=${client.id}"><spring:message code="page.home.delete" /></a></td>
					<td><a href="/spring/BankonetSpringMVC/editClient/${client.id}"><spring:message code="page.home.edit" /></a></td>
					<td><a href="/spring/BankonetComptesController/compteCourant">Gérer Compte Courant</a></td>
					<td><a href="/spring/BankonetComptesController/compteEpargne">Gérer Compte Epargne</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>