import geb.spock.GebReportingSpec

/**
 * Created by Soline on 11/07/2017.
 */

/**
 * Pass without any problem on IE and Edge
 */
class GoogleSearchSpec extends GebReportingSpec {

    def "Researching book of geb"(){
        setup:
        go "https://www.google.com"
        waitFor {title == "Google"}

        when:
        $("input#lst-ib").value "Book of Geb"
        $("button", id: "_fZl").click()

        then:
        waitFor {$("a", text: "Documentation - The Book Of Geb").displayed}
    }
}
