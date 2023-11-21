package com.whereismyhome.house.house.controller;

import com.whereismyhome.house.house.VO.DetailResultVO;
import com.whereismyhome.house.house.VO.SearchResultVO;
import com.whereismyhome.house.house.service.HouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/house")
@Slf4j
public class HouseController {

    private final HouseService houseService;

    HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("")
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
    public DetailResultVO getDealListByDongCode(@PathVariable Long dongCode, @PathVariable Long aptCode) {
        log.info("aptCode : " + aptCode);
        DetailResultVO result = null;

        result = houseService.getDealListByDongCode(dongCode, aptCode);

        log.info(result.toString());
        return result;
    }

    @GetMapping("/{dongCode}/{aptCode}/graph")
    public Map<Integer, Integer> getGraphData(@PathVariable Long dongCode, @PathVariable Long aptCode) {
        log.info("dongCode : " + dongCode + "aptCode : " + aptCode);

        return null;
    }

    @GetMapping("/{dongCode}/{aptCode}/comment")
    public List<DetailResultVO> getCommentListByAptCode(@PathVariable Long dongCode, @PathVariable Long aptCode) {
        log.info("dongCode : " + dongCode + "aptCode : " + aptCode);

        return null;
    }

    @PostMapping("/{dongCode}/{aptCode}/comment")
    public DetailResultVO postCommentListByAptCode(@PathVariable Long dongCode, @PathVariable Long aptCode) {
        log.info("dongCode : " + dongCode + "aptCode : " + aptCode);

        return null;
    }
}
