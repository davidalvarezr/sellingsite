package ch.akmotors.sellingsite.api;

import ch.akmotors.sellingsite.model.db.Ad;
import ch.akmotors.sellingsite.persistence.AdRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

// TODO: TEST THIS CLASS
@RestController
@RequestMapping("${endpoint}/ads")
public class AdController implements IAdController {
    private AdRepository adRepository;

    public AdController(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @PostMapping
    @Override
    public void insert(@RequestBody Ad ad) {
        ad.setPublicationDate(new Date());
        this.adRepository.insert(ad);
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
}
