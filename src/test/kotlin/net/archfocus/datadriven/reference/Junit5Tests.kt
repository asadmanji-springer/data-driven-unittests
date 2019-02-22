package net.archfocus.datadriven.reference

import dev.minutest.junit.JUnit5Minutests
import dev.minutest.rootContext
import net.archfocus.datadriven.testsupport.square
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class Junit5Tests {

    @TestFactory
    fun testSquares() = listOf(
        1 to 1,
        2 to 4,
        3 to 9,
        4 to 16,
        5 to 25)
        .map { (input, expected) ->
            DynamicTest.dynamicTest("when I calculate $input^2 then I get $expected") {
                assertEquals(expected, square(input))
            }
        }
}

class MinutestTests : JUnit5Minutests {

    fun tests() = rootContext<Unit> {

        listOf(
            1 to 1,
            2 to 4,
            3 to 9,
            4 to 16,
            5 to 25).forEach { (input, expected) ->
            test("when I calculate $input^2 then I get $expected") {
                assertEquals(expected, square(input))
            }
        }
    }
}
