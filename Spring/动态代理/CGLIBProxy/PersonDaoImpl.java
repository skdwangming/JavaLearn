package CGLIBProxy;

import JDKProxy.PersonDao;

public class PersonDaoImpl implements PersonDao {
    @Override
    public void savePerson() {
        System.out.println("save Person");
    }
}
