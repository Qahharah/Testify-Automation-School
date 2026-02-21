import re
import time
from appium.webdriver.common.appiumby import AppiumBy
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from utils.driver_setup import get_driver
from selenium.webdriver.common.actions.action_builder import ActionBuilder
from selenium.webdriver.common.actions.pointer_input import PointerInput


def extract_price(text):
    return float(re.sub(r"[^\d.]", "", text))


def test_full_flow_steps():

    driver = get_driver()
    wait = WebDriverWait(driver, 20)

    # Navigate to Login

    wait.until(
        EC.element_to_be_clickable(
            (AppiumBy.ACCESSIBILITY_ID, "open menu")
        )
    ).click()

    wait.until(
        EC.element_to_be_clickable(
            (AppiumBy.ACCESSIBILITY_ID, "menu item log in")
        )
    ).click()

    # Negative Tests

    # Empty login attempt
    wait.until(
        EC.element_to_be_clickable(
            (AppiumBy.ACCESSIBILITY_ID, "Login button")
        )
    ).click()

    username_field = wait.until(
        EC.presence_of_element_located(
            (AppiumBy.ACCESSIBILITY_ID, "Username input field")
        )
    )
    assert username_field.is_displayed()

    # Invalid password
    username_field.clear()
    username_field.send_keys("bob@example.com")

    driver.find_element(
        AppiumBy.ACCESSIBILITY_ID,
        "Password input field"
    ).send_keys("wrongpass")

    driver.find_element(
        AppiumBy.ACCESSIBILITY_ID,
        "Login button"
    ).click()

    wait.until(
        EC.presence_of_element_located(
            (AppiumBy.ACCESSIBILITY_ID, "Username input field")
        )
    )

    # Valid Login

    username_field.clear()
    username_field.send_keys("bob@example.com")

    password_field = driver.find_element(
        AppiumBy.ACCESSIBILITY_ID,
        "Password input field"
    )
    password_field.clear()
    password_field.send_keys("10203040")

    driver.find_element(
        AppiumBy.ACCESSIBILITY_ID,
        "Login button"
    ).click()

    # Assert Products Page

    wait.until(
        EC.presence_of_element_located(
            (AppiumBy.XPATH, "//android.widget.TextView[@text='Products']")
        )
    )

    # Sort page by Price Ascending

    wait.until(
        EC.element_to_be_clickable(
            (AppiumBy.ACCESSIBILITY_ID, "sort button")
        )
    ).click()

    wait.until(
        EC.element_to_be_clickable(
            (AppiumBy.ACCESSIBILITY_ID, "priceAsc")
        )
    ).click()

    prices = wait.until(
        EC.presence_of_all_elements_located(
            (AppiumBy.XPATH, "//android.widget.TextView[contains(@text,'$')]")
        )
    )

    extracted_prices = [extract_price(p.text) for p in prices]
    assert extracted_prices == sorted(extracted_prices)

    # Add all Items and give 5 star review

    total_items = len(
        wait.until(
            EC.presence_of_all_elements_located(
                (AppiumBy.ACCESSIBILITY_ID, "store item")
            )
        )
    )

    for i in range(total_items):

        store_items = wait.until(
            EC.presence_of_all_elements_located(
                (AppiumBy.ACCESSIBILITY_ID, "store item")
            )
        )

        store_items[i].find_element(
            AppiumBy.XPATH,
            "./android.view.ViewGroup[1]"
        ).click()

        wait.until(
            EC.presence_of_element_located(
                (AppiumBy.ACCESSIBILITY_ID, "Add To Cart button")
            )
        )

        # Review second product
        if i == 1:
            wait.until(
                EC.element_to_be_clickable(
                    (AppiumBy.XPATH, "//android.view.ViewGroup[@content-desc='review star 5']")
                )
            ).click()

            wait.until(
                EC.element_to_be_clickable(
                    (AppiumBy.ACCESSIBILITY_ID, "Close Modal button")
                )
            ).click()

        wait.until(
            EC.element_to_be_clickable(
                (AppiumBy.ACCESSIBILITY_ID, "Add To Cart button")
            )
        ).click()

        driver.back()

        wait.until(
            EC.presence_of_element_located(
                (AppiumBy.XPATH, "//android.widget.TextView[@text='Products']")
            )
        )

    # Open Cart

    wait.until(
        EC.element_to_be_clickable(
            (AppiumBy.ACCESSIBILITY_ID, "cart badge")
        )
    ).click()

    wait.until(
        EC.presence_of_element_located(
            (AppiumBy.XPATH, "//android.widget.TextView[contains(@text,'My Cart')]")
        )
    )

    # Assert Items Added to Cart

    badge_number = wait.until(
        EC.presence_of_element_located(
            (AppiumBy.XPATH,
             "//android.view.ViewGroup[@content-desc='cart badge']//android.widget.TextView")
        )
    )

    initial_count = int(badge_number.text)

    assert initial_count == total_items

    print(f"✔ You currently have {initial_count} items in your cart.")

    # Remove 2 Items from the Cart

    for _ in range(2):
        remove_buttons = wait.until(
            EC.presence_of_all_elements_located(
                (AppiumBy.ACCESSIBILITY_ID, "remove item")
            )
        )
        remove_buttons[0].click()
        time.sleep(1)

    # Assert Remaining Items in the Cart

    expected_remaining = total_items - 2

    badge_number = wait.until(
        EC.presence_of_element_located(
            (AppiumBy.XPATH,
             "//android.view.ViewGroup[@content-desc='cart badge']//android.widget.TextView")
        )
    )

    remaining_count = int(badge_number.text)

    assert remaining_count == expected_remaining

    print(f"✔ After removing 2 items, you now have {remaining_count} items remaining in your cart.")

    # Click Proceed To Checkout button

    wait.until(
        EC.element_to_be_clickable(
            (AppiumBy.ACCESSIBILITY_ID, "Proceed To Checkout button")
        )
    ).click()

    # Fill Shipping Details

    wait.until(
        EC.presence_of_element_located(
            (AppiumBy.ACCESSIBILITY_ID, "Full Name* input field")
        )
    ).send_keys("Qahharat Ibrahim")

    driver.find_element(
        AppiumBy.ACCESSIBILITY_ID,
        "Address Line 1* input field"
    ).send_keys("12 Solana Street")

    driver.find_element(
        AppiumBy.ACCESSIBILITY_ID,
        "Address Line 2 input field"
    ).send_keys("Apartment 7b")

    driver.find_element(
        AppiumBy.ACCESSIBILITY_ID,
        "City* input field"
    ).send_keys("Lagos")

    driver.find_element(
        AppiumBy.ACCESSIBILITY_ID,
        "State/Region input field"
    ).send_keys("Lagos State")

    driver.find_element(
        AppiumBy.ACCESSIBILITY_ID,
        "Zip Code* input field"
    ).send_keys("100001")

    driver.find_element(
        AppiumBy.ACCESSIBILITY_ID,
        "Country* input field"
    ).send_keys("Nigeria")

    print("✔ Shipping details filled successfully.")

    # Proceed to Payment

    wait.until(
        EC.element_to_be_clickable(
            (AppiumBy.XPATH, "//android.view.ViewGroup[@content-desc='To Payment button']")
        )
    ).click()
    
    # Assert Payment Page

    wait.until(
        EC.presence_of_element_located(
            (AppiumBy.XPATH, "//android.widget.TextView[contains(@text,'Payment')]")
        )
    )
    
    # Fill in Payment Details

    wait.until(
        EC.presence_of_element_located(
            (AppiumBy.ACCESSIBILITY_ID, "Full Name* input field")
        )
    ).clear()

    driver.find_element(
        AppiumBy.ACCESSIBILITY_ID,
        "Full Name* input field"
    ).send_keys("Qahharat Ibrahim")

    driver.find_element(
        AppiumBy.ACCESSIBILITY_ID,
        "Card Number* input field"
    ).send_keys("4111111111111111")

    driver.find_element(
        AppiumBy.ACCESSIBILITY_ID,
        "Expiration Date* input field"
    ).send_keys("12/30")

    driver.find_element(
        AppiumBy.ACCESSIBILITY_ID,
        "Security Code* input field"
    ).send_keys("123")
    
    wait.until(
        EC.element_to_be_clickable(
            (AppiumBy.ACCESSIBILITY_ID, "Review Order button")
        )
    ).click()
    
    
    # Review Order

    # Click Review Order
    wait.until(
        EC.element_to_be_clickable(
            (AppiumBy.ACCESSIBILITY_ID, "Review Order button")
        )
    ).click()

    # Confirm Review page loaded
    review_container = wait.until(
        EC.presence_of_element_located(
            (AppiumBy.ACCESSIBILITY_ID,
             "checkout review order screen")
        )
    )

    max_scrolls = 5
    scroll_count = 0

    while scroll_count < max_scrolls:
        try:
            driver.find_element(
                AppiumBy.ACCESSIBILITY_ID,
                "Place Order button"
            )
            break
        except:
            driver.execute_script("mobile: scrollGesture", {
                "elementId": review_container.id,
                "direction": "down",
                "percent": 0.8
            })
            scroll_count += 1

    wait.until(
        EC.presence_of_element_located(
            (AppiumBy.ACCESSIBILITY_ID, "Place Order button")
        )
    )
    
    # Place Order

    wait.until(
        EC.element_to_be_clickable(
            (AppiumBy.ACCESSIBILITY_ID, "Place Order button")
        )
    ).click()

    # Assert Success Message
    
    success_message = wait.until(
    EC.presence_of_element_located(
        (AppiumBy.XPATH,
         "//android.widget.TextView[@text='Thank you for your order']")
         )
    )
    assert success_message.is_displayed()

    wait.until(
        EC.element_to_be_clickable(
            (AppiumBy.ACCESSIBILITY_ID, "Continue Shopping button")
        )
    ).click()
    
    time.sleep(5)


    driver.quit()