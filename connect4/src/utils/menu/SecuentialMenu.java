package utils.menu;

public abstract class SecuentialMenu extends Menu{
    private int maxSecuences;

    public SecuentialMenu(String title, int maxSecuences) {
        super(title);
        assert maxSecuences > 1;
        this.maxSecuences = maxSecuences;
    }

    public abstract void addOptions();

    protected void interact_() {
        for (int i = 0; i < this.maxSecuences; i++) {
            super.interact_();
        }
    }
}
