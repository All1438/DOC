# Deploye l'application dans CloudFormation
sam deploy -t template.yaml -g --profile sandbox-nando --region eu-west-1

# Supprimer l'application qui est dans CloudFormation
sam delete --stack-name quarkus-aws-s3 --profile sandbox-nando --region eu-west-1

# config dans credential
`copie les info du sandbox dans credential qui se trouve dans Option 2`

# create project typeScript Sam
sam init
npm install
sam build --beta-features <!--Pour compiler le typeScript et préparer le projet pour le déployement-->
sam local invoke "<Nom function lambda>" -e events/event.json <!--tester localement-->
sam deploy --guided --profile <010330705227_AWS-Sandbox-PowerUser> Environment=<preprod>

# create project quarkus sam with mvn
mvn io.quarkus.platform:quarkus-maven-plugin:3.8.6:create -DprojectGroupId=<com.kowee.kslack> -DprojectArtifactId=<kslack> -Dextensions="<amazon-sns>"
sam deploy --guided --profile <010330705227_AWS-Sandbox-PowerUser> Environment=<preprod>
  Stack Name [sam-app]: MonNomDeStack
  AWS Region [us-east-1]: eu-west-3
sam deploy -t <template.yaml> -g --profile <10330705227_AWS-Sandbox-PowerUser> Environment=<preprod>
sam deploy --stack-name <kslack-preprod> -t template.yaml Environment=<preprod> --profile <567547540856_AWS-Legacy-Production-DevLambda > 
sam delete --stack-name <kupload-capacity-preprod> --profile <567547540856_AWS-Legacy-Production-DevLambda>

# Choose an AWS Quick Start application template
Data processing (Option 2)

Description : Ce modèle est idéal si votre Lambda doit traiter des données provenant de services AWS comme S3, DynamoDB Streams, ou Kinesis.
Utilisation : Convient si votre fonction est déclenchée par des événements liés à des flux ou au traitement de données.
Scheduled task (Option 5)

Description : Configure une Lambda déclenchée par un événement planifié via EventBridge Scheduler.
Utilisation : Si votre tâche doit s'exécuter à intervalles réguliers (par exemple, toutes les heures ou une fois par jour).
Infrastructure event management (Option 8)

Description : Ce modèle configure une Lambda pour gérer des événements d'infrastructure, tels que ceux générés par CloudWatch Events, EventBridge, ou d'autres services AWS.
Utilisation : Si votre Lambda surveille ou réagit à des changements d'infrastructure.
Serverless API (Option 7)

Description : Crée une API sans serveur avec API Gateway comme point d'entrée.
Utilisation : Si vous construisez une API REST et souhaitez y connecter d'autres services AWS.
DynamoDB Example (Option 15)

Description : Configure une Lambda pour réagir à des événements DynamoDB Streams.
Utilisation : Si votre application utilise DynamoDB et que vous souhaitez traiter les changements dans la base de données.


