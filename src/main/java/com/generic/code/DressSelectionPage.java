package com.generic.code;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
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

//		for (int i = 0; i < pf.getallDressName().size(); i++) {// 5
//
//			System.out.println("Found dress name = "+pf.getallDressName().get(i).getText());
//
//		}
		
	//	list.foreach(e->e){
			
	//	}
		
		pf.getallDressName().forEach(name->{
			
			System.out.println("Found dress name = "+name.getText());
			
		});
		

//		for (int i = 0; i < pf.getallDressPrice().size(); i++) {// 5
//
//			System.out.println("Found dress price = "+pf.getallDressPrice().get(i).getText());
//
//		}

		pf.getallDressPrice().forEach(price ->{
			
			System.out.println("Found dress price = "+ price.getText());
		});
		
		
		pf.getdressesCount().get(4).click();
		
		
		//Wait.getExplicitWaitClicable(driver, pf.getquantityinputbox());
		
		//pf.getquantityinputbox().sendKeys("4");=== hidden ......selenium failed
		
//		Actions act = new Actions(driver);
//		act.moveToElement(pf.getquantityinputbox()).click().perform();
//		act.moveToElement(pf.getquantityinputbox()).sendKeys("4").perform();
		
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		act.moveToElement(pf.getquantityinputbox()).click().perform();
		
		
		//pf.getquantityinputbox().click();
		
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		String script= "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
//		js.executeScript(script, pf.getquantityinputbox());
//		pf.getquantityinputbox().click();
//		js.executeScript("arguments[0].click();", pf.getaddtoCartBtn());
		//js.executeScript("arguments[0].value='4';", pf.getquantityinputbox());
		//js.executeScript("arguments[0].setAttribute('value', `arguments[1]');", pf.getquantityinputbox(), "4");
		
		
		//String script= "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";

		//js.executeScript(script, pf.getquantityinputbox());
		//pf.getquantityinputbox().sendKeys("4");
		
		
		
		
		
		
		
		//js.executeScript("arguments[0].click();", element);
		
		//how to handle drop down in selenium
		Select select= new Select(pf.getdressSizeDropDown());
	
		System.out.println(select.getOptions());
		select.selectByIndex(1);
		//select.selectByVisibleText("M");
		//select.selectByValue("2");
		
		pf.getaddtoCartBtn().click();
		
		
		// driver.quit();

	}

}
