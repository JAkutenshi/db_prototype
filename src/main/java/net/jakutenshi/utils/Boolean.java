package net.jakutenshi.utils;

public class Boolean  {
    boolean val;

    public Boolean(boolean val) {
        this.val = val;
    }

    public boolean isTrue() {
        return val;
    }

    public void setValue(boolean val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val ? "Да" : "Нет";
    }
}
