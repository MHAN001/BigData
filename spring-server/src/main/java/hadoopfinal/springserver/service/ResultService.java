package hadoopfinal.springserver.service;

import hadoopfinal.springserver.model.*;
import hadoopfinal.springserver.persistent.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/data")
public class ResultService {
    @Autowired
    private Repository repository;

    @GetMapping(path = "ten")
    public @ResponseBody Iterable<Model> getAll() {
        return repository.findTen();
    }

    @GetMapping(path = "age-compare")
    public @ResponseBody List<AgeResponse> getAgeCompare() {
        List<AgeModel> model = repository.findAgeCompare().stream().map(x -> new AgeModel(x[0], x[1], x[2])).collect(Collectors.toList());
        Map<String, List<Series>> map = new HashMap<>();
        for (AgeModel m : model) {
            String age = "";
            switch (m.getAge_range()) {
                case 0:
                    age = "unknow";
                    break;
                case 1:
                    age = "< 18";
                    break;
                case 2:
                    age = "[18,24]";
                    break;
                case 3:
                    age = "[25,29]";
                    break;
                case 4:
                    age = "[30,34]";
                    break;
                case 5:
                    age = "[35,39]";
                    break;
                case 6:
                    age = "[40,49]";
                    break;
                case 7:
                    age = ">=50";
                    break;
            }
            String gender = m.getGender() == 1 ? "male" : (m.getGender() == 2 ? "unknown" : "female");
            Series s = new Series(age, m.getNum());
            map.putIfAbsent(gender, new ArrayList<>());
            map.get(gender).add(s);
        }
        List<AgeResponse> res = new ArrayList<>();
        for (Map.Entry<String, List<Series>> e : map.entrySet()) {
            res.add(new AgeResponse(e.getKey(), e.getValue()));
        }
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
