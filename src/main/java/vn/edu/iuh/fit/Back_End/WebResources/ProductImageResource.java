package vn.edu.iuh.fit.Back_End.WebResources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.Back_End.convertes.JacksonConfigMapper;
import vn.edu.iuh.fit.Back_End.reponsitories.ProductImageReponsitory;
import vn.edu.iuh.fit.Back_End.entities.ProductImage;

@Path("/product_image")
public class ProductImageResource {
    private final ProductImageReponsitory productImageReponsitory = new ProductImageReponsitory();
    private final JacksonConfigMapper jacksonConfigMapper = new JacksonConfigMapper();

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getProductImageByID(@PathParam("id") long ids){
        ProductImage productImage = productImageReponsitory.getOne(ids);
        if (productImage != null){
            try {
                String json = jacksonConfigMapper.getContext(ProductImage.class)
                        .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false)
                        .writeValueAsString(productImage);
                return Response.ok(json).build();
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
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
        System.out.println(productImage);
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
//        productImage.setImage_id(id);
//        if (productImageReponsitory.updateProductImage(productImage)){
//            return Response.ok(productImage).build();
//        }
        System.out.println(productImage.getAlternative());
        System.out.println(productImage.getPath());
        return Response.ok().build();
    }
}
