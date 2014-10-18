package ngdemo.bean;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class TransData {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransData cluster = (TransData) o;

        if (data != cluster.data) return false;

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
        sb.append("{data=").append(data);
        sb.append('}');
        return sb.toString();
    }

}
