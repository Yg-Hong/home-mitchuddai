package com.whereismyhome.house.house.controller;

import com.whereismyhome.house.house.dto.LocationCodeDto;
import com.whereismyhome.house.house.model.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping(value = "/getSido")
    public List<LocationCodeDto> getSidoList() throws IOException {
        return locationService.getSidoList();
    }

    @GetMapping(value = "/getGugun/{sido}")
    public List<LocationCodeDto> getGugunList(@PathVariable String sido) throws IOException {
        return locationService.getGugunList(sido);
    }

    @GetMapping(value = "/getDong/{gugun}")
    public List<LocationCodeDto> getDongList(@PathVariable String gugun) throws IOException {
        return locationService.getDongList(gugun);
    }
}
