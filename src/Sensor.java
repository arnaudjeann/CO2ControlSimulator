import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe abstraite implémente Subject et permet de gérer la liste des observateurs à notifier
 * @author Arnaud Jean
 * @since Hiver 2026
 * @version 1.0
 */
public abstract class Sensor implements Subject {
    //Attributs
    protected double value;
    protected List<Observer> observers = new ArrayList<>();

    //Getter
    public Double getValue() {
        return value;
    }

    //Setter
    public void setValue(double value) {
        this.value = value;
        notifyObservers();
    }

    /**
     * Cette fonction ajoute un observateur à la liste
     * @param o l'observateur à ajouter
     */
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    /**
     * Cette fonction retire un observateur de la liste
     * @param o l'observateur à retirer
     */
    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    /**
     * Cette fonction permet de notifier les observateurs
     */
    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }
}