package com.jd.cdtheque.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Track {
    private String title;

    @ManyToOne
    private Album album;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Track() {
    }

    public Track(String title, Album album) {
        this.title = title;
        this.album = album;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Track{" +
                "title='" + title + '\'' +
                ", album=" + album +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        return Objects.equals(id, track.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
