package ch.akmotors.sellingsite.model.db;

import ch.akmotors.sellingsite.model.db.enummerate.VehicleState;
import ch.akmotors.sellingsite.model.db.enummerate.VehicleType;

public class Bike {
    private VehicleType vehicleType;    // BIKE | E_BIKE
    private VehicleState vehicleState;  // Etat du véhicule
    private String brand;               // Marque
    private String model;               // Modèle
    private int year;                   // Année
    private boolean isElectric;

    private int gearsNumber;            // nombre de vitesses
    private int traysNumber;            // nombre de plateaux

    public Bike(VehicleType vehicleType, VehicleState vehicleState, String brand, String model, int year, boolean isElectric, int gearsNumber, int traysNumber) throws Exception {
        setVehicleType(vehicleType);
        this.vehicleState = vehicleState;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.isElectric = isElectric;
        this.gearsNumber = gearsNumber;
        this.traysNumber = traysNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public VehicleState getVehicleState() {
        return vehicleState;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public int getGearsNumber() {
        return gearsNumber;
    }

    public int getTraysNumber() {
        return traysNumber;
    }

    public void setVehicleType(VehicleType vehicleType) throws Exception {
        if (vehicleType != VehicleType.BIKE && vehicleType != VehicleType.E_BIKE)
            throw new Exception("Vehicle type of two wheelers must either be BIKE or E_BIKE");

        this.vehicleType = vehicleType;
    }
}
