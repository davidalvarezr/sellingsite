package ch.akmotors.sellingsite.persistence;

import ch.akmotors.sellingsite.model.db.Ad;
import ch.akmotors.sellingsite.model.db.Bike;
import ch.akmotors.sellingsite.model.db.Car;
import ch.akmotors.sellingsite.model.db.TwoWheelers;
import ch.akmotors.sellingsite.model.db.enummerate.FuelType;
import ch.akmotors.sellingsite.model.db.enummerate.GearBoxType;
import ch.akmotors.sellingsite.model.db.enummerate.VehicleState;
import ch.akmotors.sellingsite.model.db.enummerate.VehicleType;
import ch.akmotors.sellingsite.service.SeederService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

// @Service // <-- comment this to prevent the seed
public class DbSeeder implements CommandLineRunner {

    private AdRepository adRepository;
    private SeederService seederService;

    public DbSeeder(AdRepository adRepository, SeederService seederService) {
        this.adRepository = adRepository;
        this.seederService = seederService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.adRepository.deleteAll();

        Collection<Ad> adCollectionSample = this.seederService.createAdCollectionSample();
        this.adRepository.insert(adCollectionSample);
    }
}
