<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<html>
    <head>
        <title>Spring MVC Form Handling</title>
    </head>
    <body>

        <h2>CreateFFFFFFFFFFFFF</h2>

        <hr>



        <form:form method="POST" action="/users/docreate" modelAttribute="model">
            <table>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name" /></td>
                    <td align="left"><c:if test="${bindingresults.hasFieldErrors('name')}">
                            <c:forEach items="${bindingresults.getFieldErrors('name')}" var="errorMessage">
                                <div id="errors" class="errors">
                                    <c:out value="${errorMessage.defaultMessage}" />
                                </div>
                            </c:forEach>
                        </c:if></td>
                </tr>
                <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email" /><form:errors path="email"/></td>
                    <td align="left">
                        <c:if test="${bindingresults.hasFieldErrors('email')}">
                            <c:forEach items="${bindingresults.getFieldErrors('email')}" var="errorMessage">
                                <div id="errors" class="errors">
                                    <c:out value="${errorMessage.defaultMessage}" />
                                </div>
                            </c:forEach>
                        </c:if>
                    </td>


                </tr>   
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit"/>
                    </td>
                </tr>
            </table> 
        </form:form>


        <spring:hasBindErrors name="model">
            <c:forEach var="error" items="${errors.allErrors}">
                <b><spring:message message="${error}" /></b>
                <br />
            </c:forEach>
        </spring:hasBindErrors>
    </body>
</html>