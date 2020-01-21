import java.util.List;

public class PeriodChecker {
    public Status checkBills(List<Period> periods) {
        if(periods.size()<=1) return Status.ALLRIGHT;
        if(periods.get(0).getEndDate().isBefore(periods.get(1).getStartDate())) return Status.GAP;
        if(periods.get(0).getEndDate().isAfter(periods.get(1).getStartDate())) return Status.OVERLAP;
        else return Status.ALLRIGHT;
    }
}
