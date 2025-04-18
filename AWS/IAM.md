# Comparaison
| **Aspect**                 | **Rôle IAM**                                                                                                             | **Groupe d'utilisateurs IAM**                                                                       | **Politique IAM**                                                                             |
|--------------------------- |-----------------------------------------------------------------------------------------------------                     |--------------------------------------------------------------------------------------------         |------------------------------------------------------------------------------------------------|
| **Définition**             | Une entité IAM que d'autres entités (utilisateurs ou services) peuvent assumer pour obtenir des permissions temporaires. | Une collection d’utilisateurs IAM partageant des permissions définies par des politiques associées. | Un ensemble de règles définissant les permissions (actions et ressources) pour une entité IAM. |
| **Utilisation principale** | Donne des permissions temporaires à un service ou utilisateur pour accomplir une tâche spécifique.                       | Simplifie la gestion des permissions pour plusieurs utilisateurs IAM ayant des rôles similaires.    | Contrôle direct et granulaire des permissions d'accès aux ressources AWS.                    |
| **Entité associée**        | Peut être assumé par un utilisateur IAM, un rôle d’un autre compte, ou un service AWS via STS.                           | Associé uniquement à des utilisateurs IAM dans le même compte.                                      | Peut être attachée à un utilisateur IAM, un groupe, ou un rôle.                               |
| **Permissions**            | Définies par des politiques IAM attachées au rôle.                                                                       | Les utilisateurs héritent des permissions des politiques associées au groupe.                       | Définit les actions autorisées ou refusées sur des ressources spécifiques.                    |
| **Durée des permissions**  | Temporaire (via des credentials temporaires générés par l'API `AssumeRole`).                                             | Permanente (tant que l’utilisateur est dans le groupe).                                             | Permanente (tant qu’elle est attachée).                                                       |
| **Exemples d’utilisation** | - Donner à un service Lambda accès à un bucket S3.                                                                       | - Gérer les permissions d’un groupe d’administrateurs ou d’auditeurs.                               | - Contrôler l’accès en lecture à un bucket S3 ou aux instances EC2.                           |
| **Portée multi-comptes**   | Oui, un rôle peut être assumé par des entités dans d’autres comptes AWS.                                                 | Non, les groupes sont limités au compte où ils sont définis.                                        | Oui, une politique peut inclure des conditions ou des ressources d'autres comptes.            |
| **Attachement direct**     | Non applicable (on assume un rôle, pas d’attachement direct).                                                            | Les utilisateurs peuvent appartenir à plusieurs groupes.                                            | Peut être attachée directement à un utilisateur, un rôle ou un groupe.                       |
| **Gestion des permissions**| Plus flexible pour les tâches temporaires et les relations inter-comptes.                                                | Plus pratique pour gérer un ensemble fixe de permissions pour plusieurs utilisateurs.               | Fournit un contrôle granulaire, applicable directement ou via des groupes ou rôles.          |

## Résumé rapide :
Rôles IAM sont utilisés pour des permissions temporaires et des intégrations inter-comptes.
Groupes d'utilisateurs IAM permettent de gérer les permissions d'un ensemble d'utilisateurs de manière centralisée.
Politiques IAM définissent directement les actions autorisées ou refusées et sont la base des permissions dans AWS.

## Quand utiliser les groupes IAM au lieu des rôles IAM ?
Groupes IAM :

Si les utilisateurs ont besoin d’un accès permanent et constant à certaines ressources.
Exemple : Une équipe d'administrateurs ou de développeurs accédant quotidiennement à des buckets S3 ou EC2.
Rôles IAM :

Si les permissions doivent être temporaires ou accessibles à des services (comme une fonction Lambda ou une instance EC2).
Exemple : Une application qui accède temporairement à une base de données ou un utilisateur externe ayant un accès limité.

| **Type**          | **Scénario**                                                                                     |
|-------------------|-------------------------------------------------------------------------------------------------|
| **Rôle IAM**      | Une application Lambda ou EC2 assume un rôle pour accéder temporairement à des ressources.      |
| **Groupe IAM**    | Une équipe partage des permissions similaires (ex. : développeurs, administrateurs).            |
| **Politique IAM** | Définit des permissions spécifiques, appliquées à un utilisateur, un groupe ou un rôle.         |

# Role IAM

| **Type d'entité de confiance**      | **Description**                                                                 | **Utilisation courante**                                                                                     |
|-------------------------------------|---------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------|
| **AWS Service**                     | Service AWS comme Lambda, EC2, ECS.                                            | Permet aux services AWS d’interagir avec d’autres ressources AWS.                                           |
| **Another AWS Account**             | Un autre compte AWS (inter-compte).                                            | Partage de ressources entre organisations ou comptes AWS.                                                   |
| **Web Identity**                    | Fournisseurs d’identité web (Cognito, Google, etc.).                           | Applications mobiles ou web utilisant des utilisateurs externes authentifiés via des identités tierces.     |
| **SAML 2.0 Federation**             | Fournisseurs d’identité SAML (Okta, Active Directory, etc.).                   | Intégration avec un système SSO basé sur SAML.                                                              |
| **Custom Trusted Entities**         | Entités spécifiques (utilisateurs ou rôles IAM).                               | Accès granulaire pour une entité IAM particulière.                                                          |


## Role AWS
| Action IAM        | Description                                                                 | Pourquoi vous en avez besoin ?                                                  |
|--------------------|-----------------------------------------------------------------------------|---------------------------------------------------------------------------------|
| iam:GetRole        | Permet de lire les informations d'un rôle IAM (ex: politique de confiance, permissions). | Utile pour vérifier si un rôle existe ou inspecter ses propriétés.             |
| iam:PassRole       | Permet de passer un rôle IAM à un service AWS (ex: Lambda, EC2, ECS).      | Obligatoire pour que SAM/CloudFormation puisse attribuer un rôle IAM à votre fonction Lambda. |
| iam:CreateRole     | Permet de créer un nouveau rôle IAM.                                       | Nécessaire pour ajouter de nouveaux rôles IAM requis pour des services ou applications. |
| iam:DeleteRole     | Permet de supprimer un rôle IAM existant.                                 | Utilisé pour nettoyer des rôles inutilisés ou obsolètes.                       |
| iam:AttachRolePolicy | Permet d'attacher une politique IAM à un rôle existant.                  | Indispensable pour attribuer les permissions nécessaires à un rôle.            |
| iam:DetachRolePolicy | Permet de détacher une politique IAM d'un rôle existant.                 | Utilisé pour modifier ou révoquer des permissions associées à un rôle.         |
| iam:UpdateRole     | Permet de mettre à jour les informations d'un rôle IAM.                   | Utile pour modifier les politiques de confiance ou d'autres paramètres d'un rôle existant. |
| iam:ListRoles      | Permet de lister tous les rôles IAM dans le compte AWS.                   | Pratique pour identifier les rôles existants et leur utilisation.              |