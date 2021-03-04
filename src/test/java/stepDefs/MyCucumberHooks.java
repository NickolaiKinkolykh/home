package stepDefs;

import driver.SingletonDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyCucumberHooks {
    @Before
    public void setUp() {
        SingletonDriver.getDriver();
    }

    @After
    public void tearDown() {

    }
}
