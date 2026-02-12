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
    options.app_package = "com.google.android.apps.maps"
    options.app_activity = "com.google.android.maps.MapsActivity"
    options.no_sign = True
    
    driver = webdriver.Remote(
        "http://127.0.0.1:4723", options=options
        )
    skip_button = driver.find_element(
        AppiumBy.XPATH, '//android.widget.LinearLayout[@resource-id="com.google.android.apps.maps:id/compass_container"]'
        )
    skip_button.click()

    time.sleep(10)

    driver.quit()


if __name__ == "__main__":
    main()