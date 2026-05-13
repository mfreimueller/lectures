import java.util.ArrayList;
import java.util.List;

record CreateBookDto(String title, String isbn, int publishedYear) {}

class Validator {
    public static List<String> validate(CreateBookDto dto) {
        var errors = new ArrayList<String>();
        if (dto.title() == null || dto.title().isBlank())
            errors.add("title must not be blank");
        if (dto.isbn() == null || !dto.isbn().matches("\\d{13}"))
            errors.add("isbn must be 13 digits");
        if (dto.publishedYear() < 1900)
            errors.add("publishedYear must be >= 1900");
        return errors;
    }
}

public class Validation {
    public static void main(String[] args) {
        var dto = new CreateBookDto("", "invalid", 1800);
        var errors = Validator.validate(dto);
        System.out.println("Errors: " + errors);
    }
}
