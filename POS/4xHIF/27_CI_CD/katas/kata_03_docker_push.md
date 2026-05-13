# Kata 3: Docker Build + Push

| Field | Value |
|-------|-------|
| Concepts | Docker buildx, Docker Hub, GitHub Secrets |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Extend the workflow with Docker build and push:

```yaml
name: CI with Docker

on:
  push:
    branches: [main]

jobs:
  build-and-push:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
          cache: maven
      - name: Build with Maven
        run: mvn -B verify

      - name: Set up Docker Buildx
        uses: docker/setup-buildx-action@v3

      - name: Log in to Docker Hub
        uses: docker/login-action@v3
        with:
          username: ${{ secrets.DOCKER_USERNAME }}
          password: ${{ secrets.DOCKER_PASSWORD }}

      - name: Build and push Docker image
        uses: docker/build-push-action@v5
        with:
          context: .
          push: true
          tags: |
            ${{ secrets.DOCKER_USERNAME }}/library-app:latest
            ${{ secrets.DOCKER_USERNAME }}/library-app:${{ github.sha }}
```

2. Configure secrets in GitHub:
   - Go to Settings → Secrets and variables → Actions
   - Add `DOCKER_USERNAME` and `DOCKER_PASSWORD`

### Extension

Add a deployment step that SSHes into a server and runs `docker compose pull && docker compose up -d`. Tag the image with the Git tag instead of commit SHA on release.
