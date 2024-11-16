package utils.models;

public class ClosedInterval {
    private int min;
    private int max;

    public ClosedInterval(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean isIncluded(int value) {
        return this.min <= value && value <= this.max;
    }
}
