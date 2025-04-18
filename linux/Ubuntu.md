site: snapcraft.io = permet de télécharger les application Linux

~ = tild

    // téléchargement fichier ubuntu
sudo dpkg -i <nom_fichier> // faut allez dans le placement du fichier
./<nom_fichier>.sh = permet d'installer un fichier avec un fichier .sh
    // désinstallation application
sudo apt remove <nom_app> --purge

sudo snap refresh <nom_app> = permet d'installer la dérnière version de l'app

vi nom_fichier = permet d'afficher un editeur de texte du nom de fichier
            // Esc = pour qu'il ne soit plus en mode editeur
            // :q! = Pour quitter sans enregistrer les modifications
            // :wq = Pour enregistrer les modifications et quitter
            // :w = Pour enregistrer les modifications sans quitter
    # Multipass permet de créer facilement 2 machines virtuelles Ubuntu en local
multipass launch -n node1 // sur laquelle on install Docker
multipass launch -n store // dans laquelle persisitées les données via le driver sshfs

tar -xf <ficher_à_extraire> = permet d'extraire un fichier

snap. version ubuntu.

ubuntu avec python
Aprennez linux par la pratique

    // Desinstallation logiciel
sudo apt-get remove --purge <nom_logiciel>
sudo apt autoremove // permet de supprimer les fichiers indésirable

    // MAJ nodejS: latest
sudo npm install -g n  // -g : veut dire que l'installation est global sur mon pc mais pas local sur l'appli
sudo n lts = permet d'installer la dérnière version


    // MAJ ubuntu en dernière version sans perdre de données
sudo apt dist-upgrade
sudo do-release-upgrade


    // transforme fichier en .zip
zip <nom_zip.zip> <nom_fichier>




    // Les dossiers racines
/ = Répertoire "root" à la base de tout les système de fichiers
/bin = Contient les binaires et les exécutables du système
/etc = Fichier de configuration assurant le comportement des applications, et fonctions du système
/home = Répertoires personnels des utilisateurs du système (ali)
/opt = logiciel tiers application optionnel qui ne sont pas fournis par le gestionnaire de paquets du système 
/tmp = Espace entièrement effacé à chaque démarrage du système, utilisé pour les fichers temporaires
/usr = Programmees en lien avec l'utilisateur
/var = Fichiers à variation, des fichiers dont le contenu change fréquemment pendant l'exécution du système

     // cat = commande de vérification ou visualisation du fichier
cat /etc/hostname = permet de vérifier le nom de la machines
cat /etc/issue = permet de vérifier la version de Ubuntu
cat /etc/passwd = affiche le contenue du fichier /etc/passwd qui contient les information sur les utilisateurs du système
    // nano  = éditeur nano
nano /path/fichier = permet d'ouvrir le fichier dans un éditeur
whoami = permet de vérifier le nom de l'utilisateur de linux
~(dans la commande) = le tild fait réferance à /home/ali 
$ = permet de savoir qu'on est sur une utilisateur standard
# = permet de savoir qu'on est sur un administrateur système (On a tout le droit)

    // man (manual)
man <command> = permet de voir la manual de la command
man -k <command> = permet de rechercher les occurences du mot "command" dans toutes les pages du manuel

sudo su = permet de changer en super-utilisateur root

    // Alias
alias ld='ls -l'  = permet de créer un racourcis de la commande ls -l
// ajouter les alias dans le fichier /home/.bashrc

    // adresseIP
ip a = permet de voir l'adresse IP du machine

    // taille
du -sh /path_dossier = permet de voir la taille du dossier 
  -s: résume la taille totale du dossier
  -h: Rend la taille plus lisible pour les humains en (ko, Mo, Go)

du -h /path_fichier = permet de voir la taille du fichier

    // commande ls -l (ex: drwxr-xr-x 2 user group 4096 Jan 1 12:01 directory)
// permet de lister les fichiers et répertoires dans un répertoire avec des informations détaillées.
  Colonne1: Les permissions
Les 10 premiers caractére de chaque ligne représentent les permissions du fichier ou du répertoire
d(directory), r(read), w(write), x(execute), -(permissions absent): 
3 premiers caractère: ce que le propriétaire du fichier peut faire
3 caractères suivants: ce que les membres du groupe auquel appartient le fichier peut faire
3 caractères restant: permission des autres utilisateur

  Colonne2: Le nombre de lien

  Colonne3: Le propriétaire
Indique le nom du propriétaire du fichier ou du répertoire
  Colonne4: Le groupe
Indique le groupe auquel appartient le fichier ou le répertoire
  Colonne5: La taille
Indique la taille du fichier en octets
  Colonne6-8: La date de modification
Indique la date et l'heur de la dernière modification du fichier ou du répertoire
  Colonne9: Le nom du fichier ou du répertoire
Affiche le nom du fichier ou du répertoire

    // crontab
 //Crontab permet de planifier l'execution de tâches à des moments spécifiques
crontab -e // permet d'ouvrir l'éditeur de texte par défaut de l'utilisateur
0 */2 * * * date >> ~/date.log // la date sera afficher tout les 2 heures
min chaque_2_+heur chaque_jour chaque_mois chaque_jour/semaine command_a_executé >> redirige_vers_fichier

    //find (chercher les fichiers avec l'extension)
find / -type f -name "*.mp3" 2>/dev/null
/: Spécifie le point de départ de la recherche
-type f: Spécifie qu'on recherche uniquement des fichier
-type d: Spécifie qu'on recherche uniquement des dossier
-name "*.mp3": Spécifie qu'on recherche un fichier dont le nom se termine par .mp3
-name "*mp3*": Spécifie de chercher un fichier dont le nom contient mp3
2>/dev/null : Redirige les messages d'erreur vers /dev/null pour les ignorer. Cela empêche l'affichage de messages d'erreur concernant les répertoires inaccessibles.

    // desactiver le server display Waylland in gdm3 pour anydesk
sudo nano /etc/gdm3//custom.conf // permet de modifier la permission du server display
*decommenter la line "WaylandEnable=false"
*Modifier la line "AutomaticLogin=user1" to "AutomaticLogin=$USERNAME"
*Decommenter les deux lines "AutomaticLoginEnable=true" et "AutomaticLogin=$USERNAME"


ping google.com <!--permet de tester la connectivité réseau entre votre machine et le serveur de Google en envoyant des paquets ICMP (Internet Control Message Protocol)-->

