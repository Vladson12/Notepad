package listeners.dialogListeners.saveAndExitDialogListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 10.05.2016.
 */
public class DontSaveButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
