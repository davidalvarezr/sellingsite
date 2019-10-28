package ch.akmotors.sellingsite.api;

import ch.akmotors.sellingsite.model.db.Ad;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IAdController {
    String insert(Ad ad);
    void update(Ad ad);
    void delete(String id);
    void softDelete(String id);
}
