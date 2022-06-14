package xyz.soulspace.cinemaline.controller;

import io.swagger.v3.oas.annotations.OpenAPI30;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.DispatcherServlet;
import xyz.soulspace.cinemaline.api.CommonResult;
import xyz.soulspace.cinemaline.entity.ImgInfo;
import xyz.soulspace.cinemaline.service.ImgInfoService;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 02:38:28
 */
@Slf4j
@Controller
@RequestMapping("/cinemaline/imgInfo")
@Tag(name = "图片信息控制器(ImgInfoController)")
public class ImgInfoController {
    @Autowired
    ImgInfoService imgInfoService;
    @Autowired
    ServletContext servletContext;

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

    @Operation(summary = "图片上传测试")
    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST, consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public ResponseEntity<?> uploadFile(@RequestPart("file") MultipartFile file) throws IOException {
        log.warn(file.getName());
        log.warn(file.getContentType());
        log.warn(file.getInputStream().toString());
        byte[] bytes = file.getInputStream().readAllBytes();
        log.warn(Arrays.toString(bytes));
        long fileSize = file.getSize();
        Map<String, Object> map = new HashMap<>();
        if (file.isEmpty()) {
            return ResponseEntity.ok("文件为空");
        } else {
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀名
            assert fileName != null;
            String extensionFileName = fileName.substring(fileName.lastIndexOf("."));
        }
        return ResponseEntity.ok(bytes);
    }
}
