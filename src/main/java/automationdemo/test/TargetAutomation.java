package automationdemo.test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;


import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationdemo.base.BaseClass;
import automationdemo.pages.HomePage;

public class TargetAutomation extends BaseClass {
	
	HomePage home=new HomePage(driver);
	
	@Test(priority=0,enabled=false)
	
	public void login() {
		
		driver.get(getproperty("url"));
		
		driver.manage().window().maximize();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setValue(home.username,getproperty("username"));
		
		setValue(home.password,"test");
		
		clickElement(home.login);
		
		clickListElements(home. addToCart);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		clickElement(home.cart);
		
		 PrintTextFromElements(home.productNames);
		
	    clickListElements(home.removeProducts);
		}
		
	      

			@Test(priority=1,enabled=false)
			public void SortProducts(List<WebElement>elements) {
	        	
	        	driver.get(getproperty("url"));
	    		
	    		driver.manage().window().maximize();
	    		
	    		setValue(home.username,getproperty("username"));
	    		
	    		setValue(home.password,getproperty("password"));
	    		
	    		clickElement(home.login);
	    		
				
				
		 SelectDropDownByValue(home.SelectFilter,getproperty("filter"));
		 
		 
		  PrintTextFromElements(home.Prices);
		  
			} 
			
		@Test(priority=2,enabled=false)
		
		public void VerifySocialLinks() {
			
			driver.get(getproperty("url"));
    		
    		driver.manage().window().maximize();
    		
    		setValue(home.username,getproperty("username"));
    		
    		setValue(home.password,getproperty("password"));
    		
    		clickElement(home.login);
    		
    		scrollTillpageEnd();
    		
    		String parent=driver.getWindowHandle();
    		
    		try {
				takeScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		ClickAndSwitchWindows(home.SocialLinks,parent);
    		
		}
		
		@DataProvider(name="testData")
		
		public Object[][] testData (Method m) throws IOException{
			
		Object[][] data = utils.ExcelUtils.getDataFromExcel(getproperty("excel"),"login",m.getName());
		
			 return data;
			
		
		}
		
		@Test(dataProvider="testData",enabled=true)


        public void login1(HashMap<String,String> data) {
			
             driver.get(getproperty("url"));
    		
    		driver.manage().window().maximize();
    		
    		setValue(home.username,data.get("username"));
    		
    		setValue(home.password,data.get("password"));
    		
    		try {
				Thread.sleep(2000);
			} catch (InterruptedException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
		
		@Test(dataProvider="testData",enabled=true)


       public void login2(HashMap<String,String> data) {
    	   
    	   driver.get(getproperty("url"));
   		
   		driver.manage().window().maximize();
   		
   		setValue(home.username,data.get("username"));
   		
   		setValue(home.password,data.get("password"));
   		
   		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		
        	
        }
		
		@Test(dataProvider="testData",enabled=true)

		  public void login3(HashMap<String,String> data) {
    	 
    	 driver.get(getproperty("url"));
 		
 		driver.manage().window().maximize();
 		
 		setValue(home.username,getproperty("username"));
 		
 		setValue(home.password,getproperty("password"));
 		
 		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	
    }
 
}

			


			

	
			
		

		

	

	
	
