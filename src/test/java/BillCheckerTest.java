import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BillCheckerTest {

    @Test
    public void should_return_all_right_with_one_bill() {
        BillChecker checker = new BillChecker();
        Bill bill = new Bill(LocalDate.of(2019,10,16),LocalDate.of(2019,11,16));

        List<Bill> bills = new ArrayList<>();
        bills.add(bill);

        assertThat(checker.checkBills(bills)).isEqualTo(Status.ALLRIGHT);
    }

    @Test
    public void should_return_gap_with_two_bills() {
        BillChecker checker = new BillChecker();
        Bill bill1 = new Bill(LocalDate.of(2019,8,16),LocalDate.of(2019,9,16));
        Bill bill2 = new Bill(LocalDate.of(2019,9,18),LocalDate.of(2019,11,17));

        List<Bill> bills = new ArrayList<>();
        bills.add(bill1);
        bills.add(bill2);

        assertThat(checker.checkBills(bills)).isEqualTo(Status.GAP);
    }

    @Test
    public void should_return_overlap_with_two_bills() {
        BillChecker checker = new BillChecker();
        Bill bill1 = new Bill(LocalDate.of(2019,8,16),LocalDate.of(2019,9,16));
        Bill bill2 = new Bill(LocalDate.of(2019,9,10),LocalDate.of(2019,11,17));

        List<Bill> bills = new ArrayList<>();
        bills.add(bill1);
        bills.add(bill2);

        assertThat(checker.checkBills(bills)).isEqualTo(Status.OVERLAP);
    }
}
