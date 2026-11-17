import java.util.List;

public class Chairman {
    private String username;
    private String password;

    public Chairman(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addMember(List<Member> members, Member member) {
        members.add(member);
    }


}
