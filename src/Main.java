void main() {

    UserInterface userInterface = new UserInterface();
  Member member1 = new Member(1323, "Per", LocalDate.of(2010, 2, 25), true);
  Member member2 = new Member(1123, "Jan", LocalDate.of(1960, 6, 4), true);
  Member member3 = new Member(1123, "Tom", LocalDate.of(1999, 9, 17), true);

  Club club = new Club();
 club.addMember(member1);
 club.addMember(member2);
 club.addMember(member3);

 userInterface.run();

}