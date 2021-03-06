package listeners.menuListeners.viewMenuItemListeners;

import ui.NotepadFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 07.05.2016.
 */
public class DarkThemeItemListener implements ActionListener {
    private final NotepadFrame ui;

    public DarkThemeItemListener(NotepadFrame ui) {
        this.ui = ui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ui.setTheme(NotepadFrame.Theme.Dark);
    }
}
