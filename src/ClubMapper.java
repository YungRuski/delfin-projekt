import java.time.LocalDate;

public class ClubMapper {
    private String delimiter = ",";

    public String toCsv (Member member) {
        return member.getMemberID() + delimiter + member.getName() + delimiter +
                member.getDateOfBirth() + delimiter + member.isActive();
    }

    public Member fromMemberCsv(String line) {
        String[] tokens = line.split(delimiter);
        int memberID = Integer.parseInt(tokens[0]);
        LocalDate dateOfBirth = LocalDate.parse(tokens[2]);
        boolean isActive = Boolean.parseBoolean(tokens[3]);
        return new Member(memberID, tokens[1], dateOfBirth, isActive);
    }
    public String toCsv(MemberCompetitive memberCompetitive) {
        return memberCompetitive.getMemberID() + delimiter + memberCompetitive.getName()
                + delimiter + memberCompetitive.getDateOfBirth();
    }
}
