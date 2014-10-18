package ngdemo.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ngdemo.bean.TransData;
import ngdemo.config.AppConfig;
import ngdemo.dao.HealthInfoDao;
import ngdemo.dao.HealthInfoDaoImpl;
import ngdemo.entity.HealthInfo;
import ngdemo.service.IProductService;

import org.seasar.doma.jdbc.tx.LocalTransaction;

@Path("/products")
public final class ProductRestService {
    LocalTransaction tx = AppConfig.getLocalTransaction();
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
        System.out.println("-----recive20141018:" + data.getData());
        // 開始
        tx.begin();
        HealthInfoDao dao = new HealthInfoDaoImpl();
        HealthInfo entity = new HealthInfo();
        entity.setHeartRate(Integer.parseInt(data.getData()));
        dao.insert(entity);
        // コミット
        tx.commit();
        TransData responseData = new TransData();
        responseData.setData("100");
        return responseData;
    }

}