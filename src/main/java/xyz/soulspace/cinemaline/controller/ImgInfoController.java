package xyz.soulspace.cinemaline.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.soulspace.cinemaline.api.CommonResult;
import xyz.soulspace.cinemaline.entity.ImgInfo;
import xyz.soulspace.cinemaline.service.ImgInfoService;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 02:38:28
 */
@Controller
@RequestMapping("/cinemaline/imgInfo")
@Tag(name = "图片信息控制器(ImgInfoController)")
public class ImgInfoController {
    @Autowired
    ImgInfoService imgInfoService;

    @Operation(summary = "添加图片信息")
    @RequestMapping(value = "/addImgInfo", method = RequestMethod.POST)
    public ResponseEntity<?> addImgInfo(@RequestBody ImgInfo imgInfo) {
        boolean save = imgInfoService.save(imgInfo);
        if (save) return ResponseEntity.ok(CommonResult.success(imgInfo));
        else return ResponseEntity.ok(CommonResult.failed(1, "添加图片失败", null));
    }

    @Operation(summary = "获取图片信息")
    @RequestMapping(value = "/listImgInfo", method = RequestMethod.GET)
    public ResponseEntity<?> listImgInfo() {
        List<ImgInfo> list = imgInfoService.list();
        return ResponseEntity.ok(CommonResult.success(list));
    }
}
