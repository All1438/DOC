# Débogage
## App SpringBoot with JMS
``` json
{
    "version": "0.2.0",
    "configurations": [
      {
        "type": "java",
        "name": "Debug (Launch) - Spring Boot App with JMS",
        "request": "launch",
        "projectName": "nom-du-projet", // Facultatif
        "cwd": "${workspaceFolder}",
        "args": "-Dspring.profiles.active=dev", // Active le profil "dev"
        "vmArgs": "-Dspring-boot.run.jvmArguments=\"-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005\"",
        "console": "integratedTerminal",
        "env": {
          "JMS_BROKER_URL": "tcp://localhost:61616", // Exemple de variable d'environnement pour votre broker JMS
          "JMS_QUEUE_NAME": "kbookingin"          // Exemple de configuration pour la file d'attente JMS
        }
      },
      {
        "type": "java",
        "name": "Attach to Running Spring Boot App with JMS",
        "request": "attach",
        "hostName": "localhost",
        "port": 5005
      }
    ]
  }
```

## App Quarkus
``` json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "Debug Quarkus App",
            "request": "attach",
            "hostName": "localhost",
            "port": 5005
        },
        {
            "name": "Launch Quarkus Dev Mode",
            "type": "java",
            "request": "launch",
            "mainClass": "io.quarkus.bootstrap.runner.QuarkusEntryPoint",
            "vmArgs": "-Dquarkus.http.port=8080",
            "cwd": "${workspaceFolder}",
            "console": "integratedTerminal"
        }
    ]
}
```