package com.example.qnasystem2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@Controller
@RequestMapping("/captcha")
public class CaptchaController {

    private static final int WIDTH = 120;
    private static final int HEIGHT = 40;
    private static final int LENGTH = 4; // 验证码长度

    @GetMapping
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 1. 生成随机验证码
        String code = generateCode(LENGTH);
        HttpSession session = req.getSession();
        session.setAttribute("captcha", code);

        // 2. 创建图片
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) image.getGraphics();

        // 背景色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // 字体
        g.setFont(new Font("Arial", Font.BOLD, 28));

        Random random = new Random();

        // 3. 绘制每个字符
        int charWidth = WIDTH / LENGTH;
        for (int i = 0; i < LENGTH; i++) {
            // 随机颜色
            g.setColor(new Color(random.nextInt(150), random.nextInt(150), random.nextInt(150)));

            // 随机旋转角度 -30 ~ +30度
            double angle = (random.nextInt(60) - 30) * Math.PI / 180;
            g.rotate(angle, i * charWidth + 15, HEIGHT / 2);

            // 写字符
            g.drawString(String.valueOf(code.charAt(i)), i * charWidth + 10, HEIGHT / 2 + 10);

            // 旋转回去
            g.rotate(-angle, i * charWidth + 15, HEIGHT / 2);
        }

        // 4. 绘制干扰线
        for (int i = 0; i < 5; i++) {
            g.setColor(new Color(random.nextInt(150), random.nextInt(150), random.nextInt(150)));
            int x1 = random.nextInt(WIDTH);
            int y1 = random.nextInt(HEIGHT);
            int x2 = random.nextInt(WIDTH);
            int y2 = random.nextInt(HEIGHT);
            g.drawLine(x1, y1, x2, y2);
        }

        g.dispose();

        // 5. 禁止缓存
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);

        // 输出图片
        resp.setContentType("image/png");
        ImageIO.write(image, "PNG", resp.getOutputStream());
    }

    // 生成随机验证码
    private String generateCode(int length) {
        String chars = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
