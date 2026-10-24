
/************************************************************
 * Name: Dennis Franks Jr.
 * Date: October 24, 2026
 * Assignment: SDC330 Week 3 Course Project -
 * Class Implementation
 *
 * Description: Singleton database manager framework.
 * SQLite JDBC operations will be implemented in Week 4.
 ************************************************************/

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

    // Database methods will be completed in Week 4.

    public void createTables() {
        // Week 4: Create SQLite tables.
    }

    public void saveVehicle(Vehicle vehicle) {
        // Week 4: Save vehicle to SQLite.
    }

    public void saveRecord(TroubleCodeRecord record) {
        // Week 4: Save diagnostic record to SQLite.
    }

    public List<TroubleCodeRecord> findRecords(String query) {
        // Week 4: Search the SQLite database.
        return new ArrayList<>();
    }

    public void updateRecord(TroubleCodeRecord record) {
        // Week 4: Update the SQLite record.
    }

    public void deleteRecord(int recordId) {
        // Week 4: Delete the SQLite record.
    }
}
