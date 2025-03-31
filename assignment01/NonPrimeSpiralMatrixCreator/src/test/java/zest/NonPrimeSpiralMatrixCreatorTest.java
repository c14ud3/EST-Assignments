package zest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class NonPrimeSpiralMatrixCreatorTest {
    @Test
    void testZero(){
        int[] result = NonPrimeSpiralMatrixCreator.createSpiralMatrix(0);
        assertArrayEquals(new int[]{}, result);
    }

    @Test
    void testOne(){
        int[] result = NonPrimeSpiralMatrixCreator.createSpiralMatrix(1);
        assertArrayEquals(new int[]{1}, result);
    }

    @Test
    void testTwo(){
        int[] result = NonPrimeSpiralMatrixCreator.createSpiralMatrix(2);
        assertArrayEquals(new int[]{1, 4, 8, 6}, result);
    }

    @Test
    void testEvenNumber(){
        int[] result = NonPrimeSpiralMatrixCreator.createSpiralMatrix(4);
        assertArrayEquals(new int[]{1, 4, 6, 8, 20, 21, 22, 9, 18, 25, 24, 10, 16, 15, 14, 12}, result);

    }

    @Test
    void testOddNumber(){
        int[] result = NonPrimeSpiralMatrixCreator.createSpiralMatrix(5);
        assertArrayEquals(new int[]{1,4,6,8,9,25,26,27,28,10,24,35,36,30,12,22,34,33,32,14,21,20,18,16,15}, result);
    }

    @Test
    void testNegativeNumber(){
        assertThrows(IllegalArgumentException.class, () -> NonPrimeSpiralMatrixCreator.createSpiralMatrix(-1));
        }
        
}