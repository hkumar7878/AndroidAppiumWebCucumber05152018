package com.cucumber.framework.Helper.Alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;

public class AlertHelper{

	WebDriver driver;
	public Logger Log = LoggerHelper.getLogger(AlertHelper.class);

	public AlertHelper(WebDriver driver) {
		this.driver = driver;
		Log.debug("AlertHelper : " + this.driver.hashCode());
	}

	public Alert getAlert() {
		Log.debug("");
		return driver.switchTo().alert();
	}

	public void acceptAlert() {
		Log.info("");
		getAlert().accept();
	}

	public void dismissAlert() {
		Log.info("");
		getAlert().dismiss();
	}

	public String getAlertText() {
		String text = getAlert().getText();
		return text;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			Log.info(true);
			return true;
		}

		catch (NoAlertPresentException e) {
			Log.info("false");
			return false;
		}
	}

}
