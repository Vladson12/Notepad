package listeners.menuListeners.viewMenuItemListeners;

import dialogs.FontDialog;
import ui.NotepadFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 08.05.2016.
 */
public class FontItemListener implements ActionListener {
    private final NotepadFrame ui;

    public FontItemListener(NotepadFrame ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new FontDialog(ui).setVisible(true);
    }
}
