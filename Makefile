build:
	mvn clean package

run:
	docker-compose up --build

test:
	mvn clean test
