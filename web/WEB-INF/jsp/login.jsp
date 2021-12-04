<%-- 
    Document   : login
    Created on : Nov 27, 2021, 8:55:17 PM
    Author     : 62878
--%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login ke Aplikasi Mahasiswa</title>
    </head>
    <body>
        <form method="post" modelAttribute="emp" >
            <table align="center">
                <tr>
                    <td>username:</td><td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>password:</td><td><input type="password" name="password"/></td> 
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="login" /></td>
                </tr>
                <tr>
                    <td colspan="2">${message}</td>
                </tr>
            </table>
        </form>
    </body>
</html>
