Bytabit Fiat Trader Server
==========================

### Clone Project

```
git clone git@bitbucket.org:bytabit/fiat-trader-server.git 
```

### Install Project Dependencies

1. Install [JDK 8u92](https://jdk8.java.net/download.html)
2. Install [Gradle version 2.13](https://gradle.org/gradle-download/)
3. Verify your JAVA_HOME environment variable is set to your JDK home

### Run Server with Gradle

```
gradle run 
```

### IntelliJ Setup

1. Install gradle plugin (if not already installed)
2. Import gradle project in IntelliJ
3. Verify the project JDK and Java Inspections settings are correct

### Build Server Docker Image

1. Commit any uncommitted code and add version label 

2. Build docker image

    ```
    gradle clean buildDocker
    ```
    
3. Confirm docker container created

    ```
    docker images
    ```
    
4. Start docker container

    ```
    docker run -d -p 8080:8080 --expose 8080 --name server bytabit/fiat-trader-server:<VERSION>
    ```
    
5. Start docker container with STDOUT (for trouble shooting)
   
   ```
   docker run -p 8080:8080 --expose 8080 --name server -a STDOUT -t bytabit/fiat-trader-server:<VERSION>
   ```

### Testnet In a Box via Docker

1. Pull bitcoin-testnet-box docker image
    
    ```
    docker pull freewil/bitcoin-testnet-box
    ```

2. Running docker container, mapping and exposing port 18444 from 19000 in our docker container 
    
    ```
    docker run -t -i -p 18444:19000 --expose 18444 freewil/bitcoin-testnet-box
    ```

3. Follow bitcoin-testnet-box [README.md](https://github.com/freewil/bitcoin-testnet-box) instructions

### Postgresql

1. Edit ```postgresql.conf``` and add: 

    ```
    listen_addresses = '*'
    ```

2. Edit ```pg_hba.conf``` and add:

    ```
    host 	bytabit 	bytabit 	192.168.0.13/32		trust 
    ```

3. Create **bytabit** user and password:
 
    ```
    CREATE USER bytabit WITH SUPERUSER PASSWORD 'bytabit@123'
    ```

4. Create empty **bytabit** database:
 
    ```
    CREATE DATABASE bytabit
    ``` 

### Versioning

We follow the [Semantic Versioning 2.0](http://semver.org/spec/v2.0.0.html) specification for this project.