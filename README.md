# spring-mcp-server-claude

This repository contains a Spring-based MCP (Minecraft Classic Protocol) server project.

Origin and attribution
- This project was created using the tutorial "Creating an MCP server" by Soham Kamani as a reference: https://www.sohamkamani.com/java/creating-an-mcp-server/
- All credit for the original tutorial and explanations goes to Soham Kamani. The code and structure in this repository adapt concepts from that tutorial.

Getting started
1. Clone the repository:

   git clone https://github.com/rohit-talathi/spring-mcp-server-claude.git

2. Open the project in your IDE (IntelliJ IDEA, Eclipse, VS Code) and run the main application class (the one annotated with `@SpringBootApplication`).

3. Build and run from the command line (examples):

- If this project uses Maven:

  mvn clean package
  java -jar target/*.jar

- If this project uses Gradle:

  ./gradlew bootRun

Adjust the commands above to match the build tool used in this repository.

Project structure
- See the `src/` directory for application code and configuration.
- The implementation follows the tutorial's approach and is adapted to use Spring where applicable.

Notes
- The repository intentionally references Soham Kamani's tutorial as the guiding resource. If you need additional attribution text or licensing details, let me know which license you prefer and I can add a LICENSE file.

What I changed
- Updated README.md to include attribution to the tutorial and basic usage instructions.

Next steps I can take for you
- Inspect the repo to detect whether it uses Maven or Gradle and update the README with exact build/run commands.
- Add example configuration, environment variables, or sample commands to connect to the MCP server.
- Add a LICENSE.md or CONTRIBUTING.md if you want.
