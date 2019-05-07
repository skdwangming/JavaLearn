package JDKProxy;

public class Transaction {
    void beginTransaction(){
        System.out.println("begin JDKProxy.Transaction");
    }

    void commit(){
        System.out.println("commit");
    }
}
