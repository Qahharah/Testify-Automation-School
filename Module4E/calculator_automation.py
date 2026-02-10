from appium import webdriver
from appium.options.android import UiAutomator2Options
from appium.webdriver.common.appiumby import AppiumBy
import time

def main():
    options = UiAutomator2Options()
    options.platform_name = "Android"
    options.device_name = "emulator-5554"
    options.automation_name = "UiAutomator2"
    options.app_package = "com.google.android.calculator"
    options.app_activity = "com.android.calculator2.Calculator"

    driver = webdriver.Remote(
        "http://127.0.0.1:4723",
        options=options
    )

    # Locate elements
    one = driver.find_element(
        AppiumBy.ID,
        "com.google.android.calculator:id/digit_1"
    )

    two = driver.find_element(
        AppiumBy.ID,
        "com.google.android.calculator:id/digit_2"
    )

    plus = driver.find_element(
        AppiumBy.ACCESSIBILITY_ID,
        "plus"
    )

    equals = driver.find_element(
        AppiumBy.ACCESSIBILITY_ID,
        "equals"
    )

    # Perform calculation: 1 + 2 =
    one.click()
    plus.click()
    two.click()
    equals.click()

    time.sleep(3)
    driver.quit()

if __name__ == "__main__":
    main()