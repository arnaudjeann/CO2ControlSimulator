import java.util.Scanner;

/**
 * Cette classe permet de faire la simulation des capteurs en permettant l'entrée de données.
 * @author Arnaud Jean
 * @since Hiver 2026
 * @version 1.0
 */
public class Simulation {
    public static void main(String[] args) {
        TemperatureSensor tempSensor = new TemperatureSensor();
        CO2Sensor co2Sensor = new CO2Sensor();

        Controller controller = new Controller();

        tempSensor.attach(controller);
        co2Sensor.attach(controller);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Entrez la température (en °C): ");
            double temp = scanner.nextDouble();
            System.out.println("--> Contrôleur : nouvelle valeur reçue du capteur de temperature : " + temp +"°C");
            tempSensor.setValue(temp);

            System.out.println("Entrez la concentration de CO2 (en ppm) : ");
            double co2 = scanner.nextDouble();
            System.out.println("--> Contrôleur : nouvelle valeur reçu du capteur de CO2 : " + co2 + " ppm");
            co2Sensor.setValue(co2);

            System.out.println("Voulez-vous continuer ? (oui/non) : ");
            String reponse = scanner.next();
            if (reponse.equals("non")) break;
        }
    }
}