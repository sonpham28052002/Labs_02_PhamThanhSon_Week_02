package vn.edu.iuh.fit.Back_End.WebResources;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.Back_End.convertes.JacksonConfigMapper;
import vn.edu.iuh.fit.Back_End.entities.Order;
import vn.edu.iuh.fit.Back_End.reponsitories.OrderReponsitory;

@Path("/order")
public class OrderResource {
    private final OrderReponsitory orderReponsitory = new OrderReponsitory();
    private final JacksonConfigMapper jacksonConfigMapper = new JacksonConfigMapper();

    @GET
    @Produces("application/json")
    public Response getAll(){
        try {
            String a = jacksonConfigMapper.getContext(Order.class).writeValueAsString(orderReponsitory.getAll());
            return Response.ok(a).build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response get(@PathParam("id") long ids){
        Order order = orderReponsitory.getOne(ids);
        if (order != null){
            try {
                String json = jacksonConfigMapper.getContext(Order.class).writeValueAsString(order);
                return Response.ok(json).build();
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
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
