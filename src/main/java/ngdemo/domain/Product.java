package ngdemo.domain;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}