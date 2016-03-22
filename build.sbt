libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test

haxeOptions in Compile ++= Seq("-dce", "no")

libraryDependencies ++= {
  if (scalaBinaryVersion.value == "2.10") {
    Seq("org.scalamacros" %% "quasiquotes" % "2.1.0")
  } else {
    Nil
  }
}

scalacOptions in doc in Compile ++= Seq("-skip-packages", "haxe:_Array:_Map")

organization := "com.thoughtworks.microbuilder"

name := "scala-haxe-util"

crossScalaVersions := Seq("2.10.6", "2.11.8")

developers := List(
  Developer(
    "Atry",
    "杨博 (Yang Bo)",
    "pop.atry@gmail.com",
    url("https://github.com/Atry")
  )
)

homepage := Some(url(s"https://github.com/ThoughtWorksInc/${name.value}"))

startYear := Some(2016)

releasePublishArtifactsAction := PgpKeys.publishSigned.value

import ReleaseTransformations._

releaseUseGlobalVersion := false

releaseCrossBuild := true

scmInfo := Some(ScmInfo(
  url(s"https://github.com/ThoughtWorksInc/${name.value}"),
  s"scm:git:git://github.com/ThoughtWorksInc/${name.value}.git",
  Some(s"scm:git:git@github.com:ThoughtWorksInc/${name.value}.git")))

licenses += "Apache" -> url("http://www.apache.org/licenses/LICENSE-2.0")

releaseProcess := {
  releaseProcess.value.patch(releaseProcess.value.indexOf(pushChanges), Seq[ReleaseStep](releaseStepCommand("sonatypeRelease")), 0)
}

releaseProcess -= runClean

releaseProcess -= runTest