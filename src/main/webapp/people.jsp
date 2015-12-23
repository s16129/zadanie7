<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/templates" %>    
<t:layout>
	<jsp:attribute name="styles">
		<!-- put your styles here -->
	</jsp:attribute>
	<jsp:attribute name="scripts">
		<script type="text/javascript" src="scripts/person/PersonViewModel.js"></script>
		<script type="text/javascript" src="scripts/person/PersonListViewModel.js"></script>
		<script type="text/javascript">
		$(function(){
			var model = JSON.parse(sessionStorage.getItem('listOfPeople'));
			var viewModel = new PersonListViewModel(model);
			ko.applyBindings(viewModel);
		});
		</script>
	
	</jsp:attribute>
	<jsp:body>
		Wszystkie osoby:<br/>
		<ul data-bind="foreach: people">
			<li><span data-bind="text:name"></span></li>
		</ul>
	</jsp:body>
	
</t:layout>