# spring-mcp-server-claude

Spring-based MCP (Minecraft Classic Protocol) server implemented using Spring Boot and the Spring AI MCP starter.

Project summary
- Artifact: com.springai:mcp_server
- Build tool: Maven (mvn) with included Maven Wrapper (./mvnw)
- Java: 21
- Purpose: Provide a minimal MCP server implementation adapted for Spring Boot using the spring-ai-starter-mcp-server dependency declared in pom.xml.

Quick start
1. Clone the repository:

   git clone https://github.com/rohit-talathi/spring-mcp-server-claude.git
   cd spring-mcp-server-claude

2. Run with the Maven Wrapper (recommended):

   ./mvnw spring-boot:run

   Or with a local Maven installation:

   mvn spring-boot:run

3. Build a runnable JAR and run it:

   ./mvnw clean package
   java -jar target/*.jar

Notes about the codebase
- Build configuration is in pom.xml. The project declares the dependency org.springframework.ai:spring-ai-starter-mcp-server and imports the spring-ai BOM.
- Look under src/main/java for the Spring application entry point (the class annotated with `@SpringBootApplication`). That class starts the Spring context and boots the MCP server components provided by the starter.
- If you want me to add exact paths or list the main classes and packages I can scan src/ and update this README with more concrete references.

Attribution
- This repository was created with reference to the tutorial "Creating an MCP server" by Soham Kamani: https://www.sohamkamani.com/java/creating-an-mcp-server/

License
- No LICENSE file detected in the repository. If you want a license added (MIT, Apache-2.0, GPL-3.0, etc.), tell me which one and I will add it.

What I changed
- Replaced the README contents with a concise project summary, build/run instructions, and attribution.

Next steps I can take
- Inspect src/ to list the main application class, important packages, and example usage, then expand the README.
- Add a LICENSE file and update copyright/attribution wording.
- Add example client instructions or a small script to start and test the server.
