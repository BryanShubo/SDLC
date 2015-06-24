<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Vendor Entry</title>

    <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
<div>
    <img alt="Vendor Entry" src="<c:url value='/images/logo.jpg'/> "/>
</div>

<div><h2>Vendor Entry</h2></div>

<br/><br/>

<div id="form">
    <form:form modelAttribute="vendor" action="vendor">

        <div class="message">
            <c:if test="${!empty message}">
                <c:out value="${message}"></c:out>
            </c:if>

        </div>

        <fieldset>
            <legend> Vendor Information</legend>
            <div>
                <label for="form">Vendor Name</label>
                <form:input path="vendorName" />
            </div>

            <div>
                <label for="form">First Name</label>
                <form:input path="firstName" />
            </div>

            <div>
                <label for="form">Last Name</label>
                <form:input path="lastName" />
            </div>

            <div>
                <label for="form">Address</label>
                <form:input path="address" />
            </div>

            <div>
                <label for="form">City</label>
                <form:input path="city" />
            </div>

            <div>
                <label for="form">State</label>
                <form:select path="state" >
                    <form:option value="Alabama">Alabama</form:option>
                </form:select>
            </div>

            <div>
                <label for="form">Zip Code</label>
                <form:input path="zipCode" />
            </div>

            <div>
                <label for="form">Phone Number</label>
                <form:input path="phoneNumber" />
            </div>

            <div>
                <label for="form">Email</label>
                <form:input path="email" />
            </div>

            <div>
                <input type="submit" value="Submit"/>
            </div>
        </fieldset>
    </form:form>
</div>
</body>
</html>
