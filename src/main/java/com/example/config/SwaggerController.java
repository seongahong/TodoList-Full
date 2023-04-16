package com.example.config;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class SwaggerController {

    @GetMapping("getApi")
    public ResponseEntity<HashMap> getApi(@RequestParam(value="param1")String param1){
        HashMap map = new HashMap();
        map.put("param1",param1);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
