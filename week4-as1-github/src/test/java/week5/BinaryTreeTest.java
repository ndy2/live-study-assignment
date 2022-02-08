package week5;

import as2345.util.CsvToList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    @CsvSource({
            "1",
            "1,2",
            "1,2,3",
            "1,2,3,4",
            "3,2,4",
            "20,1,2,4,3,30"
    })
    void printBfsTest(@CsvToList List<Integer> in){
        BinaryTree binaryTree = new BinaryTree();
        for (Integer integer : in) {
            binaryTree.add(integer);
        }
        binaryTree.bfs(new Node(in.get(0)));
    }
}