package listeners.menuListeners.fileMenuItemListeners;

import ui.NotepadFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 07.05.2016.
 */
public class SaveAsItemListener implements ActionListener {
    private final NotepadFrame ui;

    public SaveAsItemListener(NotepadFrame ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileSave = new JFileChooser();
        fileSave.setFileFilter(new FileNameExtensionFilter("Text files (\".txt\")", "txt"));
        fileSave.showSaveDialog(ui);
        ui.setFile(fileSave.getSelectedFile());
        ui.saveFile(fileSave.getSelectedFile());
        ui.resetTitle();
        ui.setSavedText(ui.getText());
    }
}
