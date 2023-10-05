package vn.edu.iuh.fit.Back_End.WebResources;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.Back_End.convertes.JacksonConfigMapper;
import vn.edu.iuh.fit.Back_End.reponsitories.CustomerReponsitory;
import vn.edu.iuh.fit.Back_End.entities.Customer;

@Path("/customer")
public class CustomerResource {
    private final CustomerReponsitory customerReponsitory = new CustomerReponsitory();
    private final JacksonConfigMapper jacksonConfigMapper = new JacksonConfigMapper();

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response get(@PathParam("id") long ids){
        Customer customer = customerReponsitory.getOne(ids);
        if (customer != null){
            JacksonConfigMapper jacksonConfigMapper = new JacksonConfigMapper();
            try {
                String a = jacksonConfigMapper.getContext(Customer.class).writeValueAsString(customer);
                return Response.ok(a).build();
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Produces("application/json")
    public Response getAll(){
        try {
            String json = jacksonConfigMapper.getContext(Customer.class).writeValueAsString(customerReponsitory.getAll());
            return Response.ok(json).build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Customer customer){
        return  Response.ok(customerReponsitory.insertCustomer(customer)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long ids){
        if (customerReponsitory.deleteCustomer(customerReponsitory.getOne(ids))){
            return Response.ok(true).build();
        }
        return Response.ok(false).build();
    }
    @PUT
    @Path("/{ids}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(@PathParam("ids") long id, Customer customer){
        customer.setId(id);
        if (customerReponsitory.updateCustomer(customer)){
            return Response.ok(customer).build();

        }
        return Response.ok().build();
    }
}
