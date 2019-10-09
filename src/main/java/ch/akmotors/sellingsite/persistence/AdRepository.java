package ch.akmotors.sellingsite.persistence;

import ch.akmotors.sellingsite.model.db.Ad;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AdRepository extends MongoRepository<Ad, String>, QuerydslPredicateExecutor<Ad> {
    Collection<Ad> findAllBy(TextCriteria textCriteria);
}
