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
    <title>register</title>
</head>
<body>

<h3>user2 등록</h3>

<a href="/ch04">처음으로</a><br>
<a href="/ch04/user2/register">등록</a>


<form action="/ch04/user2/register" method="post">
    <table border="1">
        <tr>
            <td>아이디</td>
            <td><input type="text" name="uid"></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>생년월일</td>
            <td><input type="date" name="birth"></td>
        </tr>
        <tr>
            <td>주소</td>
            <td><input type="text" name="addr"></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="등록하기">
            </td>
        </tr>

    </table>
</form>
</body>
</html>
