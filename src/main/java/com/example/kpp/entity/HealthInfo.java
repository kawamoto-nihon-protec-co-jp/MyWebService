package com.example.kpp.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * HealthInfoクラス
 * @author T.Kawamoto
 * @version 1.0
 */
@Entity(listener = HealthInfoListener.class)
@Table(name = "HEALTH_INFO")
public class HealthInfo {

    /** ID */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    /** ユーザ */
    @Column(name = "USER_ID")
    String userId;

    /** 心拍数 */
    @Column(name = "HEART_RATE")
    Integer heartRate;

    /** 測定日 */
    @Column(name = "ASSAY_DATE")
    Timestamp assayDate;

    /** 緯度 */
    @Column(name = "GPS_LATITUDE")
    BigDecimal gpsLatitude;

    /** 経度 */
    @Column(name = "GPS_LONGITUDE")
    BigDecimal gpsLongitude;

    @Column(name = "ASSAY_DATE_FMT", insertable = false, updatable = false)
    String assayDateFmt;

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

    /**
     * @return assayDateFmt
     */
    public String getAssayDateFmt() {
        return assayDateFmt;
    }

    /**
     * @param assayDateFmt セットする assayDateFmt
     */
    public void setAssayDateFmt(String assayDateFmt) {
        this.assayDateFmt = assayDateFmt;
    }
}