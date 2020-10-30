import org.junit.Test;
import static org.junit.Assert.*;

public class RedBlackTests {

    @Test
    public void flipColor(){
        MyRedBlack<Integer, Integer> rbt = new MyRedBlack<>();
        for(int i = 0; i < 1000; i++){
            rbt.put(i,i);
            assertTrue(i == rbt.rank(i));
        }
    }

    @Test
    public void height(){
        MyRedBlack<Integer, Integer> rbt = new MyRedBlack<>();
        rbt.put(5, 1);
        rbt.put(6, 2);
        assertTrue(1 == rbt.height());
        rbt.put(7, 3);
        rbt.put(8, 4);
        assertTrue(2 == rbt.height());
        rbt.delete(6);
        assertTrue(1 == rbt.height());
    }
}