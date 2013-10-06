package com.kurtphpr.sistema.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClienteTest.class, ProdutoTest.class, VendaTest.class })
public class AllTests {

}
