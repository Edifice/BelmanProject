package dk.easv.belman.GUI;

import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) throws UnsupportedLookAndFeelException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        MainGui gui = new MainGui();
        gui.setVisible(true);
        gui.setExtendedState(gui.MAXIMIZED_BOTH);
        gui.getSpnlWest().setDividerLocation((gui.getHeight() / 3) * 2 + 140);
    }
}
