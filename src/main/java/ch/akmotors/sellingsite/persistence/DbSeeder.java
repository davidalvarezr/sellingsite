package ch.akmotors.sellingsite.persistence;

import ch.akmotors.sellingsite.model.db.Ad;
import ch.akmotors.sellingsite.model.db.Bike;
import ch.akmotors.sellingsite.model.db.Car;
import ch.akmotors.sellingsite.model.db.TwoWheelers;
import ch.akmotors.sellingsite.model.db.enummerate.FuelType;
import ch.akmotors.sellingsite.model.db.enummerate.GearBoxType;
import ch.akmotors.sellingsite.model.db.enummerate.VehicleState;
import ch.akmotors.sellingsite.model.db.enummerate.VehicleType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

// @Service // <-- comment this to prevent the seed
public class DbSeeder implements CommandLineRunner {

    private AdRepository adRepository;

    public DbSeeder(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.adRepository.deleteAll();

        Collection<Ad> adCollectionSample = createAdCollectionSample();
        this.adRepository.insert(adCollectionSample);
    }



    private Collection<Ad> createAdCollectionSample() throws Exception {
        Ad ad1 = new Ad(
                "1",
                "Mercedes AMG",
                "Description of Mercedes AMG",
                14900,
                new String[]{"1-1.jpg", "1-2.jpg"},
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


        return Arrays.asList(new Ad[]{ad1, ad2, ad3, ad4});
    }
}
