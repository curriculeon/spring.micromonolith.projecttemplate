port_number=$1
./kill-port.sh $port_number
./mvnw spring-boot:run -Dserver.port=$port_number -Dmaven.test.skip=true