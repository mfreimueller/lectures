# Kata 3: Load Balancing Simulation

| Field | Value |
|-------|-------|
| Concepts | Load balancing, round-robin, multiple instances |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Create a simple "Instance Service" that runs on multiple ports and returns its instance ID:

```java
@RestController
@RequestMapping("/api/instance")
public class InstanceController {

    @Value("${server.port}")
    private int port;

    @Value("${instance.id:default}")
    private String instanceId;

    @GetMapping
    public Map&lt;String, Object&gt; getInfo() {
        return Map.of(
            "instanceId", instanceId,
            "port", port,
            "timestamp", Instant.now().toString()
        );
    }
}
```

2. Configure two profiles or startup scripts:
   - Instance A: `--server.port=8081 --instance.id=A`
   - Instance B: `--server.port=8082 --instance.id=B`

3. Create a load balancing client service that distributes requests in round-robin:

```java
@Service
public class LoadBalancingClient {

    private final List&lt;String&gt; instances = List.of(
        "http://localhost:8081",
        "http://localhost:8082"
    );
    private final AtomicInteger counter = new AtomicInteger(0);

    public Map&lt;String, Object&gt; fetchFromInstance() {
        int index = Math.abs(counter.getAndIncrement() % instances.size());
        String url = instances.get(index) + "/api/instance";
        // Use RestClient to fetch
    }
}
```

4. Create a controller that calls the load balancer and returns the result:

```java
@GetMapping("/api/lb-test")
public List&lt;Map&lt;String, Object&gt;&gt; lbTest(@RequestParam(defaultValue = "6") int count) {
    // Call the load balancer 'count' times and return all responses
}
```

5. Verify by calling `/api/lb-test?count=6` — you should see alternating instance IDs (A, B, A, B, A, B)

### Extension

Add a health-check mechanism: if an instance returns 5xx, remove it from the rotation and periodically retry it. Re-add it once it's healthy again.
