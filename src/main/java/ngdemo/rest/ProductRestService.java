package ngdemo.rest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import ngdemo.bean.JsonBean;
import ngdemo.bean.JsonBeanList;
import ngdemo.bean.TransData;
import ngdemo.domain.Product;
import ngdemo.entity.HealthInfo;
import ngdemo.service.IProductService;
import ngdemo.service.impl.HealthInfoServiceImpl;

import org.seasar.util.convert.StringConversionUtil;

@Path("/products")
public final class ProductRestService {
    @Inject
    private IProductService service;
    @Inject
    private HealthInfoServiceImpl healthInfoService;


    @Path("/getMsg")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProduct() {
//        String ret = "[{\"name\":\"kawamoto1\"},{\"name\":\"product3\"}]";
        return this.service.getProducts();
//        return ret;
    }

    @GET
    @Path("/getMessage")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonBeanList getMessage(@Context HttpServletResponse res) {
        List<HealthInfo> datas = healthInfoService.findAll();
        List<JsonBean> beans = new ArrayList<JsonBean>();
        for (HealthInfo entity : datas) {
            JsonBean bean = new JsonBean();
            bean.userId = entity.getUserId();
            bean.heartRate = StringConversionUtil.toString(entity.getHeartRate());
            bean.assayDate = StringConversionUtil.toString(entity.getAssayDate());
            beans.add(bean);
        }
        JsonBeanList json = new JsonBeanList();
        json.data = beans;
        LinkedHashMap<String, JsonBean> m = new LinkedHashMap<String, JsonBean>();
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, DELETE, OPTIONS");
        res.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
        return json;
    }

    @POST
    @Path("/putMessage")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TransData getCluster(TransData data) {
        System.out.println("-----recive20141018:" + data.getData());
//        HealthInfoDao dao = new HealthInfoDaoImpl();
        HealthInfo entity = new HealthInfo();
        entity.setHeartRate(Integer.parseInt(data.getData()));
        healthInfoService.insert(entity);
        TransData responseData = new TransData();
        responseData.setData("100");
        return responseData;
    }

}