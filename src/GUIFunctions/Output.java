package GUIFunctions;

import DatabaseAccessObjects.ResultObjects.*;
import LibraryIncharge.LibraryInchargeInterface;
import LibraryIncharge.ServerRequests;
import RequestAttributes.RequestAttributes;
import StoragePath.StoragePath;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;

public class Output {

    /* static public boolean displayUserProfile(UserProfileQueryResult userProfile) {
        if (userProfile.user_role.equals("S")) {
                System.out.println(userProfile.student.username);
                System.out.println(userProfile.student.first_name + " " + userProfile.student.last_name);
                System.out.println(userProfile.student.email);
                System.out.println(userProfile.student.mobile_no);
                if (userProfile.student.verification_status == 1) {
                    System.out.println("Verification status: completed");
                } else {
                    System.out.println("Verification status: pending");
                }
                System.out.println(userProfile.student.unique_id);
                System.out.println(userProfile.student.academic_year);
                System.out.println(userProfile.student.division);
        } else if (userProfile.user_role.equals("E")) {
            System.out.println(userProfile.employee.username);
            System.out.println(userProfile.employee.first_name + " " + userProfile.employee.last_name);
            System.out.println(userProfile.employee.email);
            System.out.println(userProfile.employee.mobile_no);
            if (userProfile.employee.verification_status == 1) {
                System.out.println("Verification status: completed");
            } else {
                System.out.println("Verification status: pending");
            }
            System.out.println(userProfile.employee.employee_no);
        }
        if (userProfile.has_pending_library_record) {
            System.out.println("Pending Records: Yes");
        } else {
            System.out.println("Pending Records: No");
        }
        return false;
    }*/

 /*static public void networkError() {
        System.out.println("Connection error...");
    }*/

 /*static public void writeRequsetResult(String requestResult) {
        System.out.println("RequestResult: " + requestResult);
    }*/
    public static String storeUsersWithOverDuePendingRecords() throws ClassNotFoundException, IOException {
        LibraryInchargeInterface libraryInchargeInterface = null;
        try {
            libraryInchargeInterface = new LibraryInchargeInterface();
        } catch (UnknownHostException e) {
            // e.printStackTrace();
        }
        libraryInchargeInterface.connectToServer();
        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GET_USERS_WITH_OVER_DUE_PENDING_RECORDS";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        List<UserProfileQueryResult> users_with_pending_records_query_result_set = (List<UserProfileQueryResult>) LibraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();

        Iterator iterator = users_with_pending_records_query_result_set.iterator();
//            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
//            LocalDateTime currentDateTime = LocalDateTime.now();
//            String currentDate = dateTimeFormat.format(currentDateTime).toString();
        StoragePath storagePath = new StoragePath();
        storagePath = StoragePath.getStoragePath(storagePath);
        if (storagePath.path.equals("PATH_NOT_FOUND")) {
            return "PATH_NOT_FOUND";
        }
        String stringStoragePath = storagePath.path;
        File storageDirectory = new File(stringStoragePath + "/CDIS_DATA/UserWithOverDuePendingRecords/");
        boolean successfullyCreatedDirectory;
        if (!storageDirectory.exists()) {
            successfullyCreatedDirectory = new File(stringStoragePath + "/CDIS_DATA/UserWithOverDuePendingRecords/").mkdirs();
        } else {
            successfullyCreatedDirectory = true;
        }
        if (successfullyCreatedDirectory) {

            String filePathForStudent = stringStoragePath + "/CDIS_DATA/UserWithOverDuePendingRecords/StudentsHavingPendingRecord.csv";
            String filePathForEmployee = stringStoragePath + "/CDIS_DATA/UserWithOverDuePendingRecords/EmployeesHavingPendingRecord.csv";

            File fileToStorePendingStudents = new File(filePathForStudent);
            File fileToStorePendingEmployee = new File(filePathForEmployee);
            try {
                if (!fileToStorePendingStudents.exists()) {
                    fileToStorePendingStudents.createNewFile();
                } else {
                    fileToStorePendingStudents.delete();
                    fileToStorePendingStudents.createNewFile();
                }
                if (!fileToStorePendingEmployee.exists()) {
                    fileToStorePendingEmployee.createNewFile();
                } else {
                    fileToStorePendingEmployee.delete();
                    fileToStorePendingEmployee.createNewFile();
                }
                FileOutputStream fileOutputStreamForStudent = new FileOutputStream(fileToStorePendingStudents);
                FileOutputStream fileOutputStreamForEmployee = new FileOutputStream(fileToStorePendingEmployee);
                PrintWriter printWriterForStudent = new PrintWriter(fileOutputStreamForStudent, true);
                PrintWriter printWriterForEmployee = new PrintWriter(fileOutputStreamForEmployee, true);

                if (iterator.hasNext()) {
                    int studentCount = 0;
                    int employeeCount = 0;
                    printWriterForStudent.println("Username,First_Name,Last_Name,Email,Mobile_No,Academic_Year,Division,Unique_ID");
                    printWriterForEmployee.println("Username,First_Name,Last_Name,Email,Mobile_No,Employee_No");
                    while (iterator.hasNext()) {
                        UserProfileQueryResult user_with_pending_record;
                        user_with_pending_record = (UserProfileQueryResult) iterator.next();
                        if (user_with_pending_record.user_role.equals("S")) {
                            printWriterForStudent.println(user_with_pending_record.student.username.replace(",", "-").replace("\n", " ").trim() + ", "
                                    + user_with_pending_record.student.first_name.replace(",", "-").replace("\n", " ").trim() + ", "
                                    + user_with_pending_record.student.last_name.replace(",", "-").replace("\n", " ").trim() + ", "
                                    + user_with_pending_record.student.email.replace(",", "-").replace("\n", " ").trim() + ";, "
                                    + user_with_pending_record.student.mobile_no.replace(",", "-").replace("\n", " ").trim() + ";, "
                                    + user_with_pending_record.student.academic_year.replace(",", "-").replace("\n", " ").trim() + ", "
                                    + user_with_pending_record.student.division.replace(",", "-").replace("\n", " ").trim() + ", "
                                    + user_with_pending_record.student.unique_id.replace(",", "-").replace("\n", " ").trim());
                            studentCount++;
                        } else if (user_with_pending_record.user_role.equals("E")) {
                            printWriterForEmployee.println(user_with_pending_record.employee.username.replace(",", "-").replace("\n", " ").trim() + ", "
                                    + user_with_pending_record.employee.first_name.replace(",", "-").replace("\n", " ").trim() + ", "
                                    + user_with_pending_record.employee.last_name.replace(",", "-").replace("\n", " ").trim() + ", "
                                    + user_with_pending_record.employee.email.replace(",", "-").replace("\n", " ").trim() + ";, "
                                    + user_with_pending_record.employee.mobile_no.replace(",", "-").replace("\n", " ").trim() + ";, "
                                    + user_with_pending_record.employee.employee_no.replace(",", "-").replace("\n", " ").trim());
                            employeeCount++;
                        }
                    }

                    String returningString;
                    printWriterForStudent.close();
                    fileOutputStreamForStudent.close();
                    if (studentCount == 0) {
                        fileToStorePendingStudents.delete();
                        returningString = "No student with pending record found to store.";
                    } else {
                        Desktop.getDesktop().open(fileToStorePendingStudents);
                        returningString = studentCount + " Students with pending records stored";
                    }

                    printWriterForEmployee.close();
                    fileOutputStreamForEmployee.close();
                    if (employeeCount == 0) {
                        fileToStorePendingEmployee.delete();
                        returningString = returningString + "\n " + "No employee with pending records found to store.";
                    } else {
                        Desktop.getDesktop().open(fileToStorePendingEmployee);
                        returningString = returningString + "\n " + employeeCount + " Employees with pending records stored";
                    }
                    return returningString;
                } else {
                    printWriterForStudent.close();
                    printWriterForEmployee.close();
                    fileOutputStreamForStudent.close();
                    fileOutputStreamForEmployee.close();
                    if (fileToStorePendingStudents.exists()) {
                        fileToStorePendingStudents.delete();
                    }
                    if (fileToStorePendingEmployee.exists()) {
                        fileToStorePendingEmployee.delete();
                    }
                    return "EMPTY_FILE";
                }
            } catch (FileNotFoundException e) {
                return "error occured in saving results"
                        + "\n close file if already opened";
            }
        } else {
            // GUI.libraryInchargeInterfacePanel.showRequsetResult("Error in locating Storage directory, try editing Storage Path");
        }
        return "NOT_STORED";
    }

    public static String storeUsersWithPendingRecords() throws ClassNotFoundException, IOException {
        LibraryInchargeInterface libraryInchargeInterface = null;
        try {
            libraryInchargeInterface = new LibraryInchargeInterface();
        } catch (UnknownHostException e) {
            //e.printStackTrace();
        }
        libraryInchargeInterface.connectToServer();
        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GET_USERS_WITH_PENDING_RECORDS";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        List<UserProfileQueryResult> users_with_pending_records_query_result_set = (List<UserProfileQueryResult>) LibraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();

        Iterator iterator = users_with_pending_records_query_result_set.iterator();
//            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
//            LocalDateTime currentDateTime = LocalDateTime.now();
//            String currentDate = dateTimeFormat.format(currentDateTime).toString();
        StoragePath storagePath = new StoragePath();
        storagePath = StoragePath.getStoragePath(storagePath);
        if (storagePath.path.equals("PATH_NOT_FOUND")) {
            return "PATH_NOT_FOUND";
        }
        String stringStoragePath = storagePath.path;
        File storageDirectory = new File(stringStoragePath + "/CDIS_DATA/UserWithPendingRecords/");
        boolean successfullyCreatedDirectory;
        if (!storageDirectory.exists()) {
            successfullyCreatedDirectory = new File(stringStoragePath + "/CDIS_DATA/UserWithPendingRecords/").mkdirs();
        } else {
            successfullyCreatedDirectory = true;
        }
        if (successfullyCreatedDirectory) {

            String filePathForStudent = stringStoragePath + "/CDIS_DATA/UserWithPendingRecords/StudentsHavingPendingRecord.csv";
            String filePathForEmployee = stringStoragePath + "/CDIS_DATA/UserWithPendingRecords/EmployeesHavingPendingRecord.csv";

            File fileToStorePendingStudents = new File(filePathForStudent);
            File fileToStorePendingEmployee = new File(filePathForEmployee);
            try {
                if (!fileToStorePendingStudents.exists()) {
                    fileToStorePendingStudents.createNewFile();
                } else {
                    fileToStorePendingStudents.delete();
                    fileToStorePendingStudents.createNewFile();
                }
                if (!fileToStorePendingEmployee.exists()) {
                    fileToStorePendingEmployee.createNewFile();
                } else {
                    fileToStorePendingEmployee.delete();
                    fileToStorePendingEmployee.createNewFile();
                }
                FileOutputStream fileOutputStreamForStudent = new FileOutputStream(fileToStorePendingStudents);
                FileOutputStream fileOutputStreamForEmployee = new FileOutputStream(fileToStorePendingEmployee);
                PrintWriter printWriterForStudent = new PrintWriter(fileOutputStreamForStudent, true);
                PrintWriter printWriterForEmployee = new PrintWriter(fileOutputStreamForEmployee, true);

                if (iterator.hasNext()) {
                    int studentCount = 0;
                    int employeeCount = 0;
                    printWriterForStudent.println("Username,First_Name,Last_Name,Email,Mobile_No,Academic_Year,Division,Unique_ID");
                    printWriterForEmployee.println("Username,First_Name,Last_Name,Email,Mobile_No,Employee_No");
                    while (iterator.hasNext()) {
                        UserProfileQueryResult user_with_pending_record;
                        user_with_pending_record = (UserProfileQueryResult) iterator.next();
                        if (user_with_pending_record.user_role.equals("S")) {
                            printWriterForStudent.println(user_with_pending_record.student.username.replace(",", "-").replace("\n", " ").trim() + ", "
                                    + user_with_pending_record.student.first_name.replace(",", "-").replace("\n", " ").trim() + ", "
                                    + user_with_pending_record.student.last_name.replace(",", "-").replace("\n", " ").trim() + ", "
                                    + user_with_pending_record.student.email.replace(",", "-").replace("\n", " ").trim() + ";, "
                                    + user_with_pending_record.student.mobile_no.replace(",", "-").replace("\n", " ").trim() + ";, "
                                    + user_with_pending_record.student.academic_year.replace(",", "-").replace("\n", " ").trim() + ", "
                                    + user_with_pending_record.student.division.replace(",", "-").replace("\n", " ").trim() + ", "
                                    + user_with_pending_record.student.unique_id.replace(",", "-").replace("\n", " ").trim());
                            studentCount++;
                        } else if (user_with_pending_record.user_role.equals("E")) {
                            printWriterForEmployee.println(user_with_pending_record.employee.username + ", "
                                    + user_with_pending_record.employee.first_name.replace(",", "-").replace("\n", " ").trim() + ", "
                                    + user_with_pending_record.employee.last_name.replace(",", "-").replace("\n", " ").trim() + ", "
                                    + user_with_pending_record.employee.email.replace(",", "-").replace("\n", " ").trim() + ";, "
                                    + user_with_pending_record.employee.mobile_no.replace(",", "-").replace("\n", " ").trim() + ";, "
                                    + user_with_pending_record.employee.employee_no.replace(",", "-").replace("\n", " ").trim());
                            employeeCount++;
                        }
                    }
                    String returningString;
                    printWriterForStudent.close();
                    fileOutputStreamForStudent.close();
                    if (studentCount == 0) {
                        fileToStorePendingStudents.delete();
                        returningString = "No student with pending record found to store.";
                    } else {
                        Desktop.getDesktop().open(fileToStorePendingStudents);
                        returningString = studentCount + " Students with pending records stored";
                    }

                    printWriterForEmployee.close();
                    fileOutputStreamForEmployee.close();
                    if (employeeCount == 0) {
                        fileToStorePendingEmployee.delete();
                        returningString = returningString + "\n " + "No employee with pending records found to store.";
                    } else {
                        Desktop.getDesktop().open(fileToStorePendingEmployee);
                        returningString = returningString + "\n " + employeeCount + " Employees with pending records stored";
                    }
                    return returningString;
                } else {
                    printWriterForStudent.close();
                    printWriterForEmployee.close();
                    fileOutputStreamForStudent.close();
                    fileOutputStreamForEmployee.close();
                    if (fileToStorePendingStudents.exists()) {
                        fileToStorePendingStudents.delete();
                    }
                    if (fileToStorePendingEmployee.exists()) {
                        fileToStorePendingEmployee.delete();
                    }
                    return "EMPTY_FILE";
                }
            } catch (FileNotFoundException e) {
                return "error occured in saving results"
                        + "\n close file if already opened";
            }
        } else {
            //GUI.libraryInchargeInterfacePanel.showRequsetResult("Error in locating Storage directory, try editing Storage Path");
        }
        return "NOT_STORED";
    }

    public static String storeAlumniStudentsList(String year) throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = null;
        try {
            libraryInchargeInterface = new LibraryInchargeInterface();
        } catch (UnknownHostException e) {
            //e.printStackTrace();
        }
        libraryInchargeInterface.connectToServer();
        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GET_ALUMNI_STUDENTS_BY_YEAR";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        //TODO get year input in GUI
        LibraryInchargeInterface.printWriter.println(year);
        List<UserProfileQueryResult> alumni_students_list = (List<UserProfileQueryResult>) LibraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();

        Iterator iterator = alumni_students_list.iterator();

//            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
//            LocalDateTime currentDateTime = LocalDateTime.now();
//            String currentDate = dateTimeFormat.format(currentDateTime).toString();
        StoragePath storagePath = new StoragePath();
        storagePath = StoragePath.getStoragePath(storagePath);
        if (storagePath.path.equals("PATH_NOT_FOUND")) {
            return "PATH_NOT_FOUND";
        }
        String stringStoragePath = storagePath.path;
        File storageDirectory = new File(stringStoragePath + "/CDIS_DATA/AlumniListByYear");
        boolean successfullyCreatedDirectory;
        if (!storageDirectory.exists()) {
            successfullyCreatedDirectory = new File(stringStoragePath + "/CDIS_DATA/AlumniListByYear").mkdirs();
        } else {
            successfullyCreatedDirectory = true;
        }

        if (successfullyCreatedDirectory) {
            String filePath = stringStoragePath + "/CDIS_DATA/AlumniListByYear/" + year + ".csv";
            File fileToStoreAL = new File(filePath);
            if (!fileToStoreAL.exists()) {
                fileToStoreAL.createNewFile();
            } else {
                fileToStoreAL.delete();
                fileToStoreAL.createNewFile();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileToStoreAL);
                PrintWriter printWriter = new PrintWriter(fileOutputStream, true);
                String returningString;
                if (iterator.hasNext()) {
                    int uwpreCount = 0;
                    printWriter.println("Username,First_Name,Last_Name,Email,Mobile_No,Academic_Year,Division,Unique_ID");
                    while (iterator.hasNext()) {
                        uwpreCount++;
                        UserProfileQueryResult alumni_student;
                        alumni_student = (UserProfileQueryResult) iterator.next();

                        printWriter.println(alumni_student.student.username.replace(",", "-").replace("\n", " ").trim() + ", "
                                + alumni_student.student.first_name.replace(",", "-").replace("\n", " ").trim() + ", "
                                + alumni_student.student.last_name.replace(",", "-").replace("\n", " ").trim() + ", "
                                + alumni_student.student.email.replace(",", "-").replace("\n", " ").trim() + ";, "
                                + alumni_student.student.mobile_no.replace(",", "-").replace("\n", " ").trim() + ";, "
                                + alumni_student.student.academic_year.replace(",", "-").replace("\n", " ").trim() + ", "
                                + alumni_student.student.division.replace(",", "-").replace("\n", " ").trim() + ", "
                                + alumni_student.student.unique_id.replace(",", "-").replace("\n", " ").trim());
                    }

                    Desktop.getDesktop().open(fileToStoreAL);
                    printWriter.close();
                    fileOutputStream.close();
                    returningString = uwpreCount + " alumni student list stored";
                    return returningString;
                } else {
                    printWriter.close();
                    fileOutputStream.close();
                    if (fileToStoreAL.exists()) {
                        fileToStoreAL.delete();
                    }
                    return "EMPTY_FILE";
                }
            } catch (FileNotFoundException e) {
                return "error occured in saving result"
                        + "\n close file if already opened";
            }
        } else {
            //GUI.libraryInchargeInterfacePanel.showRequsetResult("Error in locating Storage directory, try editing Storage Path");
        }

        return "NOT_STORED";
    }

    public static String storePublishersList() throws IOException, ClassNotFoundException {
        List<PublisherQueryResult> publishers_list;
        publishers_list = ServerRequests.getPublisherList();
        Iterator iterator = publishers_list.iterator();

//            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
//            LocalDateTime currentDateTime = LocalDateTime.now();
//            String currentDate = dateTimeFormat.format(currentDateTime).toString();
        StoragePath storagePath = new StoragePath();
        storagePath = StoragePath.getStoragePath(storagePath);
        if (storagePath.path.equals("PATH_NOT_FOUND")) {
            return "PATH_NOT_FOUND";
        }
        String stringStoragePath = storagePath.path;
        File storageDirectory = new File(stringStoragePath + "/CDIS_DATA");
        boolean successfullyCreatedDirectory;
        if (!storageDirectory.exists()) {
            successfullyCreatedDirectory = new File(stringStoragePath + "/CDIS_DATA").mkdirs();
        } else {
            successfullyCreatedDirectory = true;
        }
        if (successfullyCreatedDirectory) {
            String filePath = stringStoragePath + "/CDIS_DATA/PublishersList.csv";
            File fileToStorePL = new File(filePath);
            if (!fileToStorePL.exists()) {
                fileToStorePL.createNewFile();
            } else {
                fileToStorePL.delete();
                fileToStorePL.createNewFile();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileToStorePL);
                PrintWriter printWriter = new PrintWriter(fileOutputStream, true);
                String returningString;
                if (iterator.hasNext()) {
                    int publisher_count = 0;
                    printWriter.println("publisher_id,publisher_name");
                    while (iterator.hasNext()) {
                        publisher_count++;
                        PublisherQueryResult publisher_result;
                        publisher_result = (PublisherQueryResult) iterator.next();
                        printWriter.println(publisher_result.publisher_id + ", "
                                + publisher_result.publisher_name.replace(",", "-").replace("\n", " ").trim());
                    }
                    if (publisher_count != 0) {
                        Desktop.getDesktop().open(fileToStorePL);
                    } else {
                        fileToStorePL.delete();
                    }
                    printWriter.close();
                    fileOutputStream.close();
                    returningString = publisher_count + " publishers list stored";
                    return returningString;
                } else {
                    printWriter.close();
                    fileOutputStream.close();
                    if (fileToStorePL.exists()) {
                        fileToStorePL.delete();
                    }
                    return "EMPTY_FILE";
                }
            } catch (FileNotFoundException e) {
                return "error occured in saving result"
                        + "\n close file if already opened";
            }
        } else {
            //GUI.libraryInchargeInterfacePanel.showRequestResult("Error in locating Storage directory, try editing Storage Path");
        }
        return "NOT_STORED";
    }

    public static String storeDomainsList() throws IOException, ClassNotFoundException {
        List<DomainQueryResult> domains_list;
        domains_list = ServerRequests.getDomainList();
        Iterator iterator = domains_list.iterator();

//            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
//            LocalDateTime currentDateTime = LocalDateTime.now();
//            String currentDate = dateTimeFormat.format(currentDateTime).toString();
        StoragePath storagePath = new StoragePath();
        storagePath = StoragePath.getStoragePath(storagePath);
        if (storagePath.path.equals("PATH_NOT_FOUND")) {
            return "PATH_NOT_FOUND";
        }
        String stringStoragePath = storagePath.path;
        File storageDirectory = new File(stringStoragePath + "/CDIS_DATA");
        boolean successfullyCreatedDirectory;
        if (!storageDirectory.exists()) {
            successfullyCreatedDirectory = new File(stringStoragePath + "/CDIS_DATA").mkdirs();
        } else {
            successfullyCreatedDirectory = true;
        }
        if (successfullyCreatedDirectory) {
            String filePath = stringStoragePath + "/CDIS_DATA/DomainsList.csv";
            File fileToStoreDL = new File(filePath);
            if (!fileToStoreDL.exists()) {
                fileToStoreDL.createNewFile();
            } else {
                fileToStoreDL.delete();
                fileToStoreDL.createNewFile();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileToStoreDL);
                PrintWriter printWriter = new PrintWriter(fileOutputStream, true);
                String returningString;
                if (iterator.hasNext()) {
                    int domain_count = 0;
                    printWriter.println("domain_id,domain_name");
                    while (iterator.hasNext()) {
                        domain_count++;
                        DomainQueryResult domain_result;
                        domain_result = (DomainQueryResult) iterator.next();

                        printWriter.println(domain_result.domain_id + ", "
                                + domain_result.domain_name.replace(",", "-").replace("\n", " ").trim());
                    }
                    if (domain_count != 0) {
                        Desktop.getDesktop().open(fileToStoreDL);
                    } else {
                        fileToStoreDL.delete();
                    }
                    printWriter.close();
                    fileOutputStream.close();
                    returningString = domain_count + " domains list stored";
                    return returningString;
                } else {
                    printWriter.close();
                    fileOutputStream.close();
                    if (fileToStoreDL.exists()) {
                        fileToStoreDL.delete();
                    }
                    return "EMPTY_FILE";
                }
            } catch (FileNotFoundException e) {
                return "error occured in saving result"
                        + "\n close file if already opened";
            }
        } else {
            //GUI.libraryInchargeInterfacePanel.showRequestResult("Error in locating Storage directory, try editing Storage Path");
        }
        return "NOT_STORED";
    }

    public static String storeAccounts() throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = null;
        try {
            libraryInchargeInterface = new LibraryInchargeInterface();
        } catch (UnknownHostException e) {
            //e.printStackTrace();
        }
        libraryInchargeInterface.connectToServer();
        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GET_ACCOUNTS_LIST";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        List<AccountsQueryResult> accounts_list;

        accounts_list = (List<AccountsQueryResult>) LibraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();

        Iterator iterator = accounts_list.iterator();

//            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
//            LocalDateTime currentDateTime = LocalDateTime.now();
//            String currentDate = dateTimeFormat.format(currentDateTime).toString();
        StoragePath storagePath = new StoragePath();
        storagePath = StoragePath.getStoragePath(storagePath);
        if (storagePath.path.equals("PATH_NOT_FOUND")) {
            return "PATH_NOT_FOUND";
        }
        String stringStoragePath = storagePath.path;
        File storageDirectory = new File(stringStoragePath + "/CDIS_DATA");
        boolean successfullyCreatedDirectory;
        if (!storageDirectory.exists()) {
            successfullyCreatedDirectory = new File(stringStoragePath + "/CDIS_DATA").mkdirs();
        } else {
            successfullyCreatedDirectory = true;
        }
        storageDirectory.setWritable(true);
        if (successfullyCreatedDirectory) {
            String filePath = stringStoragePath + "/CDIS_DATA/AccountsList.csv";
            File fileToStoreAL = new File(filePath);
            if (!fileToStoreAL.exists()) {
                fileToStoreAL.createNewFile();
            } else {
                fileToStoreAL.delete();
                fileToStoreAL.createNewFile();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileToStoreAL);
                PrintWriter printWriter = new PrintWriter(fileOutputStream, true);
                String returningString;
                if (iterator.hasNext()) {
                    int accounts_count = 0;
                    printWriter.println("account_number,date_of_account,total_fine_amount");
                    while (iterator.hasNext()) {
                        accounts_count++;
                        AccountsQueryResult accounts_result ;
                        accounts_result = (AccountsQueryResult) iterator.next();
                        printWriter.println(accounts_result.account_number + ", "
                                + accounts_result.date_of_account.replace(",", "-").replace("\n", " ").trim() + ","
                                + accounts_result.total_fine_amount);
                    }
                    if (accounts_count != 0) {
                        Desktop.getDesktop().open(fileToStoreAL);
                    } else {
                        fileToStoreAL.delete();
                    }
                    printWriter.close();
                    fileOutputStream.close();
                    returningString = accounts_count + " accounts  entries stored";
                    return returningString;
                } else {
                    printWriter.close();
                    fileOutputStream.close();
                    if (fileToStoreAL.exists()) {
                        fileToStoreAL.delete();
                    }
                    return "EMPTY_FILE";
                }
            } catch (FileNotFoundException e) {
                return "error occured in saving result"
                        + "\n close file if already opened";
            }
        } else {
            //GUI.libraryInchargeInterfacePanel.showRequestResult("Error in locating Storage directory, try editing Storage Path");
        }
        return "NOT_STORED";
    }

    public static String storeSubjectsList() throws IOException, ClassNotFoundException {
        List<SubjectQueryResult> subjects_list;
        subjects_list = ServerRequests.getSubjectList();
        Iterator iterator = subjects_list.iterator();

//            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
//            LocalDateTime currentDateTime = LocalDateTime.now();
//            String currentDate = dateTimeFormat.format(currentDateTime).toString();
        StoragePath storagePath = new StoragePath();
        storagePath = StoragePath.getStoragePath(storagePath);
        if (storagePath.path.equals("PATH_NOT_FOUND")) {
            return "PATH_NOT_FOUND";
        }
        String stringStoragePath = storagePath.path;
        File storageDirectory = new File(stringStoragePath + "/CDIS_DATA");
        boolean successfullyCreatedDirectory;
        if (!storageDirectory.exists()) {
            successfullyCreatedDirectory = new File(stringStoragePath + "/CDIS_DATA").mkdirs();
        } else {
            successfullyCreatedDirectory = true;
        }
        if (successfullyCreatedDirectory) {
            String filePath = stringStoragePath + "/CDIS_DATA/SubjectsList.csv";
            File fileToStoreSL = new File(filePath);
            if (!fileToStoreSL.exists()) {
                fileToStoreSL.createNewFile();
            } else {
                fileToStoreSL.delete();
                fileToStoreSL.createNewFile();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileToStoreSL);
                PrintWriter printWriter = new PrintWriter(fileOutputStream, true);
                String returningString;
                if (iterator.hasNext()) {
                    int subject_count = 0;
                    printWriter.println("subject_id,subject_name,semester,academic_year,exam_pattern,domain_id,subject_abbreviation");
                    while (iterator.hasNext()) {
                        subject_count++;
                        SubjectQueryResult subject_result;
                        subject_result = (SubjectQueryResult) iterator.next();

                        printWriter.println(subject_result.subject_id + ", "
                                + subject_result.subject_name.replace(",", "-").replace("\n", " ").trim() + ","
                                + subject_result.semester.replace(",", "-").replace("\n", " ").trim() + ","
                                + subject_result.academic_year.replace(",", "-").replace("\n", " ").trim() + ","
                                + subject_result.exam_pattern.replace(",", "-").replace("\n", " ").trim() + ","
                                + subject_result.domain_id + ","
                                + subject_result.subject_abbreviation.replace(",", "-").replace("\n", " ").trim());
                    }
                    if (subject_count != 0) {
                        Desktop.getDesktop().open(fileToStoreSL);
                    } else {
                        fileToStoreSL.delete();
                    }
                    printWriter.close();
                    fileOutputStream.close();
                    returningString = subject_count + " subjects list stored";
                    return returningString;
                } else {
                    printWriter.close();
                    fileOutputStream.close();
                    if (fileToStoreSL.exists()) {
                        fileToStoreSL.delete();
                    }
                    return "EMPTY_FILE";
                }
            } catch (FileNotFoundException e) {
                return "error occured in saving result"
                        + "\n close file if already opened";
            }
        } else {
            //GUI.libraryInchargeInterfacePanel.showRequestResult("Error in locating Storage directory, try editing Storage Path");
        }
        return "NOT_STORED";
    }

    public static String storeBookTitles() throws IOException, ClassNotFoundException {
        List<BookTitleQueryResult> book_titles_query_result_set = ServerRequests.getBookTitleList();
        Iterator iterator = book_titles_query_result_set.iterator();

//            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
//            LocalDateTime currentDateTime = LocalDateTime.now();
//            String currentDate = dateTimeFormat.format(currentDateTime).toString();
        StoragePath storagePath = new StoragePath();
        storagePath = StoragePath.getStoragePath(storagePath);
        if (storagePath.path.equals("PATH_NOT_FOUND")) {
            return "PATH_NOT_FOUND";
        }
        String stringStoragePath = storagePath.path;
        File storageDirectory = new File(stringStoragePath + "/CDIS_DATA");
        boolean successfullyCreatedDirectory;
        if (!storageDirectory.exists()) {
            successfullyCreatedDirectory = new File(stringStoragePath + "/CDIS_DATA").mkdirs();
        } else {
            successfullyCreatedDirectory = true;
        }
        if (successfullyCreatedDirectory) {
            String filePath = stringStoragePath + "/CDIS_DATA/BookTitles.csv";
            File fileToStoreBT = new File(filePath);
            if (!fileToStoreBT.exists()) {
                fileToStoreBT.createNewFile();
            } else {
                fileToStoreBT.delete();
                fileToStoreBT.createNewFile();
            }

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileToStoreBT);
                PrintWriter printWriter = new PrintWriter(fileOutputStream, true);
                String returningString;
                if (iterator.hasNext()) {
                    int book_title_count = 0;
                    printWriter.println("book_id,book_author,book_titles,no_of_copies,available_copies,publisher,domain,cupboard_no,shelf_no");
                    while (iterator.hasNext()) {
                        book_title_count++;
                        BookTitleQueryResult book_title;
                        book_title = (BookTitleQueryResult) iterator.next();

                        printWriter.println(book_title.book_id + ", "
                                + book_title.book_author.replace(",", "-").replace("\n", " ").trim() + ","
                                + book_title.book_title.replace(",", "-").replace("\n", " ").trim() + ","
                                + book_title.no_of_copies + ","
                                + book_title.available_copies + ","
                                + book_title.publisher_id + " : " + book_title.publisher_name.replace(",", "-").replace("\n", " ").trim() + ","
                                + book_title.domain_id + " : " + book_title.domain_name.replace(",", "-").replace("\n", " ").trim() + ","
                                + book_title.cupboard_no + ","
                                + book_title.shelf_no);
                    }
                    if (book_title_count != 0) {
                        Desktop.getDesktop().open(fileToStoreBT);
                    } else {
                        fileToStoreBT.delete();
                    }
                    printWriter.close();
                    fileOutputStream.close();
                    returningString = book_title_count + " book titles stored";
                    return returningString;
                } else {
                    printWriter.close();
                    fileOutputStream.close();
                    if (fileToStoreBT.exists()) {
                        fileToStoreBT.delete();
                    }
                    return "EMPTY_FILE";
                }
            } catch (FileNotFoundException e) {
                return "error occured in saving result"
                        + "\n close file if already opened";
            }
        } else {
            //GUI.libraryInchargeInterfacePanel.showRequestResult("Error in locating Storage directory, try editing Storage Path");
        }
        return "NOT_STORED";
    }

    public static String storeReportTitles() throws IOException, ClassNotFoundException {
        List<ReportTitleQueryResult> report_titles_query_result_set = ServerRequests.getReportTitleList();
        Iterator iterator = report_titles_query_result_set.iterator();

//            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
//            LocalDateTime currentDateTime = LocalDateTime.now();
//            String currentDate = dateTimeFormat.format(currentDateTime).toString();
        StoragePath storagePath = new StoragePath();
        storagePath = StoragePath.getStoragePath(storagePath);
        if (storagePath.path.equals("PATH_NOT_FOUND")) {
            return "PATH_NOT_FOUND";
        }
        String stringStoragePath = storagePath.path;
        File storageDirectory = new File(stringStoragePath + "/CDIS_DATA");
        boolean successfullyCreatedDirectory;
        if (!storageDirectory.exists()) {
            successfullyCreatedDirectory = new File(stringStoragePath + "/CDIS_DATA").mkdirs();
        } else {
            successfullyCreatedDirectory = true;
        }
        if (successfullyCreatedDirectory) {
            String filePath = stringStoragePath + "/CDIS_DATA/ReportTitles.csv";
            File fileToStoreRT = new File(filePath);
            if (!fileToStoreRT.exists()) {
                fileToStoreRT.createNewFile();
            } else {
                fileToStoreRT.delete();
                fileToStoreRT.createNewFile();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileToStoreRT);
                PrintWriter printWriter = new PrintWriter(fileOutputStream, true);
                String returningString;
                if (iterator.hasNext()) {
                    int report_title_count = 0;
                    printWriter.println("report_id,report_titles,domain,availability,cupboard_no,shelf_no");
                    while (iterator.hasNext()) {
                        report_title_count++;
                        ReportTitleQueryResult report_title;
                        report_title = (ReportTitleQueryResult) iterator.next();

                        printWriter.println(report_title.report_id + ", "
                                + report_title.report_title.replace(",", "-").replace("\n", " ").trim() + ","
                                + report_title.domain_id + " : " + report_title.domain_name.replace(",", "-").replace("\n", " ").trim() + ","
                                + report_title.availability_status + ","
                                + report_title.cupboard_no + ","
                                + report_title.shelf_no);
                    }
                    if (report_title_count != 0) {
                        Desktop.getDesktop().open(fileToStoreRT);
                    } else {
                        fileToStoreRT.delete();
                    }
                    printWriter.close();
                    fileOutputStream.close();
                    returningString = report_title_count + " report titles stored";
                    return returningString;
                } else {
                    printWriter.close();
                    fileOutputStream.close();
                    if (fileToStoreRT.exists()) {
                        fileToStoreRT.delete();
                    }
                    return "EMPTY_FILE";
                }
            } catch (FileNotFoundException e) {
                return "error occured in saving result"
                        + "\n close file if already opened";
            }
        } else {
            //GUI.libraryInchargeInterfacePanel.showRequestResult("Error in locating Storage directory, try editing Storage Path");
        }
        return "NOT_STORED";
    }
}
