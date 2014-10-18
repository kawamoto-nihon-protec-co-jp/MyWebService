package ngdemo.dao;

import ngdemo.config.AppConfig;
import ngdemo.entity.HeartRate;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Update;

/**
 */
@Dao(config = AppConfig.class)
public interface HeartRateDao {

   /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(HeartRate entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(HeartRate entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(HeartRate entity);
}