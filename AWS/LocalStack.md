# Lancer LocalStack avec un volume
docker run -it -p 4566:4566 -p 4571:4571 \
  --restart unless-stopped \
  -e SERVICES=<service>,<service> \
  localstack/localstack 

# Ouverture d'un shell bash dans le conteneur
docker exec -it <container_id> bash


<!-- service S3 -->
# Télécharger un fichier vers le bucket
awslocal s3 cp /mnt/<path/vers/ton/fichier.txt> s3://<nom_bucket> 

# Config historique dans le bash de localstack
`install nano`
  sudo apt update && sudo apt install nano
`config dans fichier ~/.bashrc`
export HISTFILE=~/.bash_history
export HISTSIZE=1000          # Nombre de lignes à conserver en mémoire
export HISTFILESIZE=2000      # Nombre total de lignes à enregistrer sur le disque
export HISTCONTROL=ignoredups # Éviter les doublons
export HISTCONTROL=ignoredups:erasedups # Éviter les doublons et écraser les entrées existantes
shopt -s histappend           # Ajouter les commandes à l'historique au lieu de les écraser
PROMPT_COMMAND='history -a; history -c; history -r;' # Forcer l'enregistrement de l'historique, Bash enregistre les commandes à la fermeture de la session

`Recharger la configuration`
 source ~/.bashrc


# SQS
`Ajouter un queue`
awslocal sqs create-queue --queue-name <Nom_de_la_file>
`Lister les queue`
awslocal sqs list-queues
`Obtenir l'url d'une file`
awslocal sqs get-queue-url --queue-name <nom_file>
`Supprimer une file`
awslocal sqs delete-queue --queue-url <URL_queue>

## Pour gérer les messages
`Envoyer un message`
awslocal sqs send-message --queue-url '<URL_queue>' --message-body '<message>'
`Supprimer un message`
awslocal sqs delete-message --queue-url <URL_queue> --receipt-handle <ReceiptHandle>
`Purger une file`
awslocal sqs purge-queue --queue-url 
`Supprimer tous les messages`
awslocal sqs purge-queue --queue-url <URL_queue>
`Voir le nombre de message`
awslocal sqs get-queue-attributes --queue-url "<Url_queue>" --attribute-names All
