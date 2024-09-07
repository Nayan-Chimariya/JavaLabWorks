class Car{
    public String model;
    public String color;
    public double price;
    public int mileage;

    public Car(String model,String color,double price,int mileage){
        this.model = model;
        this.color = color;
        this.price = price;
        this.mileage = mileage;
    }

    public Car(){
    }

    public void displayCarInfo(){
        System.out.printf("\nModel = %s\nColor = %s\nPrice = Rs. %f\nMileage = %d\n",model,color,price,mileage);
    }

}
public class q3_carModel {
    public static void main(String[] args) {
        Car C1 = new Car();
        Car C2 = new Car("X","Purple",300000,120);

        System.out.println("\nDefault Values: ");
        C1.displayCarInfo();

        System.out.println("\nParameterized Values: ");
        C2.displayCarInfo();
    }
}
