
/************************************************************
 * Name: Dennis Franks Jr.
 * Date: October 24, 2026
 * Assignment: SDC330 Week 3 Course Project -
 * Class Implementation
 *
 * Description: Interface defining a method for searching
 * diagnostic records.
 ************************************************************/

import java.util.List;

public interface Searchable {

    List<DiagnosticRecord> searchRecords(String query);
}
