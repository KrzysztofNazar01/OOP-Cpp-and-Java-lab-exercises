package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy;

import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Atrakcja;

public class CmentarzZIWojny extends Atrakcja {
    private double czasZwiedzania = 0.333;
    private String miejscowosc;

    public CmentarzZIWojny(String nazwa) {
        super(nazwa);
        this.miejscowosc = nazwa;
    }

    @Override
    public String getNazwa() {
        return "CmentarzZIWojny w " + miejscowosc;
    }

    @Override
    public double getWymaganyCzas() {
        return czasZwiedzania;
    }
}
