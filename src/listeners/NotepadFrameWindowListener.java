package listeners;

import dialogs.SaveAndExitDialog;
import ui.NotepadFrame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by vladd on 10.05.2016.
 */
public class NotepadFrameWindowListener implements WindowListener {
    private final NotepadFrame ui;

    public NotepadFrameWindowListener(NotepadFrame ui) {
        this.ui = ui;
    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (ui.getText().equals(ui.getSavedText())) {
            System.exit(0);
        } else {
            new SaveAndExitDialog(ui).setVisible(true);
        }
    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }
}
