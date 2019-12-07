package hadoopfinal.springserver.model;

public class AgeModel {
    public AgeModel(int gender, int age_range, int num) {
        this.gender = gender;
        this.age_range = age_range;
        this.num = num;
    }

    private int gender;

    private int age_range;

    private int num;

    public int getGender() {
        return gender;
    }

    public int getAge_range() {
        return age_range;
    }

    public int getNum() {
        return num;
    }
}
