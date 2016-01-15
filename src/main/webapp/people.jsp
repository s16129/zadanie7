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
			$.ajax({
	            url: "http://localhost:8080/servletjspdemo/rest/people/all",
	            type: "GET",
	            contentType: "application/json",
	            success: function (data) {
	                var viewModel = new PersonListViewModel(data);
	                ko.applyBindings(viewModel);
	            },
	            error: function (XMLHttpRequest, testStatus, errorThrown) {
	               alert("nie udało się")

	            }
	        });
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