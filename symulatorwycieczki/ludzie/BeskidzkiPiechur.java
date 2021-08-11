package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Atrakcja;

public class BeskidzkiPiechur extends Czlowiek{

    public BeskidzkiPiechur(String imie, String nazwisko, Plec plec) {
        super(imie, nazwisko, plec, 6.0, 20.0,20.0);
    }

    @Override
    public int getUmiejetnosciNawigacyjne() {
        return 5;
    }


    @Override
    public void reagujNaAtrakcje(Atrakcja a, double czas) {
        regeneruj(czas);
        mow("Hmm, atrakcja: "+a.getNazwa());
    }
}
