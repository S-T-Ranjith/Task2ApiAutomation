package src.com.TestStructure.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import src.com.TestStructure.Actions.ApiAction.*;

import static src.com.TestStructure.Actions.ApiAction.connection;

public class Initiate {

    @Before
    public void initialization()  {
        System.out.println("API test starts...!");

    }

    @After
    public void tearDown() throws Exception {
        connection.disconnect();
        System.out.println("TEAR DOWN");
    }

}