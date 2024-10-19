import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    private final Feline feline = new Feline();

    @Test
    public void eatMeatTest() throws Exception {
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensTest() {
        Assert.assertEquals(5, feline.getKittens(5));
    }

    @Test
    public void getKittensDefaultTest() {
        Assert.assertEquals(1, feline.getKittens());
    }
}