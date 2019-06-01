package GUIFunctions;

import DatabaseAccessObjects.QueryObjects.*;
import java.util.Scanner;

public class Input {

 /*   static public BookSearchAttributes readBookSearchAttributes() {
        BookSearchAttributes book_query = new BookSearchAttributes();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter book_author, book_title, subject_abbreviation, domain_name");
        book_query.book_author = scan.next();
        if (!book_query.book_author.equals("null")) {
            book_query.book_author = "%" + book_query.book_author + "%";
        } else {
            book_query.book_author = "%";
        }
        book_query.book_title = scan.next();
        if (!book_query.book_title.equals("null")) {
            book_query.book_title = "%" + book_query.book_title + "%";
        } else {
            book_query.book_title = "%";
        }
        book_query.subject_abbreviation = scan.next();
        if (!book_query.subject_abbreviation.equals("null")) {
            book_query.subject_abbreviation = "%" + book_query.subject_abbreviation + "%";
        } else {
            book_query.subject_abbreviation = "%";
        }
        book_query.domain_name = scan.next();
        if (!book_query.domain_name.equals("null")) {
            book_query.domain_name = "%" + book_query.domain_name + "%";
        } else {
            book_query.domain_name = "%";
        }
        return book_query;
    }*/

   /* public static ReportSearchAttributes readReportSearchAttributes() {
        ReportSearchAttributes report_query = new ReportSearchAttributes();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter report_title, domain_name");
        report_query.report_title = scan.next();
        if (!report_query.report_title.equals("null")) {
            report_query.report_title = "%" + report_query.report_title + "%";
        } else {
            report_query.report_title = "%";
        }
        report_query.domain_name = scan.next();
        if (!report_query.domain_name.equals("null")) {
            report_query.domain_name = "%" + report_query.domain_name + "%";
        } else {
            report_query.domain_name = "%";
        }
        return report_query;
    }

    public static AddBookTitleAttributes readAddBookAttributes() {
        AddBookTitleAttributes add_book_query = new AddBookTitleAttributes();

        while (true) {
            boolean entered_all_values = true;
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter book_author, book_title, no_of_copies, available_copies, publisher_id, domain_id, cupboard_no, shelf_no");
            add_book_query.book_author = scan.nextLine();
            if (add_book_query.book_author.equals("null")) {
                entered_all_values = false;
            }
            add_book_query.book_title = scan.nextLine();
            if (add_book_query.book_title.equals("null")) {
                entered_all_values = false;
            }
            add_book_query.no_of_copies = scan.nextInt();
            if (add_book_query.no_of_copies == 0) {
                entered_all_values = false;
            }

            add_book_query.available_copies = scan.nextInt();
            if (add_book_query.available_copies == 0) {
                entered_all_values = false;
            }

            add_book_query.publisher_id = scan.nextInt();
            if (add_book_query.publisher_id == 0) {
                entered_all_values = false;
            }

            add_book_query.domain_id = scan.nextInt();
            if (add_book_query.domain_id == 0) {
                entered_all_values = false;
            }
            add_book_query.cupboard_no = scan.nextInt();
            add_book_query.shelf_no = scan.nextInt();
            if (entered_all_values) {
                break;
            } else {
                System.out.println("Enter all mandatory fields.");
            }
        }
        return add_book_query;
    }*/

    /*public static AddReportTitleAttributes readAddReportAttributes() {
        AddReportTitleAttributes add_report_query = new AddReportTitleAttributes();

        while (true) {
            boolean entered_all_values = true;
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter report_title, domain_id, cupboard_no, shelf_no");
            add_report_query.report_title = scan.nextLine();
            if (add_report_query.report_title.equals("null")) {
                entered_all_values = false;
            }

            add_report_query.domain_id = scan.nextInt();
            if (add_report_query.domain_id == 0) {
                entered_all_values = false;
            }

            add_report_query.cupboard_no = scan.nextInt();
            add_report_query.shelf_no = scan.nextInt();
            if (entered_all_values) {
                break;
            } else {
                System.out.println("Enter all mandatory fields.");
            }
        }
        return add_report_query;
    }*/

  /*  public static AddDomainAttributes readAddDomainAttributes() {
        AddDomainAttributes add_domain_query = new AddDomainAttributes();
        while (true) {
            boolean entered_all_values = true;
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter domain_name");
            add_domain_query.domain_name = scan.nextLine();
            if (add_domain_query.equals("null")) {
                entered_all_values = false;
            }
            if (entered_all_values) {
                break;
            } else {
                System.out.println("Enter all mandatory fields.");
            }
        }
        return add_domain_query;
    }

    public static AddPublisherAttributes readAddPublisherAttributes() {
        AddPublisherAttributes add_publisher_query = new AddPublisherAttributes();
        while (true) {
            boolean entered_all_values = true;
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter publisher_name");
            add_publisher_query.publisher_name = scan.nextLine();
            if (add_publisher_query.equals("null")) {
                entered_all_values = false;
            }
            if (entered_all_values) {
                break;
            } else {
                System.out.println("Enter all mandatory fields.");
            }
        }
        return add_publisher_query;
    }*/

    /*public static AddSubjectAttributes readAddSubjectAttributes() {
        AddSubjectAttributes add_subject_query = new AddSubjectAttributes();
        while (true) {
            boolean entered_all_values = true;
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter subject_name, semester, academic_year, exam_pattern, domain_id, subject_abbreviation");
            add_subject_query.subject_name = scan.nextLine();
            if (add_subject_query.equals("null")) {
                entered_all_values = false;
            }

            add_subject_query.semester = scan.next();
            if (add_subject_query.semester.equals("null")) {
                entered_all_values = false;
            }

            add_subject_query.academic_year = scan.next();
            if (add_subject_query.academic_year.equals("null")) {
                entered_all_values = false;
            }

            add_subject_query.exam_pattern = scan.next();
            if (add_subject_query.exam_pattern.equals("null")) {
                entered_all_values = false;
            }

            add_subject_query.domain_id = scan.nextInt();
            if (add_subject_query.domain_id == 0) {
                entered_all_values = false;
            }

            add_subject_query.subject_abbreviation = scan.next();
            if (add_subject_query.subject_abbreviation.equals("null")) {
                entered_all_values = false;
            }
            if (entered_all_values) {
                break;
            } else {
                System.out.println("Enter all mandatory fields.");
            }
        }
        return add_subject_query;
    }*/

    /*public static UserSearchAttributes readUserSearchAttributes() {
        UserSearchAttributes user_search_query = new UserSearchAttributes();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter username,email,mobile_no");
        user_search_query.username = scan.next();
        if (!user_search_query.username.equals("null")) {
            user_search_query.username = "%" + user_search_query.username + "%";
        } else {
            user_search_query.username = "%";
        }
        user_search_query.email = scan.next();
        if (!user_search_query.email.equals("null")) {
            user_search_query.email = "%" + user_search_query.email + "%";
        } else {
            user_search_query.email = "%";
        }
        user_search_query.mobile_no = scan.next();
        if (!user_search_query.mobile_no.equals("null")) {
            user_search_query.mobile_no = "%" + user_search_query.mobile_no + "%";
        } else {
            user_search_query.mobile_no = "%";
        }
        return user_search_query;
    }*/

    /*static public BookIssueAttributes readBookIssueAttributes() {
        BookIssueAttributes book_issue_query = new BookIssueAttributes();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter username, book_id");
        book_issue_query.username = scan.next();
        book_issue_query.book_id = scan.next();
        return book_issue_query;
    }*/

   /* static public boolean verifyUser(UserProfileQueryResult userProfile) {
        System.out.println("Entered username is not verified, please verify student details !");
        Output.displayUserProfile(userProfile);
        System.out.println("VerifyUser(1,0)");
        Scanner scan = new Scanner(System.in);
        int should_verify = scan.nextInt();
        if (should_verify == 1) {
            return true;
        } else {
            return false;
        }
    }*/

    /*static public UserProfileRequestAttribute readUserProfileRequestAttribute() {
        System.out.println("Enter username");
        Scanner scan = new Scanner(System.in);
        UserProfileRequestAttribute user_profile_query = new UserProfileRequestAttribute();
        user_profile_query.username = scan.next();
        return user_profile_query;
    }*/

    /*static public void readBookReturnQuery() throws IOException, ClassNotFoundException {
        UserProfileRequestAttribute user_profile_query = Input.readUserProfileRequestAttribute();
        boolean has_pending_record = Output.displayPendingBooksRecord(user_profile_query);
        if (has_pending_record) {
            BookReturnAttributes book_return_query = new BookReturnAttributes();
            book_return_query.username = user_profile_query.username;
            System.out.println("Enter book_id to be return /renew: ");
            Scanner scan = new Scanner(System.in);
            book_return_query.book_id = scan.nextInt();
            System.out.println("shouldChargeFine(1/0) :");
            int is_fine = scan.nextInt();
            if (is_fine == 1) {
                book_return_query.is_fine = true;
            } else {
                book_return_query.is_fine = false;
            }
            ServerRequests.returnBook(book_return_query);
        } else {
            Output.writeRequsetResult("No book found to return !");
        }
    }*/

  /*  public static void readReportReturnQuery() throws IOException, ClassNotFoundException {
        UserProfileRequestAttribute user_profile_query = Input.readUserProfileRequestAttribute();
        boolean has_pending_record = Output.displayPendingReportRecord(user_profile_query);
        if (has_pending_record) {
            ReportReturnAttributes report_return_query = new ReportReturnAttributes();
            report_return_query.username = user_profile_query.username;
            System.out.println("Enter report_id to be return : ");
            Scanner scan = new Scanner(System.in);
            report_return_query.report_id = scan.nextInt();
            ServerRequests.returnReport(report_return_query);
        } else {
            Output.writeRequsetResult("No report found to return !");
        }
    }

    static public void readBookRenewQuery() throws IOException, ClassNotFoundException {
        UserProfileRequestAttribute user_profile_query = Input.readUserProfileRequestAttribute();
        boolean has_pending_record = Output.displayPendingBooksRecord(user_profile_query);
        if (has_pending_record) {
            BookReturnAttributes book_return_query = new BookReturnAttributes();
            book_return_query.username = user_profile_query.username;
            System.out.println("Enter book_id to be return /renew: ");
            Scanner scan = new Scanner(System.in);
            book_return_query.book_id = scan.nextInt();
            System.out.println("shouldChargeFine(1/0) :");
            int is_fine = scan.nextInt();
            if (is_fine == 1) {
                book_return_query.is_fine = true;
            } else {
                book_return_query.is_fine = false;
            }
            ServerRequests.returnBook(book_return_query);
        } else {
            Output.writeRequsetResult("No book found to renew !");
        }
    }*/

   /* public static String readPasswordForSecureVerification(String message, String username) {
        System.out.println(message);
        System.out.println("Enter password for " + username);
        Scanner scan = new Scanner(System.in);
        String password = scan.next();
        StringBuilder reverse = new StringBuilder();
        reverse.append(password);
        password = reverse.reverse().toString();
        return password;
    }*/
}
