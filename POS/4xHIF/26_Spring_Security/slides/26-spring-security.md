---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 26 - Spring Security
## POS - 4xHIF

---

## Security-Filter-Chain

- Jeder Request durchläuft eine Kette von Filtern
- AuthenticationFilter, AuthorizationFilter, CsrfFilter, ...
- Filter können Requests ablehnen (401/403) oder modifizieren
- Reihenfolge der Filter ist entscheidend

---

## In-Memory Authentication

```java
@Bean
public UserDetailsService users() {
    UserDetails admin = User.withDefaultPasswordEncoder()
        .username("admin").password("admin").roles("ADMIN").build();
    UserDetails user = User.withDefaultPasswordEncoder()
        .username("user").password("user").roles("USER").build();
    return new InMemoryUserDetailsManager(admin, user);
}
```

Nur für Entwicklung / Demo — nie in Produktion!

---

## @PreAuthorize

```java
@Service
public class BookService {
    @PreAuthorize("hasRole('ADMIN')")
    public BookDTO create(BookDTO dto) { ... }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<BookDTO> getAll() { ... }

    @PreAuthorize("#id == authentication.principal.id")
    public BookDTO getById(Long id) { ... }
}
```

Methodensicherheit + SpEL = mächtige Access Control

---

## Custom Login Form

```java
.formLogin(form -> form
    .loginPage("/ui/login")
    .defaultSuccessUrl("/ui/books")
    .permitAll()
)
```

Thymeleaf bindet CSRF-Token automatisch via th:action.

---

<div class="highlight-box"><h2>What We Learned Today</h2><ul><li>Security-Filter-Chain</li><li>In-Memory Authentication</li><li>@PreAuthorize + Rollen</li><li>Custom Login Form mit Thymeleaf</li></ul></div>
