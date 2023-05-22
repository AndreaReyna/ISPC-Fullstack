# ISPC - Proyecto FullStack
## Libreria In47

### Tablero de trabajo: https://github.com/users/AndreaReyna/projects/4

### Wiki: https://github.com/AndreaReyna/ISPC-Fullstack/wiki


* 👨‍💻 Juan Manuel Sanchez Fin - Product Owner
* 👩‍🏫 Andrea Inés Reyna - Scrum Master
* :construction: Fiorella Cristina Melgarejo - Developer Full Stack
* :end: Franco Agustin Trivini De Elejalde - Developer Full Stack
* :book: Alejandro Celen - Admin DB
* :cop: Gonzalo Jesús Ezequiel Cuello - QA

___
## Como correr el repo?

1. Abrir una terminal en la carpeta donde vamos a clonar el proyecto


`git clone https://github.com/AndreaReyna/ISPC-Fullstack.git`


2. Navegar hasta la carpeta que contiene el proyecto en Angular


`cd front\library-in47`


3. Instalar paquetes y dependencias del proyecto


`npm install`


4. Si encuentra alguna vulnerabilidad, correr


`npm audit fix`


5. Chequear si tenemos JSON Server instalado


`json-server -v`

    - En caso de no tener instalado JSON-Server


    npm install -g json-server


6. Correr el JSON de prueba


`json-server --watch db.json`


7. Correr el servidor de Django


    - `cd ..`
    - `cd ..`
    - `cd back/in47/Scripts`
    - `activate`
    - `cd ..`
    - `cd library_site`
    - `python manage.py startapp libreriavirtual`
    - `python manage.py makemigration`
    - `python manage.py migrate`
    - `python manage.py runserver`


8. Correr el servidor de Angular


`ng serve -o`

___
## Django panel working!

![WhatsApp Image 2023-05-18 at 22 09 57](https://github.com/AndreaReyna/ISPC-Fullstack/assets/73613388/b57f9cb1-0bed-4fe0-858c-03e499060062)
