package listeners.dialogListeners.saveAndNewDialogListeners;

import dialogs.SaveAndNewDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 10.05.2016.
 */
public class CancelButtonListener implements ActionListener {
    private final SaveAndNewDialog dialog;

    public CancelButtonListener(SaveAndNewDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.dispose();
    }
}
