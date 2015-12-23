<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/templates"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
			ko.applyBindings(viewModel);
		});
	</script>
	</jsp:attribute>
	<jsp:body>
			<label>Name: <input type="text" data-bind="value: name"/></label><br/>
			<label>Age: <input type="text" data-bind="value: age"/></label><br/>
			<button data-bind="click:add">add</button>
		
	</jsp:body>
</t:layout>