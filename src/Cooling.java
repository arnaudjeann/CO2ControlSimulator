/**
 * Cette classe permet de gérer le refroidissement
 * @author Arnaud Jean
 * @since Hiver 2026
 * @version 1.0
 */
public class Cooling {
    private boolean isON = false;

    public void start() {
        this.isON = true;
        System.out.println("--> Climatiseur demarré");
    }
    public void stop() {
        this.isON = false;
        System.out.println("--> Climatiseur arrêté");
    }

    //Getter
    public boolean getIsON() {
        return this.isON;
    }
}