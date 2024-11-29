# Installation avec Docker
` télécharger l'image Keycloak`
docker pull quay.io/keycloak/keycloak:latest

` Lancer Keycloak`
docker run -d --name <name-container> -p <port>:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=<admin> -e KC_BOOTSTRAP_ADMIN_PASSWORD=<password_admin> \
--restart unless-stopped \
quay.io/keycloak/keycloak:<version> \
start-dev
