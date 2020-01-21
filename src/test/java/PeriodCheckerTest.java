import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PeriodCheckerTest {

    @Test
    public void should_return_all_right_with_one_period() {
        PeriodChecker checker = new PeriodChecker();
        Period period = new Period(LocalDate.of(2019,10,16),LocalDate.of(2019,11,16));

        List<Period> periods = new ArrayList<>();
        periods.add(period);

        assertThat(checker.checkBills(periods)).isEqualTo(Status.ALLRIGHT);
    }

    @Test
    public void should_return_gap_with_two_periods() {
        PeriodChecker checker = new PeriodChecker();
        Period period1 = new Period(LocalDate.of(2019,8,16),LocalDate.of(2019,9,16));
        Period period2 = new Period(LocalDate.of(2019,9,18),LocalDate.of(2019,11,17));

        List<Period> periods = new ArrayList<>();
        periods.add(period1);
        periods.add(period2);

        assertThat(checker.checkBills(periods)).isEqualTo(Status.GAP);
    }

    @Test
    public void should_return_overlap_with_two_periods() {
        PeriodChecker checker = new PeriodChecker();
        Period period1 = new Period(LocalDate.of(2019,8,16),LocalDate.of(2019,9,16));
        Period period2 = new Period(LocalDate.of(2019,9,10),LocalDate.of(2019,11,17));

        List<Period> periods = new ArrayList<>();
        periods.add(period1);
        periods.add(period2);

        assertThat(checker.checkBills(periods)).isEqualTo(Status.OVERLAP);
    }

    @Test
    public void should_return_gap_with_three_periods() {
        PeriodChecker checker = new PeriodChecker();
        Period period1 = new Period(LocalDate.of(2019,9,8),LocalDate.of(2019,11,16));
        Period period2 = new Period(LocalDate.of(2019,11,16),LocalDate.of(2019,12,14));
        Period period3 = new Period(LocalDate.of(2019,12,16),LocalDate.of(2020,1,14));

        List<Period> periods = new ArrayList<>();
        periods.add(period1);
        periods.add(period2);
        periods.add(period3);

        assertThat(checker.checkBills(periods)).isEqualTo(Status.GAP);
    }

}
