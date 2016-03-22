package com.thoughtworks.scalaHaxeUtil

import haxe.root.ValueType
import org.junit.{Assert, Test}

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
class EnumExtractorTest {

  @Test
  def testValueType() = {
    val TNull = EnumExtractor.TNull
    val TNull() = ValueType.TNull
    val EnumExtractor("TNull") = ValueType.TNull

    val EnumExtractor("TClass", sbClass) = ValueType.TClass(classOf[StringBuilder])
    Assert.assertEquals(classOf[StringBuilder], sbClass)

  }
}
