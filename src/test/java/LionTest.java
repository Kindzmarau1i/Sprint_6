import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Spy
    Lion lion = new Lion("Самец", new Feline());

    public LionTest() throws Exception {
    }

    @Test
    public void getKittensTest() {
        int kittens = lion.getKittens();
        Assert.assertEquals(kittens, 1);
        Mockito.verify(lion, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> food = lion.getFood();
        Assert.assertFalse(food.isEmpty());
        Mockito.verify(lion, Mockito.times(1)).getFood();
    }
}