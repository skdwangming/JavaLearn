package JDKProxy;

public class PersonDaoImpl implements PersonDao {
    @Override
    public void savePerson() {
        System.out.println("save Person");
    }
}
