# Lancer LocalStack avec un volume
docker run -it -p 4566:4566 -p 4571:4571 \
  -v </chemin/vers/ton/dossier>:/mnt/local \ <!-- remplacer le path vers le dossier de choix sur ton système local. ce dossier sera accessible dans le conteneur-->
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
shopt -s histappend           # Ajouter les commandes à l'historique au lieu de les écraser
PROMPT_COMMAND='history -a; history -c; history -r;' # Forcer l'enregistrement de l'historique, Bash enregistre les commandes à la fermeture de la session

`Recharger la configuration`
 source ~/.bashrc
