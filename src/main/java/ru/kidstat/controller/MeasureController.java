package ru.kidstat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.kidstat.model.Measure;
import ru.kidstat.service.MeasureService;

import javax.validation.*;
import java.util.Set;


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

    private Validator validator;

    public MeasureController() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }


    @RequestMapping(value = "/measure", method = RequestMethod.GET)
    public String addMeasure(Model model) {
        Measure measure = new Measure();
        model.addAttribute("measure", measure);
        model.addAttribute("listMeasures", this.measureService.getMeasures());
        return "measure";
    }

    @RequestMapping(value = "/measure", method = RequestMethod.POST)
    public String updateMeasure(@Valid @ModelAttribute("measure") Measure measure, BindingResult result){

        Set<ConstraintViolation<Measure>> violations = validator.validate(measure);

        for (ConstraintViolation<Measure> violation : violations)
        {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            // Add JSR-303 errors to BindingResult
            // This allows Spring to display them in view via a FieldError
            result.addError(new FieldError("measure", propertyPath, "Invalid "+ propertyPath + "(" + message + ")"));

        }

        System.out.println("result has errors: " + result.hasErrors());
        System.out.println("measure updated:" + measure.getWeight());

        if (result.hasErrors()) {
            return "measure";
        }

        else {
            measureService.save(measure);
            return "redirect:measure";
        }
    }

}
