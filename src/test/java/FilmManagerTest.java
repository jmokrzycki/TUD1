import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class FilmManagerTest {


    FilmManager filmManager = new FilmManager();

    RezyserManager rezyserManager = new RezyserManager();

    private final static String TYTUL_1 = "Bond";
    private final static String PREMIERA_1 = "2000";
    private final static String IMIE_REZYSER_1 = "Zenek";
    private final static String NAZWISKO_REZYSER_1 = "Kowalski";

    @Test
    public void checkConnection() {
        assertNotNull(filmManager.getConnection());
    }

    @Test
    public void checkAdding() {
        Film film = new Film(TYTUL_1, PREMIERA_1);

        filmManager.clearFilm();
        assertEquals(1, filmManager.addFilm(film));

        List<Film> filmy = filmManager.getAllFilm();
        Film filmRetrieved = filmy.get(0);

        assertEquals(TYTUL_1, filmRetrieved.getTytul());
        assertEquals(PREMIERA_1, filmRetrieved.getRok_premiery());
    }

//@Test //dodatkowa funkcja do testow
//public void checkAdding2(){

//    Film film = new Film(TYTUL_1, PREMIERA_1, FK_REZYSER_1);

//    filmManager.clearFilm();
//    assertEquals(1, filmManager.addFilmWithRezyser(film));

//    List<Film> filmy = filmManager.getAllFilm();
//    Film filmRetrieved = filmy.get(0);

//    assertEquals(TYTUL_1, filmRetrieved.getTytul());
//    assertEquals(PREMIERA_1, filmRetrieved.getRok_premiery());

//}

    @Test
    public void checkAddRezyserToFilm() {
        filmManager.clearFilm();
        rezyserManager.clearRezyser();
        Rezyser rezyser = new Rezyser(IMIE_REZYSER_1, NAZWISKO_REZYSER_1);
        rezyserManager.addRezyser(rezyser);
        filmManager.addFilm(new Film(TYTUL_1, PREMIERA_1));


        List<Film> filmy = filmManager.getAllFilm();
        List<Rezyser> rezyserzy = rezyserManager.getAllRezyser();
        Film film = new Film(filmy.get(0).getTytul(), filmy.get(0).getRok_premiery(), rezyserzy.get(0).getId());
        film.setId(filmy.get(0).getId());
        filmManager.addRezyserToFilm(film);


        List<Film> filmy1 = filmManager.getAllFilm();
        Film film1 = filmy1.get(0);
        List<Rezyser> rezyserzy1 = rezyserManager.getAllRezyser();
        Rezyser rezyser1 = rezyserzy1.get(0);
        assertEquals(rezyser1.getId(), film1.getId_rezyser());
    }

    @Test
    public void checkRemoveRezyserFromFilm() {
        filmManager.clearFilm();
        rezyserManager.clearRezyser();
        rezyserManager.addRezyser(new Rezyser(IMIE_REZYSER_1, NAZWISKO_REZYSER_1));
        List<Rezyser> rezyserzy = rezyserManager.getAllRezyser();
        Film film = new Film(TYTUL_1, PREMIERA_1, rezyserzy.get(0).getId());
        filmManager.addFilmWithRezyser(film);

        filmManager.removeRezyserFromFilm(filmManager.getAllFilm().get(0));

        List<Film> filmy = filmManager.getAllFilm();
        Film filmRetrieved = filmy.get(0);
        assertEquals(0, filmRetrieved.getId_rezyser());
    }

    @Test
    public void checkGetAllRezyserInFilm() {
        filmManager.clearFilm();
        rezyserManager.clearRezyser();
        rezyserManager.addRezyser(new Rezyser(IMIE_REZYSER_1, NAZWISKO_REZYSER_1));
        rezyserManager.addRezyser(new Rezyser(IMIE_REZYSER_1, NAZWISKO_REZYSER_1));
        List<Rezyser> rezyserzy = rezyserManager.getAllRezyser();
        filmManager.addFilmWithRezyser(new Film(TYTUL_1, PREMIERA_1, rezyserzy.get(0).getId()));
        filmManager.addFilmWithRezyser(new Film(TYTUL_1, PREMIERA_1, rezyserzy.get(1).getId()));
        filmManager.addFilm(new Film(TYTUL_1, PREMIERA_1));

        assertEquals(2, this.filmManager.getAllRezyserInFilm());
    }
}