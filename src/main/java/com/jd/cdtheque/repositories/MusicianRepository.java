package com.jd.cdtheque.repositories;

import com.jd.cdtheque.domain.Musician;
import org.springframework.data.repository.CrudRepository;

public interface MusicianRepository extends CrudRepository<Musician, Long> {
}
