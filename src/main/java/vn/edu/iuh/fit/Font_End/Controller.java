package vn.edu.iuh.fit.Font_End;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.Back_End.entities.*;
import vn.edu.iuh.fit.Back_End.reponsitories.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    private ProductReponsitory productReponsitory = new ProductReponsitory();
    private CustomerReponsitory customerReponsitory = new CustomerReponsitory();
    private EmployeeReponsitory employeeReponsitory = new EmployeeReponsitory();
    private OrderReponsitory orderReponsitory = new OrderReponsitory();
    private OrderDetailReponsitory orderDetailReponsitory = new OrderDetailReponsitory();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id =1;
        req.getSession().setAttribute("user", customerReponsitory.getOne(id));
        if (req.getParameter("giohang") != null){
            String[] cart = req.getParameter("giohang").split(",");
            List<Product> products = new ArrayList<>();
            List<Integer> slList = new ArrayList<>();
            double total = 0;
            for (String s : cart) {
                long ids = Long.parseLong(s.substring(0,s.lastIndexOf("-")));
                int sl = Integer.parseInt(s.substring(s.lastIndexOf("-")+1));
                slList.add(sl);
                Product product = productReponsitory.getOne(ids);
                int size = product.getProductPriceList().size()-1;
                total+= sl * product.getProductPriceList().get(size).getPrice();
                products.add(product);
            }
            req.getSession().setAttribute("cart",products);
            req.getSession().setAttribute("prices",slList);
            req.setAttribute("total",total);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/a.jsp");
            dispatcher.forward(req, resp);
        } else if (req.getParameter("thanhtoan")!=null) {
            List<Product> products = (List<Product>) req.getSession().getAttribute("cart");
            List<Integer> list = (List<Integer>) req.getSession().getAttribute("prices");
            Customer customer = (Customer) req.getSession().getAttribute("user");
            long empl_id = 1;
            Order order = new Order();
            order.setCustomer(customer);
            order.setEmployee(employeeReponsitory.getOne(empl_id));
            order.setOrderDate(LocalDate.now());
            System.out.println(orderReponsitory.insertOrder(order));
            int index =0;
            for (Product product:products) {
                int size = product.getProductPriceList().size()-1;
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setQuantity(list.get(index));
                orderDetail.setProduct(product);
                orderDetail.setPrice(list.get(index)* product.getProductPriceList().get(size).getPrice());
                orderDetail.setOrder(orderReponsitory.getOrderLast());
                System.out.println(orderDetailReponsitory.insertOrderDetail(orderDetail));
            }
            req.getSession().removeAttribute("cart");
            req.getSession().removeAttribute("prices");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        } else if (req.getParameter("thongke")!=null) {

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/thongke.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
