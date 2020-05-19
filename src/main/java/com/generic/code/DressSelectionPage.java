package com.generic.code;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.page.object.model.ProductPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class DressSelectionPage extends BaseLogin {

	public static void main(String[] args) throws Throwable {

		getLogin();// 1

		ProductPage pf = new ProductPage(driver);// 2
		pf.getdressesbtn().click();

		int totalNo = pf.getdressesCount().size();
		System.out.println("Total dress displayed = " + totalNo);

		pf.getallDressName().forEach(name->{
			
			System.out.println("Found dress name = "+name.getText());
			
		});

		pf.getallDressPrice().forEach(price ->{
			
			System.out.println("Found dress price = "+ price.getText());
		});
		
		new Highlighter().getcolor(driver, pf.getallDressName().get(4), "red");
		pf.getallDressName().get(4).click();
		
		pf.getquantityinputbox().clear();
		new Highlighter().getcolor(driver, pf.getquantityinputbox(), "green");
		pf.getquantityinputbox().sendKeys("4");
		
		//how to handle drop down in selenium
		Select select= new Select(pf.getdressSizeDropDown());
		select.getOptions().forEach(option->{
			System.out.println(option.getText());
		});
		
		new Highlighter().getcolor(driver, pf.getdressSizeDropDown(), "blue");
		select.selectByIndex(1);
		//select.selectByVisibleText("M");
		//select.selectByValue("2");
		new Highlighter().getcolor(driver, pf.getaddtoCartBtn(), "yellow");
		pf.getaddtoCartBtn().click();
		
		
		Wait.getExplicitWaitClicable(driver, pf.getproceedToCheckOut());
		new Highlighter().getcolor(driver, pf.getproceedToCheckOut(), "pink");
		pf.getproceedToCheckOut().click();
		
		new Highlighter().getcolor(driver, pf.getsummaryProceedToCheckOut(), "red");
		pf.getsummaryProceedToCheckOut().click();//summary
		
		
		Actions action = new Actions(driver);//Action class== helping selenium
		action.moveToElement(pf.getaddressProceedToCheckOut()).build().perform();
		new Highlighter().getcolor(driver, pf.getaddressProceedToCheckOut(), "red");
		action.click(pf.getaddressProceedToCheckOut()).build().perform();
		
		new Highlighter().getcolor(driver, pf.getcheckBox(), "red");
		pf.getcheckBox().click();//check box
		
		new Highlighter().getcolor(driver, pf.getshippingProceedToCheckOut(), "red");
		pf.getshippingProceedToCheckOut().click();//shipping
		
		//now in payment page
		new Highlighter().getcolor(driver, pf.getpaymentOptions().get(0), "red");
		pf.getpaymentOptions().get(0).click();//select payment
		
		new Highlighter().getcolor(driver, pf.getorderConfirmedBtn().get(0), "red");
		pf.getorderConfirmedBtn().get(0).click();
				
		new Highlighter().getcolor(driver, pf.getorderSummary());
		System.out.println(pf.getorderSummary().getText());
		
		TakeAppScreenShot.captureScreenShot(driver, "My Order Summary");
		
		
		
		driver.quit();

	}

}
