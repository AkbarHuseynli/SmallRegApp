package entity;

public enum Gender {
    Male("male"), Female("female");

    private final String desc;

    Gender(String desc){
        this.desc = desc;

    }

    public String getDesc() {
        return desc;
    }


}
