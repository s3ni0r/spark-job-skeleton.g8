# cotisations
# how to run

```bash
# Build core images once
cd docker-compose/hadoop-latest && make rebuild && cd -
# Build and start the cluster
docker-compose up --build -d
# Or start up the cluster if already has been built
docker-compose up -d
# Load dev data placed in the data directory into hdfs
docker exec -it namenode /scripts/hdfs-loader.sh
```

# Run spark job in the cluster via sbt

```bash
sbt
;clean;reload;compile;docker;dockerComposeUp
```

# Run Spark shell connected to yarn cluster

```bash
docker exec -it spark-shell /spark/bin/spark-shell
```

# Check Yarn history

```bash
chrome|firefox http://localhost:8188
```

# Check Spark history

```bash
chrome|firefox http://localhost:18080
```

# Check hadoop hdfs namenode

```bash
chrome|firefox http://localhost:9870
```

# stop, remove, clean volumes and network of all cluster

```bash
docker stop \$(docker ps -a -q) && docker rm \$(docker ps -a -q) && docker volume prune -f && docker network prune -f
```