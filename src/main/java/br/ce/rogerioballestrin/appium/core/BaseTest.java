package br.ce.rogerioballestrin.appium.core;

import org.junit.After;

public class BaseTest {
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}
}
