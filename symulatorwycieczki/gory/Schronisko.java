package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Atrakcja;

public class Schronisko extends Atrakcja{
    private double czasZwiedzania = 0.75;

    public Schronisko(String nazwa) {
        super(nazwa);
    }

    @Override
    public String getNazwa() {
        return "Schronisko";
    }

    @Override
    public double getWymaganyCzas() {
        return czasZwiedzania;
    }
}
