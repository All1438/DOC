fichier: package.json = permet de décrir le projet / de Lister les dépendances
// Dans le package.json
On remplace "test" par "start": "node app.js"

node <nom_fichier> = permet d'éxecuter un ficher nodeJs
npm init = permet de créer un fichier package.json et de le remplir
npm start = permet de lancer notre app . après avoir configurer le start dans package.json (start: "node <nom_fichier>)

    // install expressJs
npm install express --save = commande installation express
                            // --save = permet de lister dans notre package.json mais pas en local

    // install nodemon
npm install nodemon --save-dev = automatise le processus de redémarrage de l'app lorsqu'il détecte des modifications dans les fichiers du project
                            // --save-dev = dependencies pendant le développement spécialement
                            // faut changer le contenu de start dans package.json "node" par "nodemon"

    // install midllware morgan
npm install morgan --save-dev = permet d'obtenir des informations détaillées sur chaque requête HTTP entrant dans l'application Express.js
npm install serve-favicon --save = permet de mettre en place la favicon
npm install body-parser --save = 

    // install base de données
npm install express mysql cors dotenv ip pino pino-pretty // permet de se connecter et d'interagir avec la base de données MySQL
debog pas a pas

    // install ORM (intéragir avec la BD depuis l'API REST)
npm install sequelize --save = ORM nodeJs


    // Code de statut HTTP (permet au client de comprendre le statut de la requête et de prendre des mesure appropriées en conséquence)
200 OK: Signifie que la requête a été traité avec succés
400 Bad Request : indique que la requête du client était incorrecte ou malformée.
    ex: la requête POST manque des paramètres obligatoire
404 Not Found: lorsque le client demande une ressource qui n'existe pas en BD, que la ressource demandé n'as pas été trouvé sur le serveur
    ex: Une requête GET pour une URL qui n'existe pas sur le serveur
401 Unauthorized : lorsque le client n'a pas le droit suffisant pour y accédé (qui ne sont pas autentifié)
    ex: une tentative d'accés à une ressource protégée sans fournir de jeton d'authentification valide
403 Forbidden : si l'utilisateur c'est bien autentifié mais qui demande une ressource non autorisé (ex: un client ne peut pas accédé au API REST en tant que simple utilisateur ou en tant administrateur )
    ex: Un utilisateur régulier essaie d'accéder à une ressource qui nécessite des autorisations spéciales
500 Internal Server Error: indique une erreur interne du serveur qui empêche la requête d'être traitée.
    ex: Une erreur de BD ou une exception non gérée du côté serveur

    // Validateur
isInt, isEmail, isUrl, notNull, etc

    // Crypter un mot de passe
npm install bcrypt --save

    // JWT(JsonWebToken) utilisé pour transférer des informations entre parties de manière sécurisée. Il est défini par le standard RFC 7519. Les jetons JWT sont souvent utilisés dans les systèmes d'authentification et d'autorisation sur le web.
npm install jsonwebtoken --save

    // CORS (Cross-Origin Ressource Sharing) est utilisé pour gérer les politiques de partage des ressources entre différentes origines (domaines) dans les applications web
    Il permet de spécifier quels domaines sont autorisés à accéder aux ressources d'un serveur, notamment les API.
npm install cors --save
// Il est utilisé comme midllware


Un transpilateur a une role de traduire le code ES6 en ES5

# install node and npm
sudo apt install nodejs
sudo apt install npm
sudo npm install -g n <!--Installez n (un gestionnaire de versions pour Node.js) -->
sudo n stable <!--Mettez à jour Node.js à la version stable la plus récente-->
sudo n lts <!--(Optionnel) Mettez à jour Node.js vers la version LTS-->

curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.5/install.sh | bash <!-- Utiliser Node Version Manager (NVM) (Recommandé)-->
nvm ls-remote <!--Lister les versions disponibles-->
nvm install node <!--Installer la dernière version stable de Node.js-->
nvm install <version>
nvm use <version>
nvm alias default node <!--Definir la version comme par défaut-->
nvm alias default <version>

sudo apt install typescript --save-dev <!--Installer la dépendance type script-->

# initializer un projet sam node
sam init <!--Initialiser un projet sam node-->
1 - AWS Quick Start Templates
1 - Hello World Example
11 - nodejs22.x
1 - Zip
2 - Hello World Example TypeScript
X-Ray tracing on the function(s): N


npm run unit <!--permet de lancer les tests(test dans l'app sam)-->

# initializer un projet TypeScript
npm init -y
npm install typescript ts-node @types/node --save-dev
    typescript : Compilateur TypeScript
    ts-node : Exécuter TypeScript directement en dev
    @types/node : Définitions de types pour Node.js
npx tsc --init <!--Initialise la config TypeScript-->
npm install typeorm reflect-metadata pg
    typeorm : L'ORM principal
    reflect-metadata : Nécessaire pour les décorateurs
    pg : Pilote PostgreSQL (remplacez par mysql2, sqlite3, etc.)


# annotation:
! : Champ obligatoire (NOT NULL en base).
? : Champ optionnel (NULLABLE en base).