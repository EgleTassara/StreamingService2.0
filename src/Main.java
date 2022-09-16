public class Main {
    public static void main(String[] args) {
        Profilo profilo = new Profilo("pimarchetto03@gmail.com", "password" , TipoOfferta.STANDARD);
        Utente utente1 = new Utente("Pietro", "avatar", false, "1234", profilo);
        Utente utente2 = new Utente("PietroKid", "avatarKid", true, "1234", profilo);
        Utente utente3 = new Utente("Pietro2", "avatar2", true, "1234", profilo);

        profilo.addUtenti(utente1);
        System.out.println("streamingService.profilo.Utente 1 inserito");
        profilo.addUtenti(utente2);
        System.out.println("streamingService.profilo.Utente 2 inserito");
        profilo.addUtenti(utente3);
        System.out.println("streamingService.profilo.Utente 3 inserito");

        System.out.println("Programma Terminato");
    }
}