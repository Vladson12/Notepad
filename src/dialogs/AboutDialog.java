package dialogs;

import listeners.dialogListeners.aboutDialogListeners.OKButtonListener;
import listeners.dialogListeners.aboutDialogListeners.EmailAdressLabelMouseListener;
import ui.NotepadFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vladd on 07.05.2016.
 */
public class AboutDialog extends JDialog {
    private static final int DEFAULT_WIDTH = (int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.3);
    private static final int DEFAULT_HEIGHT = (int) (Toolkit.getDefaultToolkit().getScreenSize().height * 0.3);

    public AboutDialog(NotepadFrame ui) {

        NotepadFrame ui1 = ui;

        setTitle(NotepadFrame.getAppName() + ": information");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationByPlatform(true);
        setModal(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        prepareContent();

    }

    private void prepareContent() {
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JLabel version = new JLabel("VERSION: " + NotepadFrame.getAppVersion(), SwingConstants.CENTER);
        JLabel developer= new JLabel("DEVELOPED BY: " + NotepadFrame.getAppDeveloper(), SwingConstants.CENTER);

        JPanel versionPanel = new JPanel();
        versionPanel.add(version);

        JPanel developerPanel = new JPanel();
        developerPanel.add(developer);

        JLabel email = new JLabel("EMAIL: ");
        JLabel emailAdressString = new JLabel(NotepadFrame.getAppDevelopersEmail());
        emailAdressString.setFont(new Font("emailFont", Font.BOLD | Font.ITALIC, 15));
        emailAdressString.setForeground(Color.BLUE);
        emailAdressString.addMouseListener(new EmailAdressLabelMouseListener());

        JPanel emailPanel = new JPanel();
        emailPanel.add(email);
        emailPanel.add(emailAdressString);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new OKButtonListener(this));

        JPanel okButtonPanel = new JPanel();
        okButtonPanel.add(okButton);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        infoPanel.add(versionPanel);
        infoPanel.add(developerPanel);
        infoPanel.add(emailPanel);

        add(infoPanel);
        add(okButtonPanel);
    }
}
