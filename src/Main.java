void main() {

  Member member1 = new Member(1323, "Per", LocalDate.of(2010, 2, 25), true);
  Member member2 = new Member(1223, "Jan", LocalDate.of(1960, 6, 4), true);
  Member member3 = new Member(1123, "Tom", LocalDate.of(1999, 9, 17), true);
  Member member4 = new Member(1423, "Tim", LocalDate.of(2011, 4, 22), false);

  Club club = new Club();
 club.addMember(member1);
 club.addMember(member2);
 club.addMember(member3);
 club.addMember(member4);

  IO.print(club.calculateExpectedFee());
}