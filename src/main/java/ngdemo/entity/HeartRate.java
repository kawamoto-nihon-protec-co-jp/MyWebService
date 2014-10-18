package ngdemo.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = HeartRateListener.class)
@Table(name = "HEART_RATE")
public class HeartRate {

    /**  */
    @Column(name = "ID")
    Integer id;

    /**  */
    @Column(name = "HEART_RATE")
    Integer heartRate;

    /** 
     * Returns the id.
     * 
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /** 
     * Sets the id.
     * 
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 
     * Returns the heartRate.
     * 
     * @return the heartRate
     */
    public Integer getHeartRate() {
        return heartRate;
    }

    /** 
     * Sets the heartRate.
     * 
     * @param heartRate the heartRate
     */
    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }
}