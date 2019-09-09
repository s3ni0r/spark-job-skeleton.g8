# spark-job-skeleton.g8

Giter8 template for generating a spark job project seed in Scala.

This project is intended for people who know how to use Apache spark and want to get started right away.

You should only need to clone this project if you are modifying the giter8 template.  For information on giter8 templates, please see <http://www.foundweekends.org/giter8/>

## Running

If you want to create a project:

```bash
g8 https://github.com/s3ni0r/spark-job-skeleton.g8
```

## Running locally

If you are testing this giter8 template locally, you should [install g8](http://www.foundweekends.org/giter8/setup.html) and then run the [local test](http://www.foundweekends.org/giter8/testing.html) feature:

```bash
g8 file://spark-job-skeleton.g8/ --name=my-spark-job --force
```

Will create an example template called `my-spark-job`, for example.

# Main Goal of the generated project.

Create a local but iso to production environnement to be as autonomous as possible while working on spark projects.

## How ?

this project contain all needed configuration files to create : 

- [X] Dockerized environnement
- [X] Local but a real distributed environnement
    - 1 Namenode
    - 1 Datanode (to increase as you wish)
    - Yarn resource manager
    - 3 Yarn node managers
    - Yarn hitory server
    - Spark history
    - Spark shell
- [X] Line up with exact Hadoop components version on production
- [X] Deployment to dockerized cluster via sbt command line
- [X] Mount data to hdfs via docker volumes from withing project folder
- [X] Access spark history webui for inspection :)
- [X] Access Yarn logs for debugging :)
- [X] Access to Spark shell for fiddling :)