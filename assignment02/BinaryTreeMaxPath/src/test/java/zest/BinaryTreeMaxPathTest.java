package zest;


import net.jqwik.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeMaxPathTest {
    private static BinaryTreeMaxPath binaryTreeMaxPath = new BinaryTreeMaxPath();

    private static int getMaxPathSumFromArray(Integer[] tree) {
        BinaryTreeMaxPath.TreeNode treeNode = BinaryTreeMaxPath.TreeNode.constructTree(tree);
        return binaryTreeMaxPath.maxPathSum(treeNode);
    }

    @ParameterizedTest
    @MethodSource("simpleExamples")
    void testSimpleExamples(Integer[] tree, int expectedMaxPathSum) {
        int maxPathSum = getMaxPathSumFromArray(tree);
        assertEquals(expectedMaxPathSum, maxPathSum);
    }

    static Stream<Arguments> simpleExamples() {
        return Stream.of(
                Arguments.of(new Integer[] {1, 2, 3}, 6),
                Arguments.of(new Integer[] {-1, 1, 3}, 3),
                Arguments.of(new Integer[] {-1, null, 3}, 3)
        );
    }

    @Test
    void testNullRoot() {
        assertThrows(IllegalArgumentException.class, () -> {
            binaryTreeMaxPath.maxPathSum(null);
        });
    }

    @Test
    void testNullNodes() {
        int maxPathSum = getMaxPathSumFromArray(new Integer[] {1, null, null, null, null, 3});
        assertEquals(1, maxPathSum);
    }

    @Test
    void testEmptyArray() {
        assertEquals(0, getMaxPathSumFromArray(new Integer[] {}));
    }

    @Test
    void testSingleNode() {
        assertEquals(1, getMaxPathSumFromArray(new Integer[] {1}));
    }

    @Test
    void tooManyNodes() {
        List<Integer> treeList = new ArrayList<Integer>();
        for (int i = 0; i < 1024; i++) {
            treeList.add(0);
        }

        assertThrows(IllegalArgumentException.class, () -> {
            getMaxPathSumFromArray(treeList.toArray(new Integer[treeList.size()]));
        });
    }

    @Test
    void tooLargeNodeValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            getMaxPathSumFromArray(new Integer[] {10001});
        });
    }

    @Test
    void tooSmallNodeValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            getMaxPathSumFromArray(new Integer[] {-10001});
        });
    }

    @Test
    void testImbalancedTree() {
        assertEquals(3, getMaxPathSumFromArray(new Integer[] {1, null, 2}));
    }

    @Property
    void testLeftChildTree(
            @ForAll("positiveNumberInRange") int number1,
            @ForAll("positiveNumberInRange") int number2,
            @ForAll("positiveNumberInRange") int number3,
            @ForAll("positiveNumberInRange") int number4
    ) {
        // We here check the following tree:
        //     x
        //    x 0
        //   x 0 0
        //  x 0 0 0

        int maxSum = getMaxPathSumFromArray(new Integer[] {
            number1, number2, 0, number3, 0, 0, number4, 0, 0, 0
        });

        int realMaxSum = number1 + number2 + number3 + number4;

        assertEquals(realMaxSum, maxSum);
    }

    @Provide
    private Arbitrary<Integer> positiveNumberInRange() {
        return Arbitraries.integers()
                .lessOrEqual(10000)
                .greaterOrEqual(1);
    }

    // Here, we check that the maximum path sum is at least the maximum node value
    @Property
    void maxPathSumAtLeastMaxNodeValue(@ForAll("trees") List<Integer> tree) {
        tree.add(1); // to ensure that at least one node is positive

        int maxSum = getMaxPathSumFromArray(tree.toArray(new Integer[tree.size()]));

        int maxNodeValue = 0;
        for (Integer nodeValue : tree) {
            if (nodeValue != null && nodeValue > maxNodeValue) {
                maxNodeValue = nodeValue;
            }
        }

        assertTrue(maxSum >= maxNodeValue);
    }

    @Provide
    Arbitrary<List<Integer>> trees() {
        return Arbitraries.integers().between(-10000, 10000).list();
    }
}
