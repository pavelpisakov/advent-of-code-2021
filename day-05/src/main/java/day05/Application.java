package day05;

public class Application {

    public static void main(String[] args) {

        var submarine = new Submarine();
        var sensor = submarine.getHydrothermalVentsSensor();
        var data = sensor.readData();

        var navigator = submarine.getNavigator();

        int index = navigator.calculateDangerousVentsOnOneLineIndex(data);
        System.out.println("index (on the same line): " + index);

        index = navigator.calculateDangerousVentsIndex(data);
        System.out.println("index: " + index);

    }
}
