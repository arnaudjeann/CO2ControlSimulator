/**
 * Cette interface permet de déterminer les fonctions pour observateurs.
 * @author Arnaud Jean
 * @since Hiver 2026
 * @version 1.0
 */
public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}