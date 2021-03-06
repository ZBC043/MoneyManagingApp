package me.csed2.moneymanager.ui.model;

import me.csed2.moneymanager.charts.adapters.ChartImpl;

import java.util.List;

public class ChartNode implements UINode {

    private String name;
    private String image;
    private UINode parent;
    private ChartImpl chart;

    public ChartNode(String name, Menu parent, String image, ChartImpl chart) {
        this.name = name;
        this.parent = parent;
        this.image = image;
        this.chart = chart;

        if (parent != null) {
            parent.getChildren().add(this);
        }
    }

    public ChartImpl getChart() {
        return chart;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public UINode getParent() {
        return parent;
    }

    @Override
    public List<UINode> getChildren() {
        return null;
    }

    @Override
    public String getImage() {
        return image;
    }
}
