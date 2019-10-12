package ch.akmotors.sellingsite.api.pub;

import ch.akmotors.sellingsite.model.db.Ad;
import ch.akmotors.sellingsite.persistence.AdRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

// TODO: TEST THIS CLASS
@RestController
@CrossOrigin
@RequestMapping("${public.endpoint}/ads")
public class PublicAdController implements IPublicAdController {

    private AdRepository adRepository;

    public PublicAdController(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @GetMapping("all")
    @Override
    public Collection<Ad> all() {
        return this.adRepository.findAll();
    }

    @GetMapping("{id}")
    @Override
    public Ad byId(@PathVariable String id) {
        return this.adRepository.findById(id).orElse(null);
    }

    @GetMapping("all/byPriceAsc")
    @Override
    public Collection<Ad> allByPriceAsc() {
        Sort sortByPriceAsc = Sort.by("price").ascending();
        return this.adRepository.findAll(sortByPriceAsc);
    }

    @GetMapping("all/byPriceDesc")
    @Override
    public Collection<Ad> allByPriceDesc() {
        Sort sortByPriceDesc = Sort.by("price").descending();
        return this.adRepository.findAll(sortByPriceDesc);
    }

    @GetMapping("all/byDateAsc")
    @Override
    public Collection<Ad> allByDateAsc() {
        Sort sortByDateAsc = Sort.by("publicationDate").ascending();
        return this.adRepository.findAll(sortByDateAsc);
    }

    @GetMapping("all/byDateDesc")
    @Override
    public Collection<Ad> allByDateDesc() {
        Sort sortByDateDesc = Sort.by("publicationDate").descending();
        return this.adRepository.findAll(sortByDateDesc);
    }

    @GetMapping("fullTextSearch/{text}")
    @Override
    public Collection<Ad> fullTextSearch(@PathVariable String text) {
        TextCriteria textCriteria = TextCriteria.forDefaultLanguage().matching(text);
        return this.adRepository.findAllBy(textCriteria);
    }
}
