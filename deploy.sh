#!/bin/bash

DOCKERHUBGROUP="${DOCKERHUBGROUP:-profitware}"
NAMESPACE=${NAMESPACE:-conceptual-art}
APPNAME="${APPNAME:-conceptual-art}"
DOCKERIMAGE="${DOCKERHUBGROUP}/${APPNAME}:latest"

mvn clean package && docker build -t ${DOCKERIMAGE} . && docker push ${DOCKERIMAGE} && oc rollout latest dc/${APPNAME} -n ${NAMESPACE}

