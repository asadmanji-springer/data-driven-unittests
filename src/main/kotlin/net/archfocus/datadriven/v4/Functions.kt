package net.archfocus.datadriven.v4

import net.archfocus.datadriven.TestDataSet
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

typealias Test = TestFactory

fun <T : TestDataSet> dataSet(dataSet: () -> List<T>) = DynamicTestBuilder4(dataSet)
fun <T : TestDataSet> table(vararg dataSet: T) = DynamicTestBuilder4({ dataSet.toList() })

infix fun <T> DynamicTestBuilder4<T>.name(name: (T) -> String): DynamicTestBuilder4<T> =
    this.copy(testName = name)

infix fun <T> DynamicTestBuilder4<T>.testEach(testCase: (T) -> Unit): List<DynamicTest> =
    dataSet().map {
        DynamicTest.dynamicTest(testName(it)) {
            testCase(it)
        }
    }

data class DynamicTestBuilder4<T>(
    val dataSet: () -> List<T>,
    val testName: (T) -> String = { "Variant $it" }
)