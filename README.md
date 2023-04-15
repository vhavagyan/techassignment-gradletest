# gradleTest

Below you will find a link to a downloadable containerized Java Spring Boot application that has a GET endpoint http://localhost:8998/testload/{duration}  that starts a high-CPU load for the provided duration in seconds (http://localhost:8998/testload/10 will keep the CPU load high for 10 seconds). 
There is a health check endpoint as well (GET http://localhost:8998/health) that returns status code 200 when healthy.
The app runs on 8998 port.

Task details: 
 Create a new GCP account and you’ll get 300$ perk for one month. 
 Create a new project in GCP account.
 Create a Kubernetes Cluster in that project.
 Make sure the cluster has node pool autoscaling.
 Push this project to your GitHub account (private) and add “aramavetisyan” user as a collaborator.
 Setup a github actions pipeline for building a docker image on every push event to the master/main branch.
 Add a stage to the actions pipeline for deploying the docker image to the cluster (you can use any docker image repo you want).
 Create and apply a Service manifest that serves requests to this deployment (80 -> 8998).
 Make sure the app works:
Kube service status and deployment status.
The mentioned endpoints are reachable with via public IP.
 Apply horizontal pod autoscaling logic to the deployment, that is based on the CPU load. (2 -10 pods).
 Invite aram@podcastle.ai to the GCP project.
 Be prepared to demonstrate the entire flow.
