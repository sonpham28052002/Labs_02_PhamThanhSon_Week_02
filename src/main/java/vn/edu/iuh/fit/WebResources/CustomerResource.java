package vn.edu.iuh.fit.WebResources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.entities.Customer;
import vn.edu.iuh.fit.reponsitories.CustomerReponsitory;

@Path("/customer")
public class CustomerResource {
    private CustomerReponsitory customerReponsitory;

    public CustomerResource() {
        customerReponsitory = new CustomerReponsitory();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response get(@PathParam("id") long ids){
        Customer customer = customerReponsitory.getOne(ids);
        if (customer != null){
            return Response.ok(customer).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Produces("application/json")
    public Response getAll(){
        return Response.ok(customerReponsitory.getAll()).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Customer customer){
        customerReponsitory.insertCustomer(customer);
        return  Response.ok(customer).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long ids){
        if (customerReponsitory.deleteCustomer(customerReponsitory.getOne(ids))){
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
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
