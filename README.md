# java-docker-sample-project

This repository contains a minimal Java sample application (Maven) with Docker support.

Files added:

- [pom.xml](pom.xml)
- [src/main/java/com/example/App.java](src/main/java/com/example/App.java)
- [src/main/java/com/example/handler/HelloHandler.java](src/main/java/com/example/handler/HelloHandler.java)
- [src/main/resources/version.properties](src/main/resources/version.properties)
- [Dockerfile](Dockerfile)
- [docker-compose.yml](docker-compose.yml)
- [VERSION](VERSION)
- [.github/workflows/maven-ci.yml](.github/workflows/maven-ci.yml)

Quick start

Build locally with Maven:

```bash
mvn -B -DskipTests package
```

Build and run with Docker:

```bash
docker build -t java-docker-sample .
docker run -p 8080:8080 java-docker-sample
```

Or with docker-compose:

```bash
docker-compose up --build
```

The app serves a small JSON response at `http://localhost:8080/`.
