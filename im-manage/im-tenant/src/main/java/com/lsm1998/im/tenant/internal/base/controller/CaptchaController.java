package com.lsm1998.im.tenant.internal.base.controller;

import com.google.code.kaptcha.Producer;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("base")
public class CaptchaController
{
    @Resource
    private Producer captchaProducer;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping(value = "captcha" , produces = "image/jpeg")
    public byte[] getCaptchaCode(@RequestParam String captchaId) throws IOException
    {
        // 生成文字验证码
        String capText = captchaProducer.createText();
        String capStr = capText.substring(0, capText.lastIndexOf("@"));
        String code = capText.substring(capText.lastIndexOf("@") + 1);
        BufferedImage image = captchaProducer.createImage(capStr);
        // 保存到缓存
        redisTemplate.opsForValue().set(captchaId, code, 5, TimeUnit.MINUTES);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // 输出图片流
        ImageIO.write(image, "jpg", outputStream);
        return outputStream.toByteArray();
    }
}
