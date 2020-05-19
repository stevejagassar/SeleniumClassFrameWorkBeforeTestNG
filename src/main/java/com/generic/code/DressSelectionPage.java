package com.generic.code;

import org.openqa.selenium.support.ui.Select;

import com.page.object.model.ProductPage;
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
		
		
		pf.getallDressName().get(4).click();
		
		pf.getquantityinputbox().clear();
		pf.getquantityinputbox().sendKeys("4");
		
		//how to handle drop down in selenium
		Select select= new Select(pf.getdressSizeDropDown());
		select.getOptions().forEach(option->{
			System.out.println(option.getText());
		});
		select.selectByIndex(1);
		//select.selectByVisibleText("M");
		//select.selectByValue("2");
		
		pf.getaddtoCartBtn().click();
		
		
		Wait.getExplicitWaitClicable(driver, pf.getproceedToCheckOut());
		pf.getproceedToCheckOut().click();
		
		// driver.quit();

	}

}
