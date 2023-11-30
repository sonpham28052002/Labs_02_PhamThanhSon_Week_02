<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.Back_End.entities.Product" %>
<%@ page import="vn.edu.iuh.fit.Back_End.entities.Customer" %>
<%@ page import="com.sun.net.httpserver.Request" %><%--
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
    <title>cart</title>
    <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>

   <body style="display: flex; justify-content: center">
   <%
       List<Product> products = (List<Product>) request.getSession().getAttribute("cart");
       for (Product product:products) {
           System.out.println(product);
       }
        List<Integer> slList = (List<Integer>) request.getSession().getAttribute("prices");
        double total = (double) request.getAttribute("total");
        int index = 0;
   %>
   <div style="width: 75%;display: flex;padding-top: 50px;">
       <div style="width: 50%;height: 100%; background-color: aquamarine;padding: 5px;">
           <%for(Product product:products) {%>
           <div style="border: 1px black solid;width: 100%;height: 202px;margin-bottom: 10px;display: flex;">
               <img style="height: 198px;width: 198px;" src=<%=product.getProductImageList().get(0).getPath()%>>
               <div style="margin-left: 10px;">
                   <h2><%=product.getName()%></h2>
                   <%
                       int size = product.getProductPriceList().size() -1;
                   %>
                   <h3>price:<%=product.getProductPriceList().get(size).getPrice()%></h3>
                   <h3>quantity:<%=slList.get(index)%></h3>
                   <%
                        double tong = slList.get(index) * product.getProductPriceList().get(size).getPrice();
                        index++;
                   %>
                   <h3>total:<%=tong%></h3>
               </div>
           </div>
           <%}%>
       </div>

       <div style="width: 50%;height: 100%; background-color: red; display: flex;justify-content: center">
           <form action="Controller" style="width: 100%" method="post">
               <label style="text-align: center;font-weight: bold;font-size: 30px;width: 100%;color: white;">Tổng Tiền Thanh Toán: <%=total%> VNĐ</label>
               <button type="submit" name="thanhtoan" style="width: 90%;margin-left: 10px;margin-right: 10px;height: 50px ; border-radius: 10px">Thanh Toán</button>
           </form>
       </div>
   </div>
   </body>
</html>
