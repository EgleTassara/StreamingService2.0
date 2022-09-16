import java.util.HashSet;

public class Profilo {
    private String email;
    private String password;
    private TipoOfferta offerta;
    private HashSet<Utente> utenti = new HashSet<>();

    public Profilo (String email, String password, TipoOfferta offerta) {
        this.email = email;
        this.password = password;
        this.offerta = offerta;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public TipoOfferta getOfferta() {
        return offerta;
    }
    public HashSet<Utente> getUtenti() {
        return utenti;
    }


    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setOfferta(TipoOfferta offerta) {
        this.offerta = offerta;
    }


    //questo metodo aggiunge un utente al profilo, se vado a modificare un attributo dovrà essere void
    public void addUtenti(Utente u) {
        if(utenti.size() < offerta.getNumUtenti()) {
            utenti.add(u);
        }
        else {
            System.out.println("Non puoi aggiungere questo utente hai raggiunto il limite massimo");
        }
    }

    //Questo metodo rimuove un utente dal profilo
    public void removeUtente(Utente u) {
        if(utenti.contains(u)) {
            utenti.remove(u);
        }
        else {
            System.out.println("Errore utente non presente!");
        }
    }

    //Metodo che svuota l'insieme d'utenti
    public void emptyUtenti() {
        utenti.clear();
    }
}
