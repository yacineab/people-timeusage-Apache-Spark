name := "bigdata-timeusage"

scalaVersion := "2.11.8"

scalacOptions ++= Seq("-deprecation")

resolvers += Resolver.sonatypeRepo("releases")

// grading libraries
libraryDependencies += "junit" % "junit" % "4.10" % "test"
libraryDependencies += "com.holdenkarau" %% "spark-testing-base" % "2.1.0_0.6.0" % "test"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.1.0"


// include the common dir
commonSourcePackages += "common"
