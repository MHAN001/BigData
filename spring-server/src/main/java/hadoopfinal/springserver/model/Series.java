package hadoopfinal.springserver.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Series {
    //this name is age range of customer
    private String name;
    private int value;

    public Series(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
