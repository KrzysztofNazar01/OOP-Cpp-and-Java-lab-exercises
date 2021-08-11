package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki;

import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie.BeskidzkiPiechur;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie.MistrzPanoram;

import java.util.*;
/**
 *
 * @author TB
 */
public class SymulatorWycieczki {
    
    private final Grupa grupa;
    private final Wycieczka wycieczka;
    private int pozycjaGrupy = 0;
    private double czasWycieczki = 0.0;
    private double pokonanyDystans = 0.0;

    public SymulatorWycieczki(Grupa grupa, Wycieczka wycieczka) {
        this.grupa = grupa;
        this.wycieczka = wycieczka;
    }
    
    public void symuluj() {
        System.out.println("===Symulator Wycieczki===");
        System.out.println();
        System.out.println("Na wycieczkę idzie następująca grupa: ");
        for(Uczestnik u : grupa.getUczestnicy()) {
            System.out.println(u);
        }
        System.out.println();
        System.out.println("Przedownikiem jest "+grupa.getPrzewodnik());
        System.out.println();
        System.out.println("Przewodnik opowie teraz grupie o wycieczce");
        
        grupa.getPrzewodnik().opiszWycieczke(wycieczka);
        
        System.out.println();
        System.out.println("Grupa wyruszyła!");
        System.out.println();
        
        for(pozycjaGrupy = 0; pozycjaGrupy < wycieczka.getLiczbaElementowWycieczki(); pozycjaGrupy++) {
            ElementWycieczki elementWycieczki = wycieczka.getElementWycieczki(pozycjaGrupy);
            
            if(elementWycieczki instanceof Wedrowka) {
                Wedrowka wedrowka = (Wedrowka) elementWycieczki;
                
                System.out.println("Grupa wędruje po terenie: "+wedrowka.getNazwa());
                
                double predkoscGrupy = grupa.getPredkosc();
                predkoscGrupy = wedrowka.modyfikujPredkoscGrupy(predkoscGrupy);
                int brakiNawigacyjne = wedrowka.getTrudnoscNawigacyjna() - grupa.getPrzewodnik().getUmiejetnosciNawigacyjne();
                if(brakiNawigacyjne < 0)
                    brakiNawigacyjne = 0;
                
                if(brakiNawigacyjne > 0) {
                    System.out.println("Przewodnik nieco się pogubił.");
                    double kara = brakiNawigacyjne/5.0;
                    predkoscGrupy = (1.0 - kara) * predkoscGrupy;
                }
                
                if(predkoscGrupy <= Double.MIN_VALUE) {
                    System.out.println("Grupa nie jest w stanie iść dalej. Będzie nocowała w tym miejscu.");
                    break;
                }
                
                System.out.println("Grupa porusza się z prędkością "+predkoscGrupy+" GOT/h");
                
                double czas = wedrowka.getOdleglosc()/predkoscGrupy;
                
                for(Uczestnik u : grupa.getUczestnicy()) {
                        u.reagujNaWedrowke(wedrowka, czas);
                }
                
                System.out.println("Wędrówka zajęła grupie " + czas + " h");
                czasWycieczki += czas;
                pokonanyDystans += wedrowka.getOdleglosc();
            }

            if(elementWycieczki instanceof Atrakcja) {
                Atrakcja atrakcja = (Atrakcja) elementWycieczki;

                System.out.println("Grupa jest w atrakcji: "+atrakcja.getNazwa());

                double czas = atrakcja.getWymaganyCzas();

                for(Uczestnik u : grupa.getUczestnicy()) {
                    if(u instanceof MistrzPanoram && atrakcja.getNazwa().equals("Panorama"))
                        u.reagujNaAtrakcje(atrakcja, 2*czas);
                    else if(u instanceof BeskidzkiPiechur && atrakcja.getNazwa().equals("Drewniana Cerkiew"))
                        u.reagujNaAtrakcje(atrakcja, 2*czas);
                    else

                    u.reagujNaAtrakcje(atrakcja, czas);
                }

                System.out.println("Atrakcja zajęła grupie " + czas + " h");
                czasWycieczki += czas;
            }

            for(SluchaczPostepow s : kolekcjaSluchaczPostepow)
                s.aktualizujPostep(elementWycieczki, pozycjaGrupy+1 , wycieczka.getLiczbaElementowWycieczki());

            System.out.println();
           
        }
        System.out.printf("Trasa zajęła grupie %.2f h, przeszli oni %.2f GOT.\n", czasWycieczki, pokonanyDystans);
        System.out.println("===Koniec symulacji===");
    }

    private Set<SluchaczPostepow> kolekcjaSluchaczPostepow = new HashSet<>();

    private class klasaWewnetrzna implements SluchaczPostepow{
        @Override
        public void aktualizujPostep(ElementWycieczki elementWycieczki, int lp, int liczbaElementow){
            if(lp == liczbaElementow){
                System.out.println("Koniec wycieczki.");
            }
            else if(lp == liczbaElementow - 1){
                System.out.println("Teraz jest: " + elementWycieczki.getNazwa() + ", został tylko jeden element wycieczki" );
            }
            else{
                System.out.println("Teraz jest: " + elementWycieczki.getNazwa() + ", zostało " + (liczbaElementow - lp) + " elementów wycieczki.");
            }
        }
    }

    public void setListaSluchaczy(Set<SluchaczPostepow> kolekcjaSluchaczPostepow){
        this.kolekcjaSluchaczPostepow = kolekcjaSluchaczPostepow;
    }

    public SluchaczPostepow klasaWewnetrzna(){
        return new klasaWewnetrzna();
    }
    
}
