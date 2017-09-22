package dialogs;

import listeners.dialogListeners.fontDialogListeners.OKButtonListener;
import listeners.dialogListeners.fontDialogListeners.CancelButtonListener;
import listeners.dialogListeners.fontDialogListeners.FontSizeListListener;
import listeners.dialogListeners.fontDialogListeners.TracingListListener;
import ui.NotepadFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by vladd on 08.05.2016.
 */
public class FontDialog extends JDialog {
    private static final int DEFAULT_WIDTH = (int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.30);
    private static final int DEFAULT_HEIGHT = (int) (Toolkit.getDefaultToolkit().getScreenSize().height * 0.40);

    private final NotepadFrame ui;
    private Font selectedFont;
    private JLabel example;

    public FontDialog(NotepadFrame ui) {
        this.ui = ui;
        setTitle("Font");
        setModal(true);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationByPlatform(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        selectedFont = ui.getTextAreaFont();

        prepareContent();

    }

    private void prepareContent() {
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JPanel examplePanel = new JPanel();
        example = new JLabel("A a B b");
        example.setFont(selectedFont);

        examplePanel.add(example);
        Border border = BorderFactory.createEtchedBorder();
        Border exampleBorder = BorderFactory.createTitledBorder(border, "Example");
        examplePanel.setBorder(exampleBorder);

        JLabel tracingLabel = new JLabel("Tracing", SwingConstants.CENTER);

        JPanel tracingLabelPanel = new JPanel();
        tracingLabelPanel.add(tracingLabel);


        JComboBox<String> tracingList = new JComboBox<>();
        String normalFont = "Normal";
        String boldFont = "Bold";
        String italicFont = "Italic";
        String boldItalicFont = "Bold italic";
        tracingList.addItem(normalFont);
        tracingList.addItem(boldFont);
        tracingList.addItem(italicFont);
        tracingList.addItem(boldItalicFont);
        tracingList.setEditable(true);
        tracingList.addActionListener(new TracingListListener(this));

        JPanel tracingPanel = new JPanel();
        tracingPanel.setLayout(new BoxLayout(tracingPanel, BoxLayout.Y_AXIS));
        tracingPanel.add(tracingLabelPanel);
        tracingPanel.add(tracingList);

        JLabel sizeLabel = new JLabel("Size", SwingConstants.CENTER);
        JPanel sizeLabelPanel = new JPanel();
        sizeLabelPanel.add(sizeLabel);

        JComboBox<Integer> fontSizeList = new JComboBox<>();
        for (int i = 1; i < 101; i++) {
            fontSizeList.addItem(i);
        }
        fontSizeList.setMaximumRowCount(7);
        fontSizeList.setEditable(true);

        switch (selectedFont.getStyle()) {
            case Font.PLAIN:
                tracingList.setSelectedIndex(0);
                break;
            case Font.BOLD:
                tracingList.setSelectedIndex(1);
                break;
            case Font.ITALIC:
                tracingList.setSelectedIndex(2);
                break;
            case (Font.BOLD | Font.ITALIC):
                tracingList.setSelectedIndex(3);
                break;
        }

        fontSizeList.setSelectedIndex(selectedFont.getSize() - 1);
        fontSizeList.addActionListener(new FontSizeListListener(this));

        JPanel fontSizePanel = new JPanel();
        fontSizePanel.setLayout(new BoxLayout(fontSizePanel, BoxLayout.Y_AXIS));
        fontSizePanel.add(sizeLabelPanel);
        fontSizePanel.add(fontSizeList);

        JPanel settingPanel = new JPanel(new FlowLayout());
        settingPanel.add(tracingPanel);
        settingPanel.add(fontSizePanel);

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new OKButtonListener(this));
        cancelButton.addActionListener(new CancelButtonListener(this));

        JPanel choicePanel = new JPanel();
        choicePanel.add(okButton);
        choicePanel.add(cancelButton);

        add(settingPanel);
        add(examplePanel);
        add(choicePanel);
    }

    public JLabel getExample() {
        return example;
    }

    public Font getSelectedFont() {
        return selectedFont;
    }

    public void setSelectedFont(Font selectedFont) {
        this.selectedFont = selectedFont;
    }

    public void sendFontToUI() {
        ui.setTextAreaFont(selectedFont);
    }

}
