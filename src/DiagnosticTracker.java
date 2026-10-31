
/************************************************************
 * Name: Dennis Franks Jr.
 * Date: October 31, 2026
 * Assignment: SDC330 Week 4 Course Project -
 * Database Implementation
 *
 * Description: Manages vehicles and diagnostic records,
 * implements Searchable, and provides the terminal menu
 * with SQLite database support.
 ************************************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiagnosticTracker implements Searchable {

    private List<Vehicle> vehicles;
    private DatabaseManager databaseManager;
    private Scanner scanner;

    public DiagnosticTracker(DatabaseManager db) {
        vehicles = new ArrayList<>();
        databaseManager = db;
        scanner = new Scanner(System.in);
        loadVehicles();
    }

    private void loadVehicles() {
        vehicles.clear();
        vehicles.addAll(databaseManager.getAllVehicles());

        for (Vehicle vehicle : vehicles) {
            for (TroubleCodeRecord record :
                    databaseManager.getRecordsByVehicle(
                            vehicle.getVehicleId())) {
                vehicle.addRecord(record);
            }
        }
    }

    public void addVehicle(Vehicle vehicle) {
        databaseManager.saveVehicle(vehicle);
        loadVehicles();
    }

    public void addRecord(int vehicleId, TroubleCodeRecord record) {
        Vehicle vehicle = findVehicle(vehicleId);

        if (vehicle != null) {
            databaseManager.saveRecord(record);
            loadVehicles();
        }
    }

    private Vehicle findVehicle(int vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId() == vehicleId) {
                return vehicle;
            }
        }
        return null;
    }

    private TroubleCodeRecord findRecord(int recordId) {
        for (Vehicle vehicle : vehicles) {
            for (DiagnosticRecord record : vehicle.getRecords()) {
                if (record.getRecordId() == recordId) {
                    return (TroubleCodeRecord) record;
                }
            }
        }
        return null;
    }

    @Override
    public List<DiagnosticRecord> searchRecords(String query) {
        List<DiagnosticRecord> results = new ArrayList<>();

        for (TroubleCodeRecord record :
                databaseManager.findRecords(query)) {
            results.add(record);
        }

        return results;
    }

    public void updateRecord(TroubleCodeRecord record) {
        if (findRecord(record.getRecordId()) != null) {
            databaseManager.updateRecord(record);
            loadVehicles();
        }
    }

    public void deleteRecord(int recordId) {
        databaseManager.deleteRecord(recordId);
        loadVehicles();
    }

    private String readText(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private int readNumber(String message) {
        while (true) {
            try {
                return Integer.parseInt(readText(message).trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private void enterVehicle() {
        System.out.println("\n--- Add Vehicle ---");

        int id = readNumber("Vehicle ID: ");

        if (findVehicle(id) != null) {
            System.out.println("Vehicle ID already exists.");
            return;
        }

        int year = readNumber("Year: ");
        String make = readText("Make: ");
        String model = readText("Model: ");
        String vin = readText("VIN or Identifier: ");

        Vehicle vehicle = new Vehicle(id, year, make, model, vin);
        addVehicle(vehicle);

        System.out.println("Vehicle added successfully.");
    }

    private void enterRecord() {
        System.out.println("\n--- Add Diagnostic Record ---");

        int vehicleId = readNumber("Vehicle ID: ");

        if (findVehicle(vehicleId) == null) {
            System.out.println("Vehicle not found. Add it first.");
            return;
        }

        int recordId = readNumber("Record ID: ");

        if (findRecord(recordId) != null) {
            System.out.println("Record ID already exists.");
            return;
        }

        String code = readText("Trouble Code: ");
        String description = readText("Code Description: ");
        String symptoms = readText("Symptoms: ");
        String causes = readText("Possible Causes: ");
        String tests = readText("Diagnostic Tests/Results: ");
        String notes = readText("Resolution Notes: ");
        String date = readText("Date (YYYY-MM-DD): ");

        TroubleCodeRecord record = new TroubleCodeRecord(
                recordId, vehicleId, date, symptoms,
                causes, tests, notes, code, description);

        addRecord(vehicleId, record);

        System.out.println("Diagnostic record added successfully.");
    }

    private void viewRecords() {
        System.out.println("\n--- Vehicle Diagnostic History ---");

        loadVehicles();

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles have been added.");
            return;
        }

        for (Vehicle vehicle : vehicles) {
            System.out.println("\n" + vehicle);

            if (vehicle.getRecords().isEmpty()) {
                System.out.println("No diagnostic records.");
            }

            for (DiagnosticRecord record : vehicle.getRecords()) {
                System.out.println("\n" + record);
            }
        }
    }

    private void searchMenu() {
        String query = readText(
                "\nEnter trouble code or description: ");

        List<DiagnosticRecord> results = searchRecords(query);

        if (results.isEmpty()) {
            System.out.println("No matching records found.");
        } else {
            for (DiagnosticRecord record : results) {
                System.out.println("\n" + record);
            }
        }
    }

    private void editRecord() {
        int id = readNumber("\nEnter Record ID to update: ");
        TroubleCodeRecord record = findRecord(id);

        if (record == null) {
            System.out.println("Record not found.");
            return;
        }

        System.out.println("\nCurrent Record:");
        System.out.println(record);

        String code = readText("New Trouble Code: ");
        String description = readText("New Description: ");
        String symptoms = readText("New Symptoms: ");
        String causes = readText("New Possible Causes: ");
        String tests = readText("New Test Results: ");
        String notes = readText("New Resolution Notes: ");
        String date = readText("New Date (YYYY-MM-DD): ");

        TroubleCodeRecord updated = new TroubleCodeRecord(
                id, record.getVehicleId(), date,
                symptoms, causes, tests, notes,
                code, description);

        updateRecord(updated);

        System.out.println("Record updated successfully.");
    }

    private void removeRecord() {
        int id = readNumber("\nEnter Record ID to delete: ");

        if (findRecord(id) == null) {
            System.out.println("Record not found.");
            return;
        }

        deleteRecord(id);
        System.out.println("Record deleted successfully.");
    }

    public void displayMenu() {
        int choice;

        do {
            System.out.println("\n================================");
            System.out.println(" Vehicle Diagnostic DTC Tracker");
            System.out.println("================================");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Add Diagnostic Record");
            System.out.println("3. View Vehicle Records");
            System.out.println("4. Search Diagnostic Records");
            System.out.println("5. Update Diagnostic Record");
            System.out.println("6. Delete Diagnostic Record");
            System.out.println("7. Exit");

            choice = readNumber("Enter your choice: ");

            switch (choice) {
                case 1:
                    enterVehicle();
                    break;
                case 2:
                    enterRecord();
                    break;
                case 3:
                    viewRecords();
                    break;
                case 4:
                    searchMenu();
                    break;
                case 5:
                    editRecord();
                    break;
                case 6:
                    removeRecord();
                    break;
                case 7:
                    System.out.println("Exiting DTC Tracker.");
                    break;
                default:
                    System.out.println("Invalid menu selection.");
            }

        } while (choice != 7);
    }
}
