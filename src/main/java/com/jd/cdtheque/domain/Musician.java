package com.jd.cdtheque.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Musician {
    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(name = "album_musician", joinColumns = @JoinColumn(name = "musician_id"), inverseJoinColumns = @JoinColumn(name = "album_id"))
    private Set<Album> albums = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Musician() {
    }

    public Musician(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Musician(String firstName, String lastName, Set<Album> albums) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.albums = albums;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "Musician{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", albums=" + albums +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Musician musician = (Musician) o;

        return Objects.equals(id, musician.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
