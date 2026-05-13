import java.util.List;

public interface MemberRepository {
    List<Member> findAll();
    Member findById(int id);
    List<Member> findByName(String name);
}
