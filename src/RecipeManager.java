// import javax.swing.*;
// import java.awt.*;
import java.io.*;
import java.util.ArrayList;
// import javax.swing.JOptionPane;
import java.util.Scanner;

public class RecipeManager{

    // private JLabel descriptionLabel;
    // private JButton addRecipeButton,deleteLastRecipeButton,searchRecipeButton,exportRecipesButton;
    // private JTextField recipeIndex;
    private Scanner scanner;
    private ArrayList<Recipe> recipes;
    // private JList<String> recipeList;
    // private DefaultListModel<String> listModel;

    // private JScrollPane mainPanel;
    // private JPanel buttonPanel;
    

    public RecipeManager(){
        initiateData();
        beginListing();
        // addComponents();
        // startWindow();

    }

    public String askStringInput(String message){
        System.out.println(message);
        String input = scanner.next();
        this.scanner.nextLine();
        return input;
    }
    public int askIntInput(String message){
        System.out.println(message);
        int input = scanner.nextInt();
        this.scanner.nextLine();
        return input;
    }

    public void createRecipe(){
        Recipe newRecipe = new Recipe();

        System.out.println("Add the name of the recipe: ");
        String name = this.scanner.nextLine();
        newRecipe.setName(name);
        
        this.scanner.nextLine();
        
        System.out.println("Add a brief description about the recipe: ");
        String description = this.scanner.nextLine();
        newRecipe.setDescription(description);

        this.scanner.nextLine();
        
        System.out.println("Add the number of ingredients in the recipe: ");
        int quantity = this.scanner.nextInt();
        newRecipe.setQuantity(quantity);

        this.scanner.nextLine();
        
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

        for(int x = 0; x<newRecipe.getQuantity(); x++){
            Ingredient ingredient = new Ingredient();
            System.out.println("Add the name of the ingredient: ");
            String ingredient_name = this.scanner.nextLine(); 
            this.scanner.nextLine();
            ingredient.setName(ingredient_name);
            ingredients.add(ingredient);
        }

        newRecipe.setIngredients(ingredients);
        this.recipes.add(newRecipe);
    }

    public void deleteLastRecipe(){
        this.recipes.remove(this.recipes.size()-1);
    }

    public void searchRecipe(){
        int index = askIntInput("Add the index of the desired recipe");
        System.out.println(this.recipes.get(index).getRecipeInfo());
    }

    public void showRecipes(){
        String msg = "RECIPES\n";
        for(int i = 0;i<this.recipes.size();i++){
            msg += i+") "+this.recipes.get(i).getName()+"\n";
        }
        System.out.println(msg);
    }

    public void exportRecipes(){
        try{
            FileWriter writer = new FileWriter(new File("data.txt"));

            for(int i = 0;i<this.recipes.size();i++){
                writer.write(this.recipes.get(i).getRecipeInfo()+"\n\n");
            }
            writer.close();
            System.out.println("File saved");
        }
        catch(Exception e){
            System.out.println("Error in export");
            System.out.println(e.getStackTrace());
        }
    }

    public void beginListing(){
        boolean stopProcess = false;

        while(!stopProcess){
            int option = askIntInput("Menu\nCreate new recipe [1]\nRemove last recipe [2]\nSearch recipe [3]\nShow all recipes [4]\nExport recipes [5]\nQuit [6]");

            if(option==1){
                createRecipe();
            }
            else if(option==2){
                deleteLastRecipe();
            }
            else if(option==3){
                searchRecipe();

            }
            else if(option==4){
                showRecipes();
            }
            else if(option==5){
                exportRecipes();
            }
            else if(option==6){
                stopProcess = true;
                this.scanner.close();
            }
            else{
                System.out.println("Invalid input");
            }
        }

    }

    public void initiateData(){
        this.recipes = new ArrayList<Recipe>();
        this.scanner = new Scanner(System.in);
        System.out.println("This is a recipe manager");

        // this.descriptionLabel = new JLabel("This is a recipe manager", SwingConstants.CENTER);

        // this.listModel = new DefaultListModel<>();
        // this.recipeList = new JList<>(this.listModel);

        // this.mainPanel = new JScrollPane(recipeList);
        // this.mainPanel.setPreferredSize(new Dimension(400, 300));
        // this.mainPanel.setBackground(new Color(173, 217, 216));
    
        // this.buttonPanel = new JPanel();
        // this.buttonPanel.setLayout(new GridLayout(2, 3, 5, 5)); 
        // this.buttonPanel.setBackground(new Color(189, 243, 255));


        // this.addRecipeButton = new JButton("Add new recipe");
        // this.addRecipeButton.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         createRecipeActionPerformed(evt);
        //     }
        // });
        // this.deleteLastRecipeButton = new JButton("Delete last recipe");
        // this.deleteLastRecipeButton.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         removeLastRecipeActionPerformed(evt);
        //     }
        // });
        // this.searchRecipeButton = new JButton("Lookup recipe info");
        // this.searchRecipeButton.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         recipeLookupActionPerformed(evt);
        //     }
        // });

        // this.recipeIndex = new JTextField(10);

        // this.exportRecipesButton = new JButton("Export Recipes");
        // this.exportRecipesButton.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         recipeExportActionPerformed(evt);
        //     }
        // });
    }

    // public void createRecipeActionPerformed(java.awt.event.ActionEvent evt){
    //     Recipe newRecipe = new Recipe();
    //     newRecipe.setName(JOptionPane.showInputDialog("Add the name of the recipe"));
    //     newRecipe.setDescription(JOptionPane.showInputDialog("Add a brief description about the recipe"));
    //     newRecipe.setQuantity(Integer.parseInt(JOptionPane.showInputDialog("Add the number of ingredients in the recipe")));
    //     ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

    //     for(int x = 0; x<newRecipe.getQuantity(); x++){
    //         Ingredient ingredient = new Ingredient();
    //         ingredient.setName(JOptionPane.showInputDialog("Add the name of the ingredient"));
    //         ingredients.add(ingredient);
    //     }

    //     newRecipe.setIngredients(ingredients);
    //     this.recipes.add(newRecipe);
    //     listModel.addElement((this.recipes.size()-1)+") "+newRecipe.getName()+": "+newRecipe.getDescription());
    // }
    // public void removeLastRecipeActionPerformed(java.awt.event.ActionEvent evt){
        
    //     this.recipes.remove(this.recipes.size()-1);
    //     listModel.removeElementAt(listModel.getSize()-1);
    // }
    // public void recipeLookupActionPerformed(java.awt.event.ActionEvent evt){
    //     if(this.recipeIndex.getText().length()>0){
    //         try{
    //             int index = Integer.parseInt(this.recipeIndex.getText());
    //             JOptionPane.showMessageDialog(null,recipes.get(index).getRecipeInfo());
    //         }
    //         catch(Exception e){
    //             JOptionPane.showMessageDialog(null,"Invalid index");
    //         }
    //     }
    // }
    // public void recipeExportActionPerformed(java.awt.event.ActionEvent evt){
    //     try{
    //         FileWriter writer = new FileWriter(new File("data.txt"));

    //         for(int i = 0;i<this.recipes.size();i++){
    //             writer.write(this.recipes.get(i).getRecipeInfo()+"\n\n");
    //         }
    //         writer.close();
    //         JOptionPane.showMessageDialog(null,"File saved");
    //     }
    //     catch(Exception e){
    //         JOptionPane.showMessageDialog(null,"Error in export");
    //         System.out.println(e.getStackTrace());
    //     }
    // }

    
    // public void startWindow(){
    //     setTitle("Recipe Manager");

    //     setSize(600,500);
    //     setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    //     setVisible(true);
    // }

    // public void addComponents(){

    //     setLayout(new BorderLayout());
    //     add(this.mainPanel, BorderLayout.CENTER);
    //     add(this.buttonPanel, BorderLayout.SOUTH);

    //     this.buttonPanel.add(this.descriptionLabel);
    //     this.buttonPanel.add(this.addRecipeButton);
    //     this.buttonPanel.add(this.deleteLastRecipeButton);
    //     this.buttonPanel.add(this.recipeIndex);
    //     this.buttonPanel.add(this.searchRecipeButton);
    //     this.buttonPanel.add(this.exportRecipesButton);

    // }

}
