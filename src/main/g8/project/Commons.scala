import Dependencies._
import com.tapad.docker.DockerComposeKeys._
import com.typesafe.sbt.packager.docker.DockerPlugin.autoImport.Docker
import sbt.Keys._
import sbt._
import sbtassembly.AssemblyKeys._
import sbtassembly.AssemblyPlugin.autoImport.MergeStrategy
import sbtassembly.{AssemblyKeys, _}
import sbtdocker.DockerKeys._
import sbtdocker._

object Commons {

  lazy val dependencies = Seq(
    libraryDependencies ++= Seq(
      sparkCore % Provided,
      sparkSql % Provided,
      typesafeConfig,
      Dependencies.configs,
    )
  )

  lazy val customAssembly = Seq(
    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", xs @ _*) => {
        xs.map(_.toLowerCase) match {
          case ("manifest.mf" :: Nil) => MergeStrategy.discard
          case _                      => MergeStrategy.discard
        }
      }
      case "rootdoc.txt"           => MergeStrategy.discard
      case "conf/application.conf" => MergeStrategy.concat
      case _                       => MergeStrategy.first
    }
  )

  lazy val customDocker = Seq(
    composeNoBuild          := true,
    dockerImageCreationTask := (publishLocal in Docker).value,
    dockerfile in docker := {
      new Dockerfile {
        val artifact: File     = AssemblyKeys.assembly.value
        val artifactTargetPath = s"/app/\${artifact.name}"
        from("s4ni0r/spark-shell:2.3.2")
        add(artifact, artifactTargetPath)
        entryPoint(
          "/spark/bin/spark-submit",
          "--class",
          "mnt.Application",
          "--master",
          "yarn",
          "--deploy-mode",
          "cluster",
          s"\$artifactTargetPath"
        )
      }
    },
    imageNames in docker := Seq(
      ImageName(
        repository = name.value.toLowerCase,
        tag        = Some(s"\${version.value.toLowerCase}")
      )
    ),
    buildOptions in docker := BuildOptions(
      cache                        = false,
      removeIntermediateContainers = BuildOptions.Remove.Always
    ),
    composeFile := "docker-compose.tpl.yml",
    variablesForSubstitution := Map(
      "SERVICE_NAME" -> s"\${name.value.toLowerCase}",
      "VERSION"      -> s"\${version.value.toLowerCase}"
    )
  )
}
