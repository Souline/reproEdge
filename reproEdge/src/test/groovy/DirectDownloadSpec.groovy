import geb.navigator.Navigator
import geb.spock.GebReportingSpec

/**
 * Created by Soline on 11/07/2017.
 */

/**
 * TODO: Should be tested the old way with Edge
 */
class DirectDownloadSpec extends GebReportingSpec{

    def "Directly download from web page"(){
        setup:
        def dlZip

        when:
        go "https://www.thinkbroadband.com/download"
        Navigator dlLink = $("a", href: "http://ipv4.download.thinkbroadband.com/5MB.zip")[0]

        then:
        waitFor {title == "Download Test Files | thinkbroadband"}
        waitFor {dlLink.displayed}

        /**
         * It seems that IE11 does not provide any way to automate download process
         * This is why we try with a direct download by HTTP request forgery
         * However, the test keep failing (download error). We suspect an error in request
         * forgery. TODO: Take a look at HTTP request on download and reproduce it.
         */
        when:
        dlLink.click()
        /*def p = Runtime.getRuntime().exec("AutoDLIE11.exe")

        def exitVal = p.waitFor()
        System.out.println("Exited with error code "+exitVal)*/

        then:
        waitFor {new File("C:\\Users\\Soline\\Downloads\\5MB.zip").size() != 0}
    }
}
