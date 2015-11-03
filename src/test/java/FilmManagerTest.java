//package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

//import com.example.jdbcdemo.domain.Person;

public class FilmManagerTest {


    FilmManager filmManager = new FilmManager();

    RezyserManager rezyserManager = new RezyserManager();

    private final static String IMIE_1 = "Zenek";
    private final static String ROK_1 = "1945";

   @Test
   public void checkConnection(){
       assertNotNull(filmManager.getConnection());
   }

@Test
public void checkAdding(){
    Film film = new Film(IMIE_1, ROK_1);

    filmManager.clearFilm();
    assertEquals(1, filmManager.addFilm(film));

    List<Film> filmy = filmManager.getAllFilm();
    Film filmRetrieved = filmy.get(0);

    assertEquals(IMIE_1, filmRetrieved.getTytul());
    assertEquals(ROK_1, filmRetrieved.getRok_premiery());
}

//@Test //dodatkowa funkcja do testow
//public void checkAdding2(){

//    Film film = new Film(IMIE_1, ROK_1, FK_REZYSER_1);

//    filmManager.clearFilm();
//    assertEquals(1, filmManager.addFilmWithRezyser(film));

//    List<Film> filmy = filmManager.getAllFilm();
//    Film filmRetrieved = filmy.get(0);

//    assertEquals(IMIE_1, filmRetrieved.getTytul());
//    assertEquals(ROK_1, filmRetrieved.getRok_premiery());

//}

@Test
public void checkAddRezyserToFilm(){
    filmManager.clearFilm();
    Rezyser rezyser = new Rezyser("Zenek", "1945");
    rezyserManager.addRezyser(rezyser);
    filmManager.addFilm(new Film("Zenek", "1945"));


    List<Film> filmy = filmManager.getAllFilm();
    List<Rezyser> rezyserzy = rezyserManager.getAllRezyser();
    Film film = new Film(filmy.get(0).getTytul(), filmy.get(0).getRok_premiery(), rezyserzy.get(0).getId());
    filmManager.addRezyserToFilm(film);


    List<Film> filmy1 = filmManager.getAllFilm();
    Film film1 = filmy1.get(0);
    List<Rezyser> rezyserzy1 = rezyserManager.getAllRezyser();
    Rezyser rezyser1 = rezyserzy1.get(0);
    assertEquals(rezyser1.getId(), film1.getId_rezyser());
}

   @Test
   public void checkRemoveRezyserFromFilm(){
       filmManager.clearFilm();
       rezyserManager.clearRezyser();
       rezyserManager.addRezyser(new Rezyser("Zenek", "1945"));
       List<Rezyser> rezyserzy = rezyserManager.getAllRezyser();
       Film film = new Film("Zenek", "1945", rezyserzy.get(0).getId());
       filmManager.addFilmWithRezyser(film);

       filmManager.removeRezyserFromFilm(filmManager.getAllFilm().get(0));

       List<Film> filmy = filmManager.getAllFilm();
       Film filmRetrieved = filmy.get(0);
       assertEquals(0, filmRetrieved.getId_rezyser());
   }

    @Test
    public void checkGetAllRezyserInFilm(){
        filmManager.clearFilm();
        rezyserManager.clearRezyser();
        rezyserManager.addRezyser(new Rezyser("Zenek", "Zenek"));
        rezyserManager.addRezyser(new Rezyser("Zenek", "Zenek"));
        List<Rezyser> rezyserzy = rezyserManager.getAllRezyser();
        filmManager.addFilmWithRezyser(new Film("Zenek", "1945", rezyserzy.get(0).getId()));
        filmManager.addFilmWithRezyser(new Film("Zenek", "1945", rezyserzy.get(1).getId()));
        filmManager.addFilm(new Film("Zenek", "1945"));

        assertEquals(2, this.filmManager.getAllRezyserInFilm());
    }
}