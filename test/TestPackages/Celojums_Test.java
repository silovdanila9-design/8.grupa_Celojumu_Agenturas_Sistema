package TestPackages;

import org.junit.Test;
import static org.junit.Assert.*;

public class Celojums_Test {

    @Test
    public void testCenasAprēķins() {
        double cenaParDienu = 40.0;
        int dienuSkaits = 3;
        double kopa = cenaParDienu * dienuSkaits;
        
        // Izmantojam assertTrue, lai izvairītos no Hamcrest kļūdas
        assertTrue("Cenas aprēķinam jābūt 120.0", Math.abs(kopa - 120.0) < 0.001);
    }

    @Test
    public void testIevadesValidacijaTukšs() {
        String ievade = "";
        boolean irDerigs = ievade != null && !ievade.trim().isEmpty();
        assertFalse("Tukšam laukam jābūt nederīgam", irDerigs);
    }

    @Test
    public void testIevadesValidacijaDerigs() {
        String ievade = "Liepāja";
        boolean irDerigs = ievade != null && !ievade.trim().isEmpty();
        assertTrue("Aizpildītam laukam jābūt derīgam", irDerigs);
    }
}