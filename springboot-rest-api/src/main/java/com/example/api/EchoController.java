package com.example.api;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EchoController {

    @GetMapping("/echo")
    public Map<String, String> getEcho() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, World!");
        response.put("timestamp", LocalDateTime.now().toString());
        return response;
    }

    @PostMapping("/echo")
    public Map<String, String> postEcho(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        response.put("message", request.get("message"));
        response.put("timestamp", LocalDateTime.now().toString());
        return response;
    }

    // Default route
    @GetMapping("/")
    public String home() {
        return "Welcome to the Echo API! Access /api/echo for API usage.";
    }
}
