package net.archfocus.datadriven.v3

import net.archfocus.datadriven.TestDataSet
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.fail

typealias Test = TestFactory

class ParameterisedTest<T : TestDataSet>(
    var parameterisedTest: (T) -> Unit = { fail("Should define a `when` in an `when`{}") },
    var parameterisedName: (T) -> String = { "x" },
    val dataSet: MutableList<T> = mutableListOf()
) {

    fun `when`(block: (T) -> Unit) {
        parameterisedTest = block
    }

    fun name(block: (T) -> String) {
        parameterisedName = block
    }

    fun whereAll(block: () -> List<T>) {
        dataSet.clear()
        dataSet.addAll(block())
    }

    fun where(block: () -> T) {
        dataSet.add(block())
    }
}

fun <T : TestDataSet> testCase(builderFn: ParameterisedTest<T>.() -> Unit): List<DynamicTest> =
    ParameterisedTest<T>()
        .apply { this.builderFn() }
        .let { testCase ->
            testCase.dataSet.map {
                DynamicTest.dynamicTest(testCase.parameterisedName(it)) {
                    testCase.parameterisedTest(it)
                }
            }
        }