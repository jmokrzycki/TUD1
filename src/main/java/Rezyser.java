/**
 * Created by Jadwiga on 2015-11-01.
 */
public class Rezyser {
    private long id;

    private String imie;
    private String nazwisko;

    public Rezyser() {
    }

    public Rezyser(String imie, String nazwisko) {
        super();
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String tytul) {
        this.imie = imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String rok_premiery) {
        this.nazwisko = nazwisko;
    }
}
