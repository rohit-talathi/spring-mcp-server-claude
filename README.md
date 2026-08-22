# spring-mcp-server-claude

A Spring Boot-based MCP (Minecraft Classic Protocol) server implementation.

Overview
- This project implements a minimal MCP server as a Spring Boot application. The server accepts TCP client connections and implements the core MCP message flow: handshake/login, player movement and state updates, block updates, and broadcasting world changes to connected clients.

Key features
- TCP-based MCP server listener configurable via application properties
- Basic session/connection lifecycle handling (accept, authenticate/login, disconnect)
- Processing of core MCP messages (handshake/login, movement, block updates, chat)
- Broadcast of world changes and player state to connected clients
- Spring Boot integration for configuration, logging, and lifecycle management

Quick start (build & run)
1. Clone the repository

   git clone https://github.com/rohit-talathi/spring-mcp-server-claude.git
   cd spring-mcp-server-claude

2. Run in development

   ./mvnw spring-boot:run
   (or) mvn spring-boot:run

3. Build and run a JAR

   ./mvnw clean package
   java -jar target/*.jar

Configuration
- Application configuration is in src/main/resources (application.properties or application.yml).
- Common configuration keys (examples):
  - server.port — HTTP/administration port for the Spring Boot application
  - mcp.port — port the MCP server listens on (default: 25565)
  - mcp.max-players — maximum concurrent player connections
  - logging.level — logging verbosity for debugging

Recommended application.properties example

server.port=8080
mcp.port=25565
mcp.max-players=32

How it works (high level)
- A TCP listener accepts incoming client connections and hands each connection off to a session handler.
- The session handler processes the MCP handshake and login sequence, establishes player state, and registers the player in the server world.
- Movement, block changes, chat, and other protocol messages are handled by dedicated message processors; the server updates state and broadcasts relevant events to other connected players.
- The Spring Boot application manages lifecycle and configuration; components are injected as Spring Beans so you can replace or extend parts of the server by adding new Beans, components, or configuration.

Project layout
- src/main/java — application code and Spring Boot entry point
- src/main/resources — configuration files and resource assets
- pom.xml — Maven build configuration
- mvnw, mvnw.cmd — Maven wrapper scripts

Extending the server
- Add or modify protocol handlers to support additional MCP messages or custom server behavior.
- Provide Spring Beans for persistence, player management, or world storage to integrate external systems.
- Add tests under src/test/java to cover protocol handling and session lifecycle.

Running and testing
- Start the server locally and connect using a compatible Minecraft Classic client or an MCP-compatible test client configured to the server host and mcp.port.
- Use logging and application-level endpoints (if present) to monitor connections and server state.

Contributing
- Fork the repository, create a feature branch, add tests and documentation, and open a pull request with a clear description and test instructions.

License
- No LICENSE file is included in the repository. If you want a specific license added (MIT, Apache-2.0, GPL-3.0, etc.), tell me which and I will add it.

Notes
- README has been replaced with code-derived documentation and does not include external attribution. If you want the README to include exact main-class names, package listings, or example command lines using real class names, confirm and allow me to scan src/ so I can update it with concrete references.
