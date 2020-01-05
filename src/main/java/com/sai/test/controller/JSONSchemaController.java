package com.sai.test.controller;


import com.fasterxml.jackson.core.JsonProcessingException;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import com.sai.test.Repository.A4Repository;
import com.sai.test.JsonSchema.MyClass;
import com.sai.test.model.A;
import com.sai.test.model.A4List;
import com.sai.test.service.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/task1")
public class JSONSchemaController
{

    @Autowired
    private A4Repository repo;

    @Autowired
    private AService aService;

    @CrossOrigin
    @GetMapping(path="/getASchema", produces = "application/json")
    public String getASchema() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaGenerator jsonSchemaGenerator = new JsonSchemaGenerator(objectMapper);
        JsonSchema jsonSchema = jsonSchemaGenerator.generateSchema(MyClass.class);


        String jsonSchemaAsString = objectMapper.writeValueAsString(jsonSchema);
        jsonSchemaAsString = "{\"schema\":"+jsonSchemaAsString+",\"disable_edit_json\":1,\n" +
                "  \"disable_properties\": 1,\"disable_collapse\":1}";
        System.out.println(jsonSchemaAsString);
        System.out.println(" -- getting all Employees --");
        Iterable<A4List> iterable = repo.findAll();
        ArrayList<String> enum_list = new ArrayList<String>();
        for (A4List a4List : iterable) {
            System.out.println(a4List.getName());
            enum_list.add("\""+ a4List.getName()+"\"");
        }
        System.out.println(enum_list.toString());
        jsonSchemaAsString= jsonSchemaAsString.replace("[\"Replace\"]",enum_list.toString());
        return jsonSchemaAsString;
    }


    @CrossOrigin
    @PostMapping(value = "/createA", consumes = "application/json", produces = "application/json")
    public A createPerson(@RequestBody A a) {
        return aService.saveA(a);
    }

}
