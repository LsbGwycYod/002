package cn.edu.nbpt.lilingyi.blogmanage.pojo.enums;

public enum StateTypeEnum {
    DRAFT(0, "草稿"),
    ENABLE(1, "启用"),
    DISABLE(2, "禁用");

    private final int value;
    private final String description;

    StateTypeEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    // 根据值获取状态描述
    public static String getDescriptionByValue(int value) {
        for (StateTypeEnum state : StateTypeEnum.values()) {
            if (state.getValue() == value) {
                return state.getDescription();
            }
        }
        return null; // 如果没有匹配的值
    }
}
