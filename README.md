# MobileTestingCH

Android testing framework using Appium for the trainline app

Has the capability to perform local tests on real device or emulator as well as emulators generated in SauceLabs infrastructure

### Required environment variables:
- SauceLabsKey: Cryptographic key for saucelabs account
- SauceLabsUser: SauceLabs username 
- AppiumTestisLocal: (boolean) 0: appium tests to run on sauce labs. 1: tests to run locally. 

To run locally an appium server must be running at http://127.0.0.1:4723/wd/hub. The local capabilities are set for a Xiaomi MiA1 with android 9.0

### Java tools used
- Junit(4.13)
- Cucumber(5.4.1)
- Selenium(3.141.59)
- Appium(7.3.0)
- Monochromata reporting plugin(4.0.28)

### Reporting
This framework uses Cucumber pretty report from damianszczepanik https://github.com/damianszczepanik/cucumber-reporting . It allows reporting in HTML format to review locally or in a CI/CD environment.
