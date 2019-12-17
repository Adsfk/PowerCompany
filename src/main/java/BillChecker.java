import java.util.List;

public class BillChecker {
    public String checkBills(List<Bill> bills) {
        if(bills.size()<=1) return "All right";
        if(bills.get(0).getEndDate().isBefore(bills.get(1).getStartDate())) return "Gap";
        if(bills.get(0).getEndDate().isAfter(bills.get(1).getStartDate())) return "Overlap";
        else return "All right";
    }
}
