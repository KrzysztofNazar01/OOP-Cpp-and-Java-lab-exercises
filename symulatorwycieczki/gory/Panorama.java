package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory;

import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Atrakcja;

public class Panorama extends Atrakcja {
    private double czasZwiedzania = 0.5;

    public Panorama(String nazwa) {
        super(nazwa);
    }

    @Override
    public String getNazwa() {
        return "Panorama";
    }

    @Override
    public double getWymaganyCzas() {
        return czasZwiedzania;
    }
}

