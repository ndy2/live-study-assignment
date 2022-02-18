package as2345;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import week4.assignment.StackListNode;

import static org.junit.jupiter.api.Assertions.*;

class StackListNodeTest {
    @Test
    public void stackIntegratedTest() throws Exception {
        StackListNode stack = new StackListNode();

        stack.push(1);
        stack.push(2);
        stack.push(2);
        stack.push(-2);
        stack.push(12412);
        stack.push(0);
        stack.push(20);

        assertEquals(20, stack.pop());
        assertEquals(0, stack.pop());
        assertEquals(12412, stack.pop());
        assertEquals(-2, stack.pop());

        stack.push(7);
        stack.push(88);

        assertEquals(88, stack.pop());
        assertEquals(7, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());

        Exception ex = assertThrows(Exception.class, ()->{
            stack.pop();
        });
        Assertions.assertThat(ex.getMessage()).contains("No more stack");

    }
}