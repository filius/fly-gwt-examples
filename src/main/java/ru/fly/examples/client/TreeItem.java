package ru.fly.examples.client;

/**
 * User: fil
 * Date: 22.04.15
 */
public class TreeItem {

    public String name;

    public TreeItem(String name){
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((TreeItem)obj).getName());
    }
}
