package ngdemo.bean;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class TransData {
    private String userId;
    private String heartRate;
    private String assayDate;
    private String gpsLatitude;
    private String gpsLongitude;
    private String status = "9";

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public String getAssayDate() {
        return assayDate;
    }

    public void setAssayDate(String assayDate) {
        this.assayDate = assayDate;
    }

    public String getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(String gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public String getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(String gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransData cluster = (TransData) o;

        if (heartRate != cluster.heartRate) return false;

        return true;
    }

//    @Override
//    public int hashCode() {
//        return (int) (data ^ (data >>> 32));
//    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Cluster");
        sb.append("{data=").append(heartRate);
        sb.append('}');
        return sb.toString();
    }

}
