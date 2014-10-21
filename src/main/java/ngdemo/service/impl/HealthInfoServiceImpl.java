package ngdemo.service.impl;

import java.util.List;

import javax.inject.Inject;

import ngdemo.dao.HealthInfoDao;
import ngdemo.entity.HealthInfo;
import ngdemo.guice.persist.DomaTransactionAttribute;
import ngdemo.service.HealthInfoService;

public class HealthInfoServiceImpl implements HealthInfoService {
    @Inject
    private HealthInfoDao healthInfoDao;

    @DomaTransactionAttribute
    public List<HealthInfo> findAll() {
        return healthInfoDao.selectAll();
    }

    public int insert(HealthInfo entity) {
        return healthInfoDao.insert(entity);
    }

    public int update(HealthInfo entity) {
        return healthInfoDao.update(entity);
    }

    public int delete(HealthInfo entity) {
        return healthInfoDao.delete(entity);
    }
}
