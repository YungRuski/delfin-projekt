import java.time.LocalDate;

public class ClubMapper {
    private String delimiter = ",";

    public String toCsv(Member member) {
        String memberType;
        if (member instanceof MemberCompetitive) {
            memberType = "COMPETITIVE";
        } else {
            memberType = "REGULAR";
        }
        return member.getMemberID() + delimiter + member.getName() + delimiter +
                member.getDateOfBirth() + delimiter + member.isActive() + delimiter + memberType;
    }

    public Member fromMemberCsv(String line) {
        String[] tokens = line.split(delimiter);
        int memberID = Integer.parseInt(tokens[0]);
        LocalDate dateOfBirth = LocalDate.parse(tokens[2]);
        boolean isActive = Boolean.parseBoolean(tokens[3]);
        if (tokens[4].equals("REGULAR")) {
            return new Member(memberID, tokens[1], dateOfBirth, isActive);
        } else {
            return new MemberCompetitive(memberID, tokens[1], dateOfBirth);
        }
    }

    public String toCsv(CompetitionResult result, int memberID) {
        return memberID + delimiter + result.getDisciplin() + delimiter + result.getCompetition() +
                delimiter + result.getPlacement() + delimiter + result.getTime() + delimiter +
                result.getDate();
    }
}
