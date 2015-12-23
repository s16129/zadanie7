<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@attribute name="styles" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="scripts" fragment="true" %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="content/styles/styles.css"/>
		<jsp:invoke fragment="styles"/>
	</head>
	<body>
		<div id="pageheader">
			<jsp:invoke fragment="header"/>
		</div>
		
		<div id="menu">
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<li><a href="addperson.jsp">Dodaj</a></li>
				<li><a href="people.jsp">Wszyscy</a></li>
			</ul>
		</div>
		<div id="content">
			<jsp:doBody/>
		</div>
		
		<div id="footer">
			<jsp:invoke fragment="footer"/>
			
			<script type="text/javascript" src="scripts/jquery-1.11.3.min.js"></script>
			<script type="text/javascript" src="scripts/knockout-3.3.0.js"></script>
			<script type="text/javascript" src="scripts/knockout.mapping.js"></script>
			<jsp:invoke fragment="scripts"/>
		</div>
	</body>
</html>
