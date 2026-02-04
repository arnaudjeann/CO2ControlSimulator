/**
 * Cette classe implémente Observer, permettant ainsi la gestion de la température et de la ventilation.
 * @author Arnaud Jean
 * @since Hiver 2026
 * @version 1.0
 */
public class Controller implements Observer {
    //Constantes
    private static final Double TARGET_TEMP = 22.0;
    private static final Double MAX_CO2 = 1000.0;

    //Attributs
    private Heating heating;
    private Cooling cooling;
    private Ventilation ventilation;

    //Constructeur
    public Controller() {
        heating = new Heating();
        cooling = new Cooling();
        ventilation = new Ventilation();
    }

    /**
     * Cette fonction permet de gérer la température et la ventilation selon la donnée fournie.
     * @param sensor le capteur en question
     */
    @Override
    public void update(Sensor sensor) {
        if (sensor instanceof TemperatureSensor) {
            double temperature = sensor.getValue();
            controlTemperature(temperature);
        }

        if (sensor instanceof CO2Sensor) {
            double co2 = sensor.getValue();
            controlCO2(co2);
        }
    }

    /**
     * Cette fonction permet de contrôler la température selon les critères désirés
     * @param temperature la température reçu en paramètre
     */
    public void controlTemperature(double temperature) {
        if (temperature < TARGET_TEMP) {
            if (cooling.getIsON()) { cooling.stop(); }
            if (!heating.getIsON()) { heating.start(); }
        } else if (temperature > TARGET_TEMP) {
            if (heating.getIsON()) { heating.stop(); }
            if (!cooling.getIsON()) { cooling.start(); }
        } else {
            if (heating.getIsON()) { heating.stop(); }
            if (cooling.getIsON()) { cooling.stop(); }
        }
    }

    /**
     * Cette fonction permet de contrôler la ventilation selon les critères désirés
     * @param co2 la quantité de CO2 reçu en paramètre
     */
    public void controlCO2(double co2) {
        if (co2 > MAX_CO2) {
            if (!ventilation.getIsON()) { ventilation.start(); }
        } else {
            if (ventilation.getIsON()) { ventilation.stop(); }
        }
    }
}