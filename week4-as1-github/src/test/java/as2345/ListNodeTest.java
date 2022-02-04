package as2345;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@AggregateWith(ListAggregator.class)
@interface CsvToList {
}

class ListAggregator implements ArgumentsAggregator {
    @Override
    public List<Integer> aggregateArguments(ArgumentsAccessor arguments, ParameterContext context) {
        int size = arguments.size();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(arguments.getInteger(i));
        }
        return list;
    }
}

@DisplayName("리스트 노드 클래스")
class ListNodeTest {

    @Nested
    @DisplayName("length 메소드는")
    class LengthTest{

        @ParameterizedTest
        @CsvSource({
                "1",
                "1,2",
                "1,2,3",
                "1,2,3,4"
        })
        void small_amount_test(@CsvToList List<Integer> in){
            ListNode<Integer> listNode = new ListNode<>(in.get(0));
            for (int i = 1; i < in.size(); i++) {
                listNode.add(new ListNode<>(in.get(i)), i-1);
            }
            assertThat(listNode.length()).isEqualTo(in.size());
        }
    }


    @Nested
    @DisplayName("add 메소드는")
    class AddTest{

        @Test
        @DisplayName("더하면 더해진다.")
        void basicAddTest(){
            ListNode<Object> listNode = new ListNode<>(2.9);
            listNode.add(new ListNode<>(3.9),0);
            listNode.add(new ListNode<>(4.9),1);
            listNode.add(new ListNode<>("5.9"),2);

            assertThat(listNode.length()).isEqualTo(4);
            assertThat(listNode.at(0).getData()).isEqualTo(2.9);
            assertThat(listNode.at(1).getData()).isEqualTo(3.9);
            assertThat(listNode.at(2).getData()).isEqualTo(4.9);
            assertThat(listNode.at(3).getData()).isEqualTo("5.9");
        }

        @Test
        @DisplayName("두개씩 나눠서 더해도 더해진다")
        void splitAdditionTest(){
            ListNode<Object> front = new ListNode<>("front0");
            front.add(new ListNode<>("front1"),0);

            ListNode<Object> back = new ListNode<>("back0");
            back.add(new ListNode<>("back1"),0);

            front.add(back,1);
            assertThat(front.length()).isEqualTo(4);
            assertThat(front.at(0).getData()).isEqualTo("front0");
            assertThat(front.at(1).getData()).isEqualTo("front1");
            assertThat(front.at(2).getData()).isEqualTo("back0");
            assertThat(front.at(3).getData()).isEqualTo("back1");
        }

        @Test
        @DisplayName("중간에 넣어도 잘 더해진다")
        void addInBetweenTest(){
            ListNode<Object> front = new ListNode<>("front0");
            front.add(new ListNode<>("front1"),0);

            ListNode<Object> back = new ListNode<>("back0");
            back.add(new ListNode<>("back1"),0);

            front.add(back,0);
            assertThat(front.length()).isEqualTo(4);
            assertThat(front.at(0).getData()).isEqualTo("front0");
            assertThat(front.at(1).getData()).isEqualTo("back0");
            assertThat(front.at(2).getData()).isEqualTo("back1");
            assertThat(front.at(3).getData()).isEqualTo("front1");
        }

        @Test
        @DisplayName("head의 길이보다 큰 position을 설정 할 수 없다.")
        void rangeTest(){
            ListNode<Object> front = new ListNode<>("front0");
            front.add(new ListNode<>("front1"),0);

            ListNode<Object> back = new ListNode<>("back0");
            back.add(new ListNode<>("back1"),0);

            assertThatThrownBy(() -> front.add(back,10))
                    .isInstanceOf(IllegalArgumentException.class);

        }
    }

    @Nested
    @DisplayName("at 메소드는")
    class atTest{

        @Test
        @DisplayName("길이가 넘치면 예외를 터트린다")
        void outOfRangeExceptionTest(){
            ListNode<Object> listNode = new ListNode<>("0th Data");

            assertThatThrownBy(() -> listNode.at(1))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Nested
    @DisplayName("contains 메소드는")
    class containsTest{
        ListNode<Object> listNode0 = new ListNode<>("0th Data");
        ListNode<Object> listNode1 = new ListNode<>("1th Data");
        ListNode<Object> listNode2 = new ListNode<>("2th Data");
        ListNode<Object> listNode3 = new ListNode<>("3th Data");

        @BeforeEach
        void setUp(){
            listNode0.add(listNode1,0);
            listNode0.add(listNode2,1);
            listNode0.add(listNode3,2);
        }

        @Test
        @DisplayName("있으면 있다고 한다.")
        void trueTest(){
            assertThat(listNode0.contains(listNode0)).isTrue();
            assertThat(listNode0.contains(listNode1)).isTrue();
            assertThat(listNode0.contains(listNode2)).isTrue();
            assertThat(listNode0.contains(listNode3)).isTrue();

            assertThat(listNode1.contains(listNode1)).isTrue();
            assertThat(listNode1.contains(listNode2)).isTrue();
            assertThat(listNode1.contains(listNode3)).isTrue();

            assertThat(listNode2.contains(listNode2)).isTrue();
            assertThat(listNode2.contains(listNode3)).isTrue();
            assertThat(listNode0.length()).isEqualTo(4);
        }

        @Test
        @DisplayName("없으면 없다고 한다.")
        void falseTest(){
            assertThat(listNode1.contains(listNode0)).isFalse();

            assertThat(listNode2.contains(listNode0)).isFalse();
            assertThat(listNode2.contains(listNode1)).isFalse();

            assertThat(listNode3.contains(listNode0)).isFalse();
            assertThat(listNode3.contains(listNode1)).isFalse();
            assertThat(listNode3.contains(listNode2)).isFalse();
            assertThat(listNode0.length()).isEqualTo(4);
        }

    }


    @Nested
    @DisplayName("remove 메소드는")
    class removeTest{
        ListNode<Object> listNode0 = new ListNode<>("data0");
        ListNode<Object> listNode1 = new ListNode<>("data1");
        ListNode<Object> listNode2 = new ListNode<>("data2");
        ListNode<Object> listNode3 = new ListNode<>("data3");

        @BeforeEach
        void setUp(){
            listNode0.add(listNode1,0);
            listNode0.add(listNode2,1);
            listNode0.add(listNode3,2);
        }

        @Test
        @DisplayName("0번째 데이터 삭제.")
        void ZerothData(){
            ListNode<Object> data123 = listNode0.remove(0);
            assertThat(data123.at(0).getData()).isEqualTo("data1");
            assertThat(data123.at(1).getData()).isEqualTo("data2");
            assertThat(data123.at(2).getData()).isEqualTo("data3");
            assertThat(listNode0.length()).isEqualTo(3);
        }

        @Test
        @DisplayName("1번째 데이터 삭제.")
        void FirstData(){
            ListNode<Object> data023 = listNode0.remove(1);
            assertThat(data023.at(0).getData()).isEqualTo("data0");
            assertThat(data023.at(1).getData()).isEqualTo("data2");
            assertThat(data023.at(2).getData()).isEqualTo("data3");
            assertThat(listNode0.length()).isEqualTo(3);
        }

        @Test
        @DisplayName("2번째 데이터 삭제.")
        void SecondData(){
            ListNode<Object> data013 = listNode0.remove(2);
            assertThat(data013.at(0).getData()).isEqualTo("data0");
            assertThat(data013.at(1).getData()).isEqualTo("data1");
            assertThat(data013.at(2).getData()).isEqualTo("data3");
            assertThat(listNode0.length()).isEqualTo(3);
        }


        @Test
        @DisplayName("3번째 데이터 삭제.")
        void LastData(){
            ListNode<Object> data012 = listNode0.remove(3);
            assertThat(data012.at(0).getData()).isEqualTo("data0");
            assertThat(data012.at(1).getData()).isEqualTo("data1");
            assertThat(data012.at(2).getData()).isEqualTo("data2");
            assertThat(listNode0.length()).isEqualTo(3);
        }

        @Test
        @DisplayName("4번째 데이터 삭제 -> 예외 빵!")
        void outOfRangeExceptionTest(){
            assertThatThrownBy(() -> listNode0.remove(4))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}