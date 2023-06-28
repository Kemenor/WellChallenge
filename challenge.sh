# I'm using project gradle
#gradle jibDockerBuild
# We could seperate test into unit tests and integrations tests but I don't want to spend too much time with setup
./gradlew build test jibDockerBuild
containerId=$(docker run -p 8090:8090 -d kunkel/datetracker)
sleep 5
# Wait for docker container to be running
# if we add health checks we could wait for healthy
until [ "`docker inspect -f {{.State.Running}} $containerId`"=="true" ]; do
    sleep 2
done;

# add goss not done yet
#goss --vars-inline "expected: 2023-06-26" validate
echo "would be running tests"

#shutdown and remove the container at the end
docker rm $(docker stop $(docker ps -a -q --filter ancestor=kunkel/datetracker --format="{{.ID}}"))