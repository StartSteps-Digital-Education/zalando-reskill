package com.ecommerce.resources;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(Product product) {
        productService.addProduct(product);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

//    @GET
//    public Response getProducts(
//            @QueryParam("page") @DefaultValue("1") int page,
//            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
//
//        List<Product> allProducts = productService.getAllProducts();
//        int totalProducts = allProducts.size();
//
//        int fromIndex = (page - 1) * pageSize;
//        int toIndex = Math.min(fromIndex + pageSize, totalProducts);
//
//        if (fromIndex >= totalProducts || fromIndex < 0) {
//            return Response.status(Response.Status.NOT_FOUND).entity("Page not found").build();
//        }
//
//        List<Product> paginatedProducts = allProducts.subList(fromIndex, toIndex);
//
//        return Response.ok(paginatedProducts)
//                .header("X-Total-Count", totalProducts)
//                .header("X-Page", page)
//                .header("X-Page-Size", pageSize)
//                .build();
//    }


}
