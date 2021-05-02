<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student">
First name: <form:input path="firstName" />
<br><br>

Last Name: <form:input path="lastName" />
<br><br>

Country: <form:select path="country">
         	<form:options items="${student.countryOptions}"/>
         	
         </form:select>
<br><br>

Programming Language:  Java<form:radiobutton path="favoriteLanguage" value="Java"/>&nbsp;&nbsp;
Python<form:radiobutton path="favoriteLanguage" value="Python"/>&nbsp;&nbsp;
C++<form:radiobutton path="favoriteLanguage" value="C++"/>&nbsp;&nbsp;
JavaScript<form:radiobutton path="favoriteLanguage" value="JavScript"/>
<br><br>

Operating Systems: 
Mac OS<form:checkbox path="operatingSystems" value="Mac OS"/>&nbsp;&nbsp;
Linux<form:checkbox path="operatingSystems" value="Linux"/>&nbsp;&nbsp;
Windows<form:checkbox path="operatingSystems" value="Windows"/>
<br><br>

<input type="submit" value="submit" />
</form:form>
</body>
</html>