# I'm using project gradle
#gradle jibDockerBuild
# We could seperate test into unit tests and integrations tests but I don't want to spend too much time with setup
./gradlew build test jibDockerBuild
docker run -p 8090:8090 kunkel/datetracker &

sleep 10
# add goss not done yet
#goss --vars-inline "expected: 2023-06-26" validate

#shutdown and remove the container at the end
docker rm $(docker stop $(docker ps -a -q --filter ancestor=kunkel/datetracker --format="{{.ID}}"))