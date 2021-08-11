package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Atrakcja;

public class MistrzPanoram extends Czlowiek{

    public MistrzPanoram(String imie, String nazwisko, Plec plec) {
        super(imie, nazwisko, plec, 5.0);
    }

    @Override
    public int getUmiejetnosciNawigacyjne() {
        return 4;
    }


    @Override
    public void reagujNaAtrakcje(Atrakcja a, double czas) {
        regeneruj(czas);
        mow("Hmm, atrakcja: "+a.getNazwa());
    }
}
