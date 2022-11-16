package com.jd.cdtheque.repositories;

import com.jd.cdtheque.domain.Track;
import org.springframework.data.repository.CrudRepository;

public interface TrackRepository extends CrudRepository<Track, Long> {
}
