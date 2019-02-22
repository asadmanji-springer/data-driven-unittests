package net.archfocus.datadriven.v2

import org.junit.jupiter.api.DynamicTest

fun <T> dataSet(dataSet: () -> List<T>) = DynamicTestBuilder2(dataSet)

infix fun <T> DynamicTestBuilder2<T>.name(name: (T) -> String): DynamicTestBuilder2<T> =
    this.copy(testName = name)

infix fun <T> DynamicTestBuilder2<T>.test(testCase: (T) -> Unit): List<DynamicTest> =
    dataSet().map {
        DynamicTest.dynamicTest(testName(it)) {
            testCase(it)
        }
    }

data class DynamicTestBuilder2<T>(
    val dataSet: () -> List<T>,
    val testName: (T) -> String = { "Variant $it" }
)