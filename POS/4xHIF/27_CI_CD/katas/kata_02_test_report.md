# Kata 2: Test Report

| Field | Value |
|-------|-------|
| Concepts | Test reports, JaCoCo, coverage |
| Difficulty | 2/5 |
| Duration | approx. 25 min |

### Task

1. Add JaCoCo to `pom.xml`:

```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.12</version>
    <executions>
        <execution>
            <id>prepare-agent</id>
            <goals><goal>prepare-agent</goal></goals>
        </execution>
        <execution>
            <id>report</id>
            <phase>verify</phase>
            <goals><goal>report</goal></goals>
        </execution>
    </executions>
</plugin>
```

2. Update the workflow to publish reports:

```yaml
- name: Build with Maven
  run: mvn -B verify

- name: Upload coverage report
  uses: actions/upload-artifact@v4
  with:
    name: coverage-report
    path: target/site/jacoco/

- name: Upload test report
  if: always()
  uses: actions/upload-artifact@v4
  with:
    name: test-reports
    path: target/surefire-reports/
```

3. Add a JaCoCo coverage threshold:

```xml
<execution>
    <id>check</id>
    <goals><goal>check</goal></goals>
    <configuration>
        <rules>
            <rule><element>CLASS</element>
                <limits><limit><counter>LINE</counter><value>COVERED_RATIO</value><minimum>0.80</minimum></limit></limits>
            </rule>
        </rules>
    </configuration>
</execution>
```

### Extension

Add a Coverage Badge to the README.md using shields.io and GitHub Actions. Use `dorny/test-reporter` action for pretty test reports in the PR summary.
