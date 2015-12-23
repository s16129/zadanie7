<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/templates"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:layout>
	<jsp:attribute name="scripts">
		<script type="text/javascript" src="scripts/person/PersonViewModel.js"></script>
		<script type="text/javascript" src="scripts/person/PersonListViewModel.js"></script>
		<script type="text/javascript">
			$(function(){
				var listOfPeople = JSON.parse(sessionStorage.getItem("listOfPeople"));
				var viewModel = new PersonListViewModel(listOfPeople);
				ko.applyBindings(viewModel);
			});
		</script>
	</jsp:attribute>
	<jsp:body>
		<ul data-bind="foreach: people">
			<li><span data-bind="text:name"></span></li>
		</ul>
	</jsp:body>
</t:layout>