package com.jd.cdtheque.repositories;

import com.jd.cdtheque.domain.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long> {
}
