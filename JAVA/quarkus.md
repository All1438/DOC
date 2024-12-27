# Mode débogage application web
`launch.json`
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