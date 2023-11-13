package com.whereismyhome.house.house.controller;

import com.whereismyhome.house.house.dto.HouseDto;
import com.whereismyhome.house.house.model.service.HouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/house")
@Slf4j
public class HouseController {

    private final HouseService houseService;

    HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/")
    public void controllerTest() {
        log.trace("연결 완료");
    }

    @GetMapping("/detail/{dong}/{year}/{month}")
    public List<HouseDto> getHouseDetail(@PathVariable(name = "dong") String dong,
                                         @PathVariable(name="year") int year,
                                         @PathVariable(name = "month") int month) {
        log.info(dong + " " + year + " " + month);
        List<HouseDto> list = null;

        try {
            list = houseService.searchByDongCode(dong, year, month);
        } catch (SQLException e) {
            return null;
        }

        log.info(list.toString());
        return list;
    }
}
