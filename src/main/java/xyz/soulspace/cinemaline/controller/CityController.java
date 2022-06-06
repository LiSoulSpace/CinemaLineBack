package xyz.soulspace.cinemaline.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.soulspace.cinemaline.api.CommonResult;
import xyz.soulspace.cinemaline.entity.City;
import xyz.soulspace.cinemaline.service.CityService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:03
 */
@Slf4j
@Controller
@RequestMapping("/cinemaline/city")
@Tag(name = "城市控制器(CityController)")
@CrossOrigin
public class CityController {
    @Autowired
    CityService cityService;

    @Operation(summary = "获得所有可以买电影票的地区", method = "GET")
    @RequestMapping(value = "/getAddrs", method = RequestMethod.GET)
    public ResponseEntity<?> getAddrs() {
        Map<String, List<Map<String, String>>> allCityInfo = new ConcurrentHashMap<>();
        try {
            allCityInfo = cityService.getAllCityInfo();
            return ResponseEntity.ok(CommonResult.success(allCityInfo));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.ok(allCityInfo);
    }
}
