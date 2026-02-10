import time
from appium import webdriver
from appium.options.android import UiAutomator2Options
from appium.webdriver.common.appiumby import AppiumBy
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

def main():
    options = UiAutomator2Options()
    options.platform_name = "Android"
    options.device_name = "emulator-5554"
    options.app = "http://127.0.0.1:9009/Calculator_9.0%20%28827797324%29_APKPure.apk"

    driver = webdriver.Remote(
        command_executor="http://127.0.0.1:4723",
        options=options
    )

    print("App installed and launched from server")
    time.sleep(10)

    driver.quit()

if __name__ == "__main__":
    main()