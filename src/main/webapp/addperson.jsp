<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/templates" %>    
<t:layout>
	<jsp:attribute name="styles">
		<!-- put your styles here -->
	</jsp:attribute>
	<jsp:attribute name="scripts">
		<script type="text/javascript" src="scripts/person/PersonViewModel.js"></script>	
		<script type="text/javascript">
			$(function(){
				var model = {
						name:'',
						age:0
				};
				var viewModel = new PersonViewModel(model);
				var data = ko.toJSON( {
	            	messege:'data from web'
	            });
				ko.applyBindings(viewModel);
				
			})
		</script>
	</jsp:attribute>
	<jsp:body>
		Dodaj osobę:<br/>
		<label>Name <input type="text" data-bind="value: name"/></label><br/>
		<label>Age <input type="text" data-bind="value: age"/></label><br/>
		<button data-bind="click:show">Show</button><br/>
		<button data-bind="click:add">Add</button><br/>
	</jsp:body>
	
</t:layout>