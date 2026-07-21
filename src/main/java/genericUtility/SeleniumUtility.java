package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class SeleniumUtility {

	/**
	 * this is a generic method to access the web application
	 * @param driver
	 * @param URL
	 */
	public void accessApplication(WebDriver driver, String URL) {
		driver.get(URL);
	}

	/**
	 * this is a generic method to maximize the browser
	 * @param driver
	 */
	public void maxmizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * this is a generic method to provide implicit wait
	 * @param driver
	 * @param maxTime
	 */
	public void implicitWait(WebDriver driver, int maxTime) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(maxTime));
	}

	/**
	 * this is a generic method to refresh the webpage
	 * @param driver
	 */
	public void refreshWebpage(WebDriver driver) {
		driver.navigate().refresh();
	}

	/**
	 * this is a generic method to close the browser
	 * @param driver
	 */
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}

	///////////////// Handling Alerts ///////////////////
	
	/**
	 * this is a generic method to accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();		
	}
	
	/**
	 * this is a generic method to cancel the alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	
	///////////////// Handling Frames ///////////////
	
	/**
	 * this is a generic method to switch the control inside a frame using frameIndex
	 * @param driver
	 * @param frameIndex
	 */
	public void switchToFrameUsingIndex(WebDriver driver, int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * this is a generic method to switch the control inside a frame using nameOrId
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrameUsingNameOrId(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	
	///////////////// Handling DropDown///////////////
	
	/**
	 * this is a generic method to select an option in dropdown using index 
	 * @param dropdownEle
	 * @param index
	 */
	public void selectOptionByIndex(WebElement dropdownEle,int index) {
		Select s = new Select(dropdownEle);
		s.selectByIndex(index);
	}
	
	/**
	 * this is a generic method to select an option in dropdown using value attribute
	 * @param dropdownEle
	 * @param valueAttribute
	 */
	public void selectOptionByValue(WebElement dropdownEle, String valueAttribute) {
		Select s  = new Select(dropdownEle);
		s.selectByValue(valueAttribute);
	}
	
	/**
	 * this is a generic method to select an option in dropdown using visible text 
	 * @param dropdownEle
	 * @param visibleText
	 */
	public void selectOptionByVisibleText(WebElement dropdownEle, String visibleText) {
		Select s = new Select(dropdownEle);
		s.selectByVisibleText(visibleText);
	}
	
	
	///////////////// Handling Mouse Actions///////////////

	/**
	 * this is a generic method to perform mouse hovering action
	 * @param driver
	 * @param element
	 */
	public void mouseHovering(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	/**
	 * this is a generic method to perform drag and drop operation
	 * @param driver
	 * @param srcEle
	 * @param destEle
	 */
	public void dragAndDropOperation(WebDriver driver, WebElement srcEle, WebElement destEle) {
		Actions a = new Actions(driver);
		a.dragAndDrop(srcEle, destEle).perform();
	}
	
	/**
	 * this is a generic method to perform right click operation
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * this is a generic method to perform window scrolling operation
	 * @param driver
	 * @param element
	 */
	public void scrollWebpage(WebDriver driver,WebElement element) {
		Actions a = new Actions(driver);
		a.scrollToElement(element).perform();
	}
	
	/**
	 * this is a generic method to perform window scrolling using javascript
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollUsingJavascript(WebDriver driver, int x, int y) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy("+x+","+y+");");
	}
	
	
	///////////////// Handling File Upload ///////////////
	
	
	/**
	 * this is a generic method to upload a file to webpage 
	 * @param fileUploadEle
	 * @param filePath
	 */
	public void uploadFileToWebpage(WebElement fileUploadEle, String filePath) {
		fileUploadEle.sendKeys(filePath);
	}
	
	
	///////////////// Handling multiple when 2 tabs ///////////////
	
	/**
	 * this is a generic method to switch the control to second tab/window
	 * @param driver
	 */
	public void switchControlToSecondTab(WebDriver driver) {
		String pid = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();
		for(String id:allIds) {
			if(!id.equals(pid))
			driver.switchTo().window(id);
		}
	}
	
	
	
	///////////////// Webpage ScreenShot///////////////
	
	/**
	 * this is a generic method to capture webpage screenshot 
	 * @param driver
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public String takeWebpageScreenshot(WebDriver driver,String fileName) throws IOException {
	
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\Screenshots\\"+fileName+".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath(); 			// used in listeners 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
