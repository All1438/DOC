npm install -g @nestjs/cli <!--install nest globalement-->

# Creation d'un projet Nest
nest new <nom-projet>
nest generate module <nom-module>
nest generate controller <nom-controler>
nest generate service <nom-service>

## voir en détail les dépendances d'un package
npm info <package> dependencies

##
npm install @vendia/serverless-express

# Dépendances principales (dependencies) --save
## @vendia/serverless-express
**Rôle :** Adapte une application Express (ou NestJS) pour qu'elle puisse fonctionner sur AWS Lambda.
**Pourquoi ? :** AWS Lambda ne comprend pas directement les applications Express ou NestJS. Ce package agit comme un pont entre les événements HTTP d'API Gateway et l'application NestJS.
**Fonctionnement :** Il transforme les événements Lambda (provenant d'API Gateway) en objets req et res compatibles avec Express, puis renvoie la réponse à API Gateway.

## aws-lambda
**Rôle :** Fournit les types TypeScript pour les événements et contextes AWS Lambda.
**Pourquoi ? :** Cela permet d'avoir une meilleure autocomplétion et validation TypeScript lors de l'écriture du code Lambda.
**Exemple :** Le type Handler est utilisé pour définir la fonction Lambda (handler dans lambda.ts).

## esbuild 
Esbuild est un outil de construction (build tool) ultra-rapide pour les projets JavaScript et TypeScript

# Dépendances de développement (devDependencies) --save-dev
## serverless-offline
**Rôle :** Simule AWS Lambda et API Gateway en local pour tester votre application serverless sans avoir à déployer sur AWS.
**Pourquoi ? :** Cela permet de développer et déboguer plus rapidement en évitant les allers-retours vers AWS.
**Fonctionnement :** Il démarre un serveur local qui imite le comportement d'API Gateway et Lambda.
**Utilisation :** Ajoutez un script dans package.json pour lancer le serveur local :
``` json
"scripts": {
  "offline": "serverless offline"
} 
```

## @types/aws-lambda
**Rôle :** Fournit des définitions de types TypeScript pour les événements et contextes AWS Lambda.
**Pourquoi ? :** Cela améliore l'expérience de développement en TypeScript en fournissant des types pour les objets comme APIGatewayProxyEvent, Context, etc.
**Exemple :**
``` typescript
import { APIGatewayProxyEvent, Context } from 'aws-lambda';
```

# Démarage d'un lambda
**Cold Start** = Premier démarrage ou après une longue inactivité.
**Warm Start** = Instance déjà prête.