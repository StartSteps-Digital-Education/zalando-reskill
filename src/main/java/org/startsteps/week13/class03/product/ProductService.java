package org.startsteps.week13.class03.product;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
import java.util.stream.Collectors;

@Path("/products")
public class ProductService {

    private static Map<Integer, Product> products = new HashMap<>();
    private static Integer idCounter;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product addProduct(Product product) {
        int id = idCounter++;
        product.setId(id);
        products.put(id, product);
        return product;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts(@QueryParam("category") String category,
                                     @QueryParam("minPrice") Double minPrice,
                                     @QueryParam("maxPrice") Double maxPrice,
                                     @QueryParam("page") @DefaultValue("1") int page,
                                     @QueryParam("size") @DefaultValue("10") int size) {
        return products.values().stream()
                .filter(product -> (category == null || product.getCategory().equals(category)) &&
                        (minPrice == null || product.getPrice() >= minPrice) &&
                        (maxPrice == null || product.getPrice() <= maxPrice))
                .skip((long) (page - 1) * size)
                .limit(size)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") int id) {
        return products.get(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product updateProduct(@PathParam("id") int id, Product product) {
        product.setId(id);
        products.put(id, product);
        return product;
    }

    @DELETE
    @Path("/{id}")
    public void deleteProduct(@PathParam("id") int id) {
        products.remove(id);
    }
}


