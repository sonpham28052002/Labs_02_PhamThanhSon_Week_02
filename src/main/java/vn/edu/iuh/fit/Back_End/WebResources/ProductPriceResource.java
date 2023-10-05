package vn.edu.iuh.fit.Back_End.WebResources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.Back_End.entities.ProductPrice;
import vn.edu.iuh.fit.Back_End.reponsitories.ProductPriceReponsitory;

@Path("/product_price")
public class ProductPriceResource {
    private ProductPriceReponsitory productPriceReponsitory;

    public ProductPriceResource() {
        productPriceReponsitory = new ProductPriceReponsitory();
    }


    @GET
    @Produces("application/json")
    public Response getAll(){
        return Response.ok(productPriceReponsitory.getAll()).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(ProductPrice productPrice){
        productPriceReponsitory.insertProductPrice(productPrice);
        return  Response.ok(productPrice).build();
    }



}
