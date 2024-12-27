# Deploye l'application dans CloudFormation
sam deploy -t template.yaml -g --profile sandbox-nando --region eu-west-1

# Supprimer l'application qui est dans CloudFormation
sam delete --stack-name quarkus-aws-s3 --profile sandbox-nando --region eu-west-1

# config dans credential
`copie les info du sandbox dans credential qui se trouve dans Option 2`