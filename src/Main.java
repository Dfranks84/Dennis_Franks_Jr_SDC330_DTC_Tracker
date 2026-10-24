
/************************************************************
 * Name: Dennis Franks Jr.
 * Date: October 24, 2026
 * Assignment: SDC330 Week 3 Course Project -
 * Class Implementation
 *
 * Description: Main entry point for the Vehicle Diagnostic
 * Trouble Code Tracker application.
 ************************************************************/

public class Main {

    public static void main(String[] args) {

        System.out.println("Dennis Franks Jr.");
        System.out.println("SDC330 Week 3 Course Project");
        System.out.println("Vehicle Diagnostic Trouble Code Tracker");

        DatabaseManager db = DatabaseManager.getInstance(
                "jdbc:sqlite:diagnostics.db");

        DiagnosticTracker tracker = new DiagnosticTracker(db);

        tracker.displayMenu();
    }
}
