package learning.Harish;

public class Car {
    private String registrationNo;
    private String color;

    public Car(String registrationNo, String color) {
        this.registrationNo = registrationNo;
        this.color = color;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        return this.registrationNo.hashCode()+20;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj instanceof Car) {
            Car tldObj = (Car) obj;
            return this.registrationNo.equals(tldObj.getRegistrationNo());
        }
        return false;
    }
}
