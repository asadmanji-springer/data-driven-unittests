package net.archfocus.datadriven

import org.junit.jupiter.api.Assertions

infix fun <T> T.`==`(p0: T) {
    Assertions.assertEquals(this, p0)
}

