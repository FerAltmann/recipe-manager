import java.util.ArrayList;

public class Recipe {
    
    // variables -> valores | variables (tipos) -> String(palabras), int(decimales), ints(enteros), booleans(booleanos) char(caracter)
    // instanciarla -> guardar un espacio en memoria ->> declarla -> darle un valor 
    
    // visibilidad tipo nombre;
    
    private String name; 
    private int quantity;
    private ArrayList<Ingredient> ingredients;
    private String description;

    public Recipe(){
        this.name = "";
        this.quantity = 0;
        this.ingredients = new ArrayList<Ingredient>();
        this.description = "";
    }

    //f(x)-> x+5
    //f(5)-> 5+5
    //visibilidad TipoDeObjetoQueRetorna/void nombre(TypeDelParametro nombreParametro)

    public void setName(String name){
        this.name = name;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setIngredients(ArrayList<Ingredient> ingredients){
        this.ingredients = ingredients;
    }
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getName(){
        return this.name;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public ArrayList<Ingredient> getIngredients(){
        return this.ingredients;
    }

    public String getDescription(){
        return this.description;
    }
    
    public String getRecipeInfo(){
        String i = "---INGREDIENTES---"+"\n";
        for(int x=0;x<this.ingredients.size();x++){
            i+=this.ingredients.get(x).getName()+"\n";
        }
        String info = "NOMBRE: "+ this.name + "\n" +"DESCRIPCION: " + this.description + "\n" + "CANTIDAD DE INGREDIENTES: " +this.quantity +"\n"+ i;
        return info;
    }
}
