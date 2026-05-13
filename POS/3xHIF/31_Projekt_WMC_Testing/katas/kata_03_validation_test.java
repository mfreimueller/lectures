import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

class BookValidator {
    static boolean isValidTitle(String title) {
        return title != null && !title.isBlank();
    }

    static boolean isValidIsbn(String isbn) {
        return isbn != null && isbn.matches("\\d{13}");
    }

    static boolean isValidYear(int year) {
        return year >= 1900 && year <= 2026;
    }
}

class ValidationTest {
    @ParameterizedTest
    @CsvSource({
        "The Hobbit, true",
        "'', false",
        ", false",
        "Dune, true"
    })
    void shouldValidateTitle(String title, boolean expected) {
        assertThat(BookValidator.isValidTitle(title)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "9780547928227, true",
        "123, false",
        "'', false",
        ", false"
    })
    void shouldValidateIsbn(String isbn, boolean expected) {
        assertThat(BookValidator.isValidIsbn(isbn)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "1965, true",
        "1899, false",
        "2027, false",
        "2026, true"
    })
    void shouldValidateYear(int year, boolean expected) {
        assertThat(BookValidator.isValidYear(year)).isEqualTo(expected);
    }
}
