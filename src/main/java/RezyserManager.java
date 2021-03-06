import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RezyserManager {
    private Connection connection;

    private String url = "jdbc:hsqldb:hsql://localhost/workdb";

    private String createTableFilm = "CREATE TABLE Rezyser(id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, imie varchar(20), nazwisko varchar(20))";

    private PreparedStatement addRezyserStmt;
    private PreparedStatement deleteAllRezyserStmt;
    private PreparedStatement getAllRezyserStmt;

    private Statement statement;

    public RezyserManager() {
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();

            ResultSet rs = connection.getMetaData().getTables(null, null, null,
                    null);
            boolean tableExists = false;
            while (rs.next()) {
                if ("Rezyser".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
                    tableExists = true;
                    break;
                }
            }

            if (!tableExists)
                statement.executeUpdate(createTableFilm);

            addRezyserStmt = connection
                    .prepareStatement("INSERT INTO Rezyser (imie, nazwisko) VALUES (?, ?)");
            deleteAllRezyserStmt = connection
                    .prepareStatement("DELETE FROM Rezyser");
            getAllRezyserStmt = connection
                    .prepareStatement("SELECT id, imie,nazwisko FROM Rezyser");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Connection getConnection() {
        return connection;
    }

    void clearRezyser() {
        try {
            deleteAllRezyserStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int addRezyser(Rezyser rezyser) {
        int count = 0;
        try {
            addRezyserStmt.setString(1, rezyser.getImie());
            addRezyserStmt.setString(2, rezyser.getNazwisko());

            count = addRezyserStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Rezyser> getAllRezyser() {
        List<Rezyser> rezyserzy = new ArrayList<Rezyser>();

        try {
            ResultSet rs = getAllRezyserStmt.executeQuery();

            while (rs.next()) {
                Rezyser r = new Rezyser();
                r.setId(rs.getInt("id"));
                r.setImie(rs.getString("imie"));
                r.setNazwisko(rs.getString("nazwisko"));
                rezyserzy.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rezyserzy;
    }

}
