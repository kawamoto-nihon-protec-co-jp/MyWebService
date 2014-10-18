package ngdemo.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = HealthInfoListener.class)
@Table(name = "HEALTH_INFO")
public class HealthInfo {

    /**  */
    @Column(name = "USER_ID")
    String userId;

    /**  */
    @Id
    @Column(name = "HEART_RATE")
    Integer heartRate;

    /**  */
    @Column(name = "ASSAY_DATE")
    Timestamp assayDate;

    /** 緯度 */
    @Column(name = "GPS_LATITUDE")
    BigDecimal gpsLatitude;

    /** 経度 */
    @Column(name = "GPS_LONGITUDE")
    BigDecimal gpsLongitude;

    /** 
     * Returns the userId.
     * 
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /** 
     * Sets the userId.
     * 
     * @param userId the userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
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

    /** 
     * Returns the assayDate.
     * 
     * @return the assayDate
     */
    public Timestamp getAssayDate() {
        return assayDate;
    }

    /** 
     * Sets the assayDate.
     * 
     * @param assayDate the assayDate
     */
    public void setAssayDate(Timestamp assayDate) {
        this.assayDate = assayDate;
    }

    /** 
     * Returns the gpsLatitude.
     * 
     * @return the gpsLatitude
     */
    public BigDecimal getGpsLatitude() {
        return gpsLatitude;
    }

    /** 
     * Sets the gpsLatitude.
     * 
     * @param gpsLatitude the gpsLatitude
     */
    public void setGpsLatitude(BigDecimal gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    /** 
     * Returns the gpsLongitude.
     * 
     * @return the gpsLongitude
     */
    public BigDecimal getGpsLongitude() {
        return gpsLongitude;
    }

    /** 
     * Sets the gpsLongitude.
     * 
     * @param gpsLongitude the gpsLongitude
     */
    public void setGpsLongitude(BigDecimal gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }
}