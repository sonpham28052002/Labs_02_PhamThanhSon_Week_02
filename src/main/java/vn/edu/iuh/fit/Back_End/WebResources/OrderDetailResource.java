package vn.edu.iuh.fit.Back_End.WebResources;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.Back_End.convertes.JacksonConfigMapper;
import vn.edu.iuh.fit.Back_End.entities.OrderDetail;
import vn.edu.iuh.fit.Back_End.reponsitories.OrderDetailReponsitory;

@Path("/OrderDetail")
public class OrderDetailResource {
    private final OrderDetailReponsitory orderDetailReponsitory = new OrderDetailReponsitory();
    private final JacksonConfigMapper jacksonConfigMapper = new JacksonConfigMapper();

    @GET
    @Path("/order_id={id}")
    @Produces("application/json")
    public Response getByOrderID(@PathParam("id") long ids) {
        try {
            String json = jacksonConfigMapper.getContext(OrderDetail.class).writeValueAsString(orderDetailReponsitory.getListOrderDetailByOrderID(ids));
            return Response.ok(json).build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @GET
    @Path("/order_id={orderid},product_id={proID}")
    @Produces("application/json")
    public Response getOne(@PathParam("orderid") long orderid ,@PathParam("proID") long prodid ) {
        try {
            String json = jacksonConfigMapper.getContext(OrderDetail.class).writeValueAsString(orderDetailReponsitory.getOne(orderid,prodid));
            return Response.ok(json).build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("/product_id={id}")
    @Produces("application/json")
    public Response getByProductID(@PathParam("id") long ids) {
        try {
            String json = jacksonConfigMapper.getContext(OrderDetail.class).writeValueAsString(orderDetailReponsitory.getListOrderDetailByProductID(ids));
            return Response.ok(json).build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(OrderDetail orderDetail){
        orderDetailReponsitory.insertOrderDetail(orderDetail);
        return  Response.ok(orderDetail).build();
    }
}
