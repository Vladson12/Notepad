package dialogs;

import listeners.dialogListeners.saveAndExitDialogListeners.SaveButtonListener;
import listeners.dialogListeners.saveAndExitDialogListeners.DontSaveButtonListener;
import listeners.dialogListeners.saveAndExitDialogListeners.CancelButtonListener;
import ui.NotepadFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vladd on 10.05.2016.
 */
public class SaveAndExitDialog extends SaveAndCloseFileDialog {

    public SaveAndExitDialog(NotepadFrame ui) {
        super(ui);

        setTitle("Save and exit");

        prepareContent();
    }

    @Override
    protected void addButtonListeners() {
        getSaveButton().addActionListener(new SaveButtonListener(this, getUi()));
        getDontSaveButton().addActionListener(new DontSaveButtonListener());
        getCancelButton().addActionListener(new CancelButtonListener(this));
    }
}
