void main() {
    Club club = new Club();
    ClubMapper mapper = new ClubMapper();
    ClubSaver saver = new ClubSaver(mapper);
    ClubLoader loader = new ClubLoader(mapper);
    UserInterface userInterface = new UserInterface(club, saver);

    try {
        List<Member> loadedMembers = loader.loadMembers(Path.of("data/members.csv"));
        for (Member member : loadedMembers) {
            club.addMember(member);
        }
    } catch (IOException e) {
        IO.println("Der skete en fejl: " + e.getLocalizedMessage());
    }

    userInterface.run();

}