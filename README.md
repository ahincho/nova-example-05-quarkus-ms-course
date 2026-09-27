# ms-course-quarkus

Example instance consuming the
[`pe.edu.nova.java:nova-quarkus-parent:1.0.0`](https://github.com/ahincho/nova-java-15-quarkus-parent)
POM. The Quarkus counterpart of
[`ahincho/nova-example-02-spring-boot-ms-course`](https://github.com/ahincho/nova-example-02-spring-boot-ms-course) (the Spring Boot instance).

## Stack

- Java 25
- Quarkus 3.33.2.1 LTS

## Build

```bash
./mvnw clean verify
```

The `verify` phase runs: compile + tests + `quarkus:build`. Output: `target/quarkus-app/quarkus-run.jar`.

## Run

```bash
./mvnw quarkus:dev
```

Then:

```bash
curl http://localhost:8080/q/health
# -> {"status":"UP","checks":[]}
```

## How it consumes the parent

```xml
<parent>
    <groupId>pe.edu.nova.java</groupId>
    <artifactId>nova-quarkus-parent</artifactId>
    <version>1.0.0</version>
</parent>
```

The parent provides:
- Java 25 (compiler `--release 25`)
- Quarkus 3.33.2.1 LTS (`io.quarkus.platform:quarkus-bom` pre-imported via `<dependencyManagement>`)
- Maven plugins: compiler 3.14, surefire 3.5.3, failsafe 3.5.3

## Configuration

`src/main/resources/application.properties`:

```properties
quarkus.http.port=8080
quarkus.http.test-port=8081
```

## Related

- [`ahincho/nova-java-15-quarkus-parent`](https://github.com/ahincho/nova-java-15-quarkus-parent) — the parent POM consumed by this instance.
- [`ahincho/nova-java-18-quarkus-archetype`](https://github.com/ahincho/nova-java-18-quarkus-archetype) — the archetype that can generate similar multi-module instances.
- [`ahincho/nova-example-02-spring-boot-ms-course`](https://github.com/ahincho/nova-example-02-spring-boot-ms-course) — the Spring Boot counterpart.