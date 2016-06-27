package tatocwithoutfindelement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;


@SuppressWarnings("deprecation")
public class basic {
	public static void main(String args[]) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();

		// A "base url", used by selenium to resolve relative URLs
		 String baseurl = "http://10.0.1.86";

		// Create the Selenium implementation
		@SuppressWarnings("deprecation")
		Selenium selenium = new WebDriverBackedSelenium(driver, baseurl);
		
		selenium.open(baseurl);
		
		selenium.click("//a[contains(text(),'/tatoc')]");
		selenium.click("//a[contains(text(),'Basic Course')]");
		selenium.click("class=greenbox");
		String s1 = selenium.getAttribute("//div[(@id='answer')]@class");
		System.out.println(s1);
		selenium.selectFrame("main");
		selenium.selectFrame("child");
		String s2 = selenium.getAttribute("//div[(@id='answer')]@class");
		System.out.println(s2);
		while(true) {
			
			if(s1.equals(s2)) break;
			else
			{
				selenium.selectFrame("relative=up");
				selenium.click("//a[contains(text(),'Repaint Box 2')]");
				
			}
			
			selenium.selectFrame("child");
			s2 = selenium.getAttribute("//div[(@id='answer')]@class");
		}
		selenium.selectFrame("relative=up");
		selenium.click("//a[contains(text(),'Proceed')]");
		
		selenium.dragAndDropToObject("//div[(@id='dragbox')]", "//div[(@id='dropbox')]");
		selenium.click("//a[contains(text(),'Proceed')]");
		
		
		//popup handle
		selenium.click("//a[contains(text(),'Launch Popup Window')]");
		//selenium.selectWindow("Popup - Basic Course - T.A.T.O.C");
		selenium.selectPopUp("Popup - Basic Course - T.A.T.O.C");
		//selenium.windowFocus();
		System.out.println("chala gaya");
		//Thread.sleep(3000); 
		selenium.click("//input[(@id='name')]");
		selenium.type("//input[(@id='name')]","tara");
		selenium.click("//input[(@id='submit')]");
		System.out.println("aa gaya");		
		selenium.selectWindow(null);
		selenium.click("//a[contains(text(),'Proceed')]");
		
		
		//cookie
		selenium.click("//a[contains(text(),'Generate Token')]");
		String token = selenium.getText("id=token");
		token = token.substring(7);
		selenium.createCookie("Token="+token+"","path=http://10.0.1.86/tatoc/basic/cookie, max_age=60");
		selenium.click("//a[contains(text(),'Proceed')]");
				

	}

}
