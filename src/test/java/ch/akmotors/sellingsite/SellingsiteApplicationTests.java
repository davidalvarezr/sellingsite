package ch.akmotors.sellingsite;

import ch.akmotors.sellingsite.model.db.Ad;
import ch.akmotors.sellingsite.model.db.Car;
import ch.akmotors.sellingsite.model.db.enummerate.FuelType;
import ch.akmotors.sellingsite.model.db.enummerate.GearBoxType;
import ch.akmotors.sellingsite.model.db.enummerate.VehicleState;
import ch.akmotors.sellingsite.model.db.enummerate.VehicleType;
import ch.akmotors.sellingsite.persistence.AdRepository;
import ch.akmotors.sellingsite.service.SeederService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;

// Remember, only test method you wrote yourself. No need to test sort because I didn't implement it
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellingsiteApplicationTests {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private SeederService seederService;

    @Before
    public void before() throws Exception {
        /*this.adRepository.deleteAll();
        Collection<Ad> adCollectionSample = seederService.createAdCollectionSample();
        this.adRepository.insert(adCollectionSample);*/
    }

    @Test(expected = Exception.class)
    public void create_ad_car_with_vehicletype_not_car_should_throw_exception() throws Exception {
        /*Ad ad1 = new Ad(
                "101",
                "Mercedes AMG",
                "Description of Mercedes AMG",
                14900,
                new String[]{"1-1.jpg", "1-2.jpg"},
                 false,
                new Car(
                        VehicleType.SCOOTER,
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
    }

    @Test
    public void insert_update_delete_one_ad_everything_should_work() throws Exception {
        /*int sizeBeforeAdd = seederService.createAdCollectionSample().size();
        Ad ad1 = this.seederService.getAd1();
        this.adRepository.insert(ad1);
        Collection<Ad> allAds = this.adRepository.findAll();
        Assert.isTrue(
                allAds.size() == (sizeBeforeAdd+1),
                "There should be " + (sizeBeforeAdd+1) + " elements, but there is " + allAds.size());

        Ad ad1Fetched = this.adRepository.findById("102").orElse(null);
        Assert.isTrue(ad1Fetched.getTitle().equals("Mercedes AMG"), "Title should be 'Mercedes AMG', but it is " + ad1Fetched.getTitle());

        Ad ad1Updated = this.seederService.getAd1updated();
        this.adRepository.save(ad1Updated);
        ad1Fetched = this.adRepository.findById("102").orElse(null);
        Assert.isTrue(
                ad1Fetched.getCar().getModel().equals("AMG that is finally new")
                    && ad1Fetched.getCar().getVehicleState() == VehicleState.NEW,
                "Update should have changed the Mercedes AMG to a NEW one");

        this.adRepository.deleteById("102");
        Assert.isTrue(this.adRepository.findAll().size() == seederService.createAdCollectionSample().size(),
                "Mercedes should have been deleted");

        Assert.isTrue(
                this.adRepository.findById("102").orElse(null) == null,
                "Ad with ID 102 should return null because it should have been deleted"
        );*/
    }

    @Test
    public void full_text_search_should_find_yamaha_r6() {
        /*TextCriteria textCriteria = TextCriteria.forDefaultLanguage().matching("r6");
        ArrayList<Ad> shouldContainYamahaR6 = (ArrayList<Ad>) this.adRepository.findAllBy(textCriteria);
        Assert.isTrue(
                shouldContainYamahaR6.get(0).getTitle().equals("Yamaha R6 2017"),
                "r6 Should find 'Yamaha R6 2017' ad, but is " + shouldContainYamahaR6.get(0).getTitle());*/
    }
}
