https://code.quarkus.io/ <!--Site pour initializer un projet quarkus-->

# packager un projet quarkus
``` xml
<build>
    <plugins>
        <plugin>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-maven-plugin</artifactId>
            <version>${quarkus.version}</version>
            <executions>
                <execution>
                    <goals>
                        <goal>build</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```
mvn clean package

mvn quarkus:dev <!--Lancer le projet en mode développement-->
curl localhost:8000/<url_path> <!--permet de tester un url d'un apiREST si ça marche(un peu comme postman)-->