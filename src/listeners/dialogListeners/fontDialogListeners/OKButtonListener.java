package listeners.dialogListeners.fontDialogListeners;

import dialogs.FontDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 09.05.2016.
 */
public class OKButtonListener implements ActionListener {
    FontDialog dialog;

    public OKButtonListener(FontDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.sendFontToUI();
        dialog.dispose();
    }
}
