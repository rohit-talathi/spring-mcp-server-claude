# spring-mcp-server-claude

Spring Boot-based MCP (Minecraft Classic Protocol) server implementation.

Short description
- Minimal MCP server adapted to run as a Spring Boot application.

Prerequisites
- Java 21 (or the JDK version configured in pom.xml)
- Maven (or use the included Maven Wrapper ./mvnw)
- Git

Quick start (build & run)
1. Clone:

   git clone https://github.com/rohit-talathi/spring-mcp-server-claude.git
   cd spring-mcp-server-claude

2. Run with the Maven wrapper:

   ./mvnw spring-boot:run

   Or build a jar and run:

   ./mvnw clean package
   java -jar target/*.jar

Project details
- Artifact: com.springai:mcp_server (declared in pom.xml)
- Build tool: Maven (pom.xml present, Maven wrapper included)
- Java version: 21 (declared in pom.xml)
- Main dependency: org.springframework.ai:spring-ai-starter-mcp-server (configured in pom.xml)

Repository layout
- src/main/java — application source code and Spring Boot entry point
- src/main/resources — application configuration (application.properties / application.yml)
- pom.xml — Maven build configuration
- mvnw, mvnw.cmd — Maven wrapper

What this README does not yet list
- Exact path and name of the Spring Boot application class (the @SpringBootApplication entry point)
- Packages and key classes handling MCP lifecycle and protocol handlers

Next steps (choose one)
- I can scan src/ to list the main application class, important packages, and example usage, then expand the README.
- I can add a LICENSE file if you want a specific license applied (MIT, Apache-2.0, GPL-3.0, etc.).
- I can add example client instructions or a small script to start and test the server.

Tell me which next step you'd like and I'll proceed.
