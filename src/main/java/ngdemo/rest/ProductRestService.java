package ngdemo.rest;

import java.util.ArrayList;
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

import ngdemo.bean.ChartBeanList;
import ngdemo.bean.ChartColsBean;
import ngdemo.bean.ChartRowsBean;
import ngdemo.bean.ChartRowsList;
import ngdemo.bean.JsonBean;
import ngdemo.bean.JsonBeanList;
import ngdemo.bean.JsonChartBeanList;
import ngdemo.bean.TransData;
import ngdemo.domain.Product;
import ngdemo.entity.HealthInfo;
import ngdemo.service.IProductService;
import ngdemo.service.impl.HealthInfoServiceImpl;

import org.seasar.util.convert.BigDecimalConversionUtil;
import org.seasar.util.convert.IntegerConversionUtil;
import org.seasar.util.convert.StringConversionUtil;
import org.seasar.util.convert.TimestampConversionUtil;
import org.seasar.util.lang.StringUtil;

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
    @Path("/getChart")
    @Produces(MediaType.APPLICATION_JSON)
    public ChartBeanList getChart(@Context HttpServletResponse res) {
        List<HealthInfo> colDatas = healthInfoService.findForChartCols();
        ChartBeanList charBeanList = new ChartBeanList();
        //col
        ChartColsBean colsBean = new ChartColsBean();
        List<ChartColsBean> cols = new ArrayList<ChartColsBean>();
        colsBean.label = "heartRate";
        colsBean.type = "string";
        cols.add(colsBean);
        for (HealthInfo entity : colDatas) {
            colsBean = new ChartColsBean();
            colsBean.label = entity.getUserId();
            colsBean.type = "number";
            cols.add(colsBean);
        }
        charBeanList.cols = cols;

        //row
        List<ChartRowsList> rows = new ArrayList<ChartRowsList>();
        ChartRowsList rowsList = new ChartRowsList();
        List<HealthInfo> rowDatas = healthInfoService.findForChartRows();
        List<ChartRowsBean> rowsBeanList = new ArrayList<ChartRowsBean>();
        String lastAssayDateFmt = "";
        for (HealthInfo entity : rowDatas) {
            ChartRowsBean rowsBean = new ChartRowsBean();
            if (!StringUtil.equals(entity.getAssayDateFmt(), lastAssayDateFmt)) {
                if (StringUtil.isNotEmpty(lastAssayDateFmt)) {
                    rowsList.c = rowsBeanList;
                    rows.add(rowsList);
                    rowsBeanList = new ArrayList<ChartRowsBean>();
                    rowsList = new ChartRowsList();
                }
                rowsBean = new ChartRowsBean();
                rowsBean.v = entity.getAssayDateFmt();
                rowsBeanList.add(rowsBean);
            }
            rowsBean = new ChartRowsBean();
            rowsBean.v = StringConversionUtil.toString(entity.getHeartRate());
            rowsBeanList.add(rowsBean);
            lastAssayDateFmt = entity.getAssayDateFmt();
        }
        rowsList.c = rowsBeanList;
        rows.add(rowsList);
        charBeanList.rows = rows;
        JsonChartBeanList json = new JsonChartBeanList();
        List<ChartBeanList> charBeans = new ArrayList<ChartBeanList>();
        charBeans.add(charBeanList);
        json.data = charBeans;
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, DELETE, OPTIONS");
        res.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
        return charBeanList;
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
            bean.gpsLatitude = StringConversionUtil.toString(entity.getGpsLatitude());
            bean.gpsLongitude = StringConversionUtil.toString(entity.getGpsLongitude());
            beans.add(bean);
        }
        JsonBeanList json = new JsonBeanList();
        json.data = beans;
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
        System.out.println("-----recive20141018:" + data.getHeartRate());
//        HealthInfoDao dao = new HealthInfoDaoImpl();
        HealthInfo entity = new HealthInfo();
        entity.setUserId(data.getUserId());
        entity.setHeartRate(IntegerConversionUtil.toInteger(data.getHeartRate()));
        entity.setAssayDate(TimestampConversionUtil.toSqlTimestamp(data.getAssayDate()));
        entity.setGpsLatitude(BigDecimalConversionUtil.toBigDecimal(data.getGpsLatitude()));
        entity.setGpsLongitude(BigDecimalConversionUtil.toBigDecimal(data.getGpsLongitude()));
        healthInfoService.insert(entity);
        TransData responseData = new TransData();
        responseData.setStatus("0");
        return responseData;
    }

}