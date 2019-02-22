package net.archfocus.datadriven

interface TestDataSet

data class Tuple1<A>(val p0: A) : TestDataSet
data class Tuple2<A, B>(val p0: A, val p1: B) : TestDataSet
data class Tuple3<A, B, C>(val p0: A, val p1: B, val p2: C) : TestDataSet
data class Tuple4<A, B, C, D>(val p0: A, val p1: B, val p2: C, val p3: D) : TestDataSet

object Tuple {

    operator fun <A> invoke(_1: A): Tuple1<A> = Tuple1(_1)
    operator fun <A, B> invoke(_1: A, _2: B): Tuple2<A, B> = Tuple2(_1, _2)
    operator fun <A, B, C> invoke(_1: A, _2: B, _3: C): Tuple3<A, B, C> = Tuple3(_1, _2, _3)
    operator fun <A, B, C, D> invoke(_1: A, _2: B, _3: C, _4: D): Tuple4<A, B, C, D> = Tuple4(_1, _2, _3, _4)
}

infix fun <A, B> A.`|`(p1: B) = Tuple(this, p1)
infix fun <A, B> Tuple1<A>.`|`(p1: B) = Tuple(this.p0, p1)
infix fun <A, B, C> Tuple2<A, B>.`|`(p2: C) = Tuple(this.p0, this.p1, p2)
infix fun <A, B, C, D> Tuple3<A, B, C>.`|`(p3: D) = Tuple(this.p0, this.p1, this.p2, p3)

infix fun <T : TestDataSet> T.`||`(p0: T): List<T> = listOf(this, p0)
infix fun <T : TestDataSet> List<T>.`||`(p0: T): List<T> = this + p0