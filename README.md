# Brobank
## Prerequisites
* jdk 1.8
* docker and docker-compose
## How to build and run
* copy mysql-driver jdbc driver into `./flyway/drivers/`
* change the version of the driver in the server.xml, iff your driver has another version
* execute `./buildAndRun.sh` or `./buildAndRun.bat`
* the following endpoints should be available:
  * http://localhost:9080/metrics/
  * http://localhost:9080/ibm/api/
  * http://localhost:9080/jwt/
  * http://localhost:9080/openapi/ui/
  * http://localhost:9080/health/
  * http://localhost:9080/openapi/
  * http://localhost:9080/brobank/
