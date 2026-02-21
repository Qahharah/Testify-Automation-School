"""
driver_setup.py

This module is responsible for:
- Configuring Appium capabilities
- Creating and returning a driver instance
- Installing and launching the mobile application
"""

import os
from appium import webdriver
from appium.options.android import UiAutomator2Options


def get_driver():
    """
    Creates and returns an Appium driver instance.

    Returns:
        driver (WebDriver): Active Appium driver session
    """

    # Create UiAutomator2 options object
    options = UiAutomator2Options()
    options.platform_name = "Android"
    options.device_name = "emulator-5554"
    options.automation_name = "UiAutomator2"

    # Absolute path to the APK inside the project
    project_root = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    app_path = os.path.join(project_root, "app", "my_demo_app.apk")

    # Tell Appium which app to install
    options.app = app_path

    # Create driver session
    driver = webdriver.Remote(
        command_executor="http://127.0.0.1:4723",
        options=options
    )

    return driver