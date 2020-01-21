import java.util.List;

public class PeriodChecker {
    public Status checkBills(List<Period> periods) {
        if(periods.size()<=1) return Status.ALLRIGHT;

        Status result = Status.ALLRIGHT;

        for (int i = 0; i < periods.size()-1; i++) {
            if(periods.get(i).getEndDate().isBefore(periods.get(i+1).getStartDate())) result = Status.GAP;
            if(periods.get(i).getEndDate().isAfter(periods.get(i+1).getStartDate())) result = Status.OVERLAP;
        }

        return result;
    }
}
