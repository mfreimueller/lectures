---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 07 - Configuration & Profiles
## POS - 4xHIF

---

## Warum externalisierte Konfiguration?

- Die gleiche App läuft in dev, test, staging, production
- Jede Umgebung braucht andere Werte (DB-URL, Log-Level, API-Keys)
- Konfiguration **außerhalb** des Codes = flexibel & sicher
- 12-Factor-App: "Store config in the environment"

---

## application.properties vs. application.yml

```plaintext
# application.properties (flach)
app.title=My Project
app.version=1.0.0
app.contact=admin@example.com
datasource.url=jdbc:h2:mem:testdb
datasource.username=sa
```

```yaml
# application.yml (hierarchisch)
app:
  title: "My Project"
  version: 1.0.0
  contact: admin@example.com

datasource:
  url: jdbc:h2:mem:testdb
  username: sa
```

YAML ist lesbarer bei verschachtelten Strukturen.

---

## Priorität der Konfigurationsquellen

1. **Command Line Arguments** `--server.port=9090`
2. **Umgebungsvariablen** `SPRING_DATASOURCE_URL`
3. **application-{profile}.yml** (profil-spezifisch)
4. **application.yml** (Basis-Konfiguration)
5. **@PropertySource** auf @Configuration-Klassen

Spätere Quellen überschreiben frühere (Last Write Wins).

---

## @Value — Einfache Injection

```java
@Service
public class MailService {

    @Value("${app.mail.host}")
    private String mailHost;

    @Value("${app.mail.port:587}")
    private int mailPort;

    public void send() {
        System.out.println("Sending via " + mailHost + ":" + mailPort);
    }
}
```

Mit `:` kann ein Default-Wert angegeben werden.

---

## @Value — Typen und SpEL

```java
@Value("${app.title}")          // String
private String title;

@Value("${app.version}")        // automatische Konvertierung
private double version;

@Value("${app.feature.x:false}") // boolean mit Default
private boolean featureXEnabled;

@Value("#{2 * 3}")              // SpEL-Ausdruck
private int multiplied;
```

Nachteil: Keine Typsicherheit, schwer testbar, Werte verteilt im Code.

---

## @ConfigurationProperties — Typsicher

```java
@ConfigurationProperties(prefix = "app")
public record AppConfig(
    String title,
    String version,
    String contact
) {}
```

```yaml
# application.yml
app:
  title: "Library Manager"
  version: 1.0.0
  contact: admin@library.com
```

Werte werden automatisch ins Record/Bean gemappt — typsicher und zentral.

---

## @ConfigurationProperties — Aktivierung

```java
@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
public class TeamprojectApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeamprojectApplication.class, args);
    }
}
```

Oder kürzer: Die `@ConfigurationProperties`-Klasse mit `@Component` versehen (oder `@ConfigurationPropertiesScan` verwenden).

---

## Verschachtelte Config-Properties

```java
@ConfigurationProperties(prefix = "app")
public record AppConfig(
    String title,
    DatasourceConfig datasource
) {
    public record DatasourceConfig(
        String url,
        String username,
        String password
    ) {}
}
```

```yaml
app:
  title: "Library Manager"
  datasource:
    url: jdbc:postgresql://localhost:5432/library
    username: app_user
    password: ${DB_PASSWORD}  # Umgebungsvariable!
```

---

## @Profile — Grundidee

- Profile = Umgebungs-Labels: `dev`, `test`, `prod`
- Unterschiedliche Beans je nach aktivem Profile
- Unterschiedliche Konfigurationsdateien: `application-dev.yml`
- Separation of Concerns: Code bleibt gleich, Config variiert

---

## @Profile auf Beans

```java
@Configuration
public class DatasourceConfig {

    @Bean
    @Profile("dev")
    public DataSource devDataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .build();
    }

    @Bean
    @Profile("prod")
    public DataSource prodDataSource() {
        return DataSourceBuilder.create()
            .url("jdbc:postgresql://localhost:5432/mydb")
            .username("${db.username}")
            .password("${db.password}")
            .build();
    }
}
```

Nur der zum aktiven Profile passende Bean wird erzeugt.

---

## @Profile auf Komponenten

```java
@Service
@Profile("dev")
public class DevMailService implements MailService {
    @Override
    public void send(String message) {
        System.out.println("[DEV] Logging mail instead of sending: " + message);
    }
}

@Service
@Profile("prod")
public class ProdMailService implements MailService {
    @Override
    public void send(String message) {
        // tatsächlicher Mail-Versand
    }
}
```

---

## Profile-spezifische YAML-Dateien

```yaml
# application-dev.yml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:h2:mem:devdb
    username: sa
    password:

logging:
  level:
    at.spengergasse: DEBUG
```

```yaml
# application-prod.yml
server:
  port: 443

spring:
  datasource:
    url: jdbc:postgresql://prod-db:5432/library
    username: ${DB_USER}
    password: ${DB_PASS}

logging:
  level:
    at.spengergasse: WARN
```

---

## Profile aktivieren

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
export SPRING_PROFILES_ACTIVE=prod
./mvnw spring-boot:run
```

```yaml
# application.yml (Default-Profile setzen)
spring:
  profiles:
    active: dev
```

```java
// Programmatisch
SpringApplication app = new SpringApplication(MyApp.class);
app.setAdditionalProfiles("dev");
app.run(args);
```

---

## Mehrere Profile gleichzeitig

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev,monitoring,tracing
```

```yaml
# application.yml
spring:
  profiles:
    include: monitoring,tracing  # immer aktiv
```

- Profile können kombiniert werden
- Nützlich für Cross-Cutting-Profile (monitoring, tracing, audit)

---

## Projekt: Profile für dein Projekt

<div class="highlight-box">
<ol>
<li>Erstelle <code>application-dev.yml</code> mit H2-Datenbank</li>
<li>Erstelle <code>application-prod.yml</code> mit PostgreSQL-Konfiguration</li>
<li>Füge <code>@ConfigurationProperties(prefix = "app")</code> für Projekteinstellungen hinzu</li>
<li>Aktiviere das dev-Profile beim lokalen Start</li>
</ol>
</div>

---

<div class="highlight-box">
<h2>What We Learned Today</h2>
<ul>
<li>Externalisierte Konfiguration mit application.yml / .properties</li>
<li>@Value für einzelne Werte</li>
<li>@ConfigurationProperties für typsichere Config-Klassen</li>
<li>@Profile für umgebungsspezifische Beans</li>
<li>Profile-spezifische Konfigurationsdateien und Aktivierung (CLI, Umgebungsvariablen)</li>
</ul>
</div>
