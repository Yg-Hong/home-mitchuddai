package com.whereismyhome.house.house.controller;

import com.whereismyhome.house.house.VO.DetailResultVO;
import com.whereismyhome.house.house.VO.SearchResultVO;
import com.whereismyhome.house.house.service.HouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{dongCode}")
    public List<SearchResultVO> getHouseListByDongCode(@PathVariable Long dongCode) {
        log.info("dong : " + dongCode);
        List<SearchResultVO> list = null;

        list = houseService.getHouseListByDongCode(dongCode);

        log.info(list.toString());
        return list;
    }

    @GetMapping("/{dongCode}/{aptCode}")
    public List<DetailResultVO> getDealListByDongCode(@PathVariable Long dongCode, @PathVariable Long aptCode) {
        log.info("dptCode : " + aptCode);
        List<DetailResultVO> list = null;

        list = houseService.getDealListByDongCode(dongCode, aptCode);

        log.info(list.toString());
        return list;
    }
}
