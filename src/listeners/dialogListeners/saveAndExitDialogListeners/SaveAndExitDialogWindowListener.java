package listeners.dialogListeners.saveAndExitDialogListeners;

import dialogs.SaveAndExitDialog;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by vladd on 10.05.2016.
 */
public class SaveAndExitDialogWindowListener implements WindowListener {
    SaveAndExitDialog dialog;

    public SaveAndExitDialogWindowListener(SaveAndExitDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        dialog.dispose();
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }
}
