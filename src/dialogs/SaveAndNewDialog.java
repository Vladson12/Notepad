package dialogs;

import listeners.dialogListeners.saveAndNewDialogListeners.SaveButtonListener;
import listeners.dialogListeners.saveAndNewDialogListeners.DontSaveButtonListener;
import listeners.dialogListeners.saveAndNewDialogListeners.CancelButtonListener;
import ui.NotepadFrame;

/**
 * Created by vladd on 10.05.2016.
 */
public class SaveAndNewDialog extends SaveAndCloseFileDialog {

    public SaveAndNewDialog(NotepadFrame ui) {
        super(ui);

        setTitle("Save and new");

        prepareContent();
    }

    @Override
    protected void addButtonListeners() {
        getSaveButton().addActionListener(new SaveButtonListener(this, getUi()));
        getDontSaveButton().addActionListener(new DontSaveButtonListener(this, getUi()));
        getCancelButton().addActionListener(new CancelButtonListener(this));
    }
}
