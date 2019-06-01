package LibraryIncharge;

import DatabaseAccessObjects.QueryObjects.*;
import DatabaseAccessObjects.ResultObjects.BookIssueConstraintsQueryResult;
import DatabaseAccessObjects.ResultObjects.BookSearchQueryResult;
import DatabaseAccessObjects.ResultObjects.BookTitleQueryResult;
import DatabaseAccessObjects.ResultObjects.DomainQueryResult;
import DatabaseAccessObjects.ResultObjects.PendingBooksRecordQueryResult;
import DatabaseAccessObjects.ResultObjects.PendingReportRecordQueryResult;
import DatabaseAccessObjects.ResultObjects.PublisherQueryResult;
import DatabaseAccessObjects.ResultObjects.ReportSearchQueryResult;
import DatabaseAccessObjects.ResultObjects.ReportTitleQueryResult;
import DatabaseAccessObjects.ResultObjects.SubjectQueryResult;
import DatabaseAccessObjects.ResultObjects.UserProfileQueryResult;
import RequestAttributes.RequestAttributes;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

public class ServerRequests {

    static public boolean login(String username, String password) throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "VERIFY_CREDENTIALS";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        LibraryInchargeInterface.user = new User();
        LibraryInchargeInterface.user.username = username;
        LibraryInchargeInterface.user.password = password;
        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }
        LibraryInchargeInterface.objOut.writeObject(LibraryInchargeInterface.user);
        boolean successfulSignUp = LibraryInchargeInterface.dataIn.readBoolean();
        if (successfulSignUp == true) {
            LibraryInchargeInterface.user = (User) LibraryInchargeInterface.objIn.readObject();
            libraryInchargeInterface.closeConnection();
            return true;
        } else {
            libraryInchargeInterface.closeConnection();
            return false;
        }
    }

    static public List<BookSearchQueryResult> getBookSearchResult(BookSearchAttributes book_query) throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();
        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "SEARCH_BOOK";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        LibraryInchargeInterface.objOut.writeObject(book_query);
        List<BookSearchQueryResult> book_query_result_set = (List<BookSearchQueryResult>) LibraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();
        return book_query_result_set;
    }

    public static List<ReportSearchQueryResult> getReportSearchResult(ReportSearchAttributes report_query) throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();
        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "SEARCH_REPORT";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        LibraryInchargeInterface.objOut.writeObject(report_query);
        List<ReportSearchQueryResult> report_query_result_set = (List<ReportSearchQueryResult>) LibraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();
        return report_query_result_set;
    }

    static public List<UserProfileQueryResult> getUserSearchResult(UserSearchAttributes user_search_query) throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();
        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "SEARCH_USER";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        LibraryInchargeInterface.objOut.writeObject(user_search_query);
        List<UserProfileQueryResult> user_search_query_result_set = (List<UserProfileQueryResult>) LibraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();
        return user_search_query_result_set;
    }

    static public UserProfileQueryResult getUserProfile(UserProfileRequestAttribute user_profile_query) throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GET_USER_PROFILE";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);
        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }
        LibraryInchargeInterface.objOut.writeObject(user_profile_query);
        UserProfileQueryResult user_profile_query_result = (UserProfileQueryResult) LibraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();

        return user_profile_query_result;
    }

    static public List<PublisherQueryResult> getPublisherList() throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = null;
        try {
            libraryInchargeInterface = new LibraryInchargeInterface();
        } catch (UnknownHostException e) {
            //e.printStackTrace();
        }
        libraryInchargeInterface.connectToServer();
        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GET_PUBLISHERS_LIST";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        List<PublisherQueryResult> publishers_list ;
        publishers_list = (List<PublisherQueryResult>) LibraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();
        return publishers_list;
    }

    static public List<DomainQueryResult> getDomainList() throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = null;
        try {
            libraryInchargeInterface = new LibraryInchargeInterface();
        } catch (UnknownHostException e) {
            //e.printStackTrace();
        }
        libraryInchargeInterface.connectToServer();
        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GET_DOMAINS_LIST";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        List<DomainQueryResult> domains_list ;
        domains_list = (List<DomainQueryResult>) LibraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();
        return domains_list;
    }
    
static public List<SubjectQueryResult> getSubjectList() throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = null;
        try {
            libraryInchargeInterface = new LibraryInchargeInterface();
        } catch (UnknownHostException e) {
            //e.printStackTrace();
        }
        libraryInchargeInterface.connectToServer();
        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GET_SUBJECTS_LIST";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        List<SubjectQueryResult> subjects_list ;
        subjects_list = (List<SubjectQueryResult>) LibraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();
        return subjects_list;
}
    
    static public List<BookTitleQueryResult> getBookTitleList() throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = null;
        try {
            libraryInchargeInterface = new LibraryInchargeInterface();
        } catch (UnknownHostException e) {
            //e.printStackTrace();
        }
        libraryInchargeInterface.connectToServer();
        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GET_BOOK_TITLE_LIST";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        List<BookTitleQueryResult> book_title_list;
        book_title_list = (List<BookTitleQueryResult>) LibraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();
        return book_title_list;
    }

    static public List<ReportTitleQueryResult> getReportTitleList() throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = null;
        try {
            libraryInchargeInterface = new LibraryInchargeInterface();
        } catch (UnknownHostException e) {
            //e.printStackTrace();
        }
        libraryInchargeInterface.connectToServer();
        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GET_REPORT_TITLE_LIST";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        List<ReportTitleQueryResult> report_title_list;
        report_title_list = (List<ReportTitleQueryResult>) LibraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();
        return report_title_list;
    }
    
  
    static public List<PendingBooksRecordQueryResult> getPendingBooksRecord(UserProfileRequestAttribute user_profile_query) throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();
        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GET_PENDING_BOOKS_RECORD";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        LibraryInchargeInterface.objOut.writeObject(user_profile_query);
        List<PendingBooksRecordQueryResult> pending_records_query_result_set = (List<PendingBooksRecordQueryResult>) LibraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();
        return pending_records_query_result_set;
    }
    
   
     public static List<PendingReportRecordQueryResult> getPendingReportRecord(UserProfileRequestAttribute user_profile_query) throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();
        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GET_PENDING_REPORT_RECORD";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        LibraryInchargeInterface.objOut.writeObject(user_profile_query);
        List<PendingReportRecordQueryResult> pending_report_record_query_result_set = (List<PendingReportRecordQueryResult>)LibraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();
        return pending_report_record_query_result_set;
    }

    static public String verifyUserProfile(UserProfileQueryResult user_profile_query_result) throws IOException, ClassNotFoundException {
        UserProfileRequestAttribute user_profile_query = new UserProfileRequestAttribute();
        boolean need_to_verify = true;
        boolean has_pending_record = true;
        int verification_status = 0;

        if (user_profile_query_result.user_role.equals("S")) {
            has_pending_record = user_profile_query_result.has_pending_library_record;
            verification_status = user_profile_query_result.student.verification_status;
            if (user_profile_query_result.student.verification_status == 1) {
                need_to_verify = false;
            }
            user_profile_query.username = user_profile_query_result.student.username;
        } else if (user_profile_query_result.user_role.equals("E")) {
            has_pending_record = user_profile_query_result.has_pending_library_record;
            verification_status = user_profile_query_result.employee.verification_status;
            if (user_profile_query_result.employee.verification_status == 1) {
                need_to_verify = false;
            }
            user_profile_query.username = user_profile_query_result.employee.username;
        }
        if ((!has_pending_record)) {
            LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
            if (need_to_verify) {
                boolean requestResult;
                libraryInchargeInterface.connectToServer();
                RequestAttributes requestAttributes = new RequestAttributes();
                requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
                requestAttributes.requestCode = "VERIFY_USER_PROFILE";
                LibraryInchargeInterface.objOut.writeObject(requestAttributes);
                while (true) {
                    String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
                    if (serverStatus.equals("SERVER_READY")) {
                        break;
                    }
                }
                LibraryInchargeInterface.objOut.writeObject(user_profile_query);
                requestResult = LibraryInchargeInterface.dataIn.readBoolean();
                libraryInchargeInterface.closeConnection();
                if (requestResult) {
                    return "VERIFIED_SUCCESSFULLY";
                } else {
                    return "NOT_VERIFIED";
                }
            } else {
                return "ALREADY_VERIFIED";
            }
        } else if (has_pending_record && (verification_status != 1)) {
            UserProfileRequestAttribute userProfileRequestAttribute = new UserProfileRequestAttribute();
            if (user_profile_query_result.user_role.equals("S")) {
                userProfileRequestAttribute.username = user_profile_query_result.student.username;
            } else if (user_profile_query_result.user_role.equals("E")) {
                userProfileRequestAttribute.username = user_profile_query_result.employee.username;
            }
            return "HAS_PENDING_RECORD";
        } else {
            return "ALREADY_VERIFIED";
        }
    }

    static public String issueBook(BookIssueAttributes book_issue_query) throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "ISSUE_BOOK";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }
        LibraryInchargeInterface.objOut.writeObject(book_issue_query);
        String date_of_return = LibraryInchargeInterface.bufferedReader.readLine();
        libraryInchargeInterface.closeConnection();
        return date_of_return;
    }

    public static boolean issueReport(BookIssueAttributes report_issue_query) throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "ISSUE_REPORT";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        LibraryInchargeInterface.objOut.writeObject(report_issue_query);
        boolean issued_successfully = LibraryInchargeInterface.dataIn.readBoolean();
        libraryInchargeInterface.closeConnection();
        return issued_successfully;
    }

    public static String returnBook(BookReturnAttributes book_return_query) throws IOException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();
        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "RETURN_BOOK";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);
  
        while (true) {
           String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        LibraryInchargeInterface.objOut.writeObject(book_return_query);
        boolean returned_successfully = LibraryInchargeInterface.dataIn.readBoolean();
        libraryInchargeInterface.closeConnection();
        if (returned_successfully) {
            return "book returned successfully";
        } else {
            return "didn't returned book";
        }
    }

    public static String returnReport(ReportReturnAttributes report_return_query) throws IOException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "RETURN_REPORT";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        LibraryInchargeInterface.objOut.writeObject(report_return_query);
        boolean returned_successfully = LibraryInchargeInterface.dataIn.readBoolean();
        libraryInchargeInterface.closeConnection();
        if (returned_successfully) {
            return "report returned successfully";
        } else {
            return "didn't returned report";
        }
    }

    public static String renewBook(BookReturnAttributes book_return_query) throws IOException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "RENEW_BOOK";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        LibraryInchargeInterface.objOut.writeObject(book_return_query);
        String date_of_return = LibraryInchargeInterface.bufferedReader.readLine();
        libraryInchargeInterface.closeConnection();
        return date_of_return;
        //retuning date_of_retun to do analysis weather to delete row or not
    }

    static public String clearAndAccountLibraryRecords() throws IOException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "CLEAR_&_ACCOUNT";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        int total_cleared_book_records = LibraryInchargeInterface.dataIn.readInt();
        int total_fine_amount = LibraryInchargeInterface.dataIn.readInt();
        int total_cleared_report_records = LibraryInchargeInterface.dataIn.readInt();
        libraryInchargeInterface.closeConnection();
        return total_cleared_book_records + " completed book issue records cleared"
                + ", total  fine amount : " + total_fine_amount + " \n "
                + total_cleared_report_records + " completed report issue records cleared from";
    }

    public static String resetStudentsVerification() throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "RESET_STUDENTS_VERIFICATION";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        boolean resetSuccess = LibraryInchargeInterface.dataIn.readBoolean();
        libraryInchargeInterface.closeConnection();
        if (resetSuccess) {
            return "Students verification status restored successfully";
        } else {
            return "Students verification status didn't restored";
        }
    }

    public static boolean deleteUserProfile(UserProfileRequestAttribute user_profile_query) throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "DELETE_USER_PROFILE";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        LibraryInchargeInterface.objOut.writeObject(user_profile_query);
        boolean deleted_successfully = LibraryInchargeInterface.dataIn.readBoolean();
        libraryInchargeInterface.closeConnection();
        return deleted_successfully;
    }

    public static boolean giveClearanceToStudent(UserProfileRequestAttribute user_profile_query) throws IOException, ClassNotFoundException, InterruptedException {
        //Not handling has pending records condition already handled
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GIVE_CLEARANCE_TO_STUDENT";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        LibraryInchargeInterface.objOut.writeObject(user_profile_query);
        boolean given_clearance_successfully = LibraryInchargeInterface.dataIn.readBoolean();
        libraryInchargeInterface.closeConnection();
        return given_clearance_successfully;
    }

    public static boolean addBookTitle(AddBookTitleAttributes add_book_query) throws IOException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "ADD_BOOK_TITLE";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        LibraryInchargeInterface.objOut.writeObject(add_book_query);
        boolean added_successfully = LibraryInchargeInterface.dataIn.readBoolean();
        libraryInchargeInterface.closeConnection();
        return added_successfully;
    }

    public static boolean addReportTitle(AddReportTitleAttributes add_report_query) throws IOException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "ADD_REPORT_TITLE";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        LibraryInchargeInterface.objOut.writeObject(add_report_query);
        boolean added_successfully = LibraryInchargeInterface.dataIn.readBoolean();
        libraryInchargeInterface.closeConnection();
        return added_successfully;
    }

    public static boolean addDomain(AddDomainAttributes add_domain_query) throws IOException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "ADD_DOMAIN";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        LibraryInchargeInterface.objOut.writeObject(add_domain_query);
        boolean added_successfully = LibraryInchargeInterface.dataIn.readBoolean();
        libraryInchargeInterface.closeConnection();
        return added_successfully;
    }

    public static boolean addPublisher(AddPublisherAttributes add_publisher_query) throws IOException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "ADD_PUBLISHER";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        LibraryInchargeInterface.objOut.writeObject(add_publisher_query);
        boolean added_successfully = LibraryInchargeInterface.dataIn.readBoolean();
        libraryInchargeInterface.closeConnection();
        return added_successfully;
    }

    public static boolean addSubject(AddSubjectAttributes add_subject_query) throws IOException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "ADD_SUBJECT";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        LibraryInchargeInterface.objOut.writeObject(add_subject_query);
        boolean added_successfully = LibraryInchargeInterface.dataIn.readBoolean();
        libraryInchargeInterface.closeConnection();
        return added_successfully;
    }

    //Returns single book title if book_id pass never used
    /*public static AddBookTitleAttributes getBookTitle(int book_id) throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GET_BOOK_TITLE";
        libraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = libraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        libraryInchargeInterface.dataOut.writeInt(book_id);
        AddBookTitleAttributes book_query_result = (AddBookTitleAttributes) libraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();
        return book_query_result;
    }*/


    public static boolean updateBookTitle(AddBookTitleAttributes updatedBookTitleAttributes) throws IOException, ClassNotFoundException {
       LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

       RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "UPDATE_BOOK_TITLE";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }
        LibraryInchargeInterface.objOut.writeObject(updatedBookTitleAttributes);
        boolean updated_successfully = LibraryInchargeInterface.dataIn.readBoolean();
        libraryInchargeInterface.closeConnection();
        return updated_successfully;
    }
    
    //Returns single report title if report_id pass never used
    /* public static AddReportTitleAttributes  getReportTitle(int report_id) throws UnknownHostException, IOException, ClassNotFoundException{
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GET_REPORT_TITLE";
        libraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = libraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        libraryInchargeInterface.dataOut.writeInt(report_id);
        AddReportTitleAttributes report_query_result = (AddReportTitleAttributes) libraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();
        return report_query_result;
    }*/
    
    public static boolean updateReportTitle(AddReportTitleAttributes updatedReportTitleAttributes) throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "UPDATE_REPORT_TITLE";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }
        LibraryInchargeInterface.objOut.writeObject(updatedReportTitleAttributes);
        boolean updated_successfully = LibraryInchargeInterface.dataIn.readBoolean();
        libraryInchargeInterface.closeConnection();
        return updated_successfully;
    }
    
    /*public static AddDomainAttributes getDomain(int domain_id) throws UnknownHostException, IOException, ClassNotFoundException{
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GET_DOMAIN";
        libraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = libraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        libraryInchargeInterface.dataOut.writeInt(domain_id);
        AddDomainAttributes domain_query_result = (AddDomainAttributes) libraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();
        return domain_query_result;
    }*/

    public static boolean updateDomain(AddDomainAttributes updateDomainAttributes) throws IOException, ClassNotFoundException {
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "UPDATE_DOMAIN";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }
        LibraryInchargeInterface.objOut.writeObject(updateDomainAttributes);
        boolean updated_successfully = LibraryInchargeInterface.dataIn.readBoolean();
        libraryInchargeInterface.closeConnection();
          return updated_successfully;
    }

    /*public static AddPublisherAttributes getPublisher(int publisher_id) throws UnknownHostException, IOException, ClassNotFoundException{
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GET_PUBLISHER";
        libraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = libraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        libraryInchargeInterface.dataOut.writeInt(publisher_id);
        AddPublisherAttributes publisher_query_result = (AddPublisherAttributes) libraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();
        return publisher_query_result;
    }*/
    
    public static boolean updatePublisher(AddPublisherAttributes updatePublisherAttributes) throws IOException, ClassNotFoundException {
       LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

       RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "UPDATE_PUBLISHER";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }
        LibraryInchargeInterface.objOut.writeObject(updatePublisherAttributes);
        boolean updated_successfully = LibraryInchargeInterface.dataIn.readBoolean();
        libraryInchargeInterface.closeConnection();
        return updated_successfully;
    }

    /*public static AddSubjectAttributes getSubject(int subject_id) throws UnknownHostException, IOException, ClassNotFoundException{
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GET_SUBJECT";
        libraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = libraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        libraryInchargeInterface.dataOut.writeInt(subject_id);
        AddSubjectAttributes subject_query_result = (AddSubjectAttributes) libraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();
        return subject_query_result;
    }*/
    
    
    public static boolean updateSubject(AddSubjectAttributes updateSubjectAttributes) throws IOException, ClassNotFoundException {
       LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

       RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "UPDATE_SUBJECT";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }
        LibraryInchargeInterface.objOut.writeObject(updateSubjectAttributes);
        boolean updated_successfully = LibraryInchargeInterface.dataIn.readBoolean();
        libraryInchargeInterface.closeConnection();
        return updated_successfully;
    }

    public static List<BookIssueConstraintsQueryResult> getBookIssueConstraintsQueryResults() throws UnknownHostException, IOException, ClassNotFoundException{
        LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

        RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "GET_BOOK_ISSUE_CONSTRAINTS";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }
        List<BookIssueConstraintsQueryResult> book_issue_constraint_set = (List<BookIssueConstraintsQueryResult>) LibraryInchargeInterface.objIn.readObject();
        libraryInchargeInterface.closeConnection();
        return book_issue_constraint_set;
    }
    
    public static boolean updateBookIssueConstraints(List<BookIssueConstraintsQueryResult> bookIssueConstraintSet) throws IOException, ClassNotFoundException {
       LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

       RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "UPDATE_BOOK_ISSUE_CONSTRAINTS";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        LibraryInchargeInterface.objOut.writeObject(bookIssueConstraintSet);
        boolean updated_successfully = LibraryInchargeInterface.dataIn.readBoolean();
        libraryInchargeInterface.closeConnection();
        return updated_successfully;
    }

    public static boolean deleteLibraryContent(String year) throws UnknownHostException, IOException {
       LibraryInchargeInterface libraryInchargeInterface = new LibraryInchargeInterface();
        libraryInchargeInterface.connectToServer();

       RequestAttributes requestAttributes = new RequestAttributes();
        requestAttributes.interfaceName = LibraryInchargeInterface.interfaceName;
        requestAttributes.requestCode = "DELETE_LIBRARY_CONTNET";
        LibraryInchargeInterface.objOut.writeObject(requestAttributes);

        while (true) {
            String serverStatus = LibraryInchargeInterface.bufferedReader.readLine();
            if (serverStatus.equals("SERVER_READY")) {
                break;
            }
        }

        LibraryInchargeInterface.dataOut.writeUTF(year);
        boolean deleted_successfully = LibraryInchargeInterface.dataIn.readBoolean();
        libraryInchargeInterface.closeConnection();
        return deleted_successfully;
    }
}
