package listeners.dialogListeners.fontDialogListeners;

import dialogs.FontDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 09.05.2016.
 */
public class FontSizeListListener implements ActionListener {
    FontDialog dialog;

    public FontSizeListListener(FontDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> box = (JComboBox<String>) (e.getSource());
        int index = box.getSelectedIndex();
        Font font = dialog.getSelectedFont();
        font = new Font(font.getName(), font.getStyle(), index + 1);
        dialog.setSelectedFont(font);
        dialog.getExample().setFont(font);
    }
}
