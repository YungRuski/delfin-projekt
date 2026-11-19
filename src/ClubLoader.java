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

    public List<Member> loadMembers (Path path) throws IOException {
        List<Member> members = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                members.add(mapper.fromMemberCsv(line));
            }
        }
        return members;
    }
}
