void main() {
    Club club = new Club();
    ClubMapper mapper = new ClubMapper();
    ClubSaver saver = new ClubSaver(mapper);
    ClubLoader loader = new ClubLoader(mapper);
    LoginManager loginManager = new LoginManager();
    UserInterface userInterface = new UserInterface(club, saver, loginManager);

    try {
        List<Member> loadedMembers = loader.loadMembers(Path.of("data/members.csv"));
        for (Member member : loadedMembers) {
            club.addMember(member);
        }
        loader.loadCompetitionResults(Path.of("data/competitionResults.csv"), club);
    } catch (IOException e) {
        IO.println("Der skete en fejl: " + e.getLocalizedMessage());
    }

    userInterface.run();

}