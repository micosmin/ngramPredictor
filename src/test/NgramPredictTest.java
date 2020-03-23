package test;

import com.cosmo.NgramPredict;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NgramPredictTest {

    @Test
    void predict() {
        String result = NgramPredict.predict(2, "a");
        String result2 = NgramPredict.predict(2, "the");
        assertEquals(result, "lamb,0.5;little,0.5");
        assertEquals(result2, "lamb,0.375;eager,0.125;children,0.125;rule,0.125;teacher,0.25");
    }
}