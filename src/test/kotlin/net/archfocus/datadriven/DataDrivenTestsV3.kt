package net.archfocus.datadriven

import net.archfocus.datadriven.testsupport.square
import net.archfocus.datadriven.v3.*


class DataDrivenTestsV3 {
    @Test
    fun `testSquares`() = testCase<Tuple2<Int, Int>> {

        name { (input, expected) ->
            "when I calculate $input^2 then I get $expected"
        }

        `when` { (input, expected) ->
            expected `==` square(input)
        }

        where { 1 `|` 1 }
        where { 2 `|` 4 }
        where { 3 `|` 9 }
        where { 4 `|` 16 }
        where { 5 `|` 25 }
    }

    @Test
    fun `testSquareDigitLen`() = testCase<Tuple3<Int, Int, Boolean>> {

        name { (input, expected, isTwoDigit) ->
            "when I calculate $input^2 then I get $expected and twoDigit is $isTwoDigit"
        }

        `when` { (input, expected, isTwoDigit) ->
            expected `==` square(input)
            isTwoDigit `==` (square(input) in 10..99)
        }

        whereAll {
            (1 `|` 1 `|` false) `||` (2 `|` 4 `|` false)
        }
    }
}