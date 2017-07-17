import geb.spock.GebReportingSpec

/**
 * Created by AUBERT on 03/07/2017.
 *
 * This is a Geb/Spock specification or include. Use report "label" to debug.
 * Screenshots and DOM tree will be available at reports/test/app/test/spec/
 **/

/**
 * Pass without any problem on both IE11 and Edge
 */
class GoogleSpec extends GebReportingSpec {

    def "Go Google home page"(){
        when:
        go "https://www.google.com"

        then:
        waitFor {title == "Google"}
    }

}
