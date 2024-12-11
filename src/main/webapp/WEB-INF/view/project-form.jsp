<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Proje Ekle</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style2.css">
    </head>

<body>
<div class="container">
    <div class="wrapper">
        <header class="header">
            <h2>Proje Detayları</h2>
        </header>
        <div class="form-wrapper">
            <form:form cssClass="form" action="save" modelAttribute="project" method="post">
                <form:hidden path="id"/>
                <div class="form-group">
                    Proje Adı: <form:input path="projectName" class="form-control"/>
                </div>
                <div class="form-group">
                    Proje Sahibi: <form:input path="projectOwner" class="form-control"/>
                </div>
                <div class="form-group">
                    Başlangıç Tarihi: <form:input path="startDate" class="form-control" type="date"/>
                </div>
                <div class="form-group">
                    Bitiş Tarihi: <form:input path="finalDate" class="form-control" type="date"/>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn">
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
