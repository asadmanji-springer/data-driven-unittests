package net.archfocus.datadriven

import net.archfocus.datadriven.testsupport.square
import net.archfocus.datadriven.v4.*


class DataDrivenTestsV4 {

    @Test
    fun `test squares and division by four`() =
        table(
            1 `|` 1 `|` 0.25,
            2 `|` 4 `|` 0.5,
            3 `|` 9 `|` 0.75,
            4 `|` 16 `|` 1.0,
            5 `|` 25 `|` 1.25
        ) name { (input, expected, divideByFour) ->
            "when I calculate $input^2 then I get $expected and dividing by 4 leaves $divideByFour"
        } testEach { (input, expected, divideByFour) ->
            expected `==` square(input)
            input.toDouble().div(4) `==` divideByFour
        }

    @Test
    fun `test squares and division by four with dataset`() =
        dataSet {
            (1..5).map { Tuple(it, it*it, it.toDouble()/4) }
        } name { (input, expected, divideByFour) ->
            "when I calculate $input^2 then I get $expected and dividing by 4 leaves $divideByFour"
        } testEach { (input, expected, divideByFour) ->
            square(input) `==` expected
            square(input).toDouble().div(4).div(input) `==` divideByFour
        }

}