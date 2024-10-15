import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParametrizeTest {

    private final Feline feline = new Feline();
    private final String sex;
    private final Boolean isMane;

    public LionParametrizeTest(String sex, Boolean isMane) {
        this.sex = sex;
        this.isMane = isMane;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Чупа", false}
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Lion lionSpy = Mockito.spy(lion);
        boolean isMane1 = lionSpy.doesHaveMane();
        Assert.assertEquals(isMane1, isMane);
        Mockito.verify(lionSpy, Mockito.times(1)).doesHaveMane();
    }
}
