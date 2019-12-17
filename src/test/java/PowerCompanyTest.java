import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PowerCompanyTest {

    @Test
    public void should_return_all_right_with_no_bill() {
        BillChecker checker = new BillChecker();
        assertThat(checker.checkBills()).isEqualTo("All right");
    }
}
