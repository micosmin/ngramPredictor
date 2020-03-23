package test;

import com.cosmo.NgramGenerate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NgramGenerateTest {

    @Test
    void ngrams() {
        List<String> result = NgramGenerate.ngrams(2,  "Mary had a little lamb its fleece was white as snow");
        List<String> actual = new ArrayList<>(Arrays.asList("mary had","had a","a little","little lamb","lamb its","its fleece","fleece was","was white","white as","as snow"));
        assertNotEquals(result, "[Mary had, had a, a little, little lamb, lamb its, its fleece, fleece was, was white, white as, as snow]");
        assertEquals(result, actual);
    }
}
