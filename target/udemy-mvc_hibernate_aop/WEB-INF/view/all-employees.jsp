<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <title>Employee list</title>
    <body>
        <h2>All employees page:</h2>
        <br><br>
        <table>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Department</th>
                <th>Salary</th>
                <th>Operations</th>
            </tr>
            <c:forEach var="emp" items="${empls}">

                <c:url var="editBtn" value="/edit">
                    <c:param name="empId" value="${emp.id}"/>
                </c:url>
                <c:url var="deleteBtn" value="/delete">
                    <c:param name="empId" value="${emp.id}"/>
                </c:url>

                <tr>
                    <td>${emp.name}</td>
                    <td>${emp.surname}</td>
                    <td>${emp.department}</td>
                    <td>${emp.salary}</td>
                    <td>
                        <input type="button" value="Edit" onclick="window.location.href='${editBtn}'">
                    </td>
                    <td>
                        <input type="button" value="Delete" onclick="window.location.href='${deleteBtn}'">
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <br>
        <input type="button" value="Add" onclick="window.location.href = 'add'"/>




        <style type="text/css">
            table {
                border-collapse: collapse;
                /*убираем пустые промежутки между ячейками*/
                border: 2px solid grey;
                /*устанавливаем для таблицы внешнюю границу серого цвета толщиной 1px*/
            }

            th, td {
                border: 1px solid grey;
            }
        </style>

    </body>
</html>