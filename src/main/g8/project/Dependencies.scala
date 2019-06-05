import sbt._

object Dependencies {
  lazy val framelessVersion = "0.8.0"
  lazy val scalaTest        = "org.scalatest" %% "scalatest" % "3.0.5"
  lazy val sparkSql         = "org.apache.spark" %% "spark-sql" % "2.3.2"
  lazy val sparkCore        = "org.apache.spark" %% "spark-core" % "2.3.2"
  lazy val framelessDataset = "org.typelevel" %% "frameless-dataset" % framelessVersion
  lazy val framelessMl      = "org.typelevel" %% "frameless-ml" % framelessVersion
  lazy val framelessCats    = "org.typelevel" %% "frameless-cats" % framelessVersion
  lazy val configs          = "com.github.kxbmap" %% "configs" % "0.4.4"
  lazy val typesafeConfig   = "com.typesafe" % "config" % "1.3.4"
  lazy val cats             = "org.typelevel" %% "cats-core" % "2.0.0-M1"
}
