# data-driven-unittests
Experiments with Kotlin DSLs and JUnit5 dynamic tests to see if I can cook up something that looks a bit like Groovy Spock

## Raison d'etre
I really like the readability of Groovy Spock tests and especially the ability to specify data tables and unroll tests with 
them, and to be able to assert more concisely than hamcrest matchers allow you to. Example:
```
class SquaresSpec extends Specification {

  @Unroll
  def "when I calculate #input^2 then I get #expected"() {
      expect:
      expected == square(input)
      
      where:
      input | expected
      1     | 1
      2     | 4
      3     | 9
  }
}
```
I'd like to be able to do the same in Kotlin with type checking of parameters. I'd also like an excuse to play around a bit
more with DSLs in Kotlin.

## What does this repository contain?
A basic JUnit5 and Minutest example and then some iterations of DSLs I played around with to create a
nice readable data driven test (... acknowledging that "nice readable" is subjective and a matter of developer opinion)

Note: if you are looking for a Spock for Kotlin clone this is not it.
