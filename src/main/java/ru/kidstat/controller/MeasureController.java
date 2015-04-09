package ru.kidstat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kidstat.model.Activity;
import ru.kidstat.model.Measure;
import ru.kidstat.service.MeasureService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darya on 28/01/15.
 */

@Controller
@SessionAttributes("measure")
public class MeasureController {


   /* @RequestMapping(value = "/measure")
    public String addMeasure(@ModelAttribute ("measure") Measure measure) {
        System.out.println("weight: " + measure.getWeight());
        return "measure";
    }*/

    @Autowired
    private MeasureService measureService;

    @RequestMapping(value = "/measure", method = RequestMethod.GET)
    public String addMeasure(Model model) {
        Measure measure = new Measure();
        model.addAttribute("measure", measure);
        return "measure";
    }

    @RequestMapping(value = "/measure", method = RequestMethod.POST)
    public String updateMeasure(@ModelAttribute("measure") Measure measure){

        System.out.println("minutes updated:" + measure.getWeight());
        measureService.save(measure);
        return "redirect:measure";
    }

    @RequestMapping(value = "/activities", method = RequestMethod.GET)
    public @ResponseBody List<Activity> findAllActivities() {
        List<Activity> activities  = new ArrayList<Activity>();

        Activity run = new Activity();
        run.setDesc("Run");
        activities.add(run);

        Activity bike = new Activity();
        run.setDesc("Bike");
        activities.add(bike);

        Activity swim = new Activity();
        run.setDesc("Swim");
        activities.add(swim);

        return activities;

    }
}
