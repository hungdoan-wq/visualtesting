import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Variables (replace with your test variables or Test Data bindings)
String G_SiteURL = 'https://katalon-demo-cura.herokuapp.com/'
String Username = 'John Doe'
String Password = 'ThisIsNotAPassword'
int G_Timeout = 30

def LoginObject = findTestObject('Page_Login/loginDialog')  // Replace with your login dialog test object path

def landingPageObject = findTestObject('Page_CuraAppointment/div_Appointment') // Replace with your landing page appointment section test object

// Step 1: Open browser and navigate to site URL
WebUI.openBrowser(G_SiteURL)

// Step 2: Maximize browser window
WebUI.maximizeWindow()

// Step 3: Click Make Appointment button on homepage
WebUI.click(findTestObject('Page_CuraHomepage/btn_MakeAppointment'))

// Step 4: Capture element screenshot as checkpoint (Login Dialog Origin)
WebUI.takeElementScreenshotAsCheckpoint("Login Dialog Origin",findTestObject('Object Repository/Page_CURA Healthcare Service/section_Login                Please login to make appointment.                                                                                                                                Demo account'))

// Step 5: Enter username
WebUI.setText(findTestObject('Page_Login/txt_UserName'), Username)

// Step 6: Enter password
WebUI.setText(findTestObject('Page_Login/txt_Password'), Password)

// Step 7: Capture element screenshot as checkpoint (Login Dialog With Data)
WebUI.takeElementScreenshotAsCheckpoint('Login Dialog With Data', findTestObject('Object Repository/Page_CURA Healthcare Service/section_Login                Please login to make appointment.                                                                                                                                Demo account'))

// Step 8: Comment log about login action
WebUI.comment('When he logins to CURA system')

// Step 9: Click login button
WebUI.click(findTestObject('Page_Login/btn_Login'))

// Step 10: Comment log about expected result
WebUI.comment('Then he should be able to login successfully')

// Step 7: Capture element screenshot as checkpoint (Login Dialog With Data)
WebUI.takeElementScreenshotAsCheckpoint('appointment page', findTestObject('Object Repository/Page_CURA Healthcare Service/section_appointment'))

// Step 11: Verify element present on landing page (appointment div)
boolean landingPage = WebUI.verifyElementPresent(landingPageObject, G_Timeout)

// Step 12: Close browser
WebUI.closeBrowser()

// Optionally assert that landingPage is true if you want to fail test case on missing element
assert landingPage == true : 'Appointment section not found on landing page after login'