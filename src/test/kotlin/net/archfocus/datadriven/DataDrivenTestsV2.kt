package net.archfocus.datadriven

import net.archfocus.datadriven.testsupport.square
import net.archfocus.datadriven.v2.dataSet
import net.archfocus.datadriven.v2.name
import net.archfocus.datadriven.v2.test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestFactory

class DataDrivenTestsV2 {

    @TestFactory
    fun `testSquares`() =
        dataSet {
            listOf(
                1 to 1,
                2 to 4,
                3 to 9,
                4 to 16,
                5 to 25
            )
        } name { (input, expected) ->
            "when I calculate $input^2 then I get $expected"
        } test { (input, expected) ->
            Assertions.assertEquals(expected, square(input))
        }

}