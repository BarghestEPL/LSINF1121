import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StackTests {

    @Test
    public void EmptyTest() {
        Stack<Integer> stack = new MyStack<Integer>();
        assertTrue(stack.empty());
    }

    @Test(expected = EmptyStackException.class)
    public void EmptyStackExceptionOnPeek() {
        Stack<Integer> stack = new MyStack<Integer>();
        stack.peek();
    }

    @Test(expected = EmptyStackException.class)
    public void EmptyStackExceptionOnPop() {
        Stack<Integer> stack = new MyStack<Integer>();
        stack.pop();
    }

    @Test(expected = EmptyStackException.class)
    public void EmptyStackExceptionOnMultiplePop() {
        Stack<Integer> stack = new MyStack<Integer>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }

    @Test
    public void BasicPushAndPeek() {
        Stack<Integer> stack = new MyStack<Integer>();
        stack.push(5);
        assertEquals(Integer.valueOf(5), stack.peek());
    }

    @Test
    public void BasicPushAndPop() {
        Stack<Integer> stack = new MyStack<Integer>();
        stack.push(5);
        assertEquals(Integer.valueOf(5), stack.pop());
    }

    @Test
    public void MultiplePushAndPeek() {
        Stack<Integer> stack = new MyStack<Integer>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.peek());
    }

    @Test
    public void MultiplePushAndPop() {
        Stack<Integer> stack = new MyStack<Integer>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.pop());
    }

    @Test
    public void MultiplePushAndMultiplePeek() {
        Stack<Integer> stack = new MyStack<Integer>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.peek());
    }

    @Test
    public void GenericType() {
        Stack<String> stack = new MyStack<String>();
        stack.push("hello");
        assertEquals("hello", stack.pop());
    }

    @Test
    public void UnlimitedSize() {
        Stack<Integer> stack = new MyStack<Integer>();
        for (int i = 0; i < 4096; i++) {
            stack.push(i);
            assertEquals(Integer.valueOf(i), stack.peek());
        }

        for (int i = 4095; i >= 0; i--) {
            assertEquals(Integer.valueOf(i), stack.pop());
        }
        assertTrue(stack.empty());
    }

    @Test(expected = EmptyStackException.class)
    public void AllTest() {
        Stack<Integer> stack = new MyStack<Integer>();
        stack.push(5);
        assertEquals(Integer.valueOf(5), stack.peek());
        stack.push(4);
        assertEquals(Integer.valueOf(4), stack.peek());
        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.peek());
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(4), stack.pop());
        stack.push(8);
        assertEquals(Integer.valueOf(8), stack.peek());
        assertEquals(Integer.valueOf(8), stack.pop());
        assertEquals(Integer.valueOf(5), stack.peek());
        assertEquals(Integer.valueOf(5), stack.pop());
        assertTrue(stack.empty());
        stack.pop();
    }
}

