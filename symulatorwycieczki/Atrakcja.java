package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki;

public abstract class Atrakcja implements ElementWycieczki {
    private final String nazwa;
    private final double czas;

    public Atrakcja(String nazwa, double czas) {
        this.nazwa = nazwa;
        this.czas = czas;
    }

    public double getWymaganyCzas(){
        return czas;
    };

    public String getNazwa() {
        return nazwa;
    }

}
