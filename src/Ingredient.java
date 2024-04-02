public class Ingredient {

    private String name;
    private int quantity;

    public Ingredient() {
        this.name = "";
        this.quantity = 0;
    }

    public void setName(String name){
        this.name = name;
    }
   
    public void setQuantity (int quantity){
        this.quantity = quantity;
    }

    public String getName(){
        return this.name;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public String getInfo(){
        String info=this.name+"\n"+this.quantity;
        return info;
    }
}
