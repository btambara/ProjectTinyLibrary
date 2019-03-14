package com.service.projecttinylibrary.repo;

import com.service.projecttinylibrary.entity.TinyLibrary;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TinyLibraryRepo extends MongoRepository<TinyLibrary, ObjectId> {
    List<TinyLibrary> findByName(String name);
}
