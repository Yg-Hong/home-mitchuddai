package com.whereismyhome.house.news.controller;

import com.whereismyhome.house.news.api.NaverNewsApi;
import com.whereismyhome.house.news.dto.OpenApiParameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE} , maxAge = 6000)
@RestController
@RequestMapping("/open")
@RequiredArgsConstructor
@Slf4j
public class OpenApiController {

    @Autowired
    NaverNewsApi naver = new NaverNewsApi();

    @GetMapping("/news")
    public ResponseEntity<JSONObject> getNews(@RequestBody OpenApiParameter openApiParameter) throws Exception {

        JSONParser parser = new JSONParser();
        Object keyword;
        JSONObject obj;

        if (openApiParameter.getEconomicTrend() != "") {
            keyword = parser.parse(naver.search(openApiParameter.getEconomicTrend()));
        } else if (openApiParameter.getHousing() != "") {
            keyword = parser.parse(naver.search(openApiParameter.getHousing()));
        } else if (openApiParameter.getOffice() != "") {
            keyword = parser.parse(naver.search(openApiParameter.getOffice()));
        }
        else {
            keyword = parser.parse(naver.search(openApiParameter.getRealEstate()));
        }

        obj = (JSONObject) keyword;
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }


}