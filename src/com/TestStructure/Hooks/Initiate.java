package com.TestStructure.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Initiate {

    @Before
    public void initialization()  {
        System.out.println("API test starts...!");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Api test closed...!");
    }

}