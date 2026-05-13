# Kata 3: Custom Page DTO

| Field | Value |
|-------|-------|
| Concepts | Custom DTO, Page metadata, HATEOAS integration |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Create a custom `PagedResponse<T>` record:

```java
public record PagedResponse<T>(
    List<T> content,
    int page,
    int size,
    long totalElements,
    int totalPages,
    boolean first,
    boolean last,
    Map<String, String> links
) {

    public static <T> PagedResponse<T> of(Page<T> page) {
        return new PagedResponse<>(
            page.getContent(),
            page.getNumber(),
            page.getSize(),
            page.getTotalElements(),
            page.getTotalPages(),
            page.isFirst(),
            page.isLast(),
            new HashMap<>()
        );
    }
}
```

2. Create a utility to generate navigation links:

```java
public PagedResponse<T> withLinks(
        UriComponentsBuilder uriBuilder) {

    Map<String, String> linkMap = new HashMap<>();

    linkMap.put("self", uriBuilder
        .queryParam("page", page)
        .queryParam("size", size).toUriString());

    if (!first) {
        linkMap.put("first", uriBuilder
            .queryParam("page", 0)
            .queryParam("size", size).toUriString());
        linkMap.put("prev", uriBuilder
            .queryParam("page", page - 1)
            .queryParam("size", size).toUriString());
    }
    if (!last) {
        linkMap.put("next", uriBuilder
            .queryParam("page", page + 1)
            .queryParam("size", size).toUriString());
        linkMap.put("last", uriBuilder
            .queryParam("page", totalPages - 1)
            .queryParam("size", size).toUriString());
    }

    return new PagedResponse<>(content, page, size,
        totalElements, totalPages, first, last, linkMap);
}
```

3. Update the controller to return `PagedResponse<BookDTO>`:

```java
@GetMapping
public PagedResponse<BookDTO> getAll(
        @PageableDefault(size = 10) Pageable pageable,
        UriComponentsBuilder uriBuilder) {

    Page<BookDTO> page = service.getAll(pageable);
    return PagedResponse.of(page)
        .withLinks(uriBuilder.path("/api/books"));
}
```

### Extension

Add `@JsonView` annotations to control which fields are included in the page response vs. individual resource responses. Add a `_links` HATEOAS section to the response instead of a flat links map.
