docker image ls <!--liste image-->

# installation image
docker pull rmohr/activemq

# Démarré le container
docker run -d \
  --name my-activemq \
  -p 61616:61616 \ # Port JMS
  -p 8161:8161 \   # Port de l'interface web
  --restart unless-stopped \
  rmohr/activemq

# pour accéder
http://localhost:8161/admin
username: admin
mdp: admin