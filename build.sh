port_number=$1
if ! [[ -f "./mvnw" ]]; then
  echo "The './mvnw' file does not exist. Running 'mvn -N wrapper:wrapper'..."
  mvn -N wrapper:wrapper
fi

./kill-port.sh $port_number
./mvnw spring-boot:run -Dserver.port=$port_number -Dmaven.test.skip=true