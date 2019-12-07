package hadoopfinal.springserver.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GenderModel {
    private int gender;

    private int num;

    public GenderModel(int gender, int num) {
        this.gender = gender;
        this.num = num;
    }
}
