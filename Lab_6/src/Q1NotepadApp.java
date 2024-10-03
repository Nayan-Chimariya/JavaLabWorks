import javax.swing.*;
import java.awt.*;

public class Q1NotepadApp extends JFrame {
    // Components
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu fileMenu, editMenu, viewMenu, helpMenu;
    JMenuItem newFile, openFile, saveFile;

    public Q1NotepadApp() {
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);

        // Create MenuBar
        menuBar = new JMenuBar();

        // Create Menus
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        viewMenu = new JMenu("View");
        helpMenu = new JMenu("Help");

        // Add Menus to MenuBar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);

        // Create File Menu Items
        newFile = new JMenuItem("New");
        openFile = new JMenuItem("Open");
        saveFile = new JMenuItem("Save");

        // Add MenuItems to File Menu (No actions added)
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);

        // Set MenuBar to the Frame
        setJMenuBar(menuBar);

        setTitle("Notepad");
        setSize(600, 400);
    }


    public static void main(String[] args) {
            new Q1NotepadApp().setVisible(true);
    }
}
