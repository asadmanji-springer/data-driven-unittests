package net.archfocus.datadriven.v1

import org.junit.jupiter.api.DynamicTest

data class DynamicTestBuilder<T>(
    val testCase: (T) -> Unit,
    val testName: (T) -> String = { "With parameter $it" }
)

fun <T> unroll(test: (T) -> Unit): DynamicTestBuilder<T> = DynamicTestBuilder(test)

infix fun <T> DynamicTestBuilder<T>.withName(name: (T) -> String): DynamicTestBuilder<T> =
    this.copy(testName = name)

infix fun <T> DynamicTestBuilder<T>.where(whereBlock: () -> List<T>): List<DynamicTest> =
    whereBlock().map {
        DynamicTest.dynamicTest(testName(it)) { testCase(it) }
    }