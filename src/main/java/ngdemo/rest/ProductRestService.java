package ngdemo.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ngdemo.bean.TransData;
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

    @POST
    @Path("/putMessage")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TransData getCluster(TransData data) {
        TransData responseData = new TransData();
        responseData.setData(data.getData());
        return responseData;
    }

}