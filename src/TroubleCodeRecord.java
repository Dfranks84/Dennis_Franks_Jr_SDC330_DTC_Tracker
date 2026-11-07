
/************************************************************
 * Name: Dennis Franks Jr.
 * Date: November 7, 2026
 * Assignment: SDC330 Week 5 Course Project -
 * Final Implementation
 *
 * Description: Concrete diagnostic record containing
 * a trouble code, description, and troubleshooting details.
 * Implements the Searchable interface.
 ************************************************************/

import java.util.List;
import java.util.ArrayList;

public class TroubleCodeRecord extends DiagnosticRecord
        implements Searchable {

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
    public List<DiagnosticRecord> searchRecords(String query) {
        List<DiagnosticRecord> results = new ArrayList<>();

        if (query != null) {
            String searchText = query.toLowerCase();

            if (troubleCode.toLowerCase().contains(searchText)
                    || codeDescription.toLowerCase().contains(searchText)) {
                results.add(this);
            }
        }

        return results;
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
