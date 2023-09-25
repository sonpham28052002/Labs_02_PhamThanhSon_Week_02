package vn.edu.iuh.fit.WebResources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.entities.Employee;
import vn.edu.iuh.fit.entities.Order;
import vn.edu.iuh.fit.reponsitories.OrderReponsitory;

@Path("/order")
public class OrderResource {
    private OrderReponsitory orderReponsitory = new OrderReponsitory();

    @GET
    @Produces("application/json")
    public Response getAll(){
        return Response.ok(orderReponsitory.getAll()).build();
    }
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response get(@PathParam("id") long ids){
        Order order = orderReponsitory.getOne(ids);
        if (order != null){
            return Response.ok(order).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Order order){
        orderReponsitory.insertOrder(order);
        return  Response.ok(order).build();
    }
    @PUT
    @Path("/{ids}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(@PathParam("ids") long id, Order order){
        order.setOrder_id(id);
        if (orderReponsitory.updateOrder(order)){
            return Response.ok(order).build();
        }
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long ids){
        if (orderReponsitory.deleteOrder(orderReponsitory.getOne(ids))){
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
