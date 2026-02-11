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
    options.app_package = "com.google.android.dialer"
    options.app_activity = "com.android.dialer.main.impl.MainActivity"
    options.no_sign = True

    driver = webdriver.Remote(
        command_executor="http://127.0.0.1:4723",
        options=options
    )


    contact_button = driver.find_element(
        AppiumBy.XPATH, '(//android.widget.FrameLayout[@resource-id="com.google.android.dialer:id/navigation_bar_item_icon_container"])[3]'
        )
    contact_button.click()
    time.sleep(5)
    newcontact = driver.find_element(
        AppiumBy.XPATH, '//android.widget.TextView[@resource-id="com.google.android.dialer:id/empty_content_view_action"]'
        )
    newcontact.click()
    time.sleep(5)
    cancel = driver.find_element(
        AppiumBy.XPATH, '//android.widget.ImageButton[@content-desc="Cancel"]'
        )
    cancel.click()



    time.sleep(5)
    driver.quit()

if __name__ == "__main__":
    main()