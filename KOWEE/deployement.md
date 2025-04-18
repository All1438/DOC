# KBOOKING PREPROD
## EC2
LoadBalancing > Target Groups > TG-PREPROD-KBOOKING > ... > Terminate(delete) instance 
<!-- il y a de l'autoScaling et un instance va créer automatiquement -->
Launch Templates > LT-PREPROD-KBOOKING 
<!-- ou se trouve les scripts executer automatiquement apres chaque creation d'instance -->
## S3
koweebuild > preprod > kbooking
<!-- le path ou l'application va être déployer depuis S3 -->

## CloudWatch
Log Groups > <search_log> > /kowee/preprod/kbooking

## AmazonMQ


# KUPLOAD CAPACITY
## Lambda
Lambda > applications > kupload-capacity-preprod > KUploadCapacity > Monitor > View CloudWatch logs
<!-- permet de voir les logs si l'application a bien fonctionner-->
## S3
koweeupload > preprod > capacity
<!-- ou se trouve les fichiers traiter par l'application ou à traiter-->
## CloudFormation
<!-- ou se trouve les application lambda déployer -->

# MODULES PREPROD
## EC2
Instances > NEW-MODULES-PREPROD-JAVA21 > Connect > Session Manager
<!-- Pour se connecter à l'instance -->
## S3
rd.build > modules > newpreprod21
<!-- le path des modules à déployer-->

# Deployment KMQ
Un SG du ALB qui contrôle qui peut envoyer du trafic à ALB
Autoriser le trafic HTTP/HTTPS depuis Internet (0.0.0.0/0)
Autoriser un SG(MODULES-ADP-REC-SG) qui donne l'autorisation des modules

Un SG(SG-PREPROD-KMQ)
autorise le SG(ALB-ADP-REC-FILTERED-SG)

Un SG(RECETTE-BROKER-SG) pour activeMQ
autorise les ports 61617(ActiveMQ) et inclus SG(SG-PREPROD-KMQ)

SG(ALB-BACK-SG)
autorise les ports 80(HTTP) et inclus SG(SG-PREPROD-KMQ)

SG(ALB-ADP-REC-BACK-SG)
autorise les ports 80(HTTP) et inclus SG(SG-PREPROD-KMQ)

LT(Launch Template) qui contients les scripts a executer pendant le lancement du module. a chaque ASG(Auto Scaling Group)

# Deployment UploadCapacity
sam build
sam deploy -t template.yaml -g --profile <profil_aws> <!--si on veut déployé une autre environment de profil-->
sam deploy <!-- si s'était le même profil qu'avant>
sam delete --stack-name <stack_name> --profile <profil>