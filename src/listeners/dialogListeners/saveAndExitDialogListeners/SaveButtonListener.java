package listeners.dialogListeners.saveAndExitDialogListeners;

import dialogs.SaveAndExitDialog;
import ui.NotepadFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 10.05.2016.
 */
public class SaveButtonListener implements ActionListener {
    private final NotepadFrame ui;
    private final SaveAndExitDialog dialog;

    public SaveButtonListener(SaveAndExitDialog dialog, NotepadFrame ui) {
        this.ui = ui;
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ui.isSaved()) {
            ui.saveFile(ui.getFile());
        } else {
            JFileChooser fileSave = new JFileChooser();
            fileSave.setFileFilter(new FileNameExtensionFilter("Text files (\".txt\")", "txt"));
            fileSave.showSaveDialog(ui);
            if (fileSave.getSelectedFile() != null) {
                ui.setFile(fileSave.getSelectedFile());
            } else {
                dialog.dispose();
                return;
            }
        }
        System.exit(0);
    }
}
