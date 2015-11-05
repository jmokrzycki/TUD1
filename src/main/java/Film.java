public class Film {
    private int id;

    private String tytul;
    private String rok_premiery;
    private int id_rezyser;

    public Film() {
    }

    public Film(String tytul, String rok_premiery) {
        super();
        this.tytul = tytul;
        this.rok_premiery = rok_premiery;
    }

    public Film(String tytul, String rok_premiery, int id_rezyser) {
        super();
        this.tytul = tytul;
        this.rok_premiery = rok_premiery;
        this.id_rezyser = id_rezyser;
    }

    public Film(int id, int id_rezyser) {
        this.id = id;
        this.id_rezyser = id_rezyser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getRok_premiery() {
        return rok_premiery;
    }

    public void setRok_premiery(String rok_premiery) {
        this.rok_premiery = rok_premiery;
    }

    public int getId_rezyser() {
        return id_rezyser;
    }

    public void setId_rezyser(int id_rezyser) {
        this.id_rezyser = id_rezyser;
    }
}
