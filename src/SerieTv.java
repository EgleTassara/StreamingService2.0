import java.util.HashSet;

public class SerieTv extends Prodotto{

    private int numStagioni;
    private int epStagione;

    public SerieTv(String titolo, int anno, HashSet<String> cast, Genere genere, boolean pg, boolean originale, int numStagioni, int epStagione) {
        super(titolo, anno, cast, genere, pg, originale);
        this.numStagioni = numStagioni;
        this.epStagione = epStagione;
    }

    public int getNumStagioni() {
        return numStagioni;
    }
    public int getEpStagione() {
        return epStagione;
    }

    public void setNumStagioni(int numStagioni) {
        this.numStagioni = numStagioni;
    }
}
