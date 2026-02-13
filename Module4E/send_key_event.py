from appium import webdriver
from appium.options.android import UiAutomator2Options
from appium.webdriver.common.appiumby import AppiumBy
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
        AppiumBy.XPATH, '//android.widget.Button[@text="SKIP"]'
        )

    skip_button.click()
    time.sleep(5)
    search_button = driver.find_element(
        AppiumBy.ID, "com.google.android.apps.maps:id/search_omnibox_text_box"
        )
    search_button.click()
    enter_text = driver.find_element(
        AppiumBy.ID, "com.google.android.apps.maps:id/search_omnibox_edit_text"
        )
    enter_text.send_keys("Abuja")
    time.sleep(5)
    enter_text.clear()
    time.sleep(5)
    
    driver.quit()


if __name__ == "__main__":
    main()