package StoragePath;

import LibraryIncharge.LibraryInchargeInterface;

import java.io.*;
import java.util.Scanner;

public class StoragePath implements Serializable {

    public String path;

    public String parseStringToPath(String path) {
        if (path.contains("\\")) {
            path = path.replace("\\", "/");
        }
        if (!path.contains("/")) {
            return "INVALID_PATH";
        }
        File trialFileForValidation = new File(path);
        boolean validPath;
        if (!trialFileForValidation.exists()) {
            validPath = new File(path).mkdirs();
        } else {
            validPath = true;
        }
        if (validPath) {
            return path;
        } else {
            return "INVALID_PATH";
        }
    }

    public static StoragePath getStoragePath(StoragePath storagePath) {
        FileInputStream fileInputStream;
        try {
            String directoryToStoreConnectionDetails = LibraryInchargeInterface.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            directoryToStoreConnectionDetails = directoryToStoreConnectionDetails.replace("%20", " ");
            File storagePathFile = new File(directoryToStoreConnectionDetails + "StoragePath.cdisobj");
            fileInputStream = new FileInputStream(storagePathFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            storagePath = (StoragePath) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
           // e.printStackTrace();
            storagePath.path = "PATH_NOT_FOUND";
        } catch (ClassNotFoundException | EOFException e) {
           // e.printStackTrace();
            storagePath.path = "PATH_NOT_FOUND";
        } catch (IOException e) {
            //e.printStackTrace();
            storagePath.path = "PATH_NOT_FOUND";
        }
        return storagePath;
    }

    static public StoragePath saveStoragePath(StoragePath storagePath) {
        try {
            String directoryToStoreConnectionDetails = LibraryInchargeInterface.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            directoryToStoreConnectionDetails = directoryToStoreConnectionDetails.replace("%20", " ");
            File storagePathFile = new File(directoryToStoreConnectionDetails + "StoragePath.cdisobj");
            if (storagePathFile.exists()) {
                storagePathFile.delete();
                storagePathFile = new File(directoryToStoreConnectionDetails + "StoragePath.cdisobj");
            }
            FileOutputStream fileOutputStream = new FileOutputStream(storagePathFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(storagePath);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            storagePath.path = "PATH_NOT_SAVED";
        } catch (IOException e) {
            storagePath.path = "PATH_NOT_SAVED";
        }
        return StoragePath.getStoragePath(storagePath);
    }
}
