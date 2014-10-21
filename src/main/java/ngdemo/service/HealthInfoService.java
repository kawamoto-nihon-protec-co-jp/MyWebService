package ngdemo.service;

import java.util.List;

import ngdemo.entity.HealthInfo;

public interface HealthInfoService {

    public List<HealthInfo> findAll();

    public int insert(HealthInfo entity);

    public int update(HealthInfo entity);

    public int delete(HealthInfo entity);
}
