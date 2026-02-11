from appium import webdriver
from appium.webdriver.common.appiumby import  AppiumBy
from  selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from appium.options.android import UiAutomator2Options
import time

def main():
    options = UiAutomator2Options()
    options.platform_name = "Android"
    options.automation_name = "UiAutomator2"
    options.device_name = "emulator-5554"
    options.udid = "emulator-5554"
    options.app_package = "com.google.android.calculator"
    options.app_activity = "com.android.calculator2.Calculator"
    
    driver = webdriver.Remote(
        "http://127.0.0.1:4723", options=options
        )
    
    num3 = driver.find_element(
        AppiumBy.ACCESSIBILITY_ID, "3"
        )
    num3.click()

    multiple = driver.find_element(
        AppiumBy.ACCESSIBILITY_ID, "multiply"
        )
    multiple.click()

    num4 = driver.find_element(
        AppiumBy.ACCESSIBILITY_ID, "4"
        )
    num4.click()

    num1 = driver.find_element(AppiumBy.ACCESSIBILITY_ID, "1")
    num1.click()

    time.sleep(5)
    driver.quit()


if __name__ == "__main__":
    main()