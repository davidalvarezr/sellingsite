package ch.akmotors.sellingsite.api.pub;

import ch.akmotors.sellingsite.model.db.Ad;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

public interface IPublicAdController {
    Collection<Ad> all();

    @GetMapping("notDeleted")
    Collection<Ad> allNotDeleted();

    @GetMapping("deleted")
    Collection<Ad> allDeleted();

    Ad byId(String id);
    Collection<Ad> allByPriceAsc();
    Collection<Ad> allByPriceDesc();
    Collection<Ad> allByDateAsc();
    Collection<Ad> allByDateDesc();
    Collection<Ad> fullTextSearch(String text);
}
