# Variable d'env
sudo apt update
sudo apt install python3-venv <!--installer le package-->
python3 -m venv <nom venv> <!--créer l'environnement virtuel-->
source venv/bin/activate <!--active l'environnement virtuel-->
which python <!--Pour confirmer qu'on travail sur la variable d'env ou non-->

# Dépendance
pip install PyPDF2 <!--convertion des PDF en text-->


