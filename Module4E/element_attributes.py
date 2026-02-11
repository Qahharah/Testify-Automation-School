from appium import webdriver
from appium.options.android import UiAutomator2Options
from appium.webdriver.common.appiumby import AppiumBy
from selenium.webdriver.common.by import By
from selenium.webdriver.remote.mobile import Mobile
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException
import time


def main():
    options = UiAutomator2Options()
    options.platform_name = "Android"
    options.automation_name = "UiAutomator2"
    options.device_name = "emulator-5554"
    options.app_package = "com.google.android.dialer"
    options.app_activity = "com.android.dialer.main.impl.MainActivity"
    options.no_sign = True
    
    driver = webdriver.Remote(
        "http://127.0.0.1:4723", options=options
        )
    add_favourites_button = driver.find_element(
        AppiumBy.ID, "com.google.android.dialer:id/empty_content_view_action"
        )
    add_favourites_button.get_attribute("Package")
    print("Adding favourites...", add_favourites_button.get_attribute("Package"))
    print("resource-id", add_favourites_button.get_attribute("resource-id"))

    time.sleep(10)

    driver.quit()


if __name__ == "__main__":
    main()