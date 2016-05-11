package listeners.menuListeners.fileMenuItemListeners;

import dialogs.SaveAndOpenDialog;
import ui.NotepadFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 07.05.2016.
 */
public class OpenItemListener implements ActionListener {
    private NotepadFrame ui;

    public OpenItemListener(NotepadFrame ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!ui.getText().equals(ui.getSavedText())) {
            new SaveAndOpenDialog(ui).setVisible(true);
        } else {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(ui);
            fileOpen.setFileFilter(new FileNameExtensionFilter("Text files (\".txt\")", "txt"));
            ui.setFile(fileOpen.getSelectedFile());
            ui.openFile(fileOpen.getSelectedFile());
            ui.resetTitle();
            ui.setSavedText(ui.getText());
        }
    }
}
