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
public class SaveButtonListener implements ActionListener {
    private final SaveAndOpenDialog dialog;
    private final NotepadFrame ui;

    public SaveButtonListener(SaveAndOpenDialog dialog, NotepadFrame ui) {
        this.ui = ui;
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ui.isSaved()) {

            ui.saveFile(ui.getFile());

            JFileChooser fileOpen = new JFileChooser();
            fileOpen.setFileFilter(new FileNameExtensionFilter("Text files (\".txt\")", "txt"));
            fileOpen.showOpenDialog(ui);
            if (fileOpen.getSelectedFile() != null) {
                ui.setFile(fileOpen.getSelectedFile());
                ui.openFile(fileOpen.getSelectedFile());
                ui.resetTitle();
                ui.setSavedText(ui.getText());
            } else {
                dialog.dispose();
            }

        } else {
            JFileChooser fileSave = new JFileChooser();
            fileSave.setFileFilter(new FileNameExtensionFilter("Text files (\".txt\")", "txt"));
            fileSave.showSaveDialog(ui);
            if (fileSave.getSelectedFile() != null) {
                ui.setFile(fileSave.getSelectedFile());
                ui.resetTitle();
                ui.saveFile(fileSave.getSelectedFile());
            } else {
                dialog.dispose();
            }
        }
    }
}
