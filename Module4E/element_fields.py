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
    options.udid = "emulator-5554"
    options.app_package = "com.google.android.dialer"
    options.app_activity = "com.android.dialer.main.impl.MainActivity"
    options.no_sign = True
    
    driver = webdriver.Remote(
        "http://127.0.0.1:4723", options=options
        )
    addFovoriteButton = driver.find_element(AppiumBy.ID, "com.google.android.dialer:id/empty_content_view_action")


    print("text", addFovoriteButton.text)
    print("size", addFovoriteButton.size)
    print("Name", addFovoriteButton.tag_name)
    print("Location", addFovoriteButton.location)
    print("Rectangle", addFovoriteButton.rect)
    print("Is Enabled", addFovoriteButton.is_enabled())
    print("Is Selected", addFovoriteButton.is_selected())
    print("Is Displayed", addFovoriteButton.is_displayed())

    contact = driver.find_element(
        AppiumBy.ID, "com.google.android.dialer:id/tab_contacts"
        )
    print("text", contact.text)
    print("size", contact.size)
    print("Name", contact.tag_name)
    print("Location", contact.location)
    print("Rectangle", contact.rect)
    print("Is Enabled", contact.is_enabled())
    print("Is Selected", contact.is_selected())
    print("Is Displayed", contact.is_displayed())

    contact.click()

    createNewContactButton = driver.find_element(
        AppiumBy.ID, "com.google.android.dialer:id/empty_content_view_action"
        )
    print("text", createNewContactButton.text)
    print("size", createNewContactButton.size)
    print("Name", createNewContactButton.tag_name)
    print("Location", createNewContactButton.location)
    print("Rectangle", createNewContactButton.rect)
    print("Is Enabled", createNewContactButton.is_enabled())
    print("Is Selected", createNewContactButton.is_selected())
    print("Is Displayed", createNewContactButton.is_displayed())
    time.sleep(4)


    driver.quit()


if __name__ == "__main__":
    main()