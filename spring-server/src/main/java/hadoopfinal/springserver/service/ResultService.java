package hadoopfinal.springserver.service;

import hadoopfinal.springserver.model.AgeModel;
import hadoopfinal.springserver.model.GenderModel;
import hadoopfinal.springserver.model.Model;
import hadoopfinal.springserver.model.Top5Model;
import hadoopfinal.springserver.persistent.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/data")
public class ResultService {
    @Autowired
    private Repository repository;

    @GetMapping(path = "ten")
    public @ResponseBody Iterable<Model> getAll() {
        return repository.findTen();
    }

    @GetMapping(path = "age-compare")
    public @ResponseBody List<AgeModel> getAgeCompare() {
        List<AgeModel> res = repository.findAgeCompare().stream().map(x -> new AgeModel(x[0], x[1], x[2])).collect(Collectors.toList());
        return res;
    }

    @GetMapping(path = "top5")
    public @ResponseBody Iterable<Top5Model> getTopFive() {
        List<Top5Model> res = repository.findTop5().stream().map(x -> new Top5Model(x[0], x[1])).collect(Collectors.toList());
        return res;
    }

    @GetMapping(path = "gender-compare")
    public @ResponseBody List<GenderModel> getGenderCompare() {
        List<GenderModel> res = repository.findGenderCompare().stream().map(x -> new GenderModel(x[0], x[1])).collect(Collectors.toList());
        return res;
    }
}
