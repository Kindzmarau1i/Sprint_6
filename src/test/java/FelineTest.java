import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void eatMeatTest() throws Exception {
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

    @Test
    public void getFamilyTest() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
        Mockito.verify(feline, Mockito.times(1)).getFamily();
    }

    @Test
    public void getKittensDefaultTest() {
        Assert.assertEquals(5, feline.getKittens(5));
        Mockito.verify(feline, Mockito.times(1)).getKittens(5);
    }

    @Test
    public void getKittensTest() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = feline.getKittens();
        Assert.assertEquals(1, actual);
    }
}