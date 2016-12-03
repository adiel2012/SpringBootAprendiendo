<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Title in Work!</title>
    </head>
    <body>
        <table style="align:center;">
            <th>Name</th>
            <th>Email</th>
                <c:forEach items="${model}" var="persona">
                <tr>
                    <td><c:out value="${persona.name}"/></td>
                    <td><c:out value="${persona.email}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>