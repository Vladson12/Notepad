package listeners.dialogListeners.aboutDialogListeners;

import dialogs.AboutDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 07.05.2016.
 */
public class OKButtonListener implements ActionListener {
    AboutDialog dialog;

    public OKButtonListener(AboutDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
    }
}
