package com.example.kpp.service;

import java.util.List;

import com.example.kpp.entity.HealthInfo;

/**
 * HealthInfoサービスクラス
 * @author T.Kawamoto
 * @version 1.0
 */
public interface HealthInfoService {

    public List<HealthInfo> findAll();

    public List<HealthInfo> findForChartCols();

    public List<HealthInfo> findForChartRows();

    public int insert(HealthInfo entity);

    public int update(HealthInfo entity);

    public int delete(HealthInfo entity);
}
