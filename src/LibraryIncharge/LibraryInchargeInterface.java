package LibraryIncharge;

import Connection.ConnectionDetails;
import DatabaseAccessObjects.QueryObjects.*;

import GUI.EditConnectionForm;
import GUI.LoginForm;

import GUI.GUI;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LibraryInchargeInterface extends Application {

    static public String interfaceName = "LIBRARY_INCHARGE_INTERFACE";
    static public String interfaceFrameImageIconPath = "/Icons/96px/CDIS.png";
    static public String interfaceFrameTitle = "SKNCOECDIS v.18.1 - Departmental Library";

    static public InetAddress ipAddress;
    static public int portAddress;

    static public Socket socket;
    static public PrintWriter printWriter;
    static public BufferedReader bufferedReader;
    static public ObjectOutputStream objOut;
    static public ObjectInputStream objIn;
    static public DataOutputStream dataOut;
    static public DataInputStream dataIn;
    static public User user;

    public LibraryInchargeInterface() throws UnknownHostException {
        socket = null;
        printWriter = null;
        bufferedReader = null;
        objOut = null;
        objIn = null;
        dataOut = null;
        dataIn = null;
    }

    public void connectToServer() {
        try {
            LibraryInchargeInterface.socket = new Socket(LibraryInchargeInterface.ipAddress, LibraryInchargeInterface.portAddress);
            LibraryInchargeInterface.printWriter = new PrintWriter(LibraryInchargeInterface.socket.getOutputStream(), true);
            LibraryInchargeInterface.bufferedReader = new BufferedReader(new InputStreamReader(LibraryInchargeInterface.socket.getInputStream()));
            LibraryInchargeInterface.objOut = new ObjectOutputStream(LibraryInchargeInterface.socket.getOutputStream());
            LibraryInchargeInterface.objIn = new ObjectInputStream(LibraryInchargeInterface.socket.getInputStream());
            LibraryInchargeInterface.dataOut = new DataOutputStream(LibraryInchargeInterface.socket.getOutputStream());
            LibraryInchargeInterface.dataIn = new DataInputStream(LibraryInchargeInterface.socket.getInputStream());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(GUI.libraryInchargeInterfaceFrame, "failed to comunicate with server, resons of failure: \n *Wrong Connection Details - try editing connection details \n *Server is not responding");
        }
    }

    public void closeConnection() throws IOException {
        try {
            LibraryInchargeInterface.objOut.close();
            LibraryInchargeInterface.objIn.close();
            LibraryInchargeInterface.dataIn.close();
            LibraryInchargeInterface.dataOut.close();
            LibraryInchargeInterface.bufferedReader.close();
            LibraryInchargeInterface.printWriter.close();
            LibraryInchargeInterface.socket.close();
        } catch (IOException e) {
            //System.out.println("connection closed");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException {
        LoginForm loginForm = new LoginForm();
        loginForm.setTitle(LibraryInchargeInterface.interfaceFrameTitle);
        loginForm.setLocationRelativeTo(null);
        loginForm.pack();
        loginForm.setVisible(true);

        ConnectionDetails connectionDetails = new ConnectionDetails();
        connectionDetails = ConnectionDetails.getConnectionDetails(connectionDetails);
        if (connectionDetails.portAddress == 0) {
            connectionDetails.ipAddress = "localhost";
            connectionDetails.portAddress = 0;
            EditConnectionForm editConnectionForm = new EditConnectionForm(connectionDetails, true);
            editConnectionForm.setTitle(LibraryInchargeInterface.interfaceFrameTitle);
            editConnectionForm.setLocationRelativeTo(null);
            editConnectionForm.pack();
            loginForm.dispose();
            editConnectionForm.setVisible(true);
        } else {
            LibraryInchargeInterface.ipAddress = InetAddress.getByName(connectionDetails.ipAddress);
            LibraryInchargeInterface.portAddress = connectionDetails.portAddress;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
