package ch.akmotors.sellingsite.model.db;

import ch.akmotors.sellingsite.model.db.enummerate.FuelType;
import ch.akmotors.sellingsite.model.db.enummerate.GearBoxType;
import ch.akmotors.sellingsite.model.db.enummerate.VehicleState;
import ch.akmotors.sellingsite.model.db.enummerate.VehicleType;

public class TwoWheelers {
    private VehicleType vehicleType;    // MOTORBIKE | SCOOTER
    private String brand;               // Marque
    private String model;               // Modèle
    private int year;                   // Année
    private VehicleState vehicleState;  // Etat du véhicule
    private boolean isElectric;

    private int kms;                    // Kilométrage
    private GearBoxType gearBoxType;    // Boîte de vitesse
    private FuelType fuelType;          // Type de carburant -- (ELECTRIC included)
    private int powerCV;                // Unit: "chevaux"
    private int cylinderCM3;            // Unit: cm^3

    public TwoWheelers(
            VehicleType vehicleType,
            String brand,
            String model,
            int year,
            VehicleState vehicleState,
            boolean isElectric,
            int kms,
            GearBoxType gearBoxType,
            FuelType fuelType,
            int powerCV,
            int cylinderCM3) throws Exception {
        setVehicleType(vehicleType);
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.vehicleState = vehicleState;
        this.isElectric = isElectric;
        this.kms = kms;
        this.gearBoxType = gearBoxType;
        this.fuelType = fuelType;
        this.powerCV = powerCV;
        this.cylinderCM3 = cylinderCM3;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
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

    public VehicleState getVehicleState() {
        return vehicleState;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public int getKms() {
        return kms;
    }

    public GearBoxType getGearBoxType() {
        return gearBoxType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public int getPowerCV() {
        return powerCV;
    }

    public int getCylinderCM3() {
        return cylinderCM3;
    }

    public void setVehicleType(VehicleType vehicleType) throws Exception {
        if (vehicleType != VehicleType.MOTORBIKE && vehicleType != VehicleType.SCOOTER)
            throw new Exception("Vehicle type of two wheelers must either be MOTORBIKE or SCOOTER");

        this.vehicleType = vehicleType;
    }
}
