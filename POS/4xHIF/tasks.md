tasks:
  - id: create-week-00
    description: "Erstelle 00_Introduction_SpringBoot/ - Einführung, Jahresplanung, Spring Boot Intro, GitHub Classroom-Setup"
    done: true
    has_revision: true
    creates: 00_Introduction_SpringBoot/
    content_sources:
      - "structure.list line 1"
    delegates_to: 00_Introduction_SpringBoot/tasks.md

  - id: create-week-01
    description: "Erstelle 01_UML_DDD/ - UML (Aggregation, Composition, Inheritance), DDD Intro"
    done: true
    has_revision: true
    creates: 01_UML_DDD/
    content_sources:
      - "structure.list line 2"
    delegates_to: 01_UML_DDD/tasks.md

  - id: create-week-02
    description: "Erstelle 02_PlantUML_ValueObjects/ - PlantUML, DDD Intro, ValueObjects, RichTypes"
    done: true
    has_revision: true
    creates: 02_PlantUML_ValueObjects/
    content_sources:
      - "structure.list line 3"
    delegates_to: 02_PlantUML_ValueObjects/tasks.md

  - id: create-week-03
    description: "Erstelle 03_Milestone1_DomainModel/ - Milestone 1: Domain Model & Projekt-Setup (Präsentation)"
    done: true
    has_revision: true
    creates: 03_Milestone1_DomainModel/
    content_sources:
      - "structure.list line 4"
    delegates_to: 03_Milestone1_DomainModel/tasks.md

  - id: create-week-04
    description: "Erstelle 04_JPA_Repositories/ - JPA Repositories; Projekt: Mapping of Model to Project"
    done: true
    has_revision: true
    creates: 04_JPA_Repositories/
    content_sources:
      - "structure.list line 5"
    delegates_to: 04_JPA_Repositories/tasks.md

  - id: create-week-05
    description: "Erstelle 05_UnitTesting_JPA_H2/ - Unit Testing for JPA Repositories with H2"
    done: true
    has_revision: true
    creates: 05_UnitTesting_JPA_H2/
    content_sources:
      - "structure.list line 6"
    delegates_to: 05_UnitTesting_JPA_H2/tasks.md

  - id: create-week-06
    description: "Erstelle 06_CodeReview_JPA/ - Code Review (JPA-Mapping & Repository-Tests)"
    done: true
    has_revision: true
    creates: 06_CodeReview_JPA/
    content_sources:
      - "structure.list line 7"
    delegates_to: 06_CodeReview_JPA/tasks.md

  - id: create-week-07
    description: "Erstelle 07_Configuration_Profiles/ - Spring Boot Configuration & Profiles"
    done: true
    has_revision: true
    creates: 07_Configuration_Profiles/
    content_sources:
      - "structure.list line 9"
    delegates_to: 07_Configuration_Profiles/tasks.md

  - id: create-week-08
    description: "Erstelle 08_Testcontainers_PostgreSQL/ - Testcontainers for PostgreSQL + TestConfiguration"
    done: true
    has_revision: true
    creates: 08_Testcontainers_PostgreSQL/
    content_sources:
      - "structure.list line 10"
    delegates_to: 08_Testcontainers_PostgreSQL/tasks.md

  - id: create-week-09
    description: "Erstelle 09_Flyway_Migration/ - Database migration with Flyway"
    done: true
    has_revision: true
    creates: 09_Flyway_Migration/
    content_sources:
      - "structure.list line 11"
    delegates_to: 09_Flyway_Migration/tasks.md

  - id: create-week-10
    description: "Erstelle 10_Service_Layer/ - Service-Layer Intro (Commands vs. Regular parameters)"
    done: true
    has_revision: true
    creates: 10_Service_Layer/
    content_sources:
      - "structure.list line 12"
    delegates_to: 10_Service_Layer/tasks.md

  - id: create-week-11
    description: "Erstelle 11_ServiceLayer_Testing/ - Service-Layer Unit-Testing via Mocking"
    done: true
    has_revision: true
    creates: 11_ServiceLayer_Testing/
    content_sources:
      - "structure.list line 13"
    delegates_to: 11_ServiceLayer_Testing/tasks.md

  - id: create-week-12
    description: "Erstelle 12_ExceptionHandling_Validation/ - Exception Handling & Validation"
    done: true
    has_revision: true
    creates: 12_ExceptionHandling_Validation/
    content_sources:
      - "structure.list line 14"
    delegates_to: 12_ExceptionHandling_Validation/tasks.md

  - id: create-week-13
    description: "Erstelle 13_Logging/ - Logging (Log-Levels, Why logging?) + SA1 Vorbereitung"
    done: true
    has_revision: true
    creates: 13_Logging/
    content_sources:
      - "structure.list line 15"
    delegates_to: 13_Logging/tasks.md

  - id: create-week-14
    description: "Erstelle 14_REST_Controllers/ - REST(ful) Controllers in Spring"
    done: false
    has_revision: true
    creates: 14_REST_Controllers/
    content_sources:
      - "structure.list line 18"
    delegates_to: 14_REST_Controllers/tasks.md

  - id: create-week-15
    description: "Erstelle 15_MapStruct/ - Mappers with mapstruct"
    done: false
    has_revision: true
    creates: 15_MapStruct/
    content_sources:
      - "structure.list line 19"
    delegates_to: 15_MapStruct/tasks.md

  - id: create-week-16
    description: "Erstelle 16_HATEOAS/ - HATEOAS (Intro and how-to in Spring)"
    done: false
    has_revision: true
    creates: 16_HATEOAS/
    content_sources:
      - "structure.list line 20"
    delegates_to: 16_HATEOAS/tasks.md

  - id: create-week-17
    description: "Erstelle 17_RestClient_LoadBalancing/ - RestClient, Load Balancing"
    done: false
    has_revision: true
    creates: 17_RestClient_LoadBalancing/
    content_sources:
      - "structure.list line 21"
    delegates_to: 17_RestClient_LoadBalancing/tasks.md

  - id: create-week-18
    description: "Erstelle 18_Paging_Sorting/ - Controllers Paging & Sorting"
    done: false
    has_revision: true
    creates: 18_Paging_Sorting/
    content_sources:
      - "structure.list line 23"
    delegates_to: 18_Paging_Sorting/tasks.md

  - id: create-week-19
    description: "Erstelle 19_GraphQL_Katas/ - GraphQL (via Katas) + Projektarbeit"
    done: false
    has_revision: false
    creates: 19_GraphQL_Katas/
    content_sources:
      - "structure.list line 24"
    delegates_to: 19_GraphQL_Katas/tasks.md

  - id: create-week-20
    description: "Erstelle 20_API_Documentation/ - API Documentation (OpenAPI vs Spring Rest Docs)"
    done: false
    has_revision: true
    creates: 20_API_Documentation/
    content_sources:
      - "structure.list line 25"
    delegates_to: 20_API_Documentation/tasks.md

  - id: create-week-21
    description: "Erstelle 21_TestingREST_CodeReview/ - Testing REST APIs + Code Review"
    done: false
    has_revision: false
    creates: 21_TestingREST_CodeReview/
    content_sources:
      - "structure.list line 26"
    delegates_to: 21_TestingREST_CodeReview/tasks.md

  - id: create-week-22
    description: "Erstelle 22_Thymeleaf/ - Thymeleaf WebUI with Spring"
    done: false
    has_revision: true
    creates: 22_Thymeleaf/
    content_sources:
      - "structure.list line 27"
    delegates_to: 22_Thymeleaf/tasks.md

  - id: create-week-23
    description: "Erstelle 23_Milestone2_Zwischenpraesentation/ - Milestone 2: Zwischenpräsentation (Projektstand)"
    done: false
    has_revision: false
    creates: 23_Milestone2_Zwischenpraesentation/
    content_sources:
      - "structure.list line 28"
    delegates_to: 23_Milestone2_Zwischenpraesentation/tasks.md

  - id: create-week-24
    description: "Erstelle 24_Actuator_Metrics/ - Spring Boot Actuator & Metrics"
    done: false
    has_revision: true
    creates: 24_Actuator_Metrics/
    content_sources:
      - "structure.list line 30"
    delegates_to: 24_Actuator_Metrics/tasks.md

  - id: create-week-25
    description: "Erstelle 25_Docker/ - Containerization with Docker (Dockerfile, docker-compose)"
    done: false
    has_revision: true
    creates: 25_Docker/
    content_sources:
      - "structure.list line 31"
    delegates_to: 25_Docker/tasks.md

  - id: create-week-26
    description: "Erstelle 26_Spring_Security/ - Spring Security"
    done: false
    has_revision: true
    creates: 26_Spring_Security/
    content_sources:
      - "structure.list line 32"
    delegates_to: 26_Spring_Security/tasks.md

  - id: create-week-27
    description: "Erstelle 27_CI_CD/ - CI/CD Grundlagen (GitHub Actions)"
    done: false
    has_revision: true
    creates: 27_CI_CD/
    content_sources:
      - "structure.list line 33"
    delegates_to: 27_CI_CD/tasks.md

  - id: create-week-28
    description: "Erstelle 28_Caching_AOP/ - Caching & AOP"
    done: false
    has_revision: true
    creates: 28_Caching_AOP/
    content_sources:
      - "structure.list line 34"
    delegates_to: 28_Caching_AOP/tasks.md

  - id: create-week-29
    description: "Erstelle 29_AdvancedTopics_Katas_1/ - Advanced Topics via Katas + Projektarbeit"
    done: false
    has_revision: false
    creates: 29_AdvancedTopics_Katas_1/
    content_sources:
      - "structure.list line 36"
    delegates_to: 29_AdvancedTopics_Katas_1/tasks.md

  - id: create-week-30
    description: "Erstelle 30_AdvancedTopics_Katas_2/ - Advanced Topics via Katas + Projektarbeit"
    done: false
    has_revision: false
    creates: 30_AdvancedTopics_Katas_2/
    content_sources:
      - "structure.list line 37"
    delegates_to: 30_AdvancedTopics_Katas_2/tasks.md

  - id: create-week-31
    description: "Erstelle 31_CodeReview_Final/ - Code Review (final)"
    done: false
    has_revision: false
    creates: 31_CodeReview_Final/
    content_sources:
      - "structure.list line 38"
    delegates_to: 31_CodeReview_Final/tasks.md

  - id: create-week-32
    description: "Erstelle 32_Retrospective_Outlook/ - Retrospective & Ausblick 5. Klasse"
    done: false
    has_revision: true
    creates: 32_Retrospective_Outlook/
    content_sources:
      - "structure.list line 39"
    delegates_to: 32_Retrospective_Outlook/tasks.md

  - id: create-week-33
    description: "Erstelle 33_Final_Presentations/ - Final Presentations"
    done: false
    has_revision: false
    creates: 33_Final_Presentations/
    content_sources:
      - "structure.list line 40"
    delegates_to: 33_Final_Presentations/tasks.md
