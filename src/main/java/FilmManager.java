import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FilmManager {

    private Connection connection;

    private String url = "jdbc:hsqldb:hsql://localhost/workdb";
//private String createTableFilm = "CREATE TABLE Film(id bigint GENERATED BY DEFAULT AS IDENTITY, tytul varchar(20), rok_premiery varchar(20),bigint idRezyser , FOREIGN KEY (idRezyser) REFERENCES Rezyser(id))
    private String createTableFilm = "CREATE TABLE Film(id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, tytul varchar(20), rok_premiery varchar(20), id_rezyser int, FOREIGN KEY (id_rezyser) REFERENCES Rezyser(id))";
    // private String createTableFilm = "CREATE TABLE Film(id bigint GENERATED BY DEFAULT AS IDENTITY, tytul varchar(20), rok_premiery varchar(20))";

    private PreparedStatement addFilmStmt;
    private PreparedStatement deleteAllFilmStmt;
    private PreparedStatement getAllFilmStmt;

    private PreparedStatement addFilmStmt2;
    private PreparedStatement addRezyserToFilm;

    private Statement statement;
    public FilmManager() {
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();

            ResultSet rs = connection.getMetaData().getTables(null, null, null,
                    null);
            boolean tableExists = false;
            while (rs.next()) {
                if ("Film".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
                    tableExists = true;
                    break;
                }
            }

            if (!tableExists)
                statement.executeUpdate(createTableFilm);

            addFilmStmt = connection
                    .prepareStatement("INSERT INTO Film (tytul, rok_premiery) VALUES (?, ?)");
            deleteAllFilmStmt = connection
                    .prepareStatement("DELETE FROM Film");
            getAllFilmStmt = connection
                    .prepareStatement("SELECT id, tytul, rok_premiery FROM Film");


            addFilmStmt2 = connection
                    .prepareStatement("INSERT INTO Film (tytul, rok_premiery, id_rezyser) VALUES (?, ?, ?)");


            addRezyserToFilm = connection
                    .prepareStatement("UPDATE Film SET id_rezyser = ? WHERE id = ?");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Connection getConnection() {
        return connection;
    }

    void clearFilm() {
        try {
            deleteAllFilmStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int addFilm(Film film) {
        int count = 0;
        try {
            addFilmStmt.setString(1, film.getTytul());
            addFilmStmt.setString(2, film.getRok_premiery());

            count = addFilmStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Film> getAllFilm() {
        List<Film> filmy = new ArrayList<Film>();

        try {
            ResultSet rs = getAllFilmStmt.executeQuery();

            while (rs.next()) {
                Film f = new Film();
                f.setId(rs.getInt("id"));
                f.setTytul(rs.getString("tytul"));
                f.setRok_premiery(rs.getString("rok_premiery"));
                filmy.add(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmy;
    }

  public int addFilm2(Film film) {
      int count = 0;
      try {
          addFilmStmt2.setString(1, film.getTytul());
          addFilmStmt2.setString(2, film.getRok_premiery());
          addFilmStmt2.setInt(3, film.getId_rezyser());

          count = addFilmStmt2.executeUpdate();

      } catch (SQLException e) {
          e.printStackTrace();
      }
      return count;
  }

    public int addRezyserToFilm(Film film) {
        int count = 0;
        try{
            addRezyserToFilm.setInt(1, film.getId_rezyser());
            addRezyserToFilm.setInt(2, film.getId());

            addRezyserToFilm.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

}
