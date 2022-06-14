package xyz.soulspace.cinemaline.qrcodeTest;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
public class QrcodeTest {
    @Test
    public void qrcodeOut() {
        QrConfig qrConfig = QrConfig.create();
        String s = QrCodeUtil.generateAsBase64("www.baidu.com", qrConfig, ImgUtil.IMAGE_TYPE_PNG);
        log.warn(s);
    }
}
