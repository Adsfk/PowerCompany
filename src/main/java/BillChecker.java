import java.util.List;

public class BillChecker {
    public String checkBills(List<Bill> bills) {
        if(bills.size()<=1) return "All right";
        else return "Gap";
    }
}
