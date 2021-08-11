package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy;


import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Atrakcja;

public class DrewnianaCerkiew extends Atrakcja {
    private double czasZwiedzania = 0.5;

    public DrewnianaCerkiew(String nazwa) {
        super(nazwa);
    }

    @Override
    public String getNazwa() {
        return "Drewniana Cerkiew";
    }

    @Override
    public double getWymaganyCzas() {
        return czasZwiedzania;
    }


}
