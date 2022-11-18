import com.example.service.TestDemoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

public class FirstTest {

    private TestDemoService testDemoService = new TestDemoService();

    @Test
    public void testAdd(){
        int result = testDemoService.add(5,7);
        Assertions.assertEquals(12, result);
    }

    @Test
    public void testMultiply(){
        int result = testDemoService.multiply(3,4);
        Assertions.assertEquals(12, result);
    }

    @Test
    public void testCalculate(){
        int result = testDemoService.calculate(5,3);
        Assertions.assertEquals(17, result);
    }

}
