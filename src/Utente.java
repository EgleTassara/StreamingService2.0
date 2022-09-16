
import java.util.HashMap;
import java.util.HashSet;


public class Utente {
    private String nome;
    private String avatar;
    private boolean isKid;
    private String pin;
    private Profilo profiloUtente;
    private HashSet<Prodotto> miaLista = new HashSet<>();

    public Utente(String nome, String avatar, boolean isKid, String pin, Profilo profilo) {
        this.nome = nome;
        this.avatar = avatar;
        this.isKid = isKid;
        this.pin = pin;
        this.profiloUtente = profiloUtente;
    }

    //Getters
    public String getNome() {
        return nome;
    }
    public String getAvatar() {
        return avatar;
    }
    public boolean isKid() {
        return isKid;
    }
    public String getPin() {
        return pin;
    }
    public HashSet<Prodotto> getMiaLista() {
        return miaLista;
    }
    public Profilo getProfiloUtente() {
        return profiloUtente;
    }

    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public void setKid(boolean kid) {
        isKid = kid;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }

    //Metodo per aggiungere elemento alla mia lista (se possibile) un prodotto
    public void addInLista(Prodotto p) {
        if(profiloUtente.getOfferta() != TipoOfferta.BASIC) {
            miaLista.add(p);
        } else {
            System.out.println("Non puoi avere una lista hai l'abbonamento da poraccio!");
        }
    }

    public void removeFromLista(Prodotto p) {
        if(miaLista.contains(p)) {
            miaLista.remove(p);
        } else {
            System.out.println("Il prodotto non è presente nella tua lista");
        }
    }

    //Questo metodo inserisce un voto da 1 a 5 che l'utente assegna a un prodotto
    public void assegnaVoto(Prodotto p, Integer voto) {
        if(profiloUtente.getOfferta() != TipoOfferta.BASIC) {
            if(voto >= 1 && voto <= 5) {
                p.addVoto(this, voto);
            }
            else {
                System.out.println("Voto non valido!");
            }
        } else {
            System.out.println("Non puoi mettere voti hai l'abbonamento da poraccio!");
        }
    }

    //Questo metodo prende in input una categoria e restituisce i prodotti del catalogo di quella categoria
    public HashSet<Prodotto> cercaProdotti(Catalogo catalogo, String categoria) {
        HashSet<Prodotto> prodottiCercati = new HashSet<>();
        HashSet<Prodotto> prodottiCatalogo = catalogo.getCatalogo();
        if (profiloUtente.getOfferta().equals(TipoOfferta.PREMIUM)) {
            if (categoria.equalsIgnoreCase("film")) {
                for (Prodotto p : prodottiCatalogo) {
                    if (p instanceof Film) {
                        prodottiCercati.add(p);
                    }
                }
            } else if (categoria.equalsIgnoreCase("Serie Tv")) {
                for (Prodotto p : prodottiCatalogo) {
                    if (p instanceof Film) {
                        prodottiCercati.add(p);
                    }
                }
            } else if (categoria.equalsIgnoreCase("Documentario")) {
                for (Prodotto p : prodottiCatalogo) {
                    if (p instanceof Film) {
                        prodottiCercati.add(p);
                    }
                }
            } else {
                System.out.println("Ricerca non valida");
            }
        }
        else System.out.println("Abbonamento non valido");
        return prodottiCercati;
    }

    public HashSet<Prodotto> cercaProdotti (Catalogo catalogo, Genere genere) {
        HashSet<Prodotto> prodottiCercati = new HashSet<>();
        HashSet<Prodotto> prodottiCatalogo = catalogo.getCatalogo();
        if (profiloUtente.getOfferta().equals(TipoOfferta.PREMIUM)) {
            for (Prodotto p : prodottiCatalogo) {
                if (p.getGenere().equals(genere)) {
                    prodottiCercati.add(p);
                }
            }
        }
        return prodottiCercati;
    }

    //Questo metodo ritorna un insieme di prodotti che possono interessare all'utente
    public HashSet<Prodotto> prodottiConsigliati(Catalogo catalogo) {
        HashSet<Prodotto> prodottiCercati = new HashSet<>();
        HashSet<Prodotto> prodottiCatalogo = catalogo.getCatalogo();
        //ci calcoliamo il genere preferito dall'utente
        HashMap<Genere, Integer> votiPerGenere = new HashMap<>();
        for (Prodotto p : miaLista) {
            Genere g = p.getGenere();
            if(votiPerGenere.containsKey(g)) {
                votiPerGenere.put(g, votiPerGenere.get(g) + 1);
            } else {
                votiPerGenere.put(g, 1);
            }
        }
        //ora che ho fatto la mappa calcolo il genere preferito
        Genere genereMax = null;
        int numGenereMax = 0;
        for (Genere g : votiPerGenere.keySet()) {
            if(votiPerGenere.get(g) > numGenereMax) {
                genereMax = g;
                numGenereMax = votiPerGenere.get(g);
            }
        }
        //Aggiungo all'insieme di risultato tutti quei prodotti che sono dello stesso risultato di
        // genereMax che non sono nella lista dell'utente e che hanno media voto > 3
        for (Prodotto p : prodottiCatalogo) {
            if(p.getGenere().equals(genereMax) && !miaLista.contains(p) && p.mediaVoto() > 3) {
                prodottiCercati.add(p);
            }
        }
        return prodottiCercati;
    }
}
