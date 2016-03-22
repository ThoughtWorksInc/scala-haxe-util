package com.thoughtworks.scalaHaxeUtil


import scala.language.dynamics

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
object EnumExtractor extends Dynamic {

  private def toOptionSeq(a: haxe.root.Array[_]): Option[Seq[Any]] = {
    if (a == null) {
      None
    } else {
      Some(new IndexedSeq[Any] {
        override def length: Int = a.length
        override def apply(idx: Int): Any = a.__get(idx)
      })
    }

  }

  def unapplySeq(enum: java.lang.Enum[_]): Option[Seq[Any]] = {
    toOptionSeq(HaxeEnumExtractor.staticUnapplyArray(enum))
  }

  def unapplySeq(enum: haxe.lang.Enum): Option[Seq[Any]] = {
    toOptionSeq(HaxeEnumExtractor.staticUnapplyArray(enum))
  }

  def selectDynamic(expectedName: String) = new SelectDynamic(expectedName)

  final class SelectDynamic(expectName: String) extends HaxeEnumExtractor(expectName) {
    final def unapplySeq(enum: java.lang.Enum[_]): Option[Seq[Any]] = {
      toOptionSeq(unapplyArray(enum))
    }
    final def unapplySeq(enum: haxe.lang.Enum): Option[Seq[Any]] = {
      toOptionSeq(unapplyArray(enum))
    }
  }

}
