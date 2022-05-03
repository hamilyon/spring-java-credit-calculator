package com.torque.mortgagecalculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class MortgageController {

    @PostMapping("/mortgage")
    @CrossOrigin(origins = "http://localhost:3000")
    public Map<String, Object> mortgageDecision(@RequestBody Mortgage mortgage) {

        Map<String, Object> result = new HashMap<String, Object>();
        if (mortgage.getTotalsum() > 1000000) {
            result.put("currentPage", "contactUs");
            return result;
        } else {
            result.put("currentPage", "result");
            result.put("totalsum", mortgage.getTotalsum());
            result.put("annual_percent", mortgage.getAnnual_percent());
            result.put("term", mortgage.getTerm());
            result.put("residual_value", mortgage.getResidual_value());
            double r = mortgage.getAnnual_percent() / 100 / 12;
            double PV = mortgage.getTotalsum();
            double FV = mortgage.getResidual_value();
            double n = mortgage.getTerm();
            result.put("monthly_payment",
                    (PV - (FV / (Math.pow((1 + r), n)))) * (r / (1 - Math.pow((1 + r), -n))));
//                    mortgage.getTotalsum() * (P + (P / ((Math.pow((1 + P), mortgage.getTerm())) - 1))));

            return result;
        }
    }
}
