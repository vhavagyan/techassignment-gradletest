# gradleTest

Containerized Java Spring Boot application that has a GET endpoint http://localhost:8998/testload/{duration}  that starts a high-CPU load for the provided duration in seconds (http://localhost:8998/testload/10 will keep the CPU load high for 10 seconds).
There is a health check endpoint as well (GET http://localhost:8998/health) that returns status code 200 when healthy.
The app runs on 8998 port.

Github Actions Wrokflow:
    Builds docker image on push event to the master/main branch.
    Pushes to docker image repository.
    Deploys the docker image to the cluster.


VARIABLES AND SECRETS:
    GCP_PROJECT_ID - Google Cloud Platform project ID
    DOCKER_IMAGE_NAME - image name to build

