/**
 * Cette classe permet de gérer la ventilation
 * @author Arnaud Jean
 * @since Hiver 2026
 * @version 1.0
 */
public class Ventilation {
    private boolean isON = false;

    public void start() {
        this.isON = true;
        System.out.println("--> Ventilateur demarré");
    }
    public void stop() {
        this.isON = false;
        System.out.println("--> Ventilateur arrêté");
    }

    //Getter
    public boolean getIsON() {
        return this.isON;
    }
}