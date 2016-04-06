package net.usysdev.sc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


/**
 * 常駐スクリーンキャプチャ。
 */
public final class CaptureActionListnerImpl implements ActionListener {

    private final SCProperties scProperties;


    public CaptureActionListnerImpl(SCProperties scProperties) {

        this.scProperties = scProperties;
    }


    public void actionPerformed(ActionEvent event) {

        try {
            CaptureUtil.capture(scProperties.getSaveFolder());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                e.toString(),
                "常駐スクリーンキャプチャ",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
