/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import LibraryIncharge.LibraryInchargeInterface;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import javafx.application.Platform;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author hp
 */
public class GUI implements Runnable {

    static public LibraryInchargeInterfacePanel libraryInchargeInterfacePanel;
    static public JFrame libraryInchargeInterfaceFrame;

    @Override
    public void run() {
        libraryInchargeInterfaceFrame = new JFrame(LibraryInchargeInterface.interfaceFrameTitle);
        libraryInchargeInterfaceFrame.setDefaultCloseOperation(this.closeFrame());
        libraryInchargeInterfacePanel = new LibraryInchargeInterfacePanel();

        libraryInchargeInterfaceFrame.setContentPane(libraryInchargeInterfacePanel);
        ImageIcon logo;
        logo = new ImageIcon(getClass().getResource(LibraryInchargeInterface.interfaceFrameImageIconPath));
        libraryInchargeInterfaceFrame.setIconImage(logo.getImage());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = screenSize.width;
        int frameHeight = screenSize.height;

        //Launching configuration for 1920*1080*
        if (frameWidth == 1920 && frameHeight == 1080) {
            libraryInchargeInterfaceFrame.setSize(frameWidth, frameHeight);
            Dimension minScreenSize = new Dimension(1280 + 22, 720 + 56);
            libraryInchargeInterfaceFrame.setMinimumSize(minScreenSize);
            libraryInchargeInterfaceFrame.pack();
            libraryInchargeInterfaceFrame.setLocationRelativeTo(null);
        } else {
            libraryInchargeInterfaceFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
            libraryInchargeInterfaceFrame.setSize(1296, 720);
            Dimension minScreenSize = new Dimension(1296, 720);
            libraryInchargeInterfaceFrame.setMinimumSize(minScreenSize);
            libraryInchargeInterfaceFrame.setLocationRelativeTo(null);
        }
        libraryInchargeInterfaceFrame.setVisible(true);
    }
    
    private int closeFrame(){
        Platform.exit();
        return 3; //EXIT_ON_CLOSE
    }
}
