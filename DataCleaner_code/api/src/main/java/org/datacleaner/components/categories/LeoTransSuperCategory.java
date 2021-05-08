package org.datacleaner.components.categories;

/**
 * @Description 该类是
 * @Author LeoDY
 * @Date 2021/4/8
 **/
public class LeoTransSuperCategory extends AbstractComponentSuperCategory {
    @Override
    public String getDescription() {
        return "自定义拓展组件";
    }

    @Override
    public String getName() {
        return "自定义拓展";
    }

    @Override
    public int getSortIndex() {
        return 1500;
    }
}
