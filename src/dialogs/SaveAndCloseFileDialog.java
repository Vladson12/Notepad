package dialogs;

import ui.NotepadFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladd on 11.05.2016.
 */
public abstract class SaveAndCloseFileDialog extends JDialog {
    private static final int DEFAULT_WIDTH = (int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.3);
    private static final int DEFAULT_HEIGHT = (int) (Toolkit.getDefaultToolkit().getScreenSize().height * 0.15);

    private NotepadFrame ui;

    private JButton saveButton;
    private JButton dontSaveButton;
    private JButton cancelButton;

    public SaveAndCloseFileDialog(NotepadFrame ui) {
        this.ui = ui;

//        setTitle("Save and close");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationByPlatform(true);
        setModal(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        prepareContent();

    }

    protected void prepareContent() {
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JLabel question = new JLabel("Do you want to save changes in file:");
        JPanel questionPanel = new JPanel();
        questionPanel.add(question);

        JLabel filePath = new JLabel(ui.getFilePath() + "?");
        JPanel filePathPanel = new JPanel();
        filePathPanel.add(filePath);

        saveButton = new JButton("Save");
        dontSaveButton = new JButton("Don't save");
        cancelButton = new JButton("Cancel");

        addButtonListeners();

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(dontSaveButton);
        buttonPanel.add(cancelButton);

        add(questionPanel);
        add(filePathPanel);
        add(buttonPanel);
    }

    protected abstract void addButtonListeners();

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getDontSaveButton() {
        return dontSaveButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public NotepadFrame getUi() {
        return ui;
    }
}
