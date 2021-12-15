package automationdemo.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import utils.Screenshot;

public class BaseClass {
	
	public static WebDriver driver;
	
	static {
		
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
		
		driver=new ChromeDriver();
		
		
	}
	
	public String getproperty(String key)  {
		Properties prop=new Properties();
		
		File propertiesFile=new File("src/test/resources/data.properties");
		try {
			prop.load(new FileInputStream(propertiesFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value=prop.getProperty(key);
		return value;
		
	}
	
	public void clickElement(WebElement ele) {
		
		ele.click();
	}
	
	public void setValue(WebElement ele,String value) {
		ele.clear();
		
		ele.sendKeys(value);
	}
	
	public void clickListElements(List<WebElement>ele) {
		
		for(WebElement e:ele) {
			
			clickElement(e);
			
		}
		}
        public void PrintTextFromElements(List<WebElement>elements) {
		
		for(WebElement e:elements) {
			
			System.out.println(e.getText());
			
			
		}
		}
	
	public void SelectDropDownByValue(WebElement element,String Value) {
		
		Select select=new Select(element);
		
		select.selectByValue(Value);
	}
	
	
	

public void switchToChildWindow(String parent) {
		
	Set <String> windowhandles=driver.getWindowHandles();
		
		for(String Window:windowhandles) {
			
			if(!Window.equals(parent)){
				
				driver.switchTo().window(Window);
				
				System.out.println(driver.getTitle());
				
				driver.close();//close child
			}
		
		}
		
		driver.switchTo().window(parent);
		}

   public void ScrollToAnElement(WebElement ele) {
	
	((JavascriptExecutor)driver).executeScript("arguements[0].scrollIntoView();",ele);
}

  public void scrollTillpageEnd() {
	
	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
}


     public void ClickAndSwitchWindows(List<WebElement>ele,String parent) {
	
	for(WebElement e:ele) {
		
	e.click();
	
	switchToChildWindow(parent);
	
	}
}
     public void takeScreenshot() throws IOException {
    	 
    	 SimpleDateFormat simpledateformat=new SimpleDateFormat("dd_MMMM_yyyy_hh_mm_ss");
    	 
    	 String date=simpledateformat.format(new Date());
    	 
    	 File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	 
    	 FileUtils.copyFile(f,new File("./Screenshots/"+date+".png"));
     }
     
     @AfterMethod
     public void afterMethod(ITestResult result) throws IOException {
    	 
    	 if(ITestResult.FAILURE==result.getStatus()) {
    		 
    		Screenshot.takeScreenshot(driver,"Failure",result.getName()) ;
    	 }else
    	 {
    		 Screenshot.takeScreenshot(driver, "SUCCESS",result.getName());
    	 }
     }
     

       

	@AfterTest
	
	public void closeDriver() {
		driver.close();
	}
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
