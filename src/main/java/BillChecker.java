import java.util.List;

public class BillChecker {
    public Status checkBills(List<Bill> bills) {
        if(bills.size()<=1) return Status.ALLRIGHT;
        if(bills.get(0).getEndDate().isBefore(bills.get(1).getStartDate())) return Status.GAP;
        if(bills.get(0).getEndDate().isAfter(bills.get(1).getStartDate())) return Status.OVERLAP;
        else return Status.ALLRIGHT;
    }
}
