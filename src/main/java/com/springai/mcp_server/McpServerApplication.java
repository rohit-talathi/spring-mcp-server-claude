package com.springai.mcp_server;

import java.util.Arrays;
import java.util.List;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpServerApplication.class, args);
	}
	
	
	@Bean
	public List<ToolCallback> shoppingCartToolCallbacks(ShoppingCart shoppingCart) {
		ToolCallback[] tools = ToolCallbacks.from(shoppingCart);
		return Arrays.asList(tools);
	}

}
