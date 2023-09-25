package vn.edu.iuh.fit.WebResources;

import jakarta.persistence.EntityTransaction;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.ConectionDB.ConnectionDB;
import vn.edu.iuh.fit.entities.*;
import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.reponsitories.CustomerReponsitory;
import vn.edu.iuh.fit.reponsitories.EmployeeReponsitory;
import vn.edu.iuh.fit.reponsitories.OrderReponsitory;
import vn.edu.iuh.fit.reponsitories.ProductReponsitory;

import java.time.LocalDate;
import java.util.List;

@Path("/product")
public class ProductResource{
    private final ProductReponsitory productReponsitory;

    public ProductResource() {
        productReponsitory = new ProductReponsitory();
    }
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response get(@PathParam("id") long ids){
        Product product = productReponsitory.getOne(ids);
        if (product != null){
            return Response.ok(product).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Produces("application/json")
    public Response getAll(){
        return Response.ok(productReponsitory.getAll()).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Product product){
        productReponsitory.insertProduct(product);
        return  Response.ok(product).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long ids){
        if (productReponsitory.deleteProduct(productReponsitory.getOne(ids))){
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @PUT
    @Path("/{ids}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(@PathParam("ids") long id, Product product){
        product.setProductId(id);
        if (productReponsitory.updateProduct(product)){
            return Response.ok(product).build();

        }
        return Response.ok().build();
    }
}
