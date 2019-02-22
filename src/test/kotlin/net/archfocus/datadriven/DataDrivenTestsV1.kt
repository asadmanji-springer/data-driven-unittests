package net.archfocus.datadriven

import net.archfocus.datadriven.testsupport.square
import net.archfocus.datadriven.v1.unroll
import net.archfocus.datadriven.v1.where
import net.archfocus.datadriven.v1.withName
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestFactory

class DataDrivenTestsV1 {

    @TestFactory
    fun `testSquares`() =

        unroll<Pair<Int, Int>> { (input, expected) ->
            Assertions.assertEquals(expected, square(input))
        } withName { (input, expected) ->
            "when I calculate $input^2 then I get $expected"
        } where {
            listOf(
                1 to 1,
                2 to 4,
                3 to 9,
                4 to 16,
                5 to 25
            )
        }

}


