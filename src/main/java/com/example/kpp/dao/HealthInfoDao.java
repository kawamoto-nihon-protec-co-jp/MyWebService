package com.example.kpp.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import com.example.kpp.doma.DomaConfig;
import com.example.kpp.entity.HealthInfo;

/**
 * HealthInfoDaoクラス
 * @author T.Kawamoto
 * @version 1.0
 */
@Dao(config = DomaConfig.class)
public interface HealthInfoDao {

    @Select
    List<HealthInfo> selectAll();

    @Select
    List<HealthInfo> selectForChartCols();

    @Select
    List<HealthInfo> selectForChartRows();

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(HealthInfo entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(HealthInfo entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(HealthInfo entity);
}