package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki;

public abstract class Atrakcja implements ElementWycieczki {
    private String nazwa;

    public Atrakcja(String nazwa) {
        this.nazwa = nazwa;
    }

    public abstract double getWymaganyCzas();

    public String getNazwa() {
        return nazwa;
    }

}
