package com.example.kpp.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.example.kpp.dao.HealthInfoDao;
import com.example.kpp.entity.HealthInfo;
import com.example.kpp.guice.persist.DomaTransactionAttribute;
import com.example.kpp.service.HealthInfoService;

/**
 * HealthInfoサービスクラスの実装
 * @author T.Kawamoto
 * @version 1.0
 */
public class HealthInfoServiceImpl implements HealthInfoService {
    @Inject
    private HealthInfoDao healthInfoDao;

    @DomaTransactionAttribute
    public List<HealthInfo> findAll() {
        return healthInfoDao.selectAll();
    }

    @DomaTransactionAttribute
    public List<HealthInfo> findForChartCols() {
        return healthInfoDao.selectForChartCols();
    }

    @DomaTransactionAttribute
    public List<HealthInfo> findForChartRows() {
        return healthInfoDao.selectForChartRows();
    }

    @DomaTransactionAttribute
    public int insert(HealthInfo entity) {
        return healthInfoDao.insert(entity);
    }

    @DomaTransactionAttribute
    public int update(HealthInfo entity) {
        return healthInfoDao.update(entity);
    }

    @DomaTransactionAttribute
    public int delete(HealthInfo entity) {
        return healthInfoDao.delete(entity);
    }
}
