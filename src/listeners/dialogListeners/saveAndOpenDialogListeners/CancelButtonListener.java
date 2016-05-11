package listeners.dialogListeners.saveAndOpenDialogListeners;

import dialogs.SaveAndOpenDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 10.05.2016.
 */
public class CancelButtonListener implements ActionListener {
    SaveAndOpenDialog dialog;

    public CancelButtonListener(SaveAndOpenDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.dispose();
    }
}
