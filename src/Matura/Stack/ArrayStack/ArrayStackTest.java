package Matura.Stack.ArrayStack;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


public class ArrayStackTest {

    Stack<Integer> stack;

    @Before
    public void setUp() {
        stack = new ArrayStack<>(5);
        stack.push(2);
        stack.push(1);
        stack.push(3);
    }

    @Test
    public void testIsEmpty00() {
        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void testIsEmpty01() {
        stack = new ArrayStack<>(1);
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void testPop00() {
        Assert.assertEquals(3, (int)stack.pop());
    }

    @Test
    public void testPop01() {
        stack.pop();
        stack.pop();

        Assert.assertEquals(2, (int)stack.pop());
    }

    @Test(expected = StackUnderflowException.class)
    public void testPop02() {
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        Assert.fail("Should throw StackUnderflowException");
    }

    @Test
    public void testPeek00() {
        Assert.assertEquals(3, (int)stack.peek());
    }

    @Test
    public void testPeek01() {
        stack.pop();
        Assert.assertEquals(1, (int)stack.peek());
    }

    @Test(expected = StackUnderflowException.class)
    public void testPeek02() {
        stack = new ArrayStack<>(1);
        stack.peek();
        Assert.fail("Should throw StackUnderflowException");
    }


    @Test
    public void testPush00() {
        stack.push(1);
        Assert.assertEquals(1, (int)stack.pop());
    }

    @Test
    public void testPush01() {
        stack.push(1);
        stack.push(2);
        Assert.assertEquals(2, (int)stack.pop());
        Assert.assertEquals(1, (int)stack.pop());
    }

    @Test
    public void testSize00() {
        Assert.assertEquals(3, stack.size());
    }

    @Test
    public void testSize01() {
        stack = new ArrayStack<>(1);
        Assert.assertEquals(0, stack.size());
    }

    @Test
    public void testSize02() {
        int size = stack.size();
        stack.push(1);
        Assert.assertEquals(size + 1, stack.size());
    }

    @Test
    public void testSize03() {
        int size = stack.size();
        stack.pop();
        Assert.assertEquals(size - 1, stack.size());
    }
}
