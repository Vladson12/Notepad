package listeners.menuListeners.fileMenuItemListeners;

import ui.NotepadFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 20.04.2017.
 */
public class PrintItemListener implements ActionListener {
    private final NotepadFrame ui;

    public PrintItemListener(NotepadFrame ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        PrintJob pj = toolkit.getPrintJob(ui, "", null);

        if (pj != null){

            Graphics pg = pj.getGraphics();

            if (pg != null){

                ui.print(pg);

                pg.dispose();

            } else System.err.println("Graphics's null");

            pj.end();

        } else System.err.println("Job's null");
    }
}
