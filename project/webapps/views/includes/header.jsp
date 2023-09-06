<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title><c:out value="${requestScope.title ? requestScope.title : 'Student Portal'}"/>  </title>

	<style>
      body {
        background-color: white;
        margin: 0;
        padding: 0;
        min-height: 100vh;
        display: flex;
        flex-direction: column;
      }
      footer {
       margin-top: 250px;
       height: 175px;
      }
    </style>
</head>
<body>
	<div align="center">