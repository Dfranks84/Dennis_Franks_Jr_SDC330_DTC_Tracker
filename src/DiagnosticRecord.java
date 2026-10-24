
/************************************************************
 * Name: Dennis Franks Jr.
 * Date: October 24, 2026
 * Assignment: SDC330 Week 3 Course Project -
 * Class Implementation
 *
 * Description: Abstract superclass containing common
 * diagnostic information for vehicle troubleshooting.
 ************************************************************/

public abstract class DiagnosticRecord {

    private int recordId;
    private int vehicleId;
    private String dateRecorded;
    private String symptoms;
    private String possibleCauses;
    private String testResults;
    private String resolutionNotes;

    public DiagnosticRecord(int recordId, int vehicleId,
            String dateRecorded, String symptoms,
            String possibleCauses, String testResults,
            String resolutionNotes) {

        this.recordId = recordId;
        this.vehicleId = vehicleId;
        this.dateRecorded = dateRecorded;
        this.symptoms = symptoms;
        this.possibleCauses = possibleCauses;
        this.testResults = testResults;
        this.resolutionNotes = resolutionNotes;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(String dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getPossibleCauses() {
        return possibleCauses;
    }

    public void setPossibleCauses(String possibleCauses) {
        this.possibleCauses = possibleCauses;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }

    public String getResolutionNotes() {
        return resolutionNotes;
    }

    public void setResolutionNotes(String resolutionNotes) {
        this.resolutionNotes = resolutionNotes;
    }

    @Override
    public abstract String toString();
}
