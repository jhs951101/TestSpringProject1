package com.example.demo.controller;

import io.micrometer.core.instrument.util.StringUtils;
import java.util.HashMap;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    private JSONObject setUserInfo(JSONObject response){
        response.put("name", "심지훈");
        response.put("age", 25);
        return response;
    }

    @GetMapping("/get")
    public String processGetRequest(
        @RequestParam(value = "username", required = false) String memberId,
        @RequestParam(required = false) String password
    ) {
        JSONObject response = new JSONObject().put("success", false);

        if(StringUtils.isNotBlank(memberId) && StringUtils.isNotBlank(password)){
            response = setUserInfo(response);

            response.put("success", true);
        }

        return response.toString();
    }

    @PostMapping("/post")
    public String processPostRequest(
        @RequestParam(value = "username", required = false) String memberId,
        @RequestParam(required = false) String password
    ) {
        JSONObject response = new JSONObject().put("success", false);

        if(StringUtils.isNotBlank(memberId) && StringUtils.isNotBlank(password)){
            response = setUserInfo(response);

            response.put("success", true);
        }

        return response.toString();
    }

    @ResponseBody
    @PostMapping("/postjson")
    public String processPostJsonRequest(
        @RequestBody HashMap<String, Object> params
    ) {
        JSONObject response = new JSONObject().put("success", false);

        if (StringUtils.isNotBlank( (String) params.get("username") )
            && StringUtils.isNotBlank( (String) params.get("password") )
        ) {
            response = setUserInfo(response);

            response.put("success", true);
        }

        return response.toString();
    }
}