import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.edge.EdgeOptions
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.DesiredCapabilities

/**
 * Created by AUBERT on 03/07/2017.
 *
 * This is a Geb/Spock specification or include. Use report "label" to debug.
 * Screenshots and DOM tree will be available at reports/test/app/test/spec/
 **/

waiting {

    atCheckWaiting = true
    timeout = 10
}

environments {
    iexplorer{
        File ieDriver = new File("Drivers/IE11/IEDriverServer.exe")
        System.setProperty("webdriver.ie.driver", ieDriver.getAbsolutePath())
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer()
        caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, false)

        driver = { new InternetExplorerDriver(caps) }
    }

    edgexplorer{
        System.setProperty("webdriver.edge.driver", "Drivers/Edge/MicrosoftWebDriver.exe")
        DesiredCapabilities cap = DesiredCapabilities.edge()
        driver = { new EdgeDriver(cap) }
    }
}

driver = {
    /*File ieDriver = new File("Drivers/IE11/IEDriverServer.exe")
    System.setProperty("webdriver.ie.driver", ieDriver.getAbsolutePath())
    DesiredCapabilities caps = DesiredCapabilities.internetExplorer()
    caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, false)

    new InternetExplorerDriver(caps)*/

    System.setProperty("webdriver.edge.driver", "Drivers/Edge/MicrosoftWebDriver.exe")
    EdgeOptions opt = new EdgeOptions()
    opt.setPageLoadStrategy("eager")
    DesiredCapabilities cap = DesiredCapabilities.edge()
    new EdgeDriver(opt)
}

reportsDir = "reports/test"
