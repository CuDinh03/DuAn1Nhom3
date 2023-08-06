/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.Shopping;

/**
 *
 * @author maccuacu
 */
import javax.swing.*;

public class PopupExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Popup Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create a button to trigger the popup
        JButton button = new JButton("Show Popup");
        button.setBounds(100, 100, 100, 30);

        // Create a popup menu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem item1 = new JMenuItem("Item 1");
        JMenuItem item2 = new JMenuItem("Item 2");
        JMenuItem item3 = new JMenuItem("Item 3");

        // Add menu items to the popup menu
        popupMenu.add(item1);
        popupMenu.add(item2);
        popupMenu.add(item3);

        // Add an ActionListener to the button to show the popup menu
        button.addActionListener(e -> {
            popupMenu.show(button, 0, button.getHeight());
        });

        // Add the button to the frame
        frame.add(button);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}

