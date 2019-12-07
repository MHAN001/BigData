package hadoopfinal.springserver.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Top5Model {
    private int cat_id;

    private int num;

    public Top5Model(int cat_id, int num) {
        this.cat_id = cat_id;
        this.num = num;
    }
}
