package net.usysdev.sc;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


/**
 * 常駐スクリーンキャプチャ。
 */
public final class CaptureService {

    public static void main(String[] args) {

        final String outputDirName = System.getProperty("user.dir");

        try {
            final PopupMenu menu = new PopupMenu();

            {
                final MenuItem captureItem = new MenuItem("撮影");
                menu.add(captureItem);
                captureItem.addActionListener(new CaptureActionListnerImpl(outputDirName));
            }
            {
                final MenuItem exitItem = new MenuItem("終了");
                menu.add(exitItem);
                exitItem.addActionListener(new ExitActionListnerImpl());
            }

            final Image image = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("icon.png"));
            final TrayIcon icon = new TrayIcon(image);
            icon.setPopupMenu(menu);
            SystemTray.getSystemTray().add(icon);

            CaptureUtil.capture(outputDirName);
            while(true) {
                Thread.sleep(getSleepTime());
                CaptureUtil.capture(outputDirName);
            }
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            pw.flush();
            pw.close();
            JOptionPane.showMessageDialog(
                null,
                sw.toString(),
                "常駐スクリーンキャプチャ",
                JOptionPane.ERROR_MESSAGE);
        }
    }


    private static long getSleepTime() {

        CoreDate now = CoreDate.now();

        final int hour = now.hourOfDay();
        final int minute = now.minute();

        // 10,20,30,40,50分に丸める
        if (minute < 10) {
            CoreDate wakeup = CoreDate.createFrom(now.year(), now.month(), now.dayOfMonth(), now.hourOfDay(), 10, 0);
            return wakeup.millisec() - now.millisec();
        } else if (minute < 20) {
            CoreDate wakeup = CoreDate.createFrom(now.year(), now.month(), now.dayOfMonth(), now.hourOfDay(), 20, 0);
            return wakeup.millisec() - now.millisec();
        } else if (minute < 30) {
            CoreDate wakeup = CoreDate.createFrom(now.year(), now.month(), now.dayOfMonth(), now.hourOfDay(), 30, 0);
            return wakeup.millisec() - now.millisec();
        } else if (minute < 40) {
            CoreDate wakeup = CoreDate.createFrom(now.year(), now.month(), now.dayOfMonth(), now.hourOfDay(), 40, 0);
            return wakeup.millisec() - now.millisec();
        } else if (minute < 50) {
            CoreDate wakeup = CoreDate.createFrom(now.year(), now.month(), now.dayOfMonth(), now.hourOfDay(), 50, 0);
            return wakeup.millisec() - now.millisec();
        }

        // 0分に丸める
        if (now.hourOfDay() < 23) {
            CoreDate wakeup = CoreDate.createFrom(now.year(), now.month(), now.dayOfMonth(), now.hourOfDay() + 1, 0, 0);
            return wakeup.millisec() - now.millisec();
        }

        CoreDate tomorrow = CoreDate.createFromUTC(now.millisec() + (86400L * 1000L));
        CoreDate wakeup = CoreDate.createFrom(tomorrow.year(), tomorrow.month(), tomorrow.dayOfMonth(), 0, 0, 0);
        return wakeup.millisec() - now.millisec();
    }
}
