
/************************************************************
 * Name: Dennis Franks Jr.
 * Date: October 24, 2026
 * Assignment: SDC330 Week 3 Course Project -
 * Class Implementation
 *
 * Description: Vehicle class containing vehicle details
 * and a collection of associated diagnostic records.
 ************************************************************/

import java.util.ArrayList;
import java.util.List;

public class Vehicle {

    private int vehicleId;
    private int year;
    private String make;
    private String model;
    private String vin;
    private List<DiagnosticRecord> records;

    public Vehicle(int vehicleId, int year, String make,
            String model, String vin) {

        this.vehicleId = vehicleId;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vin = vin;
        records = new ArrayList<>();
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void addRecord(DiagnosticRecord record) {
        records.add(record);
    }

    public List<DiagnosticRecord> getRecords() {
        return records;
    }

    @Override
    public String toString() {
        return "Vehicle ID: " + vehicleId
                + "\nYear: " + year
                + "\nMake: " + make
                + "\nModel: " + model
                + "\nVIN: " + vin;
    }
}
