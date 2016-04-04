package net.usysdev.sc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * 常駐スクリーンキャプチャ。
 */
public final class ExitActionListnerImpl implements ActionListener {

    public ExitActionListnerImpl() {}


    public void actionPerformed(ActionEvent event) {
        System.exit(0);
    }
}
