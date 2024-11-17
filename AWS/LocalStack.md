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