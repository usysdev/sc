package net.usysdev.sc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 * 常駐スクリーンキャプチャ。
 */
public final class PrefernceActionListnerImpl implements ActionListener {

    private final SCProperties scProperties;


    public PrefernceActionListnerImpl(SCProperties scProperties) {

        this.scProperties = scProperties;
    }


    public void actionPerformed(ActionEvent event) {

        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        {
            final String folderName = scProperties.getSaveFolder();
            final File file = new File(folderName);
            if (file.isDirectory()) {
                fc.setCurrentDirectory(file);
            }
        }
        final int selected = fc.showSaveDialog(null);
        if (selected == JFileChooser.APPROVE_OPTION) {
            final File file = fc.getSelectedFile();
            try {
                scProperties.setSaveFolder(file.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(
                    null,
                    e.toString(),
                    "常駐スクリーンキャプチャ",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }
}
