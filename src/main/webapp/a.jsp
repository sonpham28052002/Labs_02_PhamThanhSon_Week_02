<%--
  Created by IntelliJ IDEA.
  User: Leon
  Date: 10/6/2023
  Time: 3:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>a</title>

</head>
<body>
    <div id="content">
        This is the initial content.
    </div>
    <script>
        console.log(localStorage.getItem("cart").toString())
        var loadedData = localStorage.getItem("cart");

        let contentDiv = document.getElementById("content");
        contentDiv.innerText = loadedData
    </script>
</body>
</html>
