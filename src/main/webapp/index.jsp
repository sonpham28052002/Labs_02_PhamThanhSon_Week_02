<%--
  Created by IntelliJ IDEA.
  User: Leon
  Date: 9/28/2023
  Time: 2:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>

    <script>
        axios({
            method: 'get',
            url: 'http://localhost:8080/phamthanhson/api/product',
        })
            .then(function (response) {
                console.log(response.data);
            });

    </script>
</head>
<body>
<h1 style="text-align: center">Danh Sách Sản Phẩm</h1>
<div style="display: flex; justify-content: center; align-items: center">
    <button type="button" class="btn-danger">+ Thêm Sản Phẩm Mới</button>
</div>
<div class="container" style="margin-top: 40px">
    <table class="table table-hover table-bordered">
        <thead class="thead-dark">
        <tr style="background-color: aqua">
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">description</th>
            <th scope="col">manufacturer</th>
            <th scope="col">unit</th>
            <th scope="col">status</th>
            <th scope="col">Image</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>Otto</td>
            <td>Otto</td>
            <td>Otto</td>
            <td style="text-align: center;">
                <img
                        src="https://getbootstrap.com/docs/4.1/assets/img/bootstrap-stack.png"
                        alt=""
                        srcset=""
                        style="width: 100px; height: auto"
                />
            </td>
            <td style="text-align: center;">
                <button type="button" class="btn btn-success">Update</button>
            </td>
            <td style="text-align: center;">
                <button type="button" class="btn btn-danger">Delete</button>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
