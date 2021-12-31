package day03;

import java.util.List;

public interface Submarine {

    // I would like to work with it as binary (no reason to compare chars)
    List<Integer> produceDiagnosticReport();

    List<String> produceDiagnosticReportAsString();

    int checkPowerConsumption(List<Integer> report);

    int checkLifeSupportRating(List<String> report);

}
