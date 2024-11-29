# SFTP: SSH File Transfer Protocol
C'est un protocole sécurisé utilisé pour transfèrer defs fichier sur un réseau. il fonctionne sur SSH(Secure Shell)

## Installation du serveur SSH
sudo apt-get install openssh-server
## Configuration de l'accès SFTP
Le fichier de configuration se trouve dans `/etc/ssh/sshd_config`
Match User sftpuser // sftpuser = remplacer le nom de l'utilisateur qu'on veut restreindre
    ForceCommand internal-sftp
    PasswordAuthentication yes
    ChrootDirectory %h
## Créer un utilisateur pour SFTP
sudo apt adduser sftpuser

sudo systemctl restart ssh <!--permet d'appliquer les restrictions d'accès SFTP pour l'utilisateur spécifié --> 

## Lancement dans l'utilisateur
sudo apt install putty //  PuTTY est un client SSH flexible et puissant qui offre une solution pratique pour se connecter à des serveurs distants de manière sécurisée et pour effectuer des tâches d'administration système et de transfert de fichiers.

sftp `<utilisateur>`@<adresseIP_serveur> // permet de lancer le sftp
sftp -oPort=`<port>` <nom_server>@`<adresseIP>`

put 'chemain_local_fichier' // permet de déplacer le fichier ou dossier dans le serveur à partir du sftp
ls -l // pour voir la permission si on a accées et modifier si on a pas
chmod <777> `<fichier or dossier>` // permet de changer la permission du fichier 777: (2² 2¹ 2⁰)(2² 2¹ 2⁰)(2² 2¹ 2⁰)
(x) = 1, (w) = 2 et r = 4
