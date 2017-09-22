package dialogs;


import listeners.dialogListeners.saveAndOpenDialogListeners.CancelButtonListener;
import listeners.dialogListeners.saveAndOpenDialogListeners.DontSaveButtonListener;
import listeners.dialogListeners.saveAndOpenDialogListeners.SaveButtonListener;
import ui.NotepadFrame;

/**
 * Created by vladd on 10.05.2016.
 */
public class SaveAndOpenDialog extends SaveAndCloseFileDialog {

    private NotepadFrame ui;

    public SaveAndOpenDialog(NotepadFrame ui) {
        super(ui);

        setTitle("Save and open");

        prepareContent();
    }

    @Override
    protected void addButtonListeners() {
        getSaveButton().addActionListener(new SaveButtonListener(this, getUi()));
        getDontSaveButton().addActionListener(new DontSaveButtonListener(this, getUi()));
        getCancelButton().addActionListener(new CancelButtonListener(this));
    }
}
