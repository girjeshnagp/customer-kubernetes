# Kubernetes Devops Assignment

Created this repository for assignment submission for service API named as customer-application

## Table of Contents

- [Repository Url](#repositoryurl)
- [Path For Kubernetes file in github repo](#kubernetesfiles)
- [Docker Hub Url](#dockerhuburl)
- [Service API urls](#serviceapiurl)

## RepositoryUrl

- [URL - https://github.com/girjeshnagp/customer-kubernetes](https://github.com/girjeshnagp/customer-kubernetes)

## KubernetesFiles
- [Kubenetes Files path:: https://github.com/girjeshnagp/customer-kubernetes/tree/master/src/main/resources/kubernetes_files](https://github.com/girjeshnagp/customer-kubernetes/tree/master/src/main/resources/kubernetes_files)

## DockerHubUrl
  gsoninagarro/customer-application:latest
  - [URL - https://hub.docker.com/repository/docker/gsoninagarro/customer-application](https://hub.docker.com/repository/docker/gsoninagarro/customer-application)
  
## ServiceApiUrl
- curl GET 'http://<ip-address>:8095/api/v1/customer'
- curl POST 'http://<ip-address>:8095/api/v1/customer' \
--header 'Content-Type: application/json' \
--data-raw '{
    "customerId": 6,
    "customerName": "Mohit Saxena",
    "customerEmail": "mohit.saxena@gmail.com",
    "customerPhone": "8978676756",
    "customerAddress": "Mumbai"
}'
