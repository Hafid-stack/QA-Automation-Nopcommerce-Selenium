# QA Automation Framework — NopCommerce (Selenium + Java)

An industry-grade UI and API test automation framework built against the [NopCommerce](https://automationexercise.com) e-commerce demo site. Designed to simulate a realistic onboarding assignment for a junior QA engineer joining a product team.

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java |
| UI Automation | Selenium WebDriver |
| API Testing | REST Assured |
| Test Framework | TestNG |
| Build Tool | Maven |
| Design Pattern | Page Object Model (POM) |
| IDE | IntelliJ IDEA |
| Version Control | Git & GitHub |

---

## Project Structure

```
src/
├── main/java/
│   ├── base/
│   │   ├── BasePage.java          # Shared WebDriver actions (click, type, wait)
│   │   └── BaseFlow.java          # Shared reusable flow logic
│   ├── pages/                     # Page Object classes (one per page)
│   │   ├── HomePage.java
│   │   ├── LoginPage.java
│   │   ├── RegisterPage.java
│   │   ├── ProductsPage.java
│   │   ├── ProductDetailPage.java
│   │   ├── ViewCartPage.java
│   │   ├── CheckOutPage.java
│   │   ├── PaymentPage.java
│   │   ├── PaymentDonePage.java
│   │   ├── ContactUsPage.java
│   │   ├── CategoryProductsPage.java
│   │   ├── ProductBrandPage.java
│   │   ├── AccountCreatedPage.java
│   │   ├── DeletedAccountPage.java
│   │   └── TestCasesPage.java
│   ├── utilitypages/              # Shared UI components
│   │   ├── HeaderUpperPage.java
│   │   ├── FooterPage.java
│   │   └── LeftSideBarPage.java
│   ├── flows/                     # Reusable multi-step workflows
│   │   ├── RegisterUserFlow.java
│   │   └── AddProductToCartFlow.java
│   ├── models/                    # Data models (POJOs)
│   │   ├── UserData.java
│   │   ├── NewUserSingup.java
│   │   ├── ValidUserDataToLogin.java
│   │   ├── CartItem.java
│   │   ├── AddressDelivery.java
│   │   └── FakeCardData.java
│   └── testdata/
│       ├── UserFactory.java       # Builds test user objects
│       └── Generator.java         # Random data generation
│
└── test/java/
    ├── base/
    │   ├── BaseTest.java          # Driver setup/teardown, full browser
    │   └── BaseFastTest.java      # Lightweight base for faster tests
    ├── api/tests/                 # REST API test cases
    │   ├── GetAllProductsTest.java
    │   ├── GetBrandsListTest.java
    │   ├── PostProductsListTest.java
    │   ├── PutBrandsListTest.java
    │   └── SearchProductTest.java
    └── ui/tests/
        ├── headers/               # Header navigation tests
        ├── login/                 # Login/logout test scenarios
        ├── register/              # User registration scenarios
        ├── products/              # Product browsing, search, cart
        ├── placeorder/            # End-to-end checkout flows
        └── onetimers/             # Contact, subscription, misc
```

---

## Test Coverage

### UI Tests

**Authentication**
- Register new user with valid data
- Register with empty fields (validation check)
- Register with an already-used email
- Login with valid credentials
- Login with incorrect credentials
- Login with empty fields
- Login and logout flow

**Products & Cart**
- Search for a product
- Browse products by category
- Browse products by brand
- Navigate to product detail page
- Add product to cart
- Update product quantity in cart
- Remove product from cart

**Checkout / Place Order**
- Place order after logging in
- Place order after registering
- Register during checkout flow

**Navigation & UI**
- Upper header elements and register button
- Lower header navigation links
- Subscription from home page
- Subscription from cart page
- Contact Us form submission
- Test Cases page navigation

### API Tests
- GET all products list
- GET brands list
- POST to products list (negative — method not allowed)
- PUT to brands list (negative — method not allowed)
- POST search product by name

---

## Design Highlights

**Page Object Model (POM)** — Every page of the application has a dedicated class. Test logic is fully separated from element locators and UI interactions.

**Reusable Flows** — Common multi-step actions (register a user, add product to cart) are extracted into `flows/` so tests stay clean and DRY.

**Data Models** — Test data is represented as typed Java objects (`UserData`, `CartItem`, `FakeCardData`, etc.) rather than raw strings scattered across tests.

**Test Data Factory** — `UserFactory` and `Generator` generate randomized test data, ensuring tests don't depend on hardcoded values or shared state.

**Dual Base Test Classes** — `BaseTest` handles full browser setup/teardown; `BaseFastTest` provides a lighter alternative for tests that don't need the full setup cycle.

---

## How to Run

### Prerequisites
- Java 11+
- Maven
- Chrome browser + matching ChromeDriver

### Run all tests
```bash
mvn test
```

### Run a specific test class
```bash
mvn -Dtest=LoginUserTest test
```

### Run by group/suite
Configure your `testng.xml` suite file and run:
```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

## Key Learnings

This project was built as a structured learning exercise covering:
- Implementing POM architecture from scratch
- Writing maintainable, modular test code in Java
- Separating concerns: pages, flows, models, and test data
- Testing both UI workflows and REST API endpoints
- Using TestNG annotations, assertions, and test organization
- Managing a real project with Git version control across 40+ commits

---

## Author

**Abdelhafid Idbahamd**
[LinkedIn](https://www.linkedin.com/in/your-linkedin) • [GitHub](https://github.com/Hafid-stack)
