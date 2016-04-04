package net.usysdev.sc;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * 画面撮影ユーティリティ。
 */
public final class CaptureUtil {

    public static synchronized void capture(String outputDirName)
            throws AWTException,
                   IOException {

        Rectangle bounds = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(bounds);
        Graphics g = image.getGraphics();

        CoreDate now = CoreDate.now();
        String dirName = outputDirName + "\\" + String.format("%04d-%02d-%02d", now.year(), now.month(), now.dayOfMonth());
        File dir = new File(dirName);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String fileName = String.format("%02d時%02d分.jpg", now.hourOfDay(), now.minute());
        File file = new File(dirName, fileName);
        ImageIO.write(image, "jpg", file);
    }
}
