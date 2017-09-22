package listeners.dialogListeners.aboutDialogListeners;

import ui.NotepadFrame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by vladd on 09.05.2016.
 */
public class EmailAdressLabelMouseListener implements MouseListener {
    @Override
    public void mouseReleased(MouseEvent e) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().mail(new URI("mailto:" + NotepadFrame.getAppDevelopersEmail()));
            } catch (URISyntaxException | IOException ignored) {

            }

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
}
