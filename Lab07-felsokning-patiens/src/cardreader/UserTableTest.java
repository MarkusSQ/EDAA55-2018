package cardreader;

public class UserTableTest {
	public static void main(String[] args) {
		UserTable tbl = new UserTable();
		User u73 = tbl.find(24073);
		User u74 = tbl.find(24074);
		User Jens = tbl.findByName("Jens Holmgren");
		
		System.out.println(u73);
		System.out.println(u74);
		System.out.println(Jens);
		
		tbl.add(new User(1234, "a a"));
		tbl.add(new User(99999, "a b"));
		
		System.out.println(tbl.testFind());
		
		tbl.print();
	}

}
