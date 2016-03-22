package com.thoughtworks.scalaHaxeUtil;

@:nativeGen
@:internal
class HaxeEnumExtractor {

  var expectName:String;

  @:internal
  public function new(expectName:String) {
    this.expectName = expectName;
  }


  @:internal
  private static function staticUnapplyArray(e:Dynamic):Null<Array<Dynamic>> return {
    var constructs = Type.getEnumConstructs(Type.getEnum(e));
    var name = constructs[Type.enumIndex(e)];
    var result = Type.enumParameters(e);
    result.unshift(name);
    result;
  }

  @:internal
  @:final
  private function unapplyArray(e:Dynamic):Null<Array<Dynamic>> return {
    var constructs = Type.getEnumConstructs(Type.getEnum(e));
    var name = constructs[Type.enumIndex(e)];
    if (expectName == name) {
      Type.enumParameters(e);
    } else {
      null;
    }
  }

}