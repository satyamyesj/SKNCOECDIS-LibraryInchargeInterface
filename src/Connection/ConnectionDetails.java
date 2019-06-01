package Connection;

import LibraryIncharge.LibraryInchargeInterface;

import java.io.*;

public class ConnectionDetails implements Serializable {

    public String ipAddress;
    public int portAddress;

    public static ConnectionDetails getConnectionDetails(ConnectionDetails connectionDetails) {
        FileInputStream fileInputStream;
        try {
            //String directoryToStoreConnectionDetails=LibraryInchargeInterface.class.getResource("LibraryInchargeInterface.class").toString();
            //gives : file:/E:/Computer%20Department%20IS/CDIS_FrontEnd/out/production/CDIS_FrontEnd/LibraryIncharge/LibraryInchargeInterface.class
            //open in windows
            String directoryToStoreConnectionDetails = LibraryInchargeInterface.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            directoryToStoreConnectionDetails = directoryToStoreConnectionDetails.replace("%20", " ");
             File connectionDetailsFile = new File(directoryToStoreConnectionDetails + "ConnectionDetails.cdisobj");
            fileInputStream = new FileInputStream(connectionDetailsFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            connectionDetails = (ConnectionDetails) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
           // e.printStackTrace();
            connectionDetails.portAddress = 0;
        } catch (ClassNotFoundException | IOException e) {
            //e.printStackTrace();
           connectionDetails.portAddress = 0;
        }
        return connectionDetails;
    }

    static public ConnectionDetails saveConnectionDetails(ConnectionDetails connectionDetails) {
        try {
            String directoryToStoreConnectionDetails = LibraryInchargeInterface.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            directoryToStoreConnectionDetails = directoryToStoreConnectionDetails.replace("%20", " ");
            File connectionDetailsFile = new File(directoryToStoreConnectionDetails + "ConnectionDetails.cdisobj");
            if (connectionDetailsFile.exists()) {
                connectionDetailsFile.delete();
                connectionDetailsFile=new File(directoryToStoreConnectionDetails+"ConnectionDetails.cdisobj");
            }
            FileOutputStream fileOutputStream = new FileOutputStream(connectionDetailsFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(connectionDetails);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            // e.printStackTrace();
            return connectionDetails;
        } catch (IOException e) {
          //  e.printStackTrace();
            return connectionDetails;
        }
        return ConnectionDetails.getConnectionDetails(new ConnectionDetails());
    }
}
