FROM openliberty/open-liberty:javaee8-java8-openj9
COPY server.xml /opt/ol/wlp/usr/servers/defaultServer/
COPY flyway/drivers/mysql-connector-java-*.jar /opt/ol/wlp/usr/servers/defaultServer/
COPY build/libs/brobank.war /opt/ol/wlp/usr/servers/defaultServer/dropins/
