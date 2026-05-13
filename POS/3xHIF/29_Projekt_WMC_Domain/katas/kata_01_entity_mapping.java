import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
class Member {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private MembershipCard card;
    @OneToMany(mappedBy = "member")
    private List<Loan> loans = new ArrayList<>();

    public Member() {}
    public Member(String name, String email) { this.name = name; this.email = email; }
}

@Entity
class MembershipCard {
    @Id @GeneratedValue
    private Long id;
    private String cardNumber;
    private LocalDate issuedDate;
    private LocalDate validUntil;

    public MembershipCard() {}
    public MembershipCard(String cardNumber) {
        this.cardNumber = cardNumber;
        this.issuedDate = LocalDate.now();
        this.validUntil = issuedDate.plusYears(1);
    }
}

@Entity
class Loan {
    @Id @GeneratedValue
    private Long id;
    private LocalDate loanDate;
    private LocalDate dueDate;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Loan() {}
    public Loan(LocalDate loanDate, LocalDate dueDate, Member member) {
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.member = member;
    }
}

public class EntityMapping {
    public static void main(String[] args) {
        System.out.println("Entities defined: Member, MembershipCard, Loan");
    }
}
