import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ClubSaver {
    private final ClubMapper mapper;

    public ClubSaver(ClubMapper mapper) {
        this.mapper = mapper;
    }

    public void saveMembers(List<Member> members, Path path) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Member member : members) {
                writer.write(mapper.toCsv(member));
                writer.write("\n");
            }
        }
    }
}
