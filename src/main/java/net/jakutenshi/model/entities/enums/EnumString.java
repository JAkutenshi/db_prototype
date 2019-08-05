package net.jakutenshi.model.entities.enums;

import static net.jakutenshi.utils.Constants.NONE;

public abstract class EnumString {
    private int    id;
    private String name;

    public EnumString() {
        this.id   = -1;
        this.name = NONE;
    }

    public EnumString(int id, String name) {
        this.id   = id;
        this.name = name;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
