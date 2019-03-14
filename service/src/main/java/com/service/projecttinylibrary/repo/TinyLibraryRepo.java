package com.service.projecttinylibrary.repo;

import com.service.projecttinylibrary.entity.TinyLibrary;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TinyLibraryRepo extends MongoRepository<TinyLibrary, ObjectId> {
    List<TinyLibrary> findByNameIgnoreCase(String name);

    List<TinyLibrary> findByNameIgnoreCaseContains(String nameHas);

    List<TinyLibrary> findByBooksTypeIgnoreCase(String type);

    List<TinyLibrary> findByBooksTitleIgnoreCase(String title);

    List<TinyLibrary> findByBooksTitleIgnoreCaseContains(String titleHas);

    List<TinyLibrary> findByBooksSummaryIgnoreCaseContains(String summaryHas);
}
