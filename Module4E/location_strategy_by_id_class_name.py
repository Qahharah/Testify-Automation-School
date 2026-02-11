from appium import webdriver
from appium.options.android import UiAutomator2Options
from appium.webdriver.common.appiumby import AppiumBy
from selenium.webdriver.remote.mobile import Mobile
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException
import time

def handle_notifications_popup(driver):
    for btn_id, label in [
        ("com.android.permissioncontroller:id/permission_allow_button", "Allow"),
        ("com.android.permissioncontroller:id/permission_deny_button", "Don't allow"),
    ]:
        try:
            el = WebDriverWait(driver, 4).until(
                EC.element_to_be_clickable((AppiumBy.ID, btn_id))
            )
            el.click()
            print(f"Clicked: {label}")
            return
        except TimeoutException:
            pass
    print("Notifications popup not shown (or different IDs)")

def main():
    options = UiAutomator2Options()
    options.platform_name = "Android"
    options.automation_name = "UiAutomator2"
    options.device_name = "emulator-5554"
    options.udid = "emulator-5554"
    options.app_package = "com.android.chrome"
    options.app_activity = "com.google.android.apps.chrome.Main"
    options.no_sign = True
    driver = webdriver.Remote("http://127.0.0.1:4723", options=options)
    acceptAndContinue = driver.find_element(AppiumBy.ID,"com.android.chrome:id/terms_accept")
    acceptAndContinue.click()
    addAccountNo = driver.find_element(AppiumBy.ID, "com.android.chrome:id/negative_button")
    addAccountNo.click()
    time.sleep(5)
    posotiveButton = driver.find_element(AppiumBy.ID, "com.android.chrome:id/positive_button")
    posotiveButton.click()
    time.sleep(5)
    permissionControl = driver.find_element(AppiumBy.ID, "com.android.permissioncontroller:id/permission_deny_button")
    permissionControl.click()
    time.sleep(5)
    searchBar = driver.find_element(AppiumBy.ID, "com.android.chrome:id/search_box_text")
    searchBar.send_keys("Qahharat")
    time.sleep(5)
    driver.press_keycode(66)

    time.sleep(5)
    # driver.quit()

if __name__ == "__main__":
    main()