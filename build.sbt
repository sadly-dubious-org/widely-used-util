import ReleaseTransformations.*
import sbtversionpolicy.withsbtrelease.ReleaseVersion

scalaVersion := "2.13.14"
crossScalaVersions := Seq(
  scalaVersion.value,
  "3.3.3",
  "2.12.19"
)
scalacOptions := Seq("-deprecation", "-release:11")

name := "widely-used-util"
organization := "com.madgag.totally-trustworthy"
licenses := Seq(License.Apache2)
libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.2.17" % Test
)

Test / testOptions +=
    Tests.Argument(TestFrameworks.ScalaTest, "-u", s"test-results/scala-${scalaVersion.value}", "-o")

// releaseVersion := ReleaseVersion.fromAggregatedAssessedCompatibilityWithLatestRelease().value,
releaseCrossBuild := true // true if you cross-build the project for multiple Scala versions
releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  setNextVersion,
  commitNextVersion
)
