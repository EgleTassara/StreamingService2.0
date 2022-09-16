import java.util.HashMap;
import java.util.HashSet;

public abstract class Prodotto {

    //Final perchè non cambierà nel tempo

    private final String titolo;
    private final  int anno;
    //Se mettissimo anche il regista converrebbe una Map
    private final HashSet<String> cast;

    //sarebbe meglio un hashSet di film
    private Genere genere;
    private boolean pg;
    private boolean originale;
    private HashMap<Utente, Integer> votiProdotto = new HashMap<>();

    public Prodotto(String titolo, int anno, HashSet<String> cast, Genere genere, boolean pg, boolean originale) {
        this.titolo = titolo;
        this.anno = anno;
        this.cast = cast;
        this.genere = genere;
        this.pg = pg;
        this.originale = originale;
    }

    public String getTitolo() {
        return titolo;
    }
    public int getAnno() {
        return anno;
    }
    public HashSet<String> getCast() {
        return cast;
    }
    public Genere getGenere() {
        return genere;
    }
    public boolean isPg() {
        return pg;
    }
    public boolean isOriginale() {
        return originale;
    }
    public HashMap<Utente, Integer> getVotiProdotto() {
        return votiProdotto;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }
    public void setPg(boolean pg) {
        this.pg = pg;
    }
    public void setOriginale(boolean originale) {
        this.originale = originale;
    }

    public void addVoto(Utente u, Integer voto) {
        votiProdotto.put(u, voto);
    }

    public double mediaVoto() {
        double somma = 0;
        for (Utente u: votiProdotto.keySet()) {
            somma += votiProdotto.get(u);
        }
        return somma / votiProdotto.keySet().size();
    }

    //Questo metodo ritorna la media voto del prodottto ristretta a un set di utenti
    public double mediaVotoUtenti(HashSet<Utente> utenti) {
        double somma = 0;
        for (Utente u : votiProdotto.keySet()) {
            if(utenti.contains(u)) {
                somma += votiProdotto.get(u);
            }
        }
        return somma / utenti.size();
    }
}
