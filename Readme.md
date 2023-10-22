# Clustered Data Warehouse

## Description
Clustered Data Warehouse is a Spring Boot application built with Java 17 that serves as a data warehouse for Bloomberg to analyze FX deals. The primary function of this application is to accept deal details and persist them into a PostgreSQL database.

## Installation
To run this project, you'll need the following:
- JDK 17
- PostgrsSQL server

## Features
- Accept deal details and persist them into the PostgreSQL database.

## Docker
This project is Dockerized. You can build the Docker image using the provided Dockerfile. To run the project with all dependencies, you can use Docker Compose.

### Building the Docker image
```bash
docker build -t clustered-data-warehouse .
```

### Running the project with Docker Compose
```bash
docker-compose up
```

## Makefile
A Makefile is included in the project to simplify common development tasks. You can use the following make commands:

### Build project
```bash
make build
```

### Run project
```bash
make run
```


### Run project tests

```bash
make test
```
