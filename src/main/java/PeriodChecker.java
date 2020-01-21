import java.util.List;

public class PeriodChecker {
    public Status checkBills(List<Period> periods) {
        if(periods.size()<=1) return Status.ALLRIGHT;

        Status result = Status.ALLRIGHT;

        for (int i = 0; i < periods.size()-1; i++) {
            result = periodChecker(periods.get(i), periods.get(i+1));
        }

        return result;
    }

    private Status periodChecker(Period firstPeriod, Period secondPeriod) {
        Status result = Status.ALLRIGHT;

        if(firstPeriod.getEndDate().isBefore(secondPeriod.getStartDate())) result = Status.GAP;
        if(firstPeriod.getEndDate().isAfter(secondPeriod.getStartDate())) result = Status.OVERLAP;

        return result;
    }
}
