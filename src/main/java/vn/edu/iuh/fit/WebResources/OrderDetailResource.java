package vn.edu.iuh.fit.WebResources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.reponsitories.OrderDetailReponsitory;

@Path("/OrderDetail")
public class OrderDetailResource {
    private OrderDetailReponsitory orderDetailReponsitory;

    public OrderDetailResource() {
        orderDetailReponsitory = new OrderDetailReponsitory();
    }

}
