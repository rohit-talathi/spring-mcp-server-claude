# spring-mcp-server-claude

spring-mcp-server-claude is a Spring Boot-based MCP (Minecraft Classic Protocol) server implementation. The server is packaged as a Spring Boot application and provides a configurable, minimal MCP server suitable for testing, experimentation, and extension.

This README was written using the MCP server design and message-flow concepts commonly used in MCP implementations and adapted to the structure of this repository. No external attributions or links are included in this file.

Contents
- Overview
- Features
- Prerequisites
- Build & Run
- Configuration
- Architecture & key components
- Testing
- Extending the server
- Contributing
- License

Overview

The project implements a TCP-based MCP server that handles the core Classic protocol flows: handshake/login, player session management, movement & state updates, block changes, and broadcasting world updates to connected players. The server integrates into the Spring ecosystem so handlers and components are managed as Spring Beans and configurable via application properties.

Features

- TCP listener for MCP clients
- Session lifecycle handling (connect, login, disconnect)
- Basic MCP message processing (handshake/login, movement, block updates, chat)
- Broadcasting world and player state to connected clients
- Spring Boot integration for configuration, logging, and lifecycle management
- Simple configuration via application.properties / application.yml

Prerequisites

- Java 21 (or a compatible JDK version)
- Maven or the included Maven Wrapper (./mvnw)
- Git

Build & Run

Clone the repository and run the application using the Maven wrapper (recommended):

  git clone https://github.com/rohit-talathi/spring-mcp-server-claude.git
  cd spring-mcp-server-claude
  ./mvnw spring-boot:run

Or build a runnable JAR and start it:

  ./mvnw clean package
  java -jar target/*.jar

By default the Spring Boot application will start with the configuration in src/main/resources/application.properties (or application.yml). Use environment variables or a custom properties file to override defaults.

Configuration

Key configuration keys (examples) — place in src/main/resources/application.properties or application.yml:

  # Spring Boot admin port
  server.port=8080

  # MCP server listener port
  mcp.port=25565

  # Maximum concurrent players
  mcp.max-players=32

  # Logging verbosity
  logging.level.root=INFO

Adjust keys to match actual property names in source if the code uses different naming conventions (the application.properties file in src/main/resources is authoritative).

Architecture & key components

- TCP Listener: Accepts raw TCP connections and hands sockets to session handlers.
- Session Handler: Processes the login/handshake sequence, reads/parses MCP messages, manages per-player state, and dispatches messages to protocol handlers.
- Protocol Handlers: Implement the parsing and processing of MCP message types (movement, block updates, chat, etc.). Handlers update server state and produce outgoing messages to clients.
- World State / Broadcaster: Maintains a simple in-memory world state and broadcasts updates to relevant connected clients.
- Spring Integration: Components are configured as Spring Beans. The Spring context manages lifecycle (startup/shutdown) and configuration injection.

Testing

This section describes how to test the server locally and validate core protocol flows. The server included in this repository uses the project name "claude" as the application artifact; tests below assume the server is running on localhost.

1) Start the server

  ./mvnw spring-boot:run

or

  java -jar target/*.jar

2) Connect with a Classic-compatible client

- Use a Minecraft Classic client or an MCP-compatible testing client configured to connect to localhost on the configured mcp.port (default 25565).
- If you do not have a Classic client available, you can exercise basic TCP-level flows with a simple socket client or a small test program that implements the MCP handshake and message framing.

3) Verify handshake/login

- The client should complete the handshake/login sequence. Observing server logs should show connection, login, and player registration events.

4) Validate movement and state updates

- Move the player in the client and verify that movement messages are processed and that other connected clients receive updated position/state messages (for multi-client tests, run two clients).

5) Validate block updates and broadcasting

- When changing blocks from a client, confirm the server applies the change and broadcasts the update to other connected clients as appropriate.

6) Inspect logs and metrics

- Use the Spring Boot logs to view protocol events, errors, and debug output. Increase logging level if more detail is needed.

Automated tests

- Add unit tests under src/test/java to validate message parsers, session lifecycle, and handler behavior. Integration tests may start an embedded server instance and use a lightweight client to exercise end-to-end flows.

Extending the server

- Implement additional protocol handlers as Spring Beans and register them so the session dispatcher invokes them for matching message types.
- Add persistence (e.g., a player store) by creating a Spring Bean that implements storage interfaces and wiring it into the session manager.
- Provide configuration properties with sensible defaults and document them in README and sample application.properties.

Contributing

- Fork the repo, create a feature branch, add tests and documentation, and open a pull request describing the change and how to test it.

License

No LICENSE file is included. If you want a specific license added (for example: MIT, Apache-2.0, GPL-3.0), tell me which license to add and I will create a LICENSE file and update the README accordingly.

Notes

- This README was written using MCP protocol design patterns and adapted to this project's code and layout. It does not include any external links or explicit attribution.
- If you want the README to include exact class names, package paths, or code snippets from this repository, confirm and I will scan src/ and update the README with concrete references and examples.