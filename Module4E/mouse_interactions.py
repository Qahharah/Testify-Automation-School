from appium import webdriver
from appium.options.android import UiAutomator2Options
from appium.webdriver.common.appiumby import AppiumBy
import time
from selenium.webdriver import ActionChains

def main():
    options = UiAutomator2Options()
    options.platform_name = "Android"
    options.automation_name = "UiAutomator2"
    options.device_name = "emulator-5554"
    options.app = "http://127.0.0.1:9009/Calculator_9.0%20%28827797324%29_APKPure.apk"
    
    
    driver = webdriver.Remote(
        "http://127.0.0.1:4723", options=options
        )
    num1 = driver.find_element(
        AppiumBy.ID, "com.google.android.calculator:id/digit_1"
        )
    actions = ActionChains(driver)
    actions.move_to_element(num1)
    actions.click()
    actions.perform()


    time.sleep(5)
    driver.quit()

print("Script has completed successfully")


if __name__ == "__main__":
    main()