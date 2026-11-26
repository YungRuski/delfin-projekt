import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ClubLoader {
    private ClubMapper mapper;

    public ClubLoader(ClubMapper mapper) {
        this.mapper = mapper;
    }

    public List<Member> loadMembers(Path path) throws IOException {
        List<Member> members = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                members.add(mapper.fromMemberCsv(line));
            }
        }
        return members;
    }

    public void loadCompetitionResults(Path path, Club club) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                int memberID = Integer.parseInt(tokens[0]);
                for (Member member : club.getMembers()) {
                    if(member instanceof MemberCompetitive competitive && member.getMemberID() == memberID) {
                        CompetitionResult result = mapper.fromCompetitionCsv(line);
                        competitive.addCompetitionResult(result);
                    }
                }
            }
        }
    }
}
