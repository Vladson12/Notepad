package listeners.dialogListeners.fontDialogListeners;

import dialogs.FontDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 09.05.2016.
 */
public class TracingListListener implements ActionListener {
    FontDialog dialog;

    public TracingListListener(FontDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> box = (JComboBox<String>) (e.getSource());
        Font font = dialog.getSelectedFont();

        switch (box.getSelectedIndex()) {
            case 0:
                font = new Font(font.getName(), Font.PLAIN, font.getSize());
                break;
            case 1:
                font = new Font(font.getName(), Font.BOLD, font.getSize());
                break;
            case 2:
                font = new Font(font.getName(), Font.ITALIC, font.getSize());
                break;
            case 3:
                font = new Font(font.getName(), Font.BOLD | Font.ITALIC, font.getSize());
                break;
        }
        dialog.setSelectedFont(font);
        dialog.getExample().setFont(font);
    }
}
