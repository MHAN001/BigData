package hadoopfinal.springserver.persistent;

import hadoopfinal.springserver.model.AgeModel;
import hadoopfinal.springserver.model.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Repository extends CrudRepository<Model, Integer> {
    @Query(value = "SELECT * from user_log limit 10", nativeQuery = true)
    List<Model> findTen();
    //Age-range comparison
    @Query(value = "select gender,age_range,count(*) num from user_log group by gender,age_range desc", nativeQuery = true)
    List<int[]> findAgeCompare();
    //Top 5 seller
    @Query(value = "select cat_id,count(*) num from user_log group by cat_id order by count(*) desc limit 5", nativeQuery = true)
    List<int[]> findTop5();
    //Gender comparison
    @Query(value = "select gender,count(*) num from user_log group by gender desc", nativeQuery = true)
    List<int[]> findGenderCompare();
}
