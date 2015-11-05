import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class RezyserManagerTest {


    RezyserManager rezyserManager = new RezyserManager();

    private final static String IMIE_1 = "Zenek";
    private final static String NAZWISKO_1 = "Kowalski";

    @Test
    public void checkConnection() {
        assertNotNull(rezyserManager.getConnection());
    }

    @Test
    public void checkAdding() {
        rezyserManager.clearRezyser();

        Rezyser rezyser = new Rezyser(IMIE_1, NAZWISKO_1);

        assertEquals(1, rezyserManager.addRezyser(rezyser));

        List<Rezyser> rezyserzy = rezyserManager.getAllRezyser();
        Rezyser rezyserRetrieved = rezyserzy.get(0);

        assertEquals(IMIE_1, rezyserRetrieved.getImie());
        assertEquals(NAZWISKO_1, rezyserRetrieved.getNazwisko());
    }
}
