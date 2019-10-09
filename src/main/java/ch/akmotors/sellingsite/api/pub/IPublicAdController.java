package ch.akmotors.sellingsite.api.pub;

import ch.akmotors.sellingsite.model.db.Ad;

import java.util.Collection;

public interface IPublicAdController {
    Collection<Ad> all();
    Ad byId(String id);
    Collection<Ad> allByPriceAsc();
    Collection<Ad> allByPriceDesc();
    Collection<Ad> allByDateAsc();
    Collection<Ad> allByDateDesc();
    Collection<Ad> fullTextSearch(String text);
}
