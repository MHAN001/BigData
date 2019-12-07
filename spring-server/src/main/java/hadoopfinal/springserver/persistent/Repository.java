package hadoopfinal.springserver.persistent;

import hadoopfinal.springserver.model.AgeModel;
import hadoopfinal.springserver.model.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Repository extends CrudRepository<Model, Integer> {
    @Query(value = "SELECT * from user_log limit 10", nativeQuery = true)
    List<Model> findTen();

    @Query(value = "select gender,age_range,count(*) num from user_log group by gender,age_range desc", nativeQuery = true)
    List<int[]> findAgeCompare();
}
