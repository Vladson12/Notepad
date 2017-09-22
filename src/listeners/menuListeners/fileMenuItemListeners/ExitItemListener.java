package listeners.menuListeners.fileMenuItemListeners;


import dialogs.SaveAndExitDialog;
import ui.NotepadFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 10.05.2016.
 */
public class ExitItemListener implements ActionListener {
    private final NotepadFrame ui;

    public ExitItemListener(NotepadFrame ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ui.getText().equals(ui.getSavedText())) {
            System.exit(0);
        } else {
            new SaveAndExitDialog(ui).setVisible(true);
        }
    }
}
