package automationdemo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	

public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
  @FindBy(css="#user-name")
  
     public WebElement username;
  
  @FindBy(css="#password")
    
    public WebElement password;
  
    @FindBy(css="#login-button")
  
     public WebElement login;
    
    @FindBy(xpath="//button[text()='Add to cart']")
    
    public List<WebElement> addToCart;
  
   @FindBy(css="a.shopping_cart_link")
   
   public WebElement cart;
   
	@FindBy(css="div.inventory_item_name")
	
	public List<WebElement> productNames;

	@FindBy(xpath="//button[text()='Remove']")

	public List<WebElement> removeProducts;
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	
      public WebElement SelectFilter;
	
	@FindBy(css="div.inventory_item_price")
	

	public List<WebElement> Prices;
	
	//@FindBy(xpath="//li[@class='social_twitter']/a")
	
	// public WebElement twitterLink;
	
	@FindBy(xpath="//ul[@class='social']/li/a")
	
	public List<WebElement> SocialLinks;
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}




}
