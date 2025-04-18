# Principe:
## EC2(Elastic Compute Cloud)
permet de créer et de gérer des instances de serveurs virtuels dans le cloud. Ces serveurs peuvent être utilisés pour exécuter des applications, des bases de données, ou d'autres types de charges de travail
**Elasticité** : Vous pouvez augmenter ou réduire la capacité de vos instances selon les besoins de votre application
**Tarification à la demande** : Vous payez uniquement pour les ressources que vous utilisez, avec la possibilité de choisir entre des tarifs à la demande ou des instances réservées pour un usage à long terme
**Types d'instances variés** : EC2 propose différents types d'instances adaptées à des charges de travail spécifiques (calcul, mémoire, stockage, GPU, etc.)

## EBS(Elastic Block Store)
 les volumes EBS sont stockés de manière durable dans le cloud, ce qui signifie que vos données sont conservées même si l'instance EC2 est arrêtée ou terminée
EBS est souvent utilisé pour stocker les systèmes de fichiers, les bases de données et d'autres types de données qui nécessitent une persistance.
La persistance désigne la capacité à conserver des données de manière durable
**Stockage persistant** : Les données restent disponibles même si l'instance EC2 est arrêtée ou terminée
**Volumes de stockage** : Vous pouvez attacher plusieurs volumes EBS à une instance EC2 pour étendre la capacité de stockage.
**Types de volumes** : AWS propose différents types de volumes EBS en fonction des besoins de performance et de durabilité (par exemple, SSD pour des performances rapides ou HDD pour un stockage à faible coût)

## ELB (Elastic Load Balancer)
ELB est un service d'AWS qui distribue automatiquement le trafic réseau entrant vers plusieurs instances EC2 ou ressources backend pour équilibrer la charge entre elles. Cela permet d'améliorer la disponibilité et la tolérance aux pannes des applications
**Scalabilité** : ELB ajuste automatiquement la répartition de la charge en fonction de la capacité des instances backend.
**Haute disponibilité** : Permet de distribuer le trafic sur plusieurs zones de disponibilité AWS pour assurer une disponibilité continue.
**Sécurisé**: Peut être intégré à AWS Certificate Manager pour gérer les certificats SSL/TLS et sécuriser le trafic.

EC2 : Fournit des instances de calcul (serveurs virtuels).
EBS : Fournit un stockage persistant pour les instances EC2.
ELB : Répartit le trafic réseau entrant entre plusieurs instances EC2 pour améliorer la disponibilité et la performance.

## Key Pair
est un élément essentiel pour sécuriser l'accès SSH à votre instance EC2, garantissant que seuls les utilisateurs ayant la clé privée correcte peuvent s'y connecter.
### Clé public
Associée par AWS à l'instance EC2 par défaut lors de sa création.
Elle est placée dans le fichier `~/.ssh/authorized_keys` de l'utilisateur par défaut (par exemple, ec2-user pour Amazon Linux).
Utilisée pour `vérifier les connexions entrantes provenant de clients SSH`
### Clé private
Générée en même temps que la clé publique lorsque vous `créez une paire de clés`.
`Fournie une seule fois` au moment de la création de la paire de clés.
Stockée sur votre machine locale ou dans un endroit sécurisé (par exemple, un gestionnaire de mots de passe).
Vous permet de vous `connecter à l'instance EC2 via SSH` en prouvant votre identité.

### Fonctionnement de la connexion avec la paire de clés :
Lorsque vous tentez de vous connecter via SSH, votre client utilise la clé privée pour signer la requête.
L'instance EC2 `compare cette signature avec la clé publique stockée`.
Si elles correspondent, l'accès est accordé. Sinon, la connexion est refusée.

## Network settings
### VPC (Virtual Private Cloud) :
**Définition** : Chaque instance EC2 est lancée dans un VPC, qui est un réseau virtuel isolé dans AWS.
**Fonctionnement** :
Vous pouvez créer plusieurs sous-réseaux (`subnets`) dans un VPC pour segmenter vos ressources.
Par exemple, un sous-réseau public pour `les serveurs web` et un sous-réseau privé pour `les bases de données`

### Subnet (Sous-réseau) :
**Définition** : Un sous-réseau est une subdivision du VPC dans une plage d'adresses IP donnée.
**Fonctionnement** :
Chaque instance EC2 doit être placée dans un sous-réseau.
`Un subnet public` permet à l'instance d'avoir accès direct à Internet (via une passerelle Internet).
`Un subnet privé` restreint l'accès direct à Internet, souvent utilisé pour des instances internes.
Quand tu crées un VPC, tu définis :
une plage d’adresses IP (CIDR block) – exemple 10.0.0.0/16
des subnets (réseaux + petits) : public / privé
des routes (tables de routage)
des passerelles (internet gateway, NAT gateway)
des security groups et ACLs (contrôle du trafic)


###  Security Group :
**Définition** : C'est un pare-feu virtuel qui contrôle le trafic entrant et sortant de votre instance.
**Fonctionnement** :
Vous configurez des règles pour autoriser ou bloquer certains types de trafic (par exemple, HTTP, HTTPS, SSH).
Exemple de règles :
Autoriser SSH (port 22) depuis une adresse IP spécifique.
Autoriser HTTPS (443)
Autoriser HTTP (port 80) depuis n'importe quelle adresse IP (0.0.0.0/0).

## Configure storage
permet de définir les disques attachés à l'instance, appelés volumes EBS

## Advanced Details



Résumé des coûts et flexibilité :

| Option                | Coût       | Flexibilité  | Engagement |
|-----------------------|------------|--------------|------------|
| On-Demand Instances   | Élevé      | Très élevé   | Aucun      |
| Reserved Instances    | Réduit     | Moyen        | 1-3 ans    |
| Savings Plans         | Réduit     | Élevé        | 1-3 ans    |
| Spot Instances        | Très bas   | Faible       | Aucun      |
| Dedicated Hosts       | Très élevé | Moyen        | 1-3 ans    |
| Dedicated Instances   | Élevé      | Moyen        | Aucun      |
| Capacity Reservations | Variable   | Élevé        | Aucun      |


Comparaison Spot Instance et Spot Fleet :

| **Critère**               | **Spot Instance**                                                              | **Spot Fleet**                                                                 |
|---------------------------|---------------------------------------------------------------------------------|--------------------------------------------------------------------------------|
| **Définition**             | Instance EC2 à tarif réduit en fonction de la capacité excédentaire disponible.  | Groupe d'instances EC2 Spot (et éventuellement On-Demand) géré automatiquement pour répondre aux besoins de capacité. |
| **Coût**                   | Très bas (jusqu'à 90 % de réduction par rapport aux On-Demand).                 | Dépend de la combinaison des types d'instances choisies (Spot, On-Demand, etc.), mais généralement plus économique. |
| **Disponibilité**          | Les Spot Instances peuvent être interrompues par AWS à tout moment si la capacité est nécessaire ailleurs. | Offre une gestion flexible des instances pour garantir que la capacité est respectée même en cas d'interruptions. |
| **Gestion de la capacité** | Besoin d'une gestion manuelle pour équilibrer les instances disponibles et les besoins. | AWS gère automatiquement la capacité nécessaire pour répondre aux besoins, en remplaçant les instances Spot interrompues. |
| **Durée**                  | Les Spot Instances peuvent être lancées et arrêtées à tout moment.              | Spot Fleet permet de maintenir une capacité constante en remplaçant les instances au besoin. |
| **Précaution d'interruption** | AWS prévient l'interruption avec un délai de 2 minutes.                     | Les Spot Fleet utilisent des mécanismes pour éviter les interruptions excessives en gérant le placement des instances. |
| **Cas d'utilisation**      | Idéal pour les tâches à court terme et tolérantes aux pannes (calculs par lots, tests, traitements de données). | Convient pour les applications nécessitant une capacité scalable et plus de contrôle sur la gestion de l'infrastructure. |
| **Délai d'exécution**      | Plus court car les instances sont allouées au fur et à mesure de la capacité excédentaire. | Plus stable à long terme car Spot Fleet gère les demandes et remplace automatiquement les instances si nécessaire. |
| **Automatisation**         | Nécessite une gestion manuelle pour redémarrer ou relancer des instances après une interruption. | Gère automatiquement les remplacements d'instances et ajuste les types d'instances pour respecter les besoins en capacité. |

***EC2>Instances>Spot Requests***
La section Spot Requests dans EC2 vous permet de suivre, gérer et interagir avec vos demandes d'instances Spot. Elle vous offre des informations détaillées sur l'état, les prix et la gestion de la capacité des instances Spot que vous avez demandées.



## Target Groupe (TG)
Un Target Group (TG) est un groupe de cibles (instances EC2, IPs, conteneurs, services Lambda) vers lesquelles un Load Balancer (ALB/NLB) distribue le trafic.
💡 Il sert d’intermédiaire entre le Load Balancer et les ressources backend
Le Target Group est un pont entre le Load Balancer et les instances, qui assure une répartition du trafic efficace et surveille la santé des cibles
**Définition** : Un Target Group est une liste d’instances ou de services qui vont recevoir le trafic provenant d’un Load Balancer (généralement un ALB ou NLB).
**Fonctionnement** : 
🌐 Un utilisateur envoie une requête (ex : via un navigateur).
📶 Le Load Balancer (ALB/NLB) reçoit la requête.
📦 Le Load Balancer transmet la requête au Target Group associé.
🖥️ Le Target Group distribue ensuite le trafic vers une ou plusieurs cibles (EC2, ECS, Lambda...).
**contient** :
Des targets (cibles) : ce sont généralement des instances EC2, des containers ECS, ou même des fonctions Lambda.
Un port cible (ex: 80 ou 8080)
Un protocole (HTTP, HTTPS, TCP, etc.)
Des règles de vérification de santé (health checks)

## Auto Scaling Group (ASG)
**Definition** : Un Auto Scaling Group est un service d’AWS qui permet de créer automatiquement, augmenter ou réduire le nombre d'instances EC2 selon des règles définies.
**Fonctionnement** : Tu définis un modèle de lancement (Launch Template) :
`Tu crées l'Auto Scaling Group (ASG)` :
Tu précises le nombre minimum, maximum et désiré d’instances.
Tu choisis les zones de disponibilité (AZ).
Tu lies un Target Group si les instances doivent recevoir du trafic via un ALB.
`Tu ajoutes des politiques de scaling` :
Ex : si la CPU > 70%, ajoute 1 instance.
Ex : si la CPU < 20%, retire 1 instance.

## Amazon Machine Image(AMI)
**Definition** : Une AMI est une image système préconfigurée qui contient tout ce qu’il faut pour lancer une instance EC2 :
Un système d’exploitation (Linux, Ubuntu, Windows…)
Des logiciels préinstallés (Java, Nginx, Python…)
Des fichiers de configuration
C’est un snapshot prêt à l’emploi pour créer rapidement des serveurs.
**Fonctionnement** :
Tu as installé ton app sur un serveur Ubuntu avec tout bien configuré.
Tu crées une AMI de cette instance.
Tu peux ensuite lancer autant d’instances identiques à partir de cette AMI.

## Launch Template(LT)
**Definition** : Un Launch Template est un modèle complet de configuration pour créer une instance EC2 ou pour un Auto Scaling Group.
Il inclut :
📦 L’AMI à utiliser
🖥️ Le type d’instance (ex: t3.medium)
🌍 Le VPC/Subnet
🔐 La clé SSH
📜 Des User Data scripts (scripts lancés au boot)
🔧 Des tags, volumes, IAM roles, etc.
Il permet d’automatiser et de standardiser la création d’instances.
**Fonctionnement** :
Pour que chaque instance lancée soit identique ✅
Pour les Auto Scaling Groups, EC2 Spot Fleets, ECS, etc.

## Application Load Balancer(ALB)
**Definition** : Un ALB (Application Load Balancer) est un service managé d’AWS qui sert à répartir intelligemment le trafic HTTP/HTTPS entre plusieurs instances ou services.
**Fonctionnement** :  Il agit comme une porte d’entrée publique pour ton application web :
Il reçoit les requêtes des utilisateurs via internet
Il vérifie les règles (ex: chemin URL ou host)
Il redirige le trafic vers le bon Target Group (TG), qui contient les instances EC2, ECS, Lambda…

## Availability Zone(AZ)
**DeUne Availability Zone, c’est un centre de données physique dans une région AWS.
👉 Une région AWS (comme eu-west-1 à Paris) est composée de plusieurs AZs (ex: eu-west-1a, eu-west-1b, eu-west-1c).