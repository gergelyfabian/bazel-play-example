package domain

import org.scalatest.{FreeSpec, Matchers}

class ConfigurationSpec extends FreeSpec with Matchers {
  "ConfigurationSpec should" - {
    "check configuration" in {
      Configuration.MyConfig shouldBe 134
    }
  }
}
