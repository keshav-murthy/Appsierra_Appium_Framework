
package base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import commons.ResourceReader;
import configurations.Configs;
import configurations.sections.AndroidCapability;
import configurations.sections.AppDetails;
import configurations.sections.BrowserStack;
import configurations.sections.DriverDetails;
import configurations.sections.IosCapability;
import configurations.sections.Timeout;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import listeners.ListenerTest;
import listeners.LoggerEventListener;
import listeners.MyScreenRecorder;
import pages.PageObjectManager;
import pages2.PageObjectManager2;

@Listeners(ListenerTest.class)
public class TestBase {
	private static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	private static Logger log = LogManager.getLogger(TestBase.class);
	private static AppiumDriverLocalService server;
	public static AppiumDriver driver;
	public PageObjectManager pages;
	public PageObjectManager2 pages2;
	public AppiumServiceBuilder builder = new AppiumServiceBuilder();

	@Parameters({ "deviceName", "osVersion", "port" })
	@BeforeTest
	public void invokingAppiumServer(String deviceName, String osVersion, String port) throws IOException {
		Configs.loadEnvironmentConfiguration();
//		startServer(port);
		if (DriverDetails.platform.equalsIgnoreCase("browserstack")) {
			log.info("Starting Browserstack server");
		} else {
			server = getAppiumService(Integer.parseInt(port));
			if (!checkIfAppiumServerIsRunning(Integer.parseInt(port))) {
				log.info("appium server is not running locally");
				log.info("starting server");
				server.start();
				log.info("server has been started");
				server.clearOutPutStreams();
			} else {
				log.info("server is already running");
			}
		}
		driver = getDriver(deviceName, osVersion, port);
		EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new LoggerEventListener());
		pages = new PageObjectManager(driver);
		pages2 = new PageObjectManager2(driver);
	}

//	@Parameters({ "deviceName", "osVersion", "port" })
//	@BeforeMethod
	public void initialize(String deviceName, String osVersion, String port) throws Exception {
		driver = getDriver(deviceName, osVersion, port);
		EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new LoggerEventListener());
		pages = new PageObjectManager(driver);
		pages2 = new PageObjectManager2(driver);
	}

//	@AfterMethod
	public void tearDown() throws Exception {
		MyScreenRecorder.stopRecording();
		log.info("closing driver");
		driver.closeApp();
//		driver.close();
//		driver.quit();
//		driver = null;
	}

	@AfterTest
	public void stopAppiumServer() throws Exception {
		if (DriverDetails.platform.equalsIgnoreCase("browserstack")) {
			log.info("Stopping browserstack session");
		} else {
			server.stop();
			log.info("stopped server");
		}
		MyScreenRecorder.stopRecording();
		log.info("closing driver");
		driver.closeApp();
	}

	public AppiumDriver getDriver(String deviceName, String platformVersion, String port) {
		if (driver != null) {
			return driver;
		}
		desiredCapabilities = new DesiredCapabilities();
		AppiumDriver driver = null;
		switch (DriverDetails.platform.toLowerCase()) {
		case "android":
			desiredCapabilities.setCapability("automationName", "Appium");
			desiredCapabilities.setCapability("device", deviceName);
			desiredCapabilities.setCapability("platformVersion", platformVersion);
			desiredCapabilities.setCapability("appPackage", AndroidCapability.appPackage);
			desiredCapabilities.setCapability("appActivity", AndroidCapability.appActivity);
			desiredCapabilities.setCapability("app", appPath(AppDetails.androidAppName));
			desiredCapabilities.setCapability("avdLaunchTimeout", Timeout.avdLaunchTimeout);
			try {
				driver = new AndroidDriver(new URL("http://127.0.0.1:" + port + "/wd/hub"), desiredCapabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			break;
		case "ios":
			desiredCapabilities.setCapability("automationName", "Appium");
			desiredCapabilities.setCapability("deviceName", IosCapability.deviceName);
			desiredCapabilities.setCapability("platformVersion", IosCapability.platformVersion);
			desiredCapabilities.setCapability("bundleId", IosCapability.bundleId);
			desiredCapabilities.setCapability("wdaLocalPort", IosCapability.wdaLocalPort);
			desiredCapabilities.setCapability("webkitDebugProxyPort", IosCapability.webkitDebugProxyPort);
			desiredCapabilities.setCapability("app", appPath(AppDetails.iosAppName));
			try {
				driver = new IOSDriver(new URL(DriverDetails.serverUrl), desiredCapabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			break;
		case "browserstack":
			desiredCapabilities.setCapability("browserstack.user", BrowserStack.username);
			desiredCapabilities.setCapability("browserstack.key", BrowserStack.accessKey);
			desiredCapabilities.setCapability("app", BrowserStack.appUrl);
			desiredCapabilities.setCapability("device", BrowserStack.deviceName);
			desiredCapabilities.setCapability("os_version", BrowserStack.osVersion);
			desiredCapabilities.setCapability("project", BrowserStack.project);
			desiredCapabilities.setCapability("build", BrowserStack.build);
			desiredCapabilities.setCapability("name", BrowserStack.sessionName);
			desiredCapabilities.setCapability("browserstack.console", "verbose");
			URL url = null;
			try {
				url = new URL(BrowserStack.serverUrl);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			if (BrowserStack.deviceType.equalsIgnoreCase("android"))
				driver = new AndroidDriver(url, desiredCapabilities);
			else
				driver = new IOSDriver(url, desiredCapabilities);
			break;
		default:
			throw new RuntimeException("Invalid Platform : " + DriverDetails.platform);
		}
		return driver;
	}

	public boolean checkIfAppiumServerIsRunning(int port) {
		log.info("Checking if server is running....");
		boolean isAppiumServerRunning = false;
		ServerSocket socket;
		try {
			socket = new ServerSocket(port);
			socket.close();
			socket = null;
		} catch (IOException e) {
			isAppiumServerRunning = true;
		}
		return isAppiumServerRunning;
	}

	public AppiumDriverLocalService getAppiumService(int port) {
		log.info("collecting appium services");
		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withIPAddress(DriverDetails.domain)
				.usingPort(port).withArgument(GeneralServerFlag.SESSION_OVERRIDE).withCapabilities(desiredCapabilities)
				.withArgument(GeneralServerFlag.LOG_LEVEL, "error"));
	}

	public static String appPath(String appName) {
		return new ResourceReader().getPathToFile("apps/" + appName);
	}

	public void startServer(String port) {

		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(Integer.parseInt(port));
//		builder.withCapabilities(desiredCapabilities);
//		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
//		builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

		server = AppiumDriverLocalService.buildService(builder);
		server.start();
	}
}
