import java.time.LocalDate;

public class Bill {

    private final LocalDate startDate;
    private final LocalDate endDate;

    public Bill(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
