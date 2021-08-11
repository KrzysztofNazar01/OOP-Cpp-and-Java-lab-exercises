package pl.edu.pg.eti.ksg.po.lab2;

import java.util.HashSet;
import java.util.Set;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Grupa;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.SymulatorWycieczki;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Uczestnik;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Wycieczka;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.Droga;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.GestyLas;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.Las;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.Panorama;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.Schronisko;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy.CmentarzZIWojny;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy.DrewnianaCerkiew;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie.Czlowiek;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie.PrzewodnikStudencki;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie.Student;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie.PrzewodnikBeskidzki;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie.MistrzPanoram;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie.CzlowiekZKontuzja;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie.BeskidzkiPiechur;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie.StudentKSG;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.SluchaczPostepow;
/**
 *
 * @author TB
 */
public class JavaLab2 {
    public static void main(String[] args) {

        Wycieczka w = mojaWycieczka();
        
        PrzewodnikBeskidzki przewodnik = new PrzewodnikBeskidzki("Stefan", "Długonogi", Czlowiek.Plec.MEZCZYZNA);
        Set<Uczestnik> uczestnicy = new HashSet<>();
        uczestnicy.add(new PrzewodnikBeskidzki("AlojzyPrzewodnikBesk", "Mechanik", Czlowiek.Plec.MEZCZYZNA));
        uczestnicy.add(new CzlowiekZKontuzja("AdaZKontuzja", "Lovelace", Czlowiek.Plec.KOBIETA));
        uczestnicy.add(new BeskidzkiPiechur("JanBeskidzkiPiech", "Elektronik", Czlowiek.Plec.MEZCZYZNA));
        uczestnicy.add(new StudentKSG("PiotrKSG","Kowalski", Czlowiek.Plec.MEZCZYZNA));
        uczestnicy.add(new MistrzPanoram("Panoramiarz","Nowak", Czlowiek.Plec.MEZCZYZNA));
        uczestnicy.add(new Student("SzymonStudent","Stary", Czlowiek.Plec.MEZCZYZNA));
        Grupa g = new Grupa(przewodnik, uczestnicy);


        SymulatorWycieczki symulator = new SymulatorWycieczki(g, w);

        Set<SluchaczPostepow> listaSluchaczy = new HashSet<>();
        listaSluchaczy.add(symulator.klasaWewnetrzna());
        symulator.setListaSluchaczy(listaSluchaczy);

        symulator.symuluj();
    }
    
    public static Wycieczka doDydiowki() {
        Wycieczka ret = new Wycieczka("Do Dydiówki");
        ret.dodajElementWycieczki(new Droga(1.0));
        ret.dodajElementWycieczki(new DrewnianaCerkiew("Smolnik"));
        ret.dodajElementWycieczki(new Droga(4.0));
//        ret.dodajElementWycieczki(new PrzeprawaPrzezRzeke(1.0));
//        ret.dodajElementWycieczki(new GestyLas(2.0));
        ret.dodajElementWycieczki(new Las(2.0));
        ret.dodajElementWycieczki(new Droga(5.0));
        
        return ret;
    }

    public static Wycieczka mojaWycieczka() {
        Wycieczka ret = new Wycieczka("--MOJA WYCIECZKA--");
        ret.dodajElementWycieczki(new GestyLas(1.0));
        ret.dodajElementWycieczki(new Las(3.0));
        ret.dodajElementWycieczki(new Panorama("Potoki"));
        ret.dodajElementWycieczki(new Droga(4.0));
        ret.dodajElementWycieczki(new Schronisko("PTTK"));
        ret.dodajElementWycieczki(new Droga(4.0));
        ret.dodajElementWycieczki(new DrewnianaCerkiew("Drewniana Cerkiwe w Smolniku"));
        ret.dodajElementWycieczki(new Las(2.0));
        ret.dodajElementWycieczki(new CmentarzZIWojny("Cmentarz z I Wojny w Beskidach"));
        ret.dodajElementWycieczki(new Droga(10.0));
        ret.dodajElementWycieczki(new Panorama("Góry"));
        return ret;
    }
   
}
