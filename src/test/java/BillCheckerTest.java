import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BillCheckerTest {

    @Test
    public void should_return_all_right_with_one_bill() {
        BillChecker checker = new BillChecker();
        Bill bill = new Bill("16/11/2019","16/12/2019");

        List<Bill> bills = new ArrayList<>();
        bills.add(bill);

        assertThat(checker.checkBills(bills)).isEqualTo("All right");
    }

    @Test
    public void should_return_gap_with_two_bills() {
        BillChecker checker = new BillChecker();
        Bill bill1 = new Bill("16/09/2019","16/10/2019");
        Bill bill2 = new Bill("18/10/2019","17/12/2019");

        List<Bill> bills = new ArrayList<>();
        bills.add(bill1);
        bills.add(bill2);

        assertThat(checker.checkBills(bills)).isEqualTo("Gap");
    }
}
