import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BillCheckerTest {

    @Test
    public void should_return_all_right_with_one_bill() {
        BillChecker checker = new BillChecker();
        Bill bill = new Bill("16/11/2019","16/12/2019");
        assertThat(checker.checkBills(bill)).isEqualTo("All right");
    }

}
