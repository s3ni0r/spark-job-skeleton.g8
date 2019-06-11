import sbt._

object Dependencies {
  lazy val sparkVersion     = "2.3.2"
  lazy val framelessVersion = "0.8.0"
  lazy val scalaTest        = "org.scalatest" %% "scalatest" % "3.0.5"
  lazy val sparkSql         = "org.apache.spark" %% "spark-sql" % sparkVersion
  lazy val sparkCore        = "org.apache.spark" %% "spark-core" % sparkVersion
  lazy val sparkTestingBase = "com.holdenkarau" %% "spark-testing-base" % s"${sparkVersion}_0.12.0" % "test"
  lazy val framelessDataset = "org.typelevel" %% "frameless-dataset" % framelessVersion
  lazy val framelessMl      = "org.typelevel" %% "frameless-ml" % framelessVersion
  lazy val framelessCats    = "org.typelevel" %% "frameless-cats" % framelessVersion
  lazy val configs          = "com.github.kxbmap" %% "configs" % "0.4.4"
  lazy val typesafeConfig   = "com.typesafe" % "config" % "1.3.4"
  lazy val cats             = "org.typelevel" %% "cats-core" % "2.0.0-M1"
}
