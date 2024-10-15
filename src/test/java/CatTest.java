import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Spy
    private Cat cat = new Cat(new Feline());

    @Test
    public void getSoundTest() {
        Assert.assertEquals("Мяу", cat.getSound());
        Mockito.verify(cat, Mockito.times(1)).getSound();
    }

    @Test
    public void getFoodTest() throws Exception {
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
        Mockito.verify(cat, Mockito.times(1)).getFood();
    }
}