package entity;

public enum Gender {
    Male("male"), Female("female");

    private String desc;

    Gender(String desc){
        this.desc = desc;

    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
