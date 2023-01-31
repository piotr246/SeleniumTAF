package tests;

import org.junit.jupiter.api.*;
import org.junitpioneer.jupiter.DisableIfTestFails;

@DisableIfTestFails
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalcTest {

    @Test
    @Order(1)
    public void t1() {
        System.out.println("1");
        Assertions.assertTrue(1 == 1);

    }

    @Test
    @Order(2)
    public void t2() {
        System.out.println("2");
        Assertions.assertTrue(1 == 2);
    }

    @Test
    @Order(3)
    public void t3() {
        System.out.println("3");
    }
}
