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
