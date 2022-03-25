package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name="musiicInstruments")

public class MusicInstrument {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String instrument;
    private int howMuch;

    public MusicInstrument() {
    }

    public MusicInstrument( String instrument, int howMuch) {
        this.instrument = instrument;
        this.howMuch = howMuch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public int getHowMuch() {
        return howMuch;
    }

    public void setHowMuch(int howMuch) {
        this.howMuch = howMuch;
    }

    @Override
    public String toString() {
        return "MusicInstrument{" +
                "id=" + id +
                ", instrument='" + instrument + '\'' +
                ", howMuch=" + howMuch +
                '}';
    }
}
