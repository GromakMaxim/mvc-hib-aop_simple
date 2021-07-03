<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Employee info</title>
    </head>
    <body>
        <h2>Type new employee's data here</h2>
        <br>
        <form:form action="save" modelAttribute="newEmp">
            <form:hidden path="id"/>

            Name <form:input path="name"/>
            <br><br>
            Surname <form:input path="surname"/>
            <br><br>
            Department <form:input path="department"/>
            <br><br>
            Salary <form:input path="salary"/>
            <br><br>
            <input type="submit" value="Confirm"/>
        </form:form>

    </body>
</html>
