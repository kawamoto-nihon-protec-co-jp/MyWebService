package ngdemo.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ngdemo.service.IProductService;

@Path("/products")
public final class ProductRestService {

    private final IProductService service;

    @Inject
    public ProductRestService(IProductService service) {
        this.service = service;
    }


    @Path("/getMessage")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProduct() {
        String ret = "[{\"name\":\"kawamoto1\"},{\"name\":\"product3\"}]";
//        return this.service.getProducts();
        return ret;
    }

}