import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

@RunWith(Parameterized.class)
public class LionParametrizeTest {

    @Spy
    private Feline feline;
    private final String sex;
    private final Boolean isMane;

    public LionParametrizeTest(String sex, Boolean isMane) {
        this.sex = sex;
        this.isMane = isMane;
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
//                {"Чупа", false}
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(lion.doesHaveMane(), isMane);
    }
}
