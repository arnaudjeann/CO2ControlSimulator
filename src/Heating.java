/**
 * Cette classe permet de gérer le chauffage
 * @author Arnaud Jean
 * @since Hiver 2026
 * @version 1.0
 */
public class Heating {
    private boolean isON = false;

    public void start() {
        this.isON = true;
        System.out.println("--> Chauffage démarré");
    }
    public void stop() {
        this.isON = false;
        System.out.println("--> Chauffage arrêté");
    }

    //Getter
    public boolean getIsON() {
        return this.isON;
    }
}