package ch.akmotors.sellingsite.api;

import ch.akmotors.sellingsite.model.db.Ad;

import java.util.Collection;

public interface IAdController {
    void insert(Ad ad);
    void update(Ad ad);
    void delete(String id);
}
