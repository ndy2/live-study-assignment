package week5;

import as2345.util.CsvToList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import week5.assignment.BinaryTree;
import week5.assignment.Node;

import java.util.List;

class BinaryTreeTest {

    @DisplayName("dfs 프린트 테스트")
    @ParameterizedTest
    @CsvSource({
            "1",
            "1,2",
            "1,2,3",
            "1,2,3,4",
            "3,2,4",
            "20,1,2,4,3,30"
    })
    void printDfsTest(@CsvToList List<Integer> in){
        BinaryTree binaryTree = new BinaryTree();
        for (Integer integer : in) {
            binaryTree.add(integer);
        }
        binaryTree.dfs(new Node(in.get(0)));
    }

    @DisplayName("bfs 프린트 테스트")
    @ParameterizedTest
    @CsvSource(delimiterString = "=>",value = {
            "1 => 1",
            "1,2 => 1,2",
            "1,2,3 => 1 2 3",
            "1,2,3,4 => 1 2 3 4",
            "3,2,4 => 3 2 4",
            "20,1,2,4,3,30 => 20 1 30 2 4 3"
    })
    void printBfsTest(@CsvToTestCase TestCase tc){
        BinaryTree binaryTree = new BinaryTree();
        for (Integer integer : tc.in) {
            binaryTree.add(integer);
        }
        System.out.println(tc.expectedOut);
        binaryTree.bfs(new Node(tc.in.get(0)));
    }
}