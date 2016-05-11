package listeners.menuListeners.fileMenuItemListeners;

import ui.NotepadFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 07.05.2016.
 */
public class SaveItemListener implements ActionListener {
    private NotepadFrame ui;

    public SaveItemListener(NotepadFrame ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ui.isSaved()) {
            ui.saveFile(ui.getFile());
        } else {
            JFileChooser fileSave = new JFileChooser();
            fileSave.setFileFilter(new FileNameExtensionFilter("Text files (\".txt\")", "txt"));
            fileSave.showSaveDialog(ui);
            ui.setFile(fileSave.getSelectedFile());
            ui.saveFile(fileSave.getSelectedFile());
            ui.resetTitle();
            ui.setSavedText(ui.getText());
        }
    }
}
