package projects.TA_web.entity;

public class Coupon{
    private String Duration;
    private String Name;
    private String Point;
    private String Value;
    private String Status;
    private String UnitName;
    private String UnitNameTimes;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getUnitName() {
        return UnitName;
    }

    public void setUnitName(String unitName) {
        UnitName = unitName;
    }

    public String getUnitNameTimes() {
        return UnitNameTimes;
    }

    public void setUnitNameTimes(String unitNameTimes) {
        UnitNameTimes = unitNameTimes;
    }

    public Coupon(String duration, String name, String Point, String Value) {
        this.Duration = duration;
        this.Name = name;
        this.Point = Point;
        this.Value = Value;

    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPoint() {
        return Point;
    }

    public void setPoint(String Point) {
        this.Point = Point;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }


}