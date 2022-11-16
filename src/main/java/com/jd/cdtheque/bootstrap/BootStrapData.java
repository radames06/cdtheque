package com.jd.cdtheque.bootstrap;

import com.jd.cdtheque.domain.Album;
import com.jd.cdtheque.domain.Musician;
import com.jd.cdtheque.domain.Track;
import com.jd.cdtheque.repositories.AlbumRepository;
import com.jd.cdtheque.repositories.MusicianRepository;
import com.jd.cdtheque.repositories.TrackRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AlbumRepository albumRepository;
    private final TrackRepository trackRepository;
    private final MusicianRepository musicianRepository;

    public BootStrapData(AlbumRepository albumRepository, TrackRepository trackRepository, MusicianRepository musicianRepository) {
        this.albumRepository = albumRepository;
        this.trackRepository = trackRepository;
        this.musicianRepository = musicianRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Musician milesDavis = new Musician("Miles", "Davis");
        Musician johnColtrane = new Musician("John", "Coltrane");

        Album sevenSteps = new Album("Seven Steps");
        Album kindOfBlue = new Album("Kind of Blue");

        Track step1 = new Track("Step 1", sevenSteps);
        Track step2 = new Track("Step 2", sevenSteps);
        Track allBlues = new Track("All Blues", kindOfBlue);

        johnColtrane.getAlbums().add(sevenSteps);
        sevenSteps.getMusicians().add(johnColtrane);
        sevenSteps.getTracks().add(step1);
        sevenSteps.getTracks().add(step2);
        milesDavis.getAlbums().add(kindOfBlue);
        kindOfBlue.getMusicians().add(milesDavis);
        kindOfBlue.getTracks().add(allBlues);

        albumRepository.save(sevenSteps);
        albumRepository.save(kindOfBlue);
        musicianRepository.save(milesDavis);
        musicianRepository.save(johnColtrane);
        trackRepository.save(step1);
        trackRepository.save(step2);
        trackRepository.save(allBlues);


        System.out.println("Number of Musicians : " + musicianRepository.count());
        System.out.println("Number of Albums : " + albumRepository.count());
        System.out.println("Number of Tracks : " + trackRepository.count());
    }
}
