package ui;

import listeners.NotepadFrameWindowListener;
import listeners.menuListeners.fileMenuItemListeners.*;
import listeners.menuListeners.helpMenuItemListeners.AboutItemListener;
import listeners.menuListeners.viewMenuItemListeners.DarkThemeItemListener;
import listeners.menuListeners.viewMenuItemListeners.DefaultThemeItemListener;
import listeners.menuListeners.viewMenuItemListeners.FontItemListener;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * Created by vladd on 07.05.2016.
 */


public class NotepadFrame extends JFrame {
    public enum Theme {Default, Dark}

    private static final int DEFAULT_WIDTH = (int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.5);
    private static final int DEFAULT_HEIGHT = (int) (Toolkit.getDefaultToolkit().getScreenSize().height * 0.7);
    private static final Font DEFAULT_FONT = new Font("Default", Font.PLAIN, 15);
    private static final String NEW_FILE_NAME = "Unnamed";
    private static final String APP_NAME = "NotePad";
    private static final String NEW_FILE_NAME_AND_APP_NAME_SEPARATOR = " - ";
    private static final String APP_VERSION = "1.0";
    private static final String APP_DEVELOPER = "Vladislav Magomedov";
    private static final String APP_DEVELOPERS_EMAIL = "vladdmagg94@yandex.ru";

    private JTextArea textArea;
    private String savedText;
    private File file;

    public NotepadFrame() {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationByPlatform(true);
        setTitle(NEW_FILE_NAME + NEW_FILE_NAME_AND_APP_NAME_SEPARATOR + APP_NAME);
        setIconImage(new ImageIcon("resources\\Icon.png").getImage());

        prepareContent();

        savedText = getText();
        Font savedFont = getFont();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTheme(Theme.Default);

        addWindowListener(new NotepadFrameWindowListener(this));
    }

    private void prepareContent() {

        prepareMenuBar();
        prepareTextArea();


    }

    private void prepareTextArea() {

        textArea = new JTextArea();
        textArea.setFont(DEFAULT_FONT);

        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(scroller);
    }

    private void prepareMenuBar() {
        JMenuBar menuBar = new JMenuBar();


//        "File"
        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open...");
        JMenuItem printItem = new JMenuItem("Print");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save as...");
        JMenuItem exitItem = new JMenuItem("Exit");

        newItem.addActionListener(new NewItemListener(this));
        openItem.addActionListener(new OpenItemListener(this));
        printItem.addActionListener(new PrintItemListener(this));
        saveItem.addActionListener(new SaveItemListener(this));
        saveAsItem.addActionListener(new SaveAsItemListener(this));
        exitItem.addActionListener(new ExitItemListener(this));

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(printItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);


//        "View"
        JMenu viewMenu = new JMenu("View");

        JMenu themeMenu = new JMenu("Theme");

        JMenuItem defaultItem = new JMenuItem("Default");
        JMenuItem darkItem = new JMenuItem("Dark");

        themeMenu.add(defaultItem);
        themeMenu.add(darkItem);

        defaultItem.addActionListener(new DefaultThemeItemListener(this));
        darkItem.addActionListener(new DarkThemeItemListener(this));

        JMenuItem fontItem = new JMenuItem("Font");

        fontItem.addActionListener(new FontItemListener(this));

        viewMenu.add(themeMenu);
        viewMenu.add(fontItem);

        menuBar.add(viewMenu);


//        "Help"
        JMenu helpMenu = new JMenu("Help");

        JMenuItem aboutItem = new JMenuItem("About");

        aboutItem.addActionListener(new AboutItemListener(this));

        helpMenu.add(aboutItem);


        menuBar.add(helpMenu);



        setJMenuBar(menuBar);
    }

    public boolean isSaved() {
        return (file != null);
    }

    public static String getAppName() {
        return APP_NAME;
    }

    public static String getAppVersion() {
        return APP_VERSION;
    }

    public static String getAppDeveloper() {
        return APP_DEVELOPER;
    }

    public static String getAppDevelopersEmail() {
        return APP_DEVELOPERS_EMAIL;
    }

    public Font getTextAreaFont() {
        return textArea.getFont();
    }

    public String getText() {
        return textArea.getText();
    }

    public Font getFont() {return textArea.getFont(); }

    public String getSavedText() {
        return savedText;
    }

    public File getFile() {
        return file;
    }

    private String getFileName() {
        if (file != null) {
            return file.getName();
        } else {
            return NEW_FILE_NAME;
        }
    }

    public String getFilePath() {
        if (file != null) {
            return file.getAbsolutePath();
        } else {
            return NEW_FILE_NAME;
        }
    }

    public void setTextAreaFont(Font font) {
        textArea.setFont(font);
    }

    public void setTheme(Theme theme) {
        switch (theme) {
            case Default:
                textArea.setForeground(Color.BLACK);
                textArea.setBackground(Color.WHITE);
                break;
            case Dark:
                textArea.setForeground(Color.WHITE);
                textArea.setBackground(Color.DARK_GRAY);
                break;
        }
    }

    public void setFileToNull() {
        this.file = null;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void resetTitle() {
        setTitle(getFileName() + NEW_FILE_NAME_AND_APP_NAME_SEPARATOR + APP_NAME);
    }

    public void clearTextArea() {
        textArea.setText("");
    }

    public void openFile(File file) {
        try {
            StringBuilder buffer = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            while ((str = reader.readLine()) != null) {
               buffer.append(str).append(System.lineSeparator());
            }
            reader.close();
            textArea.setText(buffer.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void saveFile(File file) {
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(file));
            writer.print(textArea.getText());
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setSavedText(String savedText) {
        this.savedText = savedText;
    }

    @Override
    public void paint(Graphics g) {

    }
}
