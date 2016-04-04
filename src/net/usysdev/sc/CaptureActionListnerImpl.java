package net.usysdev.sc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JOptionPane;


/**
 * 常駐スクリーンキャプチャ。
 */
public final class CaptureActionListnerImpl implements ActionListener {

    private final String outputDirName;


    public CaptureActionListnerImpl(String outputDirName) {

        this.outputDirName = outputDirName;
    }


    public void actionPerformed(ActionEvent event) {

        try {
            CaptureUtil.capture(outputDirName);
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
}
