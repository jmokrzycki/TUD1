/**
 * Created by Jadwiga on 2015-11-01.
 */
    public class Film {
        private long id;

        private String tytul;
        private String rok_premiery;

        public Film() {
        }

        public Film(String tytul, String rok_premiery) {
            super();
            this.tytul = tytul;
            this.rok_premiery = rok_premiery;
        }
        public long getId() {
            return id;
        }
        public void setId(long id) {
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
    }
