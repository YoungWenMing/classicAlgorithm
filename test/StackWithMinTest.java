import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackWithMinTest {

    StackWithMin<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new StackWithMin<>();
        stack.push(0);
        stack.push(1);
        stack.push(-1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void push() {
    }

    @Test
    public void pop() {
    }

    @Test
    public void getMin() {
        assertEquals(stack.getMin(),  new Integer(-1));
        stack.pop();
        assertEquals(stack.getMin(),  new Integer(-1));
        stack.pop();
        assertEquals(stack.getMin(),  new Integer(-1));
        stack.pop();
        assertEquals(stack.getMin(),  new Integer(0));
    }

    @Test
    public void isCompatible() {
        assertTrue(!StackWithMin.isCompatible(new int[]{1, 2, 3}, new int[]{3, 1, 2}));
    }
}