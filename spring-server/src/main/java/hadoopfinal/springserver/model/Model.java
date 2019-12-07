package hadoopfinal.springserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private long user_id;

    private long item_id;

    private long cat_id;

    private long merchant_id;

    private long brand_id;

    private int month;

    private int day;

    private int action;

    private int age_range;

    private int gender;

    private String province;

    public int getId() {
        return id;
    }

    public long getUser_id() {
        return user_id;
    }

    public long getItem_id() {
        return item_id;
    }

    public long getCat_id() {
        return cat_id;
    }

    public long getMerchant_id() {
        return merchant_id;
    }

    public long getBrand_id() {
        return brand_id;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getAction() {
        return action;
    }

    public int getAge_range() {
        return age_range;
    }

    public int getGender() {
        return gender;
    }

    public String getProvince() {
        return province;
    }
}
