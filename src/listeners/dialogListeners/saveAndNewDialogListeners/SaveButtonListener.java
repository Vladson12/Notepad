package listeners.dialogListeners.saveAndNewDialogListeners;

import dialogs.SaveAndNewDialog;
import ui.NotepadFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 10.05.2016.
 */
public class SaveButtonListener implements ActionListener {
    NotepadFrame ui;
    SaveAndNewDialog dialog;

    static int count = 0;

    public SaveButtonListener(SaveAndNewDialog dialog, NotepadFrame ui)
    {
        this.dialog = dialog;
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
            ui.resetTitle();
            ui.saveFile(fileSave.getSelectedFile());
        }
        ui.setFileToNull();
        ui.resetTitle();
        ui.clearTextArea();
        ui.setSavedText("");
        dialog.dispose();
    }
}
