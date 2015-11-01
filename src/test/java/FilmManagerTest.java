//package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

//import com.example.jdbcdemo.domain.Person;

public class FilmManagerTest {


    FilmManager filmManager = new FilmManager();

    private final static String IMIE_1 = "Zenek";
    private final static String ROK_1 = "1945";

    private final static int FK_REZYSER_1 = 1;

    @Test
    public void checkConnection(){
        assertNotNull(filmManager.getConnection());
    }

   // @Test
   // public void checkAdding(){
//
   //     Film film = new Film(IMIE_1, ROK_1);
//
   //     filmManager.clearFilm();
   //     assertEquals(1, filmManager.addFilm(film));
//
   //     List<Film> filmy = filmManager.getAllFilm();
   //     Film filmRetrieved = filmy.get(0);
//
   //     assertEquals(IMIE_1, filmRetrieved.getTytul());
   //     assertEquals(ROK_1, filmRetrieved.getRok_premiery());
//
   // }
//
  // @Test
  // public void checkAdding_FK(){
//
  //     Film film = new Film(IMIE_1, ROK_1, FK_REZYSER_1);
//
  //     filmManager.clearFilm();
  //     assertEquals(1, filmManager.addFilm(film));
//
  //     List<Film> filmy = filmManager.getAllFilm();
  //     Film filmRetrieved = filmy.get(0);
//
  //     assertEquals(IMIE_1, filmRetrieved.getTytul());
  //     assertEquals(ROK_1, filmRetrieved.getRok_premiery());
//
  // }

}
