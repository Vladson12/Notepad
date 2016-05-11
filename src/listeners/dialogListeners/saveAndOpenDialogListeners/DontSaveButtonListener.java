package listeners.dialogListeners.saveAndOpenDialogListeners;

import dialogs.SaveAndOpenDialog;
import ui.NotepadFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 10.05.2016.
 */
public class DontSaveButtonListener implements ActionListener {
    SaveAndOpenDialog dialog;
    NotepadFrame ui;

    public DontSaveButtonListener(SaveAndOpenDialog dialog, NotepadFrame ui) {
        this.dialog = dialog;
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileOpen = new JFileChooser();
        fileOpen.showOpenDialog(ui);
        fileOpen.setFileFilter(new FileNameExtensionFilter("Text files (\".txt\")", "txt"));
        if (fileOpen.getSelectedFile() != null) {
            ui.setFile(fileOpen.getSelectedFile());
            ui.openFile(fileOpen.getSelectedFile());
            ui.resetTitle();
            ui.setSavedText(ui.getText());
        }
    dialog.dispose();
    }
}
