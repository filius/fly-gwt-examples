package ru.fly.examples.client.tree;

/**
 * User: fil
 * Date: 22.04.15
 */
public class TreeGridItem {

    private String column1;
    private String column2;
    private String column3;

    public TreeGridItem(String column1, String column2, String column3){
        setColumn1(column1);
        setColumn2(column2);
        setColumn3(column3);
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public String getColumn3() {
        return column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    @Override
    public boolean equals(Object obj) {
        return column1.equals(((TreeGridItem)obj).getColumn1());
    }
}
