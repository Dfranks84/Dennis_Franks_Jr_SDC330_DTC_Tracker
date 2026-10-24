
/************************************************************
 * Name: Dennis Franks Jr.
 * Date: October 24, 2026
 * Assignment: SDC330 Week 3 Course Project -
 * Class Implementation
 *
 * Description: Concrete diagnostic record containing
 * a trouble code, description, and troubleshooting details.
 ************************************************************/

public class TroubleCodeRecord extends DiagnosticRecord {

    private String troubleCode;
    private String codeDescription;

    public TroubleCodeRecord(int recordId, int vehicleId,
            String dateRecorded, String symptoms,
            String possibleCauses, String testResults,
            String resolutionNotes, String troubleCode,
            String codeDescription) {

        super(recordId, vehicleId, dateRecorded, symptoms,
                possibleCauses, testResults, resolutionNotes);

        this.troubleCode = troubleCode;
        this.codeDescription = codeDescription;
    }

    public String getTroubleCode() {
        return troubleCode;
    }

    public void setTroubleCode(String troubleCode) {
        this.troubleCode = troubleCode;
    }

    public String getCodeDescription() {
        return codeDescription;
    }

    public void setCodeDescription(String codeDescription) {
        this.codeDescription = codeDescription;
    }

    @Override
    public String toString() {
        return "Record ID: " + getRecordId()
                + "\nVehicle ID: " + getVehicleId()
                + "\nTrouble Code: " + troubleCode
                + "\nDescription: " + codeDescription
                + "\nDate: " + getDateRecorded()
                + "\nSymptoms: " + getSymptoms()
                + "\nPossible Causes: " + getPossibleCauses()
                + "\nTest Results: " + getTestResults()
                + "\nResolution Notes: " + getResolutionNotes();
    }
}
