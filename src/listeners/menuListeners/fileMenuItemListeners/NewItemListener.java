package listeners.menuListeners.fileMenuItemListeners;

import dialogs.SaveAndNewDialog;
import ui.NotepadFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 07.05.2016.
 */
public class NewItemListener implements ActionListener {
    private final NotepadFrame ui;

    public NewItemListener(NotepadFrame ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!ui.getText().equals(ui.getSavedText())) {
            new SaveAndNewDialog(ui).setVisible(true);
        } else {
            ui.setFileToNull();
            ui.resetTitle();
            ui.clearTextArea();
            ui.setSavedText("");
        }
    }
}
