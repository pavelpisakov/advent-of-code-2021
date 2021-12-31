package day03;

public class Application {

    public static void main(String[] args) {

        var submarine = new CrackingSubmarine();

        var powerConsumption = submarine.checkPowerConsumption(submarine.produceDiagnosticReport());
        var lifeSupportRating = submarine.checkLifeSupportRating(submarine.produceDiagnosticReportAsString());

        System.out.println("power consumption: " + powerConsumption);
        System.out.println("life support rating: " + lifeSupportRating);
    }
}
