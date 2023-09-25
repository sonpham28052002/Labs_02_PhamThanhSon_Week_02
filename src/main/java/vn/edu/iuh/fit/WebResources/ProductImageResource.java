package vn.edu.iuh.fit.WebResources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.entities.ProductImage;
import vn.edu.iuh.fit.reponsitories.ProductImageReponsitory;

@Path("/product_image")
public class ProductImageResource {
    private ProductImageReponsitory productImageReponsitory ;

    public ProductImageResource() {
        productImageReponsitory = new ProductImageReponsitory();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getProductImageByID(@PathParam("id") long ids){
        ProductImage productImage = productImageReponsitory.getOne(ids);
        if (productImage != null){
            return Response.ok(productImage).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Path("/product_id = {id}")
    @Produces("application/json")
    public Response getProductImageByProductID(@PathParam("id") long ids){
        ProductImage productImage = productImageReponsitory.getOne(ids);
        if (productImage != null){
            return Response.ok(productImage).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(ProductImage productImage){
        productImageReponsitory.insertProductImage(productImage);
        return  Response.ok(productImage).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long ids){
        if (productImageReponsitory.deleteProductImage(productImageReponsitory.getOne(ids))){
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @PUT
    @Path("/{ids}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(@PathParam("ids") long id, ProductImage productImage){
        productImage.setImage_id(id);
        if (productImageReponsitory.updateProductImage(productImage)){
            return Response.ok(productImage).build();
        }
        return Response.ok().build();
    }
}
