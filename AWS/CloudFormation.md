# Definition:
AWS CloudFormation est un service d'AWS qui permet de modéliser, provisionner et gérer les ressources de votre infrastructure AWS de manière automatisée et reproductible. Il repose sur l'utilisation de fichiers de configuration appelés templates (en JSON ou YAML) pour décrire l'infrastructure souhaitée

# Pourquoi utiliser AWS CloudFormation ?
## Infrastructure as Code (IaC)
CloudFormation permet de gérer votre infrastructure sous forme de code, ce qui facilite la versioning, la collaboration et l'audit.
Cela remplace les configurations manuelles qui peuvent être sujettes aux erreurs.

## Automatisation :
CloudFormation automatise le processus de création, de mise à jour et de suppression des ressources AWS

## Réduction des erreurs :
En décrivant votre infrastructure dans un fichier, vous minimisez les erreurs dues aux configurations manuelles.

## Rollback automatique :
En cas d'erreur lors de la création ou de la mise à jour d'une stack, CloudFormation peut revenir automatiquement à l'état précédent pour garantir la stabilité.