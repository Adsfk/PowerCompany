import java.util.List;

public class PeriodChecker {
    public Status checkBills(List<Period> periods) {
        if(periods.size()<=1) return Status.ALLRIGHT;

        Status result = Status.ALLRIGHT;
        for (int i = 0; i < periods.size()-1; i++)
            result = checkPeriods(periods.get(i), periods.get(i+1), result);

        return result;
    }

    private Status checkPeriods(Period firstPeriod, Period secondPeriod, Status result) {

        if(thereIsGap(firstPeriod, secondPeriod)) result = Status.GAP;
        if(thereIsOverlap(firstPeriod, secondPeriod)) result = Status.OVERLAP;

        return result;
    }

    private boolean thereIsOverlap(Period firstPeriod, Period secondPeriod) {
        return firstPeriod.getEndDate().isAfter(secondPeriod.getStartDate());
    }

    private boolean thereIsGap(Period firstPeriod, Period secondPeriod) {
        return firstPeriod.getEndDate().isBefore(secondPeriod.getStartDate());
    }
}
