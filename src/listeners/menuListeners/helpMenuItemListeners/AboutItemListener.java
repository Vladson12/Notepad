package listeners.menuListeners.helpMenuItemListeners;

import dialogs.AboutDialog;
import ui.NotepadFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 07.05.2016.
 */
public class AboutItemListener implements ActionListener {
    private final NotepadFrame ui;

    public AboutItemListener(NotepadFrame ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new AboutDialog(ui).setVisible(true);
    }
}
