package ch.akmotors.sellingsite.api;

import ch.akmotors.sellingsite.model.db.Ad;
import ch.akmotors.sellingsite.persistence.AdRepository;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

// TODO: TEST THIS CLASS
@RestController
@CrossOrigin
@RequestMapping("${endpoint}/ads")
public class AdController implements IAdController {
    private AdRepository adRepository;

    public AdController(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @PostMapping
    @RequestMapping(produces = "text/plain")
    @Override
    public String insert(@RequestBody Ad ad) {
        ad.setPublicationDate(new Date());
        Ad insertedAd = this.adRepository.save(ad);
        String insertedId = insertedAd.getId();

        // Insert all image names : <AdId>-<imageNo> (image no begin at 1)
        for (int i = 0; i < insertedAd.getImageNb(); i++) {
            insertedAd.setImages(
                    ArrayUtils.addAll(
                            insertedAd.getImages(),
                            insertedId + "-" + (i+1)
                    )
            );
        }

        this.adRepository.save(ad); // update

        return insertedId;
    }


    /**
     * /!\ If id given does not exist, will create a new ad
     * @param ad
     */
    @PutMapping
    @Override
    public void update(@RequestBody Ad ad) {
        this.adRepository.save(ad);
    }

    @DeleteMapping("{id}")
    @Override
    public void delete(@PathVariable String id) {
        this.adRepository.deleteById(id);
    }

    @DeleteMapping("softDelete/{id}")
    @Override
    public void softDelete(@PathVariable String id) {
        Ad ad = this.adRepository.findById(id).orElse(null);
        if (ad != null) {
            ad.setDeleted(true);
            this.adRepository.save(ad);
        }
    }
}
