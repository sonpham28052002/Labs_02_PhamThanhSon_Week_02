package vn.edu.iuh.fit.Back_End.WebResources;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.persistence.EntityTransaction;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.Back_End.convertes.JacksonConfigMapper;
import vn.edu.iuh.fit.Back_End.ConectionDB.ConnectionDB;
import vn.edu.iuh.fit.Back_End.entities.*;
import vn.edu.iuh.fit.Back_End.reponsitories.ProductReponsitory;

@Path("/product")
public class ProductResource{
    private final ProductReponsitory productReponsitory;
    private final JacksonConfigMapper jacksonConfigMapper = new JacksonConfigMapper();
    
    public ProductResource() {
        productReponsitory = new ProductReponsitory();
    }
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response get(@PathParam("id") long ids) {
        Product product = productReponsitory.getOne(ids);
        if (product != null){
            try {
                String json = jacksonConfigMapper.getContext(Product.class).writeValueAsString(product);
                return Response.ok(json).build();
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Produces("application/json")
    public Response getAll(){
        EntityTransaction transaction = ConnectionDB.getConnectionDB().getManagerFactory().createEntityManager().getTransaction();
        transaction.begin();
        try {
            String json = jacksonConfigMapper.getContext(Product.class).writeValueAsString(productReponsitory.getAll());
            return Response.ok(json).build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
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
