<%--
  Created by IntelliJ IDEA.
  User: lotte4
  Date: 2024-09-04
  Time: 오전 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>modify</title>
</head>
<body>
<h3>User1 수정</h3>

<a href="/ch05">처음으로</a><br>
<a href="/ch05/user1/register">등록</a>

<form action="/ch05/user1/modify" method="post">
    <table border="1">
        <tr>
            <td>아이디</td>
            <td><input type="text" name="uid" value="${user1.uid}" readonly></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" value="${user1.name}"></td>
        </tr>
        <tr>
            <td>생년월일</td>
            <td><input type="date" name="birth" value="${user1.birth}"></td>
        </tr>
        <tr>
            <td>휴대폰</td>
            <td><input type="text" name="hp" value="${user1.hp}"></td>
        </tr>
        <tr>
            <td>나이</td>
            <td><input type="number" name="age" value="${user1.age}"></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="수정하기">
            </td>
        </tr>

    </table>
</form>

</body>
</html>
