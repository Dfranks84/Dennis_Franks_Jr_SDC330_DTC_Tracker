
/************************************************************
 * Name: Dennis Franks Jr.
 * Date: October 31, 2026
 * Assignment: SDC330 Week 4 Course Project -
 * Database Implementation
 *
 * Description: Singleton database manager that connects
 * to SQLite and performs CRUD operations for vehicles
 * and diagnostic trouble code records.
 ************************************************************/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static DatabaseManager instance;
    private String databaseUrl;

    private DatabaseManager(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public static DatabaseManager getInstance(String databaseUrl) {
        if (instance == null) {
            instance = new DatabaseManager(databaseUrl);
        }
        return instance;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    private Connection connect() throws SQLException {
        Connection conn = DriverManager.getConnection(databaseUrl);

        try (Statement stmt = conn.createStatement()) {
            stmt.execute("PRAGMA foreign_keys = ON");
        } catch (SQLException e) {
            conn.close();
            throw e;
        }

        return conn;
    }

    public void createTables() {
        String vehiclesSql =
                "CREATE TABLE IF NOT EXISTS Vehicles ("
                + "vehicle_id INTEGER PRIMARY KEY, "
                + "year INTEGER NOT NULL, "
                + "make TEXT NOT NULL, "
                + "model TEXT NOT NULL, "
                + "vin TEXT)";

        String recordsSql =
                "CREATE TABLE IF NOT EXISTS DiagnosticRecords ("
                + "record_id INTEGER PRIMARY KEY, "
                + "vehicle_id INTEGER NOT NULL, "
                + "trouble_code TEXT NOT NULL, "
                + "code_description TEXT, "
                + "symptoms TEXT, "
                + "possible_causes TEXT, "
                + "test_results TEXT, "
                + "resolution_notes TEXT, "
                + "date_recorded TEXT, "
                + "FOREIGN KEY(vehicle_id) "
                + "REFERENCES Vehicles(vehicle_id))";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(vehiclesSql);
            stmt.execute(recordsSql);

            System.out.println("Database tables ready.");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public void saveVehicle(Vehicle vehicle) {
        String sql =
                "INSERT INTO Vehicles "
                + "(vehicle_id, year, make, model, vin) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, vehicle.getVehicleId());
            pst.setInt(2, vehicle.getYear());
            pst.setString(3, vehicle.getMake());
            pst.setString(4, vehicle.getModel());
            pst.setString(5, vehicle.getVin());

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Save vehicle error: " + e.getMessage());
        }
    }

    public void saveRecord(TroubleCodeRecord record) {
        String sql =
                "INSERT INTO DiagnosticRecords "
                + "(record_id, vehicle_id, trouble_code, "
                + "code_description, symptoms, possible_causes, "
                + "test_results, resolution_notes, date_recorded) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, record.getRecordId());
            pst.setInt(2, record.getVehicleId());
            pst.setString(3, record.getTroubleCode());
            pst.setString(4, record.getCodeDescription());
            pst.setString(5, record.getSymptoms());
            pst.setString(6, record.getPossibleCauses());
            pst.setString(7, record.getTestResults());
            pst.setString(8, record.getResolutionNotes());
            pst.setString(9, record.getDateRecorded());

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Save record error: " + e.getMessage());
        }
    }

    public List<TroubleCodeRecord> findRecords(String query) {
        List<TroubleCodeRecord> records = new ArrayList<>();

        String sql =
                "SELECT * FROM DiagnosticRecords "
                + "WHERE trouble_code LIKE ? "
                + "OR code_description LIKE ?";

        try (Connection conn = connect();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, "%" + query + "%");
            pst.setString(2, "%" + query + "%");

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    TroubleCodeRecord record = new TroubleCodeRecord(
                            rs.getInt("record_id"),
                            rs.getInt("vehicle_id"),
                            rs.getString("date_recorded"),
                            rs.getString("symptoms"),
                            rs.getString("possible_causes"),
                            rs.getString("test_results"),
                            rs.getString("resolution_notes"),
                            rs.getString("trouble_code"),
                            rs.getString("code_description")
                    );

                    records.add(record);
                }
            }

        } catch (SQLException e) {
            System.out.println("Search error: " + e.getMessage());
        }

        return records;
    }

    public void updateRecord(TroubleCodeRecord record) {
        String sql =
                "UPDATE DiagnosticRecords SET "
                + "trouble_code = ?, "
                + "code_description = ?, "
                + "symptoms = ?, "
                + "possible_causes = ?, "
                + "test_results = ?, "
                + "resolution_notes = ?, "
                + "date_recorded = ? "
                + "WHERE record_id = ?";

        try (Connection conn = connect();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, record.getTroubleCode());
            pst.setString(2, record.getCodeDescription());
            pst.setString(3, record.getSymptoms());
            pst.setString(4, record.getPossibleCauses());
            pst.setString(5, record.getTestResults());
            pst.setString(6, record.getResolutionNotes());
            pst.setString(7, record.getDateRecorded());
            pst.setInt(8, record.getRecordId());

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Update error: " + e.getMessage());
        }
    }

    public void deleteRecord(int recordId) {
        String sql =
                "DELETE FROM DiagnosticRecords WHERE record_id = ?";

        try (Connection conn = connect();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, recordId);
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Delete error: " + e.getMessage());
        }
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        String sql = "SELECT * FROM Vehicles";

        try (Connection conn = connect();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Vehicle vehicle = new Vehicle(
                        rs.getInt("vehicle_id"),
                        rs.getInt("year"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getString("vin")
                );

                vehicles.add(vehicle);
            }

        } catch (SQLException e) {
            System.out.println("Load vehicles error: " + e.getMessage());
        }

        return vehicles;
    }

    public List<TroubleCodeRecord> getRecordsByVehicle(int vehicleId) {
        List<TroubleCodeRecord> records = new ArrayList<>();

        String sql =
                "SELECT * FROM DiagnosticRecords WHERE vehicle_id = ?";

        try (Connection conn = connect();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, vehicleId);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    TroubleCodeRecord record = new TroubleCodeRecord(
                            rs.getInt("record_id"),
                            rs.getInt("vehicle_id"),
                            rs.getString("date_recorded"),
                            rs.getString("symptoms"),
                            rs.getString("possible_causes"),
                            rs.getString("test_results"),
                            rs.getString("resolution_notes"),
                            rs.getString("trouble_code"),
                            rs.getString("code_description")
                    );

                    records.add(record);
                }
            }

        } catch (SQLException e) {
            System.out.println("Load records error: " + e.getMessage());
        }

        return records;
    }
}
