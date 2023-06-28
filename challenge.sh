gradle build test jibDockerBuild
containerId=$(docker run -p 8090:8090 -d kunkel/datetracker)
sleep 5

until [ "`docker inspect -f {{.State.Running}} $containerId`"=="true" ]; do
    sleep 2
done;

goss --vars-inline "expected: 2023-06-28" validate

#shutdown and remove the container at the end
docker rm $(docker stop $(docker ps -a -q --filter ancestor=kunkel/datetracker --format="{{.ID}}"))