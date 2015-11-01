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

// @Test //nie potrzebna funkcja
// public void checkAdding2(){
//
//     Film film = new Film(IMIE_1, ROK_1, FK_REZYSER_1);
//
//     filmManager.clearFilm();
//     assertEquals(1, filmManager.addFilm2(film));
//
//     List<Film> filmy = filmManager.getAllFilm();
//     Film filmRetrieved = filmy.get(0);
//
//     assertEquals(IMIE_1, filmRetrieved.getTytul());
//     assertEquals(ROK_1, filmRetrieved.getRok_premiery());
//
// }

  @Test
  public void checkaddRezyserToFilm(){
      //filmManager.clearFilm();

      List<Film> filmy = filmManager.getAllFilm();
      List<Rezyser> rezyserzy = rezyserManager.getAllRezyser();

      Film film = filmy.get(0);
      Rezyser rezyser = rezyserzy.get(0);

      film.setId_rezyser(rezyser.getId());

      assertEquals(1, filmManager.addRezyserToFilm(film));

      Film filmRetrieved = filmy.get(0);

      assertEquals(rezyser.getId(), filmRetrieved.getId_rezyser());
  }
}
