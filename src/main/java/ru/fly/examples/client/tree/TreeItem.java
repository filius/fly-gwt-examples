package ru.fly.examples.client.tree;

/**
 * User: fil
 * Date: 22.04.15
 */
public class TreeItem {

    private String name;
    private String sign;

    public TreeItem(String name, String sign){
        setName(name);
        setSign(sign);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && name != null && obj instanceof TreeItem && name.equals(((TreeItem)obj).getName());
    }
}
