package hadoopfinal.springserver.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AgeResponse {
    //Name is gender of customer
    private String name;
    private List<Series> series;

    public AgeResponse(String gender, List<Series> series) {
        this.name = gender;
        this.series = series;
    }
}
