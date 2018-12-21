package utility;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotLibrary {

	public static void ScreenshotTest(WebDriver driver, String Screenshot) 
	{
		try 
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("./Screenshots/" + Screenshot + ".png"));
		}

		catch (Exception e) {

			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
	}

	
	}

