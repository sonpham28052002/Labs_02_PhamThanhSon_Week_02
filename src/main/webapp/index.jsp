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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <script>
        var cart = []
        localStorage.setItem("cart","");
        $(document).ready(function () {

            getProduct()
        })
        var getProduct = () => {
            var data;
            axios({
                method: 'get',
                url: 'http://localhost:8080/phamthanhson/api/product',
            })
                .then(function (response) {
                    let body = document.getElementById("body_Product")
                    let renderJson = "";
                    for (let x of response.data) {
                        renderJson += renderTableProduct(x)
                    }
                    body.innerHTML = renderJson;
                });

        }

        var renderTableProduct = (x) => {
            return "<tr>" +
                " <th scope='row'>" + x.productId + "</th>" +
                "<td>" + x.name + "</td>" +
                "<td>" + x.description + "</td>" +
                "<td>" + x.manufacturer + "</td>" +
                "<td>" + x.unit + "</td>" +
                "<td>" + x.status + "</td>" +
                "<td>" +
                " <img src='" + x.productImageList[0].path + "' style='width: 100px; height: auto'/>" +
                "  </td>" +
                "<td >" +
                "<button type='button' style='margin-top: 10px'  class='btn btn-success' value='" + x + "'>Update</button>" +
                "</td>" +
                "<td>" +
                "<button type='button' style='margin-top: 10px' class='btn btn-danger' value='" + x.productId + "' onclick='deleteCookie()'>Delete</button>" +
                " </td>" +
                "<td >" +
                "<button type='button' style='margin-top: 10px' class='btn btn-success' id='" + x.productId + "' onclick='pushProductToCart(id)'>Thêm giỏ Hàng</button>" +
                " </td>" +
                "</tr>"
        }
        var pushProductToCart = (id) => {
            if (!cart.includes(id)) {
                cart.push(id)
                localStorage.setItem("cart", cart);
                console.log(localStorage.getItem("cart"))
                console.log(cart)
            }
        }
    </script>
</head>
<body>
<h1 style="text-align: center">Danh Sách Sản Phẩm</h1>
<div style="display: flex; justify-content: center; align-items: center">
    <button type="button" class="btn-danger">+ Thêm Sản Phẩm Mới</button>
    <a href="a.jsp">a</a>
</div>
<div class="container" style="margin-top: 40px">
    <table class="table table-hover table-bordered">
        <thead class="thead-dark">
        <tr style="background-color: aqua ">
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">description</th>
            <th scope="col">manufacturer</th>
            <th scope="col">unit</th>
            <th scope="col">status</th>
            <th scope="col">Image</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody id="body_Product">

        </tbody>
    </table>
</div>
</body>
</html>
