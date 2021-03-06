package ch.akmotors.sellingsite.service;

import ch.akmotors.sellingsite.model.db.Ad;
import ch.akmotors.sellingsite.model.db.Bike;
import ch.akmotors.sellingsite.model.db.Car;
import ch.akmotors.sellingsite.model.db.TwoWheelers;
import ch.akmotors.sellingsite.model.db.enummerate.FuelType;
import ch.akmotors.sellingsite.model.db.enummerate.GearBoxType;
import ch.akmotors.sellingsite.model.db.enummerate.VehicleState;
import ch.akmotors.sellingsite.model.db.enummerate.VehicleType;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class SeederService {

    public Collection<Ad> createAdCollectionSample() throws Exception {
        /*Ad ad1 = new Ad(
                "1",
                "Mercedes AMG",
                "Description of Mercedes AMG",
                14900,
                new String[]{"1-1.jpg", "1-2.jpg"},
                 false,
                new Car(
                        VehicleType.CAR,
                        "Mercedes",
                        "AMG",
                        2005,
                        VehicleState.USED,
                        false,
                        39000,
                        GearBoxType.MANUAL,
                        FuelType.PETROL,
                        400,
                        2),
                null,
                null);

        Ad ad2 = new Ad(
                "2",
                "Yamaha R6 2017",
                "Description of Yamaha R6 2017",
                9000,
                new String[]{"2-1.jpg", "2-2.jpg"},
                 false,
                null,
                new TwoWheelers(
                        VehicleType.MOTORBIKE,
                        "Yamaha",
                        "R6",
                        2017,
                        VehicleState.USED,
                        false,
                        14000,
                        GearBoxType.AUTO,
                        FuelType.PETROL,
                        156,
                        600
                ),
                null);

        Ad ad3 = new Ad(
                "3",
                "Peugeot SpeedFight 3",
                "Description of Peugeot SpeedFight 3",
                1700,
                new String[]{"3-1.jpg", "3-2.jpg"},
               false,
                null,
                new TwoWheelers(
                        VehicleType.SCOOTER,
                        "Peugeot",
                        "SpeedFight 3",
                        2011,
                        VehicleState.USED,
                        false,
                        9000,
                        GearBoxType.AUTO,
                        FuelType.PETROL,
                        42,
                        50
                ),
                null
        );

        Ad ad4 = new Ad(
                "4",
                "Cool VTT",
                "Description of Cool VTT",
                1190,
                new String[]{"3-1.jpg", "3-2.jpg"},
                false,
                null,
                null,
                new Bike(
                        VehicleType.BIKE,
                        VehicleState.USED,
                        "SuperBike",
                        "VTT X_TREM",
                        2015,
                        false,
                        7,
                        3
                )
        );


        return Arrays.asList(new Ad[]{ad1, ad2, ad3, ad4});*/
        return Arrays.asList();
    }

    /**
     *
     * @return A Mercedes USED car with ID 102
     * @throws Exception
     */
    public Ad getAd1() throws Exception {
        /*return new Ad(
                "102",
                "Mercedes AMG",
                "Description of Mercedes AMG",
                14900,
                new String[]{"1-1.jpg", "1-2.jpg"},
               false,
                new Car(
                        VehicleType.CAR,
                        "Mercedes",
                        "AMG",
                        2005,
                        VehicleState.USED,
                        false,
                        39000,
                        GearBoxType.MANUAL,
                        FuelType.PETROL,
                        400,
                        2),
                null,
                null);*/
        return null;
    }

    /**
     *
     * @return A Mercedes NEW car with ID 102
     * @throws Exception
     */
    public Ad getAd1updated() throws Exception {
        /*return new Ad(
                "102",
                "Mercedes AMG",
                "Description of Mercedes AMG",
                14900,
                new String[]{"1-1.jpg", "1-2.jpg"},
                 false,
                new Car(
                        VehicleType.CAR,
                        "Mercedes",
                        "AMG that is finally new",
                        2005,
                        VehicleState.NEW,
                        false,
                        39000,
                        GearBoxType.MANUAL,
                        FuelType.PETROL,
                        400,
                        2),
                null,
                null);*/
        return null;
    }

}
