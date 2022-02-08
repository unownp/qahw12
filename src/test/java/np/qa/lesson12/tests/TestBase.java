package np.qa.lesson12.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import np.qa.lesson12.helpers.Attach;
import np.qa.lesson12.pages.components.FixedBanComponent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        //Configuration.startMaximized = true;
        //Configuration.holdBrowserOpen = true;

//        String user = System.getProperty("user");
//        String pass = System.getProperty("pass");
//        String remoteUrl = System.getProperty("remoteUrl", "selenoid.autotests.cloud/wd/hub");
//        Configuration.remote = "https://" + user + ":" + pass + "@" + remoteUrl;

//        Configuration.browser = System.getProperty("browser");
//        Configuration.browserVersion = System.getProperty("browserVersion");

       // Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
    FixedBanComponent fixedBanComponent=new FixedBanComponent();

}
