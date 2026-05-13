import java.util.Date;

public class Member {
    private int id;
    private String name;
    private String email;
    private Date memberSince;

    public Member(int id, String name, String email, Date memberSince) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.memberSince = memberSince;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Date getMemberSince() { return memberSince; }
    public void setMemberSince(Date memberSince) { this.memberSince = memberSince; }

    @Override
    public String toString() {
        return "Member{id=" + id + ", name='" + name + "', email='" + email + "', memberSince=" + memberSince + "}";
    }
}
