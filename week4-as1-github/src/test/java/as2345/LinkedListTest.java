package as2345;

import as2345.util.CsvToList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("링크드 리스트 클래스")
class LinkedListTest {
    @Nested
    @DisplayName("length 메소드는")
    class LengthTest {

        @ParameterizedTest
        @CsvSource({
                "1",
                "1,2",
                "1,2,3",
                "1,2,3,4"
        })
        void small_amount_test(@CsvToList List<Integer> in) {
            LinkedList linkedList = new LinkedList(in.get(0));
            for (int i = 1; i < in.size(); i++) {
                linkedList.add(new ListNode<>(in.get(i)), i - 1);
            }
            assertThat(linkedList.length()).isEqualTo(in.size());
        }
    }

    @Nested
    @DisplayName("add 메소드는")
    class AddTest {

        @Test
        @DisplayName("더하면 더해진다.")
        void basicAddTest() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.add(new ListNode<>(3), 0);
            linkedList.add(new ListNode<>(4), 1);
            linkedList.add(new ListNode<>(5), 2);

            assertThat(linkedList.length()).isEqualTo(4);
            assertThat(linkedList.at(0).getData()).isEqualTo(2);
            assertThat(linkedList.at(1).getData()).isEqualTo(3);
            assertThat(linkedList.at(2).getData()).isEqualTo(4);
            assertThat(linkedList.at(3).getData()).isEqualTo(5);
        }

    }
}