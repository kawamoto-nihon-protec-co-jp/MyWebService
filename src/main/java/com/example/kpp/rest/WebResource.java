package com.example.kpp.rest;

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

import org.seasar.util.convert.BigDecimalConversionUtil;
import org.seasar.util.convert.IntegerConversionUtil;
import org.seasar.util.convert.StringConversionUtil;
import org.seasar.util.convert.TimestampConversionUtil;
import org.seasar.util.lang.StringUtil;

import com.example.kpp.bean.ChartBeanList;
import com.example.kpp.bean.ChartColsBean;
import com.example.kpp.bean.ChartRowsBean;
import com.example.kpp.bean.ChartRowsList;
import com.example.kpp.bean.JsonBean;
import com.example.kpp.bean.JsonBeanList;
import com.example.kpp.bean.JsonChartBeanList;
import com.example.kpp.bean.TransData;
import com.example.kpp.entity.HealthInfo;
import com.example.kpp.service.HealthInfoService;
import com.example.kpp.util.DateFormatUtil;

/**
 * Resource提供クラス
 * @author T.Kawamoto
 * @version 1.0
 */
@Path("/resource")
public final class WebResource {
    @Inject
    private HealthInfoService healthInfoService;

    /**
     * グラフ用のデータを提供する
     * @param res
     * @return グラフ用のデータ
     */
    @GET
    @Path("/getChartData")
    @Produces(MediaType.APPLICATION_JSON)
    public ChartBeanList createChartData(@Context HttpServletResponse res) {
        List<HealthInfo> colDatas = healthInfoService.findForChartCols();
        ChartBeanList charBeanList = new ChartBeanList();
        // col
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

        // row
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
        return charBeanList;
    }

    /**
     * 一覧表示用のデータを提供する
     * @param res
     * @return 一覧表示用のデータ
     */
    @GET
    @Path("/getGridData")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonBeanList createGridData(@Context HttpServletResponse res) {
        List<HealthInfo> datas = healthInfoService.findAll();
        List<JsonBean> beans = new ArrayList<JsonBean>();
        for (HealthInfo entity : datas) {
            JsonBean bean = new JsonBean();
            bean.userId = entity.getUserId();
            bean.heartRate = StringConversionUtil.toString(entity.getHeartRate());
            bean.assayDate = DateFormatUtil.getDateFormatConvert(entity.getAssayDate());
            bean.gpsLatitude = StringConversionUtil.toString(entity.getGpsLatitude());
            bean.gpsLongitude = StringConversionUtil.toString(entity.getGpsLongitude());
            beans.add(bean);
        }
        JsonBeanList json = new JsonBeanList();
        json.data = beans;
        return json;
    }

    /**
     * 測定情報をデータベースに登録する
     * @param data タブレットからの測定情報
     * @return 処理結果（0:成功, 9:失敗）
     */
    @POST
    @Path("/putHealthInfo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TransData registerHealthInfo(TransData data) {
        TransData responseData = new TransData();
        try {
            HealthInfo entity = new HealthInfo();
            entity.setUserId(data.getUserId());
            entity.setHeartRate(IntegerConversionUtil.toInteger(data.getHeartRate()));
            entity.setAssayDate(TimestampConversionUtil.toSqlTimestamp(data.getAssayDate()));
            entity.setGpsLatitude(BigDecimalConversionUtil.toBigDecimal(data.getGpsLatitude()));
            entity.setGpsLongitude(BigDecimalConversionUtil.toBigDecimal(data.getGpsLongitude()));
            healthInfoService.insert(entity);
            responseData.setStatus("0");
        } catch (Exception e) {
            // エラーになった時の処理
        }

        return responseData;
    }

}