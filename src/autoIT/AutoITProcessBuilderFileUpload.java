package autoIT;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoITProcessBuilderFileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.monsterindia.com/seeker/registration");

		Thread.sleep(3000);

		// Scrolling to keep upload process in view

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement random = driver.findElement(By.xpath("//h3[text()='Preferred Industry']"));

		js.executeScript("arguments[0].scrollIntoView(true)", random);

		driver.findElement(By.xpath("//label[@class='upload-file']")).click();

		// Path of the file to be uploaded

		String filepath = "D:\\AbhishekBhardwaj_QA.docx";

		String autoItPATH = "E:\\UploaderScript.exe";
		
		// LIST <String> to be passed as parameter in Processbuilder should have:
				// path to the autoIt .exe file and all the parameters
		
		List<String> allscripts = Arrays.asList(autoItPATH,filepath);
		
		// using ProcessBuilder().exe

		new ProcessBuilder(allscripts).start();

		Thread.sleep(3000);
		driver.quit();

	}

}
