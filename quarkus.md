https://code.quarkus.io/ <!--Site pour initializer un projet quarkus-->

# packager un projet quarkus
``` xml
<build>
    <plugins>
        <plugin>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-maven-plugin</artifactId>
            <version>${quarkus.version}</version>
            <executions>
                <execution>
                    <goals>
                        <goal>build</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```
mvn clean package

mvn quarkus:dev <!--Lancer le projet en mode développement-->
curl localhost:8000/<url_path> <!--permet de tester un url d'un apiREST si ça marche(un peu comme postman)-->

# creation projet quarkus
`CLI Quarkus`
quarkus create app fr.loicmathieu.eni.quarkus:chapitre-04 \ 
--extension=resteasy,jdbc-postgresql

`maven`
mvn io.quarkus.platform:quarkus-maven-plugin:2.16.1.Final:create \ 
    -DprojectGroupId=fr.loicmathieu.eni.quarkus \ 
    -DprojectArtifactId=chapitre-4 \ 
    -Dextension=resteasy,jdbc-postgresql 

# Ajouter une extension:
`CLI Quarkus`
quarkus extension add <nom-extension-quarkus>

`CLI Maven`
mvn quarkus:add-extension \ 
    -Dextension=<nom-extension-quarkus>

# Les logs:
Par défaut, Quarkus supporte les API de log suivantes :
JUL : JDK java.util.logging.
JBoss Logging : utilisée en interne dans le code de Quarkus.
SFL4J.
Apache Commons Logging.

# Injection de dépendance
@Singleton : il n’y aura qu’une instance de bean pour toute l’application, et ce bean ne pourra être proxifié (et donc intercepté).

@ApplicationScoped : il n’y aura qu’une instance de bean pour toute l’application.

@Dependent : le scope du bean est celui du bean dans lequel il est injecté.

@RequestScoped : il y aura une instance de bean pour chaque requête.

@SessionScoped : il y aura une instance de bean pour chaque session.

# Lancé l'application avec CLI (Le dev mode)
`CLI Quarkus`
quarkus dev
`Maven`
mvn quarkus:dev
`Gradle`
gradle --console=plain quarkusDev

# La dev UI(http://localhost:8080/q/dev)

# Les Dev Services

# développement endPoint
@Path : permet de spécifier le chemin HTTP d’un endpoint (au niveau de la classe) ou d’une opération (au niveau de la méthode). Il peut être paramétré via {nomDuParam}.

@GET, @POST, @PUT, @DELETE : permettent de spécifier la méthode HTTP utilisée.

@Produces, @Consumes : permettent de spécifier le type de média utilisé pour sérialiser la donnée entrante (@Consumes) ou sortante (@Produces). Par défaut, Quarkus utilisera le type de média application/json si aucune de ces annotations n’est utilisée.

@PathParam, @QueryParam, @HeaderParam : permettent de récupérer un paramètre depuis le chemin HTTP, les paramètres de la requête (query strings) ou les en-têtes (headers) HTTP.

# Documentation API(Swagger):
<dependency> 
    <groupId>io.quarkus</groupId> 
    <artifactId>quarkus-smallrye-openapi</artifactId> 
</dependency>
Dès l’ajout de cette dépendance, une documentation par défaut de l’API est disponible à l’URL <http://localhost:8080/q/openapi>

Pour personnaliser cette documentation par défaut, vous pouvez utiliser les annotations suivantes :
`@OpenAPIDefinition :` au niveau de la ressource d’API, documentation globale de votre API.

`@Operation :` au niveau de l’opération de votre ressource, documentation propre à l’opération.

`@Parameter :` au niveau des paramètres de l’opération, à utiliser quel que soit le type de paramètre : header, query string, path...

`@APIResponse :` au niveau de l’opération de votre ressource, permet de documenter ses réponses.
``` java
@OpenAPIDefinition(info = 
    @Info(title ="Product API", version = "1.0.0", 
            description = "L'API produit de ACME Corp.") 
) 
@Path("/products") 
public class ProductResource { 
 
    @GET 
    @Operation(summary = "Liste tous les produits") 
    public Collection<Product> list() { 
    } 
 
    @GET 
    @Path("/{id}") 
    @Operation(summary = "Récupère un produit") 
    @APIResponse(responseCode = "404", 
            description = "Quand le produit n'est pas trouvé") 
    public Product get(@Parameter(description = "Identifiant") 
                           @PathParam("id") String id) { 
    } 
 
    @POST 
    @Operation(summary = "Crée un produit") 
    public Response create(Product product) { 
    } 
 
    @PUT 
    @Path("/{id}") 
    @Operation(summary = "Met à jour  un produit") 
    @APIResponse(responseCode = "404", 
            description = "Quand le produit n'est pas trouvé") 
    public void update(@Parameter(description = "Identifiant") 
                           @PathParam("id") String id,  
                       Product product) { 
    } 
 
    @DELETE 
    @Path("/{id}") 
    @Operation(summary = "Supprime  un produit") 
    public void delete(@Parameter(description = "Identifiant")  
                           @PathParam("id") String id) { 
    } 
} 
```

# Le filtre de Cors
Le filtre CORS peut être configuré avec les propriétés suivantes :

`quarkus.http.cors.origins` : liste des origines autorisées, par défaut vide, ce qui signifie que toutes les origines seront autorisées.

`quarkus.http.cors.methods` : liste des méthodes HTTP autorisées, par défaut vide, ce qui signifie que toutes les méthodes HTTP seront autorisées.

`quarkus.http.cors.headers` : liste des en-têtes HTTP autorisés, par défaut vide, ce qui signifie que tous les en-têtes HTTP seront autorisés.

`quarkus.http.cors.exposed-headers` : liste des en-têtes HTTP exposés. 

`quarkus.http.cors.access-control-max-age` : si configurée, représente la valeur de l’en-tête HTTP Access-Control-Max-Age qui sera retourné dans la réponse. Par défaut vide.

`quarkus.http.cors.access-control-allow-credentials` : indique si la requête principale peut être effectuée avec des informations d’authentification, par défaut true si quarkus.http.cors.origins est configurée et qu’il y a correspondance avec l’origine de la requête.

quarkus.http.cors=true 
quarkus.http.cors.origins=http://foo.com,http://www.bar.io 
quarkus.http.cors.methods=GET,PUT,POST 
quarkus.http.cors.access-control-max-age=24H 
quarkus.http.cors.access-control-allow-credentials=true

# Configuration HTTP
Il est possible d’activer les logs d’accès HTTP via la propriété de configuration quarkus.http.access-log.enabled. Ceux-ci sont désactivés par défaut. Une fois activés, il est possible de les configurer avec les propriétés de configuration suivantes :
`quarkus.http.access-log.log-to-file` : permet de loguer dans un fichier, supporte la rotation de fichier.

`quarkus.http.access-log.pattern` : permet de configurer le pattern de log.

`quarkus.http.access-log.exclude-pattern` : permet d’exclure certains chemins des logs.

Pour limiter les risques de sécurité et protéger l’application, des limites HTTP sont définies. Ces limites sont configurables via les propriétés de configuration suivantes :
`quarkus.http.limits.max-header-size` : taille maximum des en-têtes HTTP, par défaut 20 Ko.

`quarkus.http.limits.max-body-size` : taille maximum du corps d’une requête HTTP, par défaut 10 Mo.

`quarkus.http.limits.max-initial-line-length` : longueur maximum de la première ligne de la requête HTTP (par exemple : GET /path HTTP/1.0), par défaut 4096.

`quarkus.http.limits.max-form-attribute-size` : taille maximum d’un attribut de formulaire, par défaut 2048 octets.

`quarkus.http.limits.max-connections` : nombre maximum de connexions autorisées à un instant t, par défaut non limité (pas de valeur).



# Différence entre JVM et GraalVM:
| **Aspect**               | **JVM**                                | **GraalVM**                                   |
|--------------------------|-----------------------------------     |-----------------------------------------------|
| **Langages supportés**   | Principalement Java et langages JVM    | Java, Python, Ruby, JavaScript, R, LLVM (C/C++). |
| **Compilation**          | JIT uniquement                         | JIT (via Graal) + AOT (binaire natif).        |
| **Interopérabilité**     | Limité aux langages JVM                | Polyglot (interopérabilité entre plusieurs langages). |
| **Temps de démarrage**   | Plus lent (dépend de la JVM)           | Très rapide avec les binaires natifs.         |
| **Mémoire**              | Dépend de la JVM                       | Réduction significative avec les binaires natifs. |
| **Performance**          | Dépend du compilateur C2               | Optimisé avec le compilateur Graal.           |
| **Support cloud-native** | Pas conçu spécifiquement pour le cloud | Optimisé pour le cloud (démarrage rapide, faible mémoire). |
| **Interopération native**| Non                                    | Oui (via LLVM pour exécuter C/C++).           |



# Différence entre Rest Client Classic et Rest Client Reactive
| **Aspect**                | **Rest Client Classic**                       | **Rest Client Reactive**                      |
|---------------------------|-----------------------------------            |-----------------------------------------------|
| **Modèle**                | Impératif (bloquant)                          | Réactif (non-bloquant)                        |
| **Gestion des threads**   | Bloque le thread en attente de la réponse     | Libère le thread, réponse via callbacks        |
| **Types de retour**       | Objets Java simples (String, List<T>, etc.)   | Types réactifs (Uni, Multi)                   |
| **Performances**          | Moins efficace sous forte charge              | Plus efficace pour les environnements scalables |
| **Courbe d'apprentissage**| Facile, même pour les débutants               | Nécessite une connaissance des paradigmes réactifs |
| **Cas d'utilisation**     | Applications traditionnelles ou monolithiques | Microservices, systèmes réactifs à grande échelle |

# Securité: authentification et habilitation
Quarkus supporte un grand nombre de méthodes d’authentification différentes : HTTP Basic, Bearer Token, mTLS
fournisseurs d’authentification différents : properties file, JWT, OIDC, LDAP, BDD…
## L'authentification via fichier de configuration
quarkus.security.users.embedded.enabled=true 
quarkus.security.users.embedded.plain-text=true 
quarkus.security.users.embedded.users.jdoe=p4ssw0rd 
quarkus.security.users.embedded.users.admin=n0Adm1n 
quarkus.security.users.embedded.roles.jdoe=user 
quarkus.security.users.embedded.roles.admin=user,admin 

## L'habilitation via annotations
Quarkus supporte les annotations Common Security permettant de définir des habilitations. Ces annotations doivent être ajoutées sur une méthode dont on veut restreindre l’appel en fonction des rôles de l’utilisateur :
`@RolesAllowed("user")` : seul un utilisateur ayant le rôle user peut appeler cette méthode.

`@PermitAll` : tout le monde peut appeler cette méthode, y compris un utilisateur non authentifié (accès anonyme).

`@DenyAll` : personne ne peut appeler cette méthode.

## L'habilitation via fichier de configuration
définir les habilitations dans le fichier application.properties
Tout d’abord, il faut définir des politiques de rôles :
quarkus.http.auth.policy.role-policy1.roles-allowed=user,admin 
quarkus.http.auth.permission.roles1.paths=/secured/*,/other/* 
quarkus.http.auth.permission.roles1.policy=role-policy1 
quarkus.http.auth.permission.roles1.methods=GET

La règle de permission roles1 va définir la politique role-policy-1 pour les chemins d’URL /secured/* et /other/* et la méthode HTTP GET (qui est la méthode par défaut). Ces chemins vont donc être restreints aux utilisateurs ayant les rôles user et admin pour la méthode HTTP GET.
exemple:
quarkus.http.auth.policy.user.roles-allowed=user 
quarkus.http.auth.policy.admin.roles-allowed=admin 
quarkus.http.auth.permission.authenticated.paths=/products/* 
quarkus.http.auth.permission.authenticated.policy=authenticated 
quarkus.http.auth.permission.permit.paths=/products/search 
quarkus.http.auth.permission.permit.policy=permit 
quarkus.http.auth.permission.user.paths=/products/* 
quarkus.http.auth.permission.user.policy=user 
quarkus.http.auth.permission.user.methods=POST,PUT 
quarkus.http.auth.permission.admin.paths=/products/* 
quarkus.http.auth.permission.admin.policy=admin 
quarkus.http.auth.permission.admin.methods=delete

# Gestion du Cache
<!-- dependance -->
<dependency> 
  <groupId>io.quarkus</groupId> 
  <artifactId>quarkus-cache</artifactId> 
</dependency> 
Pour mettre en cache le résultat d’une méthode, il faut annoter cette méthode avec `@CacheResult`

ex:
``` java
@GET 
@CacheResult(cacheName = "product-cache") 
public Collection<ProductEntity> list() { 
    return ProductEntity.listAll(); 
}
```

# Cloud Ready et Cloud native
| **Aspect**             | **Cloud-Ready**                                                         | **Cloud-Native**                                           |
|----------------------- |---------------------------------------------------------------          |------------------------------------------------------------|
| **Conception**         | Conçu pour être déployé dans le cloud, mais pas optimisé pour celui-ci. | Conçu spécifiquement pour tirer parti des fonctionnalités du cloud. |
| **Architecture**       | Souvent monolithique ou avec des adaptations pour le cloud.             | Basée sur des microservices, conteneurisée, et évolutive.   |
| **Scalabilité**        | Peut être mise à l'échelle, mais pas automatiquement ou dynamiquement.  | Mise à l'échelle automatique et dynamique en fonction de la demande. |
| **Résilience**         | Peut nécessiter des ajustements pour gérer les pannes dans le cloud.    | Conçu pour être résilient avec une tolérance aux pannes intégrée. |
| **Conteneurisation**   | Pas nécessairement conteneurisé.                                        | Généralement conteneurisé (par exemple, Docker).            |
| **Orchestration**      | Peut nécessiter une orchestration manuelle.                             | Utilise des outils d'orchestration comme Kubernetes.         |
| **Flexibilité**        | Moins flexible et dépendant de l'infrastructure.                        | Très flexible et adaptable aux services cloud.             |
| **Mise à jour**        | Mise à jour traditionnelle, souvent par déploiement manuel.             | Déploiements fréquents, souvent via CI/CD et DevOps.        |
| **Exemple**            | Application monolithique migrée vers le cloud.                          | Application microservices conteneurisée, déployée sur Kubernetes. |

# Test de santé
<dependency> 
    <groupId>io.quarkus</groupId> 
    <artifactId>quarkus-smallrye-health</artifactId> 
</dependency> 

Il existe trois types de tests :
`Test de vie (liveness check)` : l’application fonctionne correctement ; disponible à l’URL http://localhost:8080/q/health/live.
`Test de préparation (readiness check)` : l’application est prête à recevoir du trafic ; disponible à l’URL http://localhost:8080/q/health/ready.
`Test de démarrage (startup check)` : l’application a correctement démarré; disponible à l’URL http://localhost:8080/q/health/startup.


# Metrologie
<dependency> 
    <groupId>io.quarkus</groupId> 
    <artifactId>quarkus-micrometer-registry-prometheus</artifactId> 
</dependency>
En résumé, la métrologie dans Quarkus avec Cloud-Ready permet de surveiller et d'optimiser les performances des applications dans un environnement cloud. Grâce à des extensions comme SmallRye Metrics et SmallRye Health, vous pouvez collecter des métriques, surveiller la santé de vos services, et intégrer ces données dans des systèmes de gestion de cloud, offrant ainsi plus de visibilité et de contrôle sur le fonctionnement de votre application en production

# OpenTracing et OpenTelemetry
OpenTracing et OpenTelemetry sont des outils pour le tracing distribué, qui aident à surveiller et à déboguer les applications distribuées. Dans le cadre de Quarkus, ces technologies permettent de tracer les requêtes à travers plusieurs services pour comprendre les performances et détecter les problèmes.

## OpenTracing dans Quarkus
**Principe:** OpenTracing fournit une API standardisée pour le traçage distribué. Il permet de suivre une requête d'un service à l'autre et de collecter des données sur son parcours (traces).
**Config:** ./mvnw quarkus:add-extension -Dextensions="quarkus-opentracing"
        - Application.properties
        quarkus.jaeger.service-name=my-service
        quarkus.jaeger.endpoint=http://localhost:14268/api/traces
        quarkus.jaeger.sampler-type=const
        quarkus.jaeger.sampler-param=1

## OpenTelemetry dans Quarkus
**Principe:** OpenTelemetry est l'évolution d'OpenTracing et d'OpenCensus. Il unifie le traçage distribué, la collecte de métriques et le logging.
**Config:** ./mvnw quarkus:add-extension -Dextensions="quarkus-opentelemetry"
        - Application.properties
        quarkus.opentelemetry.tracer.exporter.otlp.endpoint=http://localhost:4317
        quarkus.opentelemetry.tracer.exporter.otlp.enabled=true
        quarkus.opentelemetry.tracer.sampler-probability=1.0

## fonctionnalités communes
`Injection automatique des spans :`
Avec les extensions, Quarkus injecte automatiquement les traces dans vos appels REST, Kafka, JDBC, etc.
`Instrumentation automatique :`
Pas besoin de beaucoup de code supplémentaire : Quarkus instrumente automatiquement les frameworks courants (resteasy, Hibernate, etc.).
`Visualisation des traces :`
Les traces collectées peuvent être envoyées à des outils comme Jaeger ou Zipkin pour une analyse graphique.

| **Aspect**          | **OpenTracing**             | **OpenTelemetry**          |
|----------------------|-----------------------------|-----------------------------|
| **Standard**         | Ancien standard            | Remplace OpenTracing        |
| **Fonctionnalités**  | Traçage uniquement         | Traçage, métriques, logging |
| **Support Quarkus**  | `quarkus-opentracing`      | `quarkus-opentelemetry`    |
| **Évolution**        | Déprécié (non maintenu)     | Actif et recommandé         |

# tolérance à la pannes
**Principe:** dans Quarkus est basée sur la spécification MicroProfile Fault Tolerance, qui fournit des mécanismes pour gérer les erreurs et maintenir la résilience des applications. Elle permet de définir des stratégies comme les timeouts, les circuits breakers, les tentatives automatiques (retries), et le fallback. Voici comment cela fonctionne 
**Config:**  ./mvnw quarkus:add-extension -Dextensions="quarkus-smallrye-fault-tolerance"
## Activation via annotations
| **Annotation**      | **Fonction**                                                                                           |
|----------------------|-------------------------------------------------------------------------------------------------------|
| `@Retry`            | Relance automatiquement une opération en cas d'échec.                                                |
| `@Timeout`          | Définit un délai limite pour qu'une opération se termine, sinon elle échoue.                          |
| `@CircuitBreaker`   | Interrompt temporairement les appels vers une méthode en cas d'échecs répétés.                        |
| `@Fallback`         | Définit une méthode alternative à appeler en cas d'échec.                                            |
| `@Bulkhead`         | Limite le nombre d'exécutions simultanées d'une méthode pour éviter la surcharge du système.          |

## Dev UI
Le dev UI de Quarkus pour la tolérance à la panne est un outil puissant qui facilite la compréhension, la surveillance et l'optimisation des stratégies de résilience dans votre application.
./mvnw quarkus:dev
http://localhost:8080/q/dev <!--Accéder au dev UI-->

# GraalVM
### Principe de GraalVM avec Quarkus

| **Aspect**                      | **Description**                                                                                   |
|----------------------------     |---------------------------------------------------------------------------------------------------|
| **Démarrage ultra-rapide**      | Les applications compilées avec GraalVM démarrent en quelques millisecondes.                     |
| **Faible consommation mémoire** | Les binaires natifs consomment beaucoup moins de mémoire qu'une JVM traditionnelle.         |
| **Portabilité**                 | Les binaires natifs sont autonomes et ne nécessitent pas de JVM pour être exécutés.              |
| **Idéal pour le cloud**         | Réduction des coûts grâce à une empreinte mémoire et un temps de démarrage faibles.              |
| **Intégration avec Kubernetes** | Les microservices compilés en natif fonctionnent parfaitement dans des environnements containers. |

---

### Fonctionnement de GraalVM avec Quarkus

| **Étape**                  | **Description**                                                                                   |
|----------------------------|---------------------------------------------------------------------------------------------------|
| **Phase de développement** | En mode JVM, Quarkus fonctionne comme une application Java classique, avec live reload.          |
| **Compilation native**     | Utilisation de GraalVM pour générer un binaire natif via SubstrateVM lors du build.               |
| **Exécution native**       | Le binaire natif est autonome et peut être exécuté directement sans JVM.                         |
| **Optimisations**          | GraalVM élimine les chemins de code inutiles, optimise les reflections et génère du code efficace.|

---

### Avantages de GraalVM avec Quarkus

| **Avantage**               | **Description**                                                                                   |
|----------------------------|---------------------------------------------------------------------------------------------------|
| **Démarrage rapide**       | Les binaires natifs démarrent instantanément.                                                    |
| **Faible empreinte mémoire** | Les applications consomment moins de ressources en production.                                |
| **Adapté aux containers**  | Applications légères et optimisées pour Kubernetes.                                             |
| **Portabilité**            | Les binaires peuvent être exécutés sur différents systèmes sans JVM.                            |
| **Réduction des coûts**    | Moins de ressources nécessaires, idéal pour les environnements cloud et serverless.             |

---

### Limitations de GraalVM avec Quarkus

| **Limitation**             | **Description**                                                                                  |
|----------------------------|--------------------------------------------------------------------------------------------------|
| **Support des APIs limité** | Certaines parties de la bibliothèque standard Java nécessitent des configurations spéciales.    |
| **Temps de compilation**    | La compilation native peut être plus longue que la compilation JVM classique.                   |
| **Taille des binaires**     | Les binaires natifs peuvent être plus volumineux que les fichiers `.jar`.                       |
| **Compatibilité des librairies** | Certaines librairies Java nécessitent des ajustements pour fonctionner correctement avec GraalVM. |



## Compilation native avec Quarkus
`execution en mode JVM`
./mvnw quarkus:dev

`Compilation et exécution en mode natif`
Maven: ./mvnw package -Pnative
CLI: quarkus build --native
<!-- Le binaire natif sera généré dans le dossier target ou build. Par exemple -->
target/my-app-runner

## Cas d'utilisation
**Serverless :** Utilisez un binaire natif pour AWS Lambda ou Google Cloud Functions.
**Microservices :** Démarrage ultra-rapide et faible consommation pour Kubernetes.
**Environnements embarqués :** Applications légères pour l’IoT ou l’edge computing.

## Monitoring et débogage
Déboguer et monitorer une application native compilée avec GraalVM nécessite des outils et des pratiques spécifiques, car les binaires natifs n’offrent pas les mêmes mécanismes de débogage qu’une JVM classique

### Ajout de symboles de débogage pendant la compilation
`./mvnw package -Pnative -Dquarkus.native.debug.enabled=true`
Cela permet d'inclure des symboles de débogage dans le binaire natif, ce qui facilite l'analyse avec des outils comme GDB

### Utilisation de GDB pour le débogage
`sudo apt install gdb`
**Executer avec GBD**
Lancez votre binaire natif avec GDB:
`gdb ./target/my-app-runner`
Une fois dans GDB, démarrez le programme :
`run`
Si le programme plante, vous pouvez afficher la pile d'appels:
`backtrace`
Ajoutez des points d'arrêt pour analyser le comportement :
`break main`

### Outils/Techniques
| **Aspect**          | **Outils/Techniques**                                     |
|-------------------  |----------------------------------------------------------|
| **Débogage**        | GDB, symboles de débogage, logs détaillés                 |
| **Monitoring**      | Prometheus, Grafana, OpenTelemetry (Jaeger, Zipkin)       |
| **Profiling**       | perf, GraalVM Dashboard                                   |
| **Tests de charge** | JMeter                                                 |
| **Kubernetes**      | Probes (liveness/readiness), intégration Prometheus/Kiali/Jaeger |

### Différence entre Débogage JVM et Native
| **Aspect**          | **Débogage JVM**                            | **Débogage natif (GraalVM)**            |
|---------------------|---------------------------------------------|-----------------------------------------|
| **Environnement**   | JVM avec introspection dynamique            | Binaire natif sans machine virtuelle    |
| **Outils principaux** | IntelliJ, Eclipse, JVisualVM, JProfiler   | GDB, perf, OpenTelemetry                |
| **Exceptions**      | Pile d’appels détaillée                     | Pile brute si symboles activés          |
| **Profiling**       | Flight Recorder, VisualVM                   | perf, Valgrind                          |
| **Logs et traces**  | SLF4J, Logback                              | Logs intégrés, OpenTelemetry            |
| **Portabilité**     | Identique sur toutes les plateformes        | Dépendant de la plateforme cible        |



# déboguer une application native sur VSCode de bout en bout
## Prérequis
**extension:** 
Debugger for Java (optionnel si vous utilisez un environnement mixte).
Native Debug : Une extension pour déboguer les binaires natifs
Compiler l’application avec des symboles de débogage
./mvnw package -Pnative -Dquarkus.native.debug.enabled=true

**Installer GDB:**

## Configuration VSCode
fichier .vscode/launch.json:
``` json
{
  "version": "0.2.0",
  "configurations": [
    {
      "name": "Debug Native App",
      "type": "cppdbg",
      "request": "launch",
      "program": "${workspaceFolder}/target/my-app-runner", // Chemin vers le binaire natif
      "args": [], // Arguments de ligne de commande pour l'application
      "stopAtEntry": false,
      "cwd": "${workspaceFolder}",
      "environment": [],
      "externalConsole": false,
      "MIMode": "gdb",
      "setupCommands": [
        {
          "description": "Enable pretty-printing for gdb",
          "text": "-enable-pretty-printing",
          "ignoreFailures": true
        }
      ]
    }
  ]
}
 ```
**Points clés de la configuration :**
`program :` Chemin du fichier binaire compilé (généralement dans target/).
`args `: Arguments à passer à l'application (par exemple, paramètres de démarrage).
`MIMode `: Défini sur gdb, car GDB est utilisé pour déboguer les binaires natifs.

# Google Cloud Functions
Google Cloud Functions est un service de computing serverless proposé par Google Cloud Platform (GCP). Il permet de déployer et exécuter des fonctions dans le cloud sans se préoccuper de la gestion des serveurs ou de l'infrastructure.

## Principe de fonctionnement
### Evénements déclencheurs:
Google Cloud Functions s’exécute en réponse à des événements. Ces événements peuvent provenir de diverses sources :
***HTTP :*** Une requête HTTP déclenche la fonction.
***Cloud Pub/Sub :*** Un message publié sur un topic déclenche la fonction.
***Cloud Storage :*** Un événement sur un fichier (création, modification, suppression) déclenche la fonction.
***Firebase :*** Événements provenant de Firebase, comme des mises à jour en base de données.
***Cloud Scheduler :*** Programmation de fonctions pour s’exécuter à intervalles réguliers.

### Environnement serverless:
Pas besoin de provisionner ou de gérer des serveurs.
Les fonctions s'exécutent dans un environnement isolé.
Les ressources (CPU, mémoire) sont allouées automatiquement en fonction de la demande.

### développement basé sur des fonctions:
Chaque Google Cloud Function est une fonction unique, définie par le développeur, et exécutée en réponse à un événement.
Les fonctions peuvent être écrites dans plusieurs langages supportés : Node.js, Python, Go, Java, C#, Ruby.

### Scalabilité automatique:
Les fonctions scalent automatiquement selon la charge :
Une seule invocation de fonction peut être gérée.
Des centaines ou des milliers d’instances de la fonction peuvent être exécutées en parallèle si nécessaire

### Exécution stateless :
Les fonctions sont stateless, c'est-à-dire qu'elles n'ont pas de persistance locale entre les invocations.
Toute persistance doit être gérée via des services externes comme Cloud Storage, Firestore ou une base de données

### Avantages:
***Optimisation des coûts :*** Facturation basée uniquement sur le temps d’exécution et la quantité de ressources consommées.
***Intégration GCP native :*** Facilement connecté aux autres services Google Cloud (Pub/Sub, Storage, Firebase, etc.).

### Limitation et défis:
***Durée d'exécution limitée :***
Une fonction peut s'exécuter jusqu’à un maximum de 9 minutes.
Pour des traitements longs, utilisez des alternatives comme Cloud Run ou des workflows.
***Cold starts :***
Si une fonction n'a pas été utilisée depuis un certain temps, il peut y avoir un délai de démarrage (cold start).
Utiliser des techniques comme le maintien actif (keep-alive) pour minimiser ce délai.

***Dépendances externes :***
Si votre fonction nécessite des bibliothèques externes, elles doivent être empaquetées et déployées avec le code

### Outils pour déboguer et tester
***Tests locaux :***
Google propose des outils comme functions-framework pour exécuter et tester les fonctions localement.
***Supervision :***
Intégration avec Cloud Logging et Error Reporting pour traquer les erreurs.

Etapes pour utiliser Google Cloud Functions avec Quarkus
./mvnw quarkus:add-extension -Dextensions="google-cloud-functions-http"
**Configurer le packaging** 
<plugin>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-maven-plugin</artifactId>
    <version>${quarkus.version}</version>
    <executions>
        <execution>
            <goals>
                <goal>build</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <output-target>google-cloud-functions</output-target>
    </configuration>
</plugin>

**Compiler**
./mvnw package



# Comparaison entre SAM et Google Cloud Function
| **Aspect**                   | **AWS SAM**                                                       | **Google Cloud Functions**                                  |
|------------------------------|-------------------------------------------------------------------|-------------------------------------------------------------|
| **Définition**                | Framework pour déployer des applications serverless sur AWS.      | Service géré pour exécuter des fonctions cloud sur Google Cloud. |
| **Déploiement**               | Utilise des modèles YAML pour définir et déployer des stacks CloudFormation. | Déploiement simple via `gcloud` ou la console Google Cloud. |
| **Écosystème**                | Spécifique à AWS (Lambda, API Gateway, S3, etc.).                | Spécifique à Google Cloud (Pub/Sub, Storage, etc.).          |
| **Types d'événements**        | Large support (HTTP, S3, DynamoDB, SNS, etc.).                   | Supporte HTTP, Pub/Sub, Cloud Storage, Firestore, etc.      |
| **Langages supportés**        | Java, Python, Node.js, Go, Ruby, etc.                            | Java, Python, Node.js, Go, .NET, etc.                       |
| **Gestion des dépendances**   | Dépend de l'environnement du runtime AWS Lambda.                 | Gère les dépendances via le runtime Google Cloud.           |
| **Personnalisation**          | Très flexible grâce aux modèles SAM et CloudFormation.           | Personnalisation limitée, orientée vers la simplicité.      |
| **Portabilité**               | Déploiement principalement sur AWS, mais exportable via des outils tiers. | Déploiement natif sur Google Cloud, moins portable.         |
| **Performances**              | Démarrage rapide, optimisé pour AWS Lambda.                      | Démarrage rapide, optimisé pour Google Cloud Functions.     |
| **Monitoring et logs**        | AWS CloudWatch pour logs et métriques.                           | Google Cloud Monitoring et Logging pour logs et métriques.  |
| **Outils CLI**                | `sam` CLI pour déploiement et tests locaux.                      | `gcloud` CLI pour gestion des fonctions.                    |
| **Interopérabilité**          | Intégration facile avec d'autres services AWS.                   | Intégration facile avec d'autres services Google Cloud.     |
| **Flexibilité de la configuration** | Hautement configurable avec SAM templates.                    | Configuration simple via CLI ou Console.                    |

# Framework comme SAM:
| **Outil/Framework**           | **Description**                                                                                   | **Écosystème**            | **Similarité avec SAM**                                                                                      |
|-------------------------------|---------------------------------------------------------------------------------------------------|---------------------------|-------------------------------------------------------------------------------------------------------------|
| **Serverless Framework**      | Framework open-source pour déployer des applications serverless sur plusieurs plateformes.       | AWS, Google Cloud, Azure, etc. | Approche multi-cloud, plus flexible que SAM, mais avec une courbe d'apprentissage plus large.              |
| **CloudFormation**            | Service d'infrastructure-as-code pour gérer des ressources AWS.                                 | AWS                       | SAM est un sur-ensemble simplifié de CloudFormation pour les workloads serverless.                         |
| **AWS CDK (Cloud Development Kit)** | Infrastructure-as-code via des langages de programmation (TypeScript, Python, Java, etc.).       | AWS                       | Plus orienté développeur, permet de définir des applications serverless avec un contrôle précis.           |
| **Google Deployment Manager** | Service d’infrastructure-as-code pour définir des ressources sur Google Cloud.                  | Google Cloud              | Comparable à CloudFormation, mais pour l’écosystème Google. Moins optimisé pour serverless.                |
| **Google Cloud Run**          | Plateforme serverless pour exécuter des conteneurs, semblable à AWS Lambda dans un contexte conteneurisé. | Google Cloud              | Moins spécifique aux fonctions que SAM, plus adapté aux workloads conteneurisés.                           |
| **Azure Resource Manager (ARM)** | Infrastructure-as-code pour gérer des ressources sur Azure.                                   | Azure                     | Équivalent de CloudFormation/SAM pour Azure, mais avec une approche centrée sur les ressources.            |
| **Terraform**                 | Outil open-source pour gérer l'infrastructure sur plusieurs clouds avec une approche déclarative. | Multi-cloud               | Alternative multi-cloud populaire, plus flexible mais pas spécifique aux applications serverless.          |
| **Pulumi**                    | Outil d’infrastructure-as-code utilisant des langages de programmation.                         | Multi-cloud               | Similaire au CDK, mais multi-cloud et plus orienté développeur que SAM.                                    |
| **Knative**                   | Framework pour exécuter des workloads serverless sur Kubernetes, souvent utilisé avec Cloud Run. | Kubernetes                | Moins spécifique que SAM, centré sur les applications conteneurisées et Kubernetes.                        |


# SAM
AWS SAM (Serverless Application Model) est un framework de développement pour la création et le déploiement d'applications serverless sur AWS. Il permet de définir facilement des ressources serverless telles que AWS Lambda, API Gateway, DynamoDB, S3, et d'autres services AWS dans un fichier de configuration

***template.yaml***
``` yml
AWSTemplateFormatVersion: '2010-09-09'
Transform: 'AWS::Serverless-2016-10-31' # Transform : Cette directive indique à CloudFormation que ce modèle est un modèle SAM
Description: this is a description

Parameters: # La section Parameters est utilisée pour déclarer des paramètres dynamiques qui peuvent être spécifiés au moment du déploiement
  Environment:
    Type: String # Indique que ce paramètre est une chaine de caractère
    Default: "preprod" # Si l'utilisateur ne fournit pas de valeur pour ce paramètre au moment du déploiement, la valeur par défaut sera utilisée
    AllowedValues: # Spécifie une liste des valeurs acceptées pour ce paramètre
      - preprod
      - prod

Resources: #  C'est la section où les ressources AWS sont définies
  HelloWorldFunction: # doit être descriptif et indique ce que fait la ressource
    Type: 'AWS::Serverless::Function' # une fonction Lambda est définie, pour dire que l'application est une fonction Lambda
    Properties: # Chaque ressource a des propriétés qui décrivent les caractéristiques de la ressource (par exemple, le runtime de la fonction, la mémoire allouée, le chemin du code, etc.)
      Handler: 'index.handler'
      Runtime: 'nodejs14.x'
      CodeUri: './src'
      MemorySize: 128
      Timeout: 10
  ApiGateway:
    Type: 'AWS::Serverless::Api'
    Properties:
      StageName: 'prod'
```

##  Déploiement d'une application avec SAM
**Build (compilation) de l'application**
sam build
or
mvn clean package
**Déploiement avec SAM**
sam deploy --stack-name kupload-capacity-preprod -t template.yaml Environment=preprod --profile 567547540856_AWS-Legacy-Production-DevLambda

## Test Locaux avec SAM CLI

# create project aws with mvn
mvn io.quarkus.platform:quarkus-maven-plugin:3.8.6:create -DprojectGroupId=<com.kowee.kslack> -DprojectArtifactId=<kslack> -Dextensions="<amazon-sns>"
sam deploy --guided --profile <010330705227_AWS-Sandbox-PowerUser> Environment=<preprod>
  Stack Name [sam-app]: MonNomDeStack
  AWS Region [us-east-1]: eu-west-3
sam deploy -t <template.yaml> -g --profile <10330705227_AWS-Sandbox-PowerUser> Environment=<preprod>
sam deploy --stack-name <kslack-preprod> -t template.yaml Environment=<preprod> --profile <567547540856_AWS-Legacy-Production-DevLambda > 
sam delete --stack-name <kupload-capacity-preprod> --profile <567547540856_AWS-Legacy-Production-DevLambda>



