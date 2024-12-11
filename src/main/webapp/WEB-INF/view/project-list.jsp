<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Proje Listesi</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style1.css">
</head>

<body>
    <div class="container">
        <div class="wrapper">
            <header class="header">
                <h2>Proje Listesi</h2>
            </header>
            <div class="content">
                <a href="show-project-form" class="btn">Proje Ekle</a>
                <table>
                    <tr>
                        <th>Proje Adı</th>
                        <th>Proje Sahibi</th>
                        <th>Başlangıç Tarihi</th>
                        <th>Teslim Tarihi</th>
                        <th>Güncelle</th>
                        <th>Sil</th>
                    </tr>
                    <c:forEach var="project" items="${projects}">
                        <c:url var="updateLink" value="/project/update-form">
                            <c:param name="id" value="${project.id}"/>
                        </c:url>
                        <c:url var="deleteLink" value="/project/delete">
                            <c:param name="id" value="${project.id}"/>
                        </c:url>
                        <tr>
                            <td>${project.projectName}</td>
                            <td>${project.projectOwner}</td>
                            <td>${project.startDate}</td>
                            <td>${project.finalDate}</td>
                            <td>
                                <a href="${updateLink}" type="button" class="btn" >Güncelle</a>
                           </td>
                            <td>
                                <a href="${deleteLink}" type="button" class="btn" onclick="if(!(confirm('Silmek istediğinize emin misiniz?'))) return false">Sil</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>