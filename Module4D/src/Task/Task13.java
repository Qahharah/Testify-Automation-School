package Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Task13 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // 1. Open the EXACT dropdown page
            driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");

            // 2. Locate COUNTRY dropdown (first select on the page)
            WebElement countryDropdown =
                    driver.findElement(By.xpath("(//select)[1]"));
            Select country = new Select(countryDropdown);
            country.selectByVisibleText("Nigeria");

            // 3. Locate MONTHS dropdown (second select on the page)
            WebElement monthDropdown =
                    driver.findElement(By.xpath("(//select)[2]"));
            Select months = new Select(monthDropdown);

            if (!months.isMultiple()) {
                throw new RuntimeException("Months dropdown is not multi-select");
            }

            // 4. Select January, February, March
            months.selectByVisibleText("January");
            months.selectByVisibleText("February");
            months.selectByVisibleText("March");

            // 5. Verification
            List<WebElement> selectedMonths = months.getAllSelectedOptions();
            if (selectedMonths.size() != 3) {
                throw new RuntimeException("Month selection failed");
            }

            System.out.println("Task 13 completed successfully");

        } finally {
            // Leave open briefly for visual confirmation
            // driver.quit();
        }
    }
}
