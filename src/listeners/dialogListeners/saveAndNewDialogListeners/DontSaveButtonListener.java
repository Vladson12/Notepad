package listeners.dialogListeners.saveAndNewDialogListeners;

import dialogs.SaveAndNewDialog;
import ui.NotepadFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 10.05.2016.
 */
public class DontSaveButtonListener implements ActionListener {
    private final SaveAndNewDialog dialog;
    private final NotepadFrame ui;

    public DontSaveButtonListener(SaveAndNewDialog dialog, NotepadFrame ui) {
        this.dialog = dialog;
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ui.setFileToNull();
        ui.resetTitle();
        ui.clearTextArea();
        ui.setSavedText("");
        dialog.dispose();
    }
}
