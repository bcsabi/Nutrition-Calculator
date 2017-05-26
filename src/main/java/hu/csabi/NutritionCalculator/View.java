package hu.csabi.NutritionCalculator;

import hu.csabi.NutritionCalculator.Controllers.ControllerForConsumptionsXML;
import hu.csabi.NutritionCalculator.Controllers.ControllerForDailyCalorieCalculators;
import hu.csabi.NutritionCalculator.Controllers.ControllerForFoodsXML;
import hu.csabi.NutritionCalculator.Controllers.ControllerForNutritionCalculators;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.InputStream;

/**
 * A kalória kalkulátort JavaFX által megvalósító osztály.
 */
public class View extends Application{

    /**
     * A ControllerForFoodsXML osztályt meghívó objektum deklarálása.
     */
    private final ControllerForFoodsXML controllerForFoodsXML = new ControllerForFoodsXML();
    /**
     * A ControllerForNutritionalCalulators osztályt meghívó objektum deklarálása.
     */
    private final ControllerForNutritionCalculators controllerForNutritionCalculators = new ControllerForNutritionCalculators();
    /**
     * A ControllerForDailyCalorieCalculators osztályt meghívó objektum deklarálása.
     */
    private final ControllerForDailyCalorieCalculators controllerForDailyCalorieCalculators = new ControllerForDailyCalorieCalculators();
    /**
     * A ControllerForConsumptionsXML osztályt meghívó objektum deklarálása.
     */
    private final ControllerForConsumptionsXML controllerForConsumptionsXML = new ControllerForConsumptionsXML();
    /**
     * Az error üzeneteket megvalósító objektum deklarálása.
     */
    private final Alert errorMessage = new Alert(AlertType.ERROR);




    /**
     * Beállítja az összes képernyőt és elindítja az első képernyőt.
     * @param primaryStage Stage
     * @throws Exception Kivétel keletkezhet a háttérképek beolvasása során.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        final Group mainRoot = new Group();
        final Group nutritionCalculatorRoot = new Group();
        final Group dailyCalorieCalculatorRoot = new Group();


        //First screen
        final Scene firstScreen = new Scene(mainRoot, 800, 600);
        primaryStage.setTitle("Nutrition Application");

        try{
            InputStream img = ClassLoader.class.getResourceAsStream("/hu/csabi/NutritionCalculator/Img17.png");
            Image backgroundImage = new Image(img);
            ImagePattern pattern = new ImagePattern(backgroundImage);
            firstScreen.setFill(pattern);
        }
        catch(Exception e){
            firstScreen.setFill(Color.BLACK);
        }

        final Font sawasdee = new Font("Sawasdee", 25);
        final Font textSize = new Font(15);

        final Button nutritionCalculatorButton = new Button("Nutrition Calculator");
        nutritionCalculatorButton.setLayoutX(300);
        nutritionCalculatorButton.setLayoutY(150);
        nutritionCalculatorButton.setPrefSize(200,20);
        nutritionCalculatorButton.setTextFill(Color.BLACK);
        nutritionCalculatorButton.setCursor(Cursor.HAND);
        nutritionCalculatorButton.setStyle("-fx-font: 13 Arial ; -fx-background-color: blanchedalmond");
        mainRoot.getChildren().add(nutritionCalculatorButton);

        final Button dailyCaloreCalculatorButton = new Button("Daily Calorie Calculator");
        dailyCaloreCalculatorButton.setLayoutX(300);
        dailyCaloreCalculatorButton.setLayoutY(200);
        dailyCaloreCalculatorButton.setPrefSize(200,20);
        dailyCaloreCalculatorButton.setTextFill(Color.BLACK);
        dailyCaloreCalculatorButton.setCursor(Cursor.HAND);
        dailyCaloreCalculatorButton.setStyle("-fx-font: 13 Arial ; -fx-background-color: blanchedalmond");
        mainRoot.getChildren().add(dailyCaloreCalculatorButton);

        final Button exitButton = new Button("Close the application");
        exitButton.setLayoutX(300);
        exitButton.setLayoutY(420);
        exitButton.setPrefSize(200,20);
        exitButton.setTextFill(Color.BLACK);
        exitButton.setCursor(Cursor.HAND);
        exitButton.setStyle("-fx-font: 13 Arial; -fx-background-color: blanchedalmond");
        mainRoot.getChildren().add(exitButton);

        final Text welcomeText = new Text(180, 30, "Welcome to the Nutrition Application!");
        welcomeText.setFill(Color.rgb(255,236,134));
        welcomeText.setFont(sawasdee);
        mainRoot.getChildren().add(welcomeText);





        //Nutrition Calculator Screen:
        final Scene nutritionCalculatorScreen = new Scene(nutritionCalculatorRoot, 800, 600);

        try{
            InputStream img = ClassLoader.class.getResourceAsStream("/hu/csabi/NutritionCalculator/Img17.png");
            Image backgroundImage = new Image(img);
            ImagePattern pattern = new ImagePattern(backgroundImage);
            nutritionCalculatorScreen.setFill(pattern);
        }
        catch(Exception e){
            System.err.println("No image found!");
            nutritionCalculatorScreen.setFill(Color.SILVER);
        }



        final Button addButton = new Button("ADD");
        addButton.setLayoutX(680);
        addButton.setLayoutY(20);
        addButton.setPrefSize(100,20);
        addButton.setTextFill(Color.BLACK);
        addButton.setCursor(Cursor.HAND);
        addButton.setStyle("-fx-font: 13 Arial ; -fx-background-color: blanchedalmond");
        nutritionCalculatorRoot.getChildren().add(addButton);

        final Button deleteButton = new Button("DELETE");
        deleteButton.setLayoutX(680);
        deleteButton.setLayoutY(65);
        deleteButton.setPrefSize(100,20);
        deleteButton.setTextFill(Color.BLACK);
        deleteButton.setCursor(Cursor.HAND);
        deleteButton.setStyle("-fx-font: 13 Arial ; -fx-background-color: blanchedalmond");
        nutritionCalculatorRoot.getChildren().add(deleteButton);

        final Button backButton = new Button("BACK");
        backButton.setLayoutX(20);
        backButton.setLayoutY(560);
        backButton.setPrefSize(100,20);
        backButton.setTextFill(Color.BLACK);
        backButton.setCursor(Cursor.HAND);
        backButton.setStyle("-fx-font: 13 Arial ; -fx-background-color: blanchedalmond");
        nutritionCalculatorRoot.getChildren().add(backButton);

        final Button saveButton = new Button("SAVE");
        saveButton.setLayoutX(680);
        saveButton.setLayoutY(560);
        saveButton.setPrefSize(100,20);
        saveButton.setTextFill(Color.BLACK);
        saveButton.setCursor(Cursor.HAND);
        saveButton.setStyle("-fx-font: 13 Arial ; -fx-background-color: blanchedalmond");
        nutritionCalculatorRoot.getChildren().add(saveButton);



        final Label foodsLabel = new Label("Select a food.");
        foodsLabel.setLayoutX(20);
        foodsLabel.setLayoutY(5);
        foodsLabel.setStyle("-fx-font: 20 Sawasdee");
        foodsLabel.setTextFill(Color.BLANCHEDALMOND);
        nutritionCalculatorRoot.getChildren().add(foodsLabel);

        final ChoiceBox<String> foodsCBox = new ChoiceBox<>();
        foodsCBox.setLayoutX(20);
        foodsCBox.setLayoutY(35);
        foodsCBox.setPrefSize(120,30);
        nutritionCalculatorRoot.getChildren().add(foodsCBox);



        final Label howMuchDidYouEatLabel = new Label("How much did you eat?");
        howMuchDidYouEatLabel.setLayoutX(200);
        howMuchDidYouEatLabel.setLayoutY(5);
        howMuchDidYouEatLabel.setStyle("-fx-font: 20 Sawasdee");
        howMuchDidYouEatLabel.setTextFill(Color.BLANCHEDALMOND);
        nutritionCalculatorRoot.getChildren().add(howMuchDidYouEatLabel);

        final TextField amountConsumedTextField = new TextField();
        amountConsumedTextField.setPrefSize(80,30);
        amountConsumedTextField.setLayoutX(200);
        amountConsumedTextField.setLayoutY(35);
        amountConsumedTextField.setFont(textSize);
        nutritionCalculatorRoot.getChildren().add(amountConsumedTextField);

        final Label eatGramsLabel = new Label("grams");
        eatGramsLabel.setLayoutX(290);
        eatGramsLabel.setLayoutY(35);
        eatGramsLabel.setStyle("-fx-font: 20 Sawasdee");
        eatGramsLabel.setTextFill(Color.BLANCHEDALMOND);
        nutritionCalculatorRoot.getChildren().add(eatGramsLabel);




        final Label consumedLabel = new Label("List of consumed foods!");
        consumedLabel.setLayoutX(20);
        consumedLabel.setLayoutY(100);
        consumedLabel.setStyle("-fx-font: 20 Sawasdee");
        consumedLabel.setTextFill(Color.BLANCHEDALMOND);
        nutritionCalculatorRoot.getChildren().add(consumedLabel);

        final ListView<String> consumedListView = new ListView<>();
        consumedListView.setEditable(false);
        consumedListView.setPrefSize(215,170);
        consumedListView.setLayoutX(20);
        consumedListView.setLayoutY(130);
        nutritionCalculatorRoot.getChildren().add(consumedListView);




        final Label nutritionalValueLabel = new Label("Nutritional values of selected food in 100g!");
        nutritionalValueLabel.setLayoutX(280);
        nutritionalValueLabel.setLayoutY(100);
        nutritionalValueLabel.setStyle("-fx-font: 20 Sawasdee");
        nutritionalValueLabel.setTextFill(Color.BLANCHEDALMOND);
        nutritionCalculatorRoot.getChildren().add(nutritionalValueLabel);

        final ListView<String> nutritionalValueListView = new ListView<>();
        nutritionalValueListView.setEditable(false);
        nutritionalValueListView.setPrefSize(215,122);
        nutritionalValueListView.setLayoutX(280);
        nutritionalValueListView.setLayoutY(130);
        nutritionalValueListView.getItems().add("Food name: ");
        nutritionalValueListView.getItems().add("Protein: ");
        nutritionalValueListView.getItems().add("Carbohydrate: ");
        nutritionalValueListView.getItems().add("Fat: ");
        nutritionalValueListView.getItems().add("Calories: ");
        nutritionCalculatorRoot.getChildren().add(nutritionalValueListView);




        final Label nutritionalCounterLabel = new Label("Intake of nutritional values!");
        nutritionalCounterLabel.setLayoutX(20);
        nutritionalCounterLabel.setLayoutY(322);
        nutritionalCounterLabel.setStyle("-fx-font: 20 Sawasdee");
        nutritionalCounterLabel.setTextFill(Color.BLANCHEDALMOND);
        nutritionCalculatorRoot.getChildren().add(nutritionalCounterLabel);

        final ListView<String> nutritionalCounterListView = new ListView<>();
        nutritionalCounterListView.setEditable(false);
        nutritionalCounterListView.setPrefSize(215,100);
        nutritionalCounterListView.setLayoutX(20);
        nutritionalCounterListView.setLayoutY(355);
        nutritionalCounterListView.getItems().add("Protein: ");
        nutritionalCounterListView.getItems().add("Carbohydrate: ");
        nutritionalCounterListView.getItems().add("Fat: ");
        nutritionalCounterListView.getItems().add("Calorie: ");
        nutritionCalculatorRoot.getChildren().add(nutritionalCounterListView);


        final Label consumptionHistoryLabel = new Label("Consumption history");
        consumptionHistoryLabel.setLayoutX(280);
        consumptionHistoryLabel.setLayoutY(285);
        consumptionHistoryLabel.setStyle("-fx-font: 20 Sawasdee");
        consumptionHistoryLabel.setTextFill(Color.BLANCHEDALMOND);
        nutritionCalculatorRoot.getChildren().add(consumptionHistoryLabel);

        final ChoiceBox<String> consumptionHistoryCBox = new ChoiceBox<>();
        consumptionHistoryCBox.setLayoutX(280);
        consumptionHistoryCBox.setLayoutY(315);
        consumptionHistoryCBox.setPrefSize(215,30);
        nutritionCalculatorRoot.getChildren().add(consumptionHistoryCBox);

        final ListView<String> consumptionHistoryListWiew = new ListView<>();
        consumptionHistoryListWiew.setLayoutX(280);
        consumptionHistoryListWiew.setLayoutY(355);
        consumptionHistoryListWiew.setPrefSize(215,100);
        consumptionHistoryListWiew.setEditable(false);
        consumptionHistoryListWiew.getItems().add("Protein: ");
        consumptionHistoryListWiew.getItems().add("Carbohydrate: ");
        consumptionHistoryListWiew.getItems().add("Fat: ");
        consumptionHistoryListWiew.getItems().add("Calorie: ");
        nutritionCalculatorRoot.getChildren().add(consumptionHistoryListWiew);


        if(!foodsCBox.getItems().isEmpty())
        {
            foodsCBox.getItems().remove(0,foodsCBox.getItems().size());
        }
        try{
            for(String foods : controllerForFoodsXML.loadFoods())
            {
                foodsCBox.getItems().add(foods);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            }

        if(!consumptionHistoryCBox.getItems().isEmpty())
        {
            consumptionHistoryCBox.getItems().remove(0,consumptionHistoryCBox.getItems().size());
        }
        try{
            for(String dates: controllerForConsumptionsXML.loadDates())
            {
                consumptionHistoryCBox.getItems().add(dates);
            }
        }
        catch (Exception e){
            //System.err.println("View");
            e.printStackTrace();
        }


        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> barChart = new BarChart<>(xAxis,yAxis);

        barChart.setLayoutX(490);
        barChart.setLayoutY(120);
        barChart.setPrefSize(310,340);

        XYChart.Series<String,Number> seriesProtein = new XYChart.Series<>();
        seriesProtein.setName("Protein");

        XYChart.Series<String,Number> seriesCarbohydrate = new XYChart.Series<>();
        seriesCarbohydrate.setName("Carbohydrate");

        XYChart.Series<String,Number> seriesFat = new XYChart.Series<>();
        seriesFat.setName("Fat");

        XYChart.Series<String,Number> seriesCalorie = new XYChart.Series<>();
        seriesCalorie.setName("Calorie");

        barChart.getData().addAll(seriesProtein,seriesCarbohydrate,seriesFat);
        nutritionCalculatorRoot.getChildren().add(barChart);



        /*
          Daily Calorie Calculator
         */
        Scene dailyCalorieCalculatorScreen = new Scene(dailyCalorieCalculatorRoot, 800,600);

        try{
            InputStream img = ClassLoader.class.getResourceAsStream("/hu/csabi/NutritionCalculator/Img17.png");
            Image backgroundImage = new Image(img);
            ImagePattern pattern = new ImagePattern(backgroundImage);
            dailyCalorieCalculatorScreen.setFill(pattern);
        }
        catch(Exception e){
            dailyCalorieCalculatorScreen.setFill(Color.ORANGERED);
        }


        Line lineAfterDetails = new Line();
        lineAfterDetails.setStartX(0);
        lineAfterDetails.setStartY(110);
        lineAfterDetails.setEndX(800);
        lineAfterDetails.setEndY(110);
        lineAfterDetails.setStroke(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(lineAfterDetails);

        Line lineAfterMaintainWeight = new Line();
        lineAfterMaintainWeight.setStartX(0);
        lineAfterMaintainWeight.setStartY(220);
        lineAfterMaintainWeight.setEndX(800);
        lineAfterMaintainWeight.setEndY(220);
        lineAfterMaintainWeight.setStroke(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(lineAfterMaintainWeight);

        Line lineAfterLoseWeight = new Line();
        lineAfterLoseWeight.setStartX(0);
        lineAfterLoseWeight.setStartY(340);
        lineAfterLoseWeight.setEndX(800);
        lineAfterLoseWeight.setEndY(340);
        lineAfterLoseWeight.setStroke(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(lineAfterLoseWeight);


        Line lineAfterGainWeight = new Line();
        lineAfterGainWeight.setStartX(0);
        lineAfterGainWeight.setStartY(460);
        lineAfterGainWeight.setEndX(800);
        lineAfterGainWeight.setEndY(460);
        lineAfterGainWeight.setStroke(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(lineAfterGainWeight);


        final Button dailyBackButton = new Button("BACK");
        dailyBackButton.setLayoutX(20);
        dailyBackButton.setLayoutY(560);
        dailyBackButton.setPrefSize(100,20);
        dailyBackButton.setTextFill(Color.BLACK);
        dailyBackButton.setCursor(Cursor.HAND);
        dailyBackButton.setStyle("-fx-font: 13 Arial ; -fx-background-color: blanchedalmond");
        dailyCalorieCalculatorRoot.getChildren().add(dailyBackButton);



        final Button dailyCalculateButton = new Button("CALCULATE");
        dailyCalculateButton.setLayoutX(680);
        dailyCalculateButton.setLayoutY(560);
        dailyCalculateButton.setPrefSize(100,20);
        dailyCalculateButton.setTextFill(Color.BLACK);
        dailyCalculateButton.setCursor(Cursor.HAND);
        dailyCalculateButton.setStyle("-fx-font: 13 Arial ; -fx-background-color: blanchedalmond");
        dailyCalorieCalculatorRoot.getChildren().add(dailyCalculateButton);



        final Button dailyCleanButton = new Button("CLEAN");
        dailyCleanButton.setLayoutX(350);
        dailyCleanButton.setLayoutY(560);
        dailyCleanButton.setPrefSize(100,20);
        dailyCleanButton.setTextFill(Color.BLACK);
        dailyCleanButton.setCursor(Cursor.HAND);
        dailyCleanButton.setStyle("-fx-font: 13 Arial ; -fx-background-color: blanchedalmond");
        dailyCalorieCalculatorRoot.getChildren().add(dailyCleanButton);



        final Label detailsLabel = new Label("Please fill the gaps with the required details!");
        detailsLabel.setLayoutX(20);
        detailsLabel.setLayoutY(5);
        detailsLabel.setStyle("-fx-font: 20 Sawasdee");
        detailsLabel.setTextFill(Color.rgb(255,236,134));
        dailyCalorieCalculatorRoot.getChildren().add(detailsLabel);

        final Label ageLabel = new Label("Age:");
        ageLabel.setLayoutX(20);
        ageLabel.setLayoutY(45);
        ageLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(ageLabel);

        final TextField ageTextField = new TextField();
        ageTextField.setFont(textSize);
        ageTextField.setTooltip(new Tooltip("How old are you?"));
        ageTextField.setLayoutX(20);
        ageTextField.setLayoutY(65);
        ageTextField.setPrefSize(80,20);
        dailyCalorieCalculatorRoot.getChildren().add(ageTextField);

        final Label genderLabel = new Label("Gender:");
        genderLabel.setLayoutX(150);
        genderLabel.setLayoutY(45);
        genderLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(genderLabel);

        final ChoiceBox<String> genderCBox = new ChoiceBox<>();
        genderCBox.getItems().add("Male");
        genderCBox.getItems().add("Female");
        genderCBox.setLayoutX(150);
        genderCBox.setLayoutY(65);
        genderCBox.setPrefSize(80,30);
        dailyCalorieCalculatorRoot.getChildren().add(genderCBox);

        final Label weightLabel = new Label("Weight:");
        weightLabel.setLayoutX(280);
        weightLabel.setLayoutY(45);
        weightLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(weightLabel);

        final TextField weightTextField = new TextField();
        weightTextField.setFont(textSize);
        weightTextField.setLayoutX(280);
        weightTextField.setLayoutY(65);
        weightTextField.setPrefSize(80,20);
        dailyCalorieCalculatorRoot.getChildren().add(weightTextField);

        final Label heightLabel = new Label("Height:");
        heightLabel.setLayoutX(410);
        heightLabel.setLayoutY(45);
        heightLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(heightLabel);

        final TextField heightTextField = new TextField();
        heightTextField.setFont(textSize);
        heightTextField.setLayoutX(410);
        heightTextField.setLayoutY(65);
        heightTextField.setPrefSize(80,20);
        dailyCalorieCalculatorRoot.getChildren().add(heightTextField);

        final Label unitLabel = new Label("Units:");
        unitLabel.setLayoutX(540);
        unitLabel.setLayoutY(45);
        unitLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(unitLabel);

        final ChoiceBox<String> unitCBOX = new ChoiceBox<>();
        unitCBOX.getItems().add("kg - cm");
        unitCBOX.getItems().add("lb - in");
        unitCBOX.setTooltip(new Tooltip("Unit for weight and height"));
        unitCBOX.getSelectionModel().selectFirst();
        unitCBOX.setLayoutX(540);
        unitCBOX.setLayoutY(65);
        unitCBOX.setPrefSize(80,30);
        dailyCalorieCalculatorRoot.getChildren().add(unitCBOX);

        final Label trainLabel = new Label("Workout(s)/week:");
        trainLabel.setLayoutX(670);
        trainLabel.setLayoutY(45);
        trainLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(trainLabel);

        final TextField trainTextField = new TextField();
        trainTextField.setFont(textSize);
        trainTextField.setTooltip(new Tooltip("How many days do you train a week? (0 - 7)"));
        trainTextField.setLayoutX(670);
        trainTextField.setLayoutY(65);
        trainTextField.setPrefSize(80,20);
        dailyCalorieCalculatorRoot.getChildren().add(trainTextField);



        final Label toMaintainWeightLabel = new Label("To maintain weight:");
        toMaintainWeightLabel.setLayoutX(20);
        toMaintainWeightLabel.setLayoutY(115);
        toMaintainWeightLabel.setStyle("-fx-font: 20 Sawasdee");
        toMaintainWeightLabel.setTextFill(Color.rgb(255,236,134));
        dailyCalorieCalculatorRoot.getChildren().add(toMaintainWeightLabel);

        final Label calorieToMaintainWeight = new Label("Calorie:");
        calorieToMaintainWeight.setLayoutX(20);
        calorieToMaintainWeight.setLayoutY(155);
        calorieToMaintainWeight.setStyle("-fx-font: 15 Arial");
        calorieToMaintainWeight.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(calorieToMaintainWeight);

        final TextField calorieToMaintainWeightTextField = new TextField();
        calorieToMaintainWeightTextField.setPrefSize(80,20);
        calorieToMaintainWeightTextField.setLayoutX(20);
        calorieToMaintainWeightTextField.setLayoutY(175);
        calorieToMaintainWeightTextField.setFont(textSize);
        calorieToMaintainWeightTextField.setEditable(false);
        dailyCalorieCalculatorRoot.getChildren().add(calorieToMaintainWeightTextField);

        final Label kcalCTMWLabel = new Label("kcal");
        kcalCTMWLabel.setLayoutX(110);
        kcalCTMWLabel.setLayoutY(180);
        kcalCTMWLabel.setStyle("-fx-font: 20 Arial");
        kcalCTMWLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(kcalCTMWLabel);

        final Label proteinToMaintainWeightLabel = new Label("Protein:");
        proteinToMaintainWeightLabel.setLayoutX(210);
        proteinToMaintainWeightLabel.setLayoutY(155);
        proteinToMaintainWeightLabel.setStyle("-fx-font: 15 Arial");
        proteinToMaintainWeightLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(proteinToMaintainWeightLabel);

        final TextField proteinToMaintainWeightTextField = new TextField();
        proteinToMaintainWeightTextField.setPrefSize(80,20);
        proteinToMaintainWeightTextField.setLayoutX(210);
        proteinToMaintainWeightTextField.setLayoutY(175);
        proteinToMaintainWeightTextField.setFont(textSize);
        proteinToMaintainWeightTextField.setEditable(false);
        dailyCalorieCalculatorRoot.getChildren().add(proteinToMaintainWeightTextField);

        final Label gramsPTMWLabel = new Label("grams");
        gramsPTMWLabel.setLayoutX(300);
        gramsPTMWLabel.setLayoutY(180);
        gramsPTMWLabel.setStyle("-fx-font: 20 Arial");
        gramsPTMWLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(gramsPTMWLabel);

        final Label carbohydrateToMaintainWeightLabel = new Label("Carbohydrate:");
        carbohydrateToMaintainWeightLabel.setLayoutX(400);
        carbohydrateToMaintainWeightLabel.setLayoutY(155);
        carbohydrateToMaintainWeightLabel.setStyle("-fx-font: 15 Arial");
        carbohydrateToMaintainWeightLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(carbohydrateToMaintainWeightLabel);

        final TextField carbohydrateToMaintainWeightTextField = new TextField();
        carbohydrateToMaintainWeightTextField.setPrefSize(80,20);
        carbohydrateToMaintainWeightTextField.setLayoutX(400);
        carbohydrateToMaintainWeightTextField.setLayoutY(175);
        carbohydrateToMaintainWeightTextField.setFont(textSize);
        carbohydrateToMaintainWeightTextField.setEditable(false);
        dailyCalorieCalculatorRoot.getChildren().add(carbohydrateToMaintainWeightTextField);

        final Label gramsCTMWLabel = new Label("grams");
        gramsCTMWLabel.setLayoutX(490);
        gramsCTMWLabel.setLayoutY(180);
        gramsCTMWLabel.setStyle("-fx-font: 20 Arial");
        gramsCTMWLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(gramsCTMWLabel);

        final Label fatToMaintainWeightLabel = new Label("Fat:");
        fatToMaintainWeightLabel.setLayoutX(590);
        fatToMaintainWeightLabel.setLayoutY(155);
        fatToMaintainWeightLabel.setStyle("-fx-font: 15 Arial");
        fatToMaintainWeightLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(fatToMaintainWeightLabel);

        final TextField fatToMaintainWeightTextField = new TextField();
        fatToMaintainWeightTextField.setPrefSize(80,20);
        fatToMaintainWeightTextField.setLayoutX(590);
        fatToMaintainWeightTextField.setLayoutY(175);
        fatToMaintainWeightTextField.setFont(textSize);
        fatToMaintainWeightTextField.setEditable(false);
        dailyCalorieCalculatorRoot.getChildren().add(fatToMaintainWeightTextField);

        final Label gramsFTMWLabel = new Label("grams");
        gramsFTMWLabel.setLayoutX(680);
        gramsFTMWLabel.setLayoutY(180);
        gramsFTMWLabel.setStyle("-fx-font: 20 Arial");
        gramsFTMWLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(gramsFTMWLabel);



        final Label toLoseWeightLabel = new Label("To lose weight:");
        toLoseWeightLabel.setLayoutX(20);
        toLoseWeightLabel.setLayoutY(235);
        toLoseWeightLabel.setStyle("-fx-font: 20 Sawasdee");
        toLoseWeightLabel.setTextFill(Color.rgb(255,236,134));
        dailyCalorieCalculatorRoot.getChildren().add(toLoseWeightLabel);

        final Label calorieToLoseWeightLabel = new Label("Calorie:");
        calorieToLoseWeightLabel.setLayoutX(20);
        calorieToLoseWeightLabel.setLayoutY(275);
        calorieToLoseWeightLabel.setStyle("-fx-font: 15 Arial");
        calorieToLoseWeightLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(calorieToLoseWeightLabel);

        final TextField calorieToLoseWeightTextField = new TextField();
        calorieToLoseWeightTextField.setPrefSize(80,20);
        calorieToLoseWeightTextField.setLayoutX(20);
        calorieToLoseWeightTextField.setLayoutY(295);
        calorieToLoseWeightTextField.setFont(textSize);
        calorieToLoseWeightTextField.setEditable(false);
        dailyCalorieCalculatorRoot.getChildren().add(calorieToLoseWeightTextField);

        final Label kcalCTLWLabel = new Label("kcal");
        kcalCTLWLabel.setLayoutX(110);
        kcalCTLWLabel.setLayoutY(300);
        kcalCTLWLabel.setStyle("-fx-font: 20 Arial");
        kcalCTLWLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(kcalCTLWLabel);

        final Label proteinToLoseWeightLabel = new Label("Protein:");
        proteinToLoseWeightLabel.setLayoutX(210);
        proteinToLoseWeightLabel.setLayoutY(275);
        proteinToLoseWeightLabel.setStyle("-fx-font: 15 Arial");
        proteinToLoseWeightLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(proteinToLoseWeightLabel);

        final TextField proteinToLoseWeightTextField = new TextField();
        proteinToLoseWeightTextField.setPrefSize(80,20);
        proteinToLoseWeightTextField.setLayoutX(210);
        proteinToLoseWeightTextField.setLayoutY(295);
        proteinToLoseWeightTextField.setFont(textSize);
        proteinToLoseWeightTextField.setEditable(false);
        dailyCalorieCalculatorRoot.getChildren().add(proteinToLoseWeightTextField);

        final Label gramsPTLWLabel = new Label("grams");
        gramsPTLWLabel.setLayoutX(300);
        gramsPTLWLabel.setLayoutY(300);
        gramsPTLWLabel.setStyle("-fx-font: 20 Arial");
        gramsPTLWLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(gramsPTLWLabel);

        final Label carbohydrateToLoseWeightLabel = new Label("Carbohydrate:");
        carbohydrateToLoseWeightLabel.setLayoutX(400);
        carbohydrateToLoseWeightLabel.setLayoutY(275);
        carbohydrateToLoseWeightLabel.setStyle("-fx-font: 15 Arial");
        carbohydrateToLoseWeightLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(carbohydrateToLoseWeightLabel);

        final TextField carbohydrateToLoseWeightTextField = new TextField();
        carbohydrateToLoseWeightTextField.setPrefSize(80,20);
        carbohydrateToLoseWeightTextField.setLayoutX(400);
        carbohydrateToLoseWeightTextField.setLayoutY(295);
        carbohydrateToLoseWeightTextField.setFont(textSize);
        carbohydrateToLoseWeightTextField.setEditable(false);
        dailyCalorieCalculatorRoot.getChildren().add(carbohydrateToLoseWeightTextField);

        final Label gramsCTLWLabel = new Label("grams");
        gramsCTLWLabel.setLayoutX(490);
        gramsCTLWLabel.setLayoutY(300);
        gramsCTLWLabel.setStyle("-fx-font: 20 Arial");
        gramsCTLWLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(gramsCTLWLabel);

        final Label fatToLoseWeightLabel = new Label("Fat:");
        fatToLoseWeightLabel.setLayoutX(590);
        fatToLoseWeightLabel.setLayoutY(275);
        fatToLoseWeightLabel.setStyle("-fx-font: 15 Arial");
        fatToLoseWeightLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(fatToLoseWeightLabel);

        final TextField fatToLoseWeightTextField = new TextField();
        fatToLoseWeightTextField.setPrefSize(80,20);
        fatToLoseWeightTextField.setLayoutX(590);
        fatToLoseWeightTextField.setLayoutY(295);
        fatToLoseWeightTextField.setFont(textSize);
        fatToLoseWeightTextField.setEditable(false);
        dailyCalorieCalculatorRoot.getChildren().add(fatToLoseWeightTextField);

        final Label gramsFTLWLabel = new Label("grams");
        gramsFTLWLabel.setLayoutX(680);
        gramsFTLWLabel.setLayoutY(300);
        gramsFTLWLabel.setStyle("-fx-font: 20 Arial");
        gramsFTLWLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(gramsFTLWLabel);



        final Label toGainWeightLabel = new Label("To gain weight: ");
        toGainWeightLabel.setLayoutX(20);
        toGainWeightLabel.setLayoutY(355);
        toGainWeightLabel.setStyle("-fx-font: 20 Sawasdee");
        toGainWeightLabel.setTextFill(Color.rgb(255,236,134));
        dailyCalorieCalculatorRoot.getChildren().add(toGainWeightLabel);

        final Label calorieToGainWeightLabel = new Label("Calorie:");
        calorieToGainWeightLabel.setLayoutX(20);
        calorieToGainWeightLabel.setLayoutY(395);
        calorieToGainWeightLabel.setStyle("-fx-font: 15 Arial");
        calorieToGainWeightLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(calorieToGainWeightLabel);

        final TextField calorieToGainWeightTextField = new TextField();
        calorieToGainWeightTextField.setPrefSize(80,20);
        calorieToGainWeightTextField.setLayoutX(20);
        calorieToGainWeightTextField.setLayoutY(415);
        calorieToGainWeightTextField.setFont(textSize);
        calorieToGainWeightTextField.setEditable(false);
        dailyCalorieCalculatorRoot.getChildren().add(calorieToGainWeightTextField);

        final Label kcalCTGWLabel = new Label("kcal");
        kcalCTGWLabel.setLayoutX(110);
        kcalCTGWLabel.setLayoutY(420);
        kcalCTGWLabel.setStyle("-fx-font: 20 Arial");
        kcalCTGWLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(kcalCTGWLabel);

        final Label proteinToGainWeightLabel = new Label("Protein:");
        proteinToGainWeightLabel.setLayoutX(210);
        proteinToGainWeightLabel.setLayoutY(395);
        proteinToGainWeightLabel.setStyle("-fx-font: 15 Arial");
        proteinToGainWeightLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(proteinToGainWeightLabel);

        final TextField proteinToGainWeightTextField = new TextField();
        proteinToGainWeightTextField.setPrefSize(80,20);
        proteinToGainWeightTextField.setLayoutX(210);
        proteinToGainWeightTextField.setLayoutY(415);
        proteinToGainWeightTextField.setFont(textSize);
        proteinToGainWeightTextField.setEditable(false);
        dailyCalorieCalculatorRoot.getChildren().add(proteinToGainWeightTextField);

        final Label gramsPTGWLabel = new Label("grams");
        gramsPTGWLabel.setLayoutX(300);
        gramsPTGWLabel.setLayoutY(420);
        gramsPTGWLabel.setStyle("-fx-font: 20 Arial");
        gramsPTGWLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(gramsPTGWLabel);

        final Label carbohydrateToGainWeightLabel = new Label("Carbohydrate:");
        carbohydrateToGainWeightLabel.setLayoutX(400);
        carbohydrateToGainWeightLabel.setLayoutY(395);
        carbohydrateToGainWeightLabel.setStyle("-fx-font: 15 Arial");
        carbohydrateToGainWeightLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(carbohydrateToGainWeightLabel);

        final TextField carbohydrateToGainWeightTextField = new TextField();
        carbohydrateToGainWeightTextField.setPrefSize(80,20);
        carbohydrateToGainWeightTextField.setLayoutX(400);
        carbohydrateToGainWeightTextField.setLayoutY(415);
        carbohydrateToGainWeightTextField.setFont(textSize);
        carbohydrateToGainWeightTextField.setEditable(false);
        dailyCalorieCalculatorRoot.getChildren().add(carbohydrateToGainWeightTextField);

        final Label gramsCTGWLabel = new Label("grams");
        gramsCTGWLabel.setLayoutX(490);
        gramsCTGWLabel.setLayoutY(420);
        gramsCTGWLabel.setStyle("-fx-font: 20 Arial");
        gramsCTGWLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(gramsCTGWLabel);

        final Label fatToGainWeightLabel = new Label("Fat:");
        fatToGainWeightLabel.setLayoutX(590);
        fatToGainWeightLabel.setLayoutY(395);
        fatToGainWeightLabel.setStyle("-fx-font: 15 Arial");
        fatToGainWeightLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(fatToGainWeightLabel);

        final TextField fatToGainWeightTextField = new TextField();
        fatToGainWeightTextField.setPrefSize(80,20);
        fatToGainWeightTextField.setLayoutX(590);
        fatToGainWeightTextField.setLayoutY(415);
        fatToGainWeightTextField.setFont(textSize);
        fatToGainWeightTextField.setEditable(false);
        dailyCalorieCalculatorRoot.getChildren().add(fatToGainWeightTextField);

        final Label gramsFTGWLabel = new Label("grams");
        gramsFTGWLabel.setLayoutX(680);
        gramsFTGWLabel.setLayoutY(420);
        gramsFTGWLabel.setStyle("-fx-font: 20 Arial");
        gramsFTGWLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(gramsFTGWLabel);



        final Label bmrLabel = new Label("BMR:");
        bmrLabel.setLayoutX(20);
        bmrLabel.setLayoutY(470);
        bmrLabel.setStyle("-fx-font: 20 Sawasdee");
        bmrLabel.setTextFill(Color.rgb(255,236,134));
        dailyCalorieCalculatorRoot.getChildren().add(bmrLabel);

        final TextField bmrTextField = new TextField();
        bmrTextField.setLayoutX(20);
        bmrTextField.setLayoutY(500);
        bmrTextField.setPrefSize(80,20);
        bmrTextField.setFont(textSize);
        bmrTextField.setEditable(false);
        dailyCalorieCalculatorRoot.getChildren().add(bmrTextField);

        final Label bmrKcalLabel = new Label("kcal");
        bmrKcalLabel.setLayoutX(110);
        bmrKcalLabel.setLayoutY(505);
        bmrKcalLabel.setStyle("-fx-font: 20 Arial");
        bmrKcalLabel.setTextFill(Color.BLANCHEDALMOND);
        dailyCalorieCalculatorRoot.getChildren().add(bmrKcalLabel);




        //FirstScreen events:
        nutritionCalculatorButton.setOnMousePressed((MouseEvent event) -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                primaryStage.setScene(nutritionCalculatorScreen);

            }
        });

        dailyCaloreCalculatorButton.setOnMousePressed((MouseEvent event) -> {
            if(event.getButton() == MouseButton.PRIMARY){
                primaryStage.setScene(dailyCalorieCalculatorScreen);
            }
        });

        exitButton.setOnMousePressed((MouseEvent event) -> {
            if(event.getButton() == MouseButton.PRIMARY){
                primaryStage.close();
            }
        });





        //NutritionCalculatorScreen events:
        backButton.setOnMousePressed((MouseEvent event) ->{
            if(event.getButton() == MouseButton.PRIMARY) {
                primaryStage.setScene(firstScreen);
            }
        });

        addButton.setOnMousePressed((MouseEvent event) -> {
            if(event.getButton() == MouseButton.PRIMARY){
                if(foodsCBox.getSelectionModel().isEmpty() || amountConsumedTextField.getText().isEmpty())
                {
                    errorMessage.setTitle("Error: Not enough data!");
                    errorMessage.setContentText("Data is missing...");
                    errorMessage.show();
                }
                else{
                    try {
                        if ((Double.parseDouble(amountConsumedTextField.getText()) > 0)) {

                            controllerForNutritionCalculators.addToProteinCounter(
                                    controllerForFoodsXML.getProteinByIndex(foodsCBox.getSelectionModel().getSelectedIndex()),
                                    amountConsumedTextField.getText()
                            );

                            controllerForNutritionCalculators.addToCarbohydrateCounter(
                                    controllerForFoodsXML.getCarbohydrateByIndex(foodsCBox.getSelectionModel().getSelectedIndex()),
                                    amountConsumedTextField.getText()
                            );

                            controllerForNutritionCalculators.addToFatCounter(
                                    controllerForFoodsXML.getFatByIndex(foodsCBox.getSelectionModel().getSelectedIndex()),
                                    amountConsumedTextField.getText()
                            );

                            controllerForNutritionCalculators.addToCalorieCounter(
                                    controllerForFoodsXML.getCalorieByIndex(foodsCBox.getSelectionModel().getSelectedIndex()),
                                    amountConsumedTextField.getText()
                            );


                            nutritionalCounterListView.getItems().remove(0, nutritionalCounterListView.getItems().size());

                            nutritionalCounterListView.getItems().add(controllerForNutritionCalculators.getProteinCounterAsString());
                            nutritionalCounterListView.getItems().add(controllerForNutritionCalculators.getCarbohydrateCounterAsString());
                            nutritionalCounterListView.getItems().add(controllerForNutritionCalculators.getFatCounterAsString());
                            nutritionalCounterListView.getItems().add(controllerForNutritionCalculators.getCalorieCounterAsString());

                            consumedListView.getItems().add(foodsCBox.getSelectionModel().getSelectedItem()
                                    + " " + amountConsumedTextField.getText() + " grams");

                        }
                        else {
                            errorMessage.setTitle("Error: Wrong data!");
                            errorMessage.setContentText("You have entered wrong data. Please correct it.");
                            errorMessage.show();
                        }
                    }

                    catch(NumberFormatException e)
                    {
                        errorMessage.setTitle("Error: Wrong data!");
                        errorMessage.setContentText("You have entered wrong data. Please correct it.");
                        errorMessage.show();
                    }
                }
            }

        });

        deleteButton.setOnMousePressed((MouseEvent event) ->{
            if(event.getButton() == MouseButton.PRIMARY){

                controllerForNutritionCalculators.initTheCounters();
                consumedListView.getItems().remove(0,consumedListView.getItems().size());
                nutritionalCounterListView.getItems().remove(0, nutritionalCounterListView.getItems().size());
                nutritionalCounterListView.getItems().add(controllerForNutritionCalculators.getProteinCounterAsString());
                nutritionalCounterListView.getItems().add(controllerForNutritionCalculators.getCarbohydrateCounterAsString());
                nutritionalCounterListView.getItems().add(controllerForNutritionCalculators.getFatCounterAsString());
                nutritionalCounterListView.getItems().add(controllerForNutritionCalculators.getCalorieCounterAsString());

            }
        });

        foodsCBox.setOnAction((ActionEvent event) ->{
            if(!foodsCBox.getSelectionModel().getSelectedItem().isEmpty())
            {
                int index = foodsCBox.getSelectionModel().getSelectedIndex();

                nutritionalValueListView.getItems().remove(0,nutritionalValueListView.getItems().size());

                nutritionalValueListView.getItems().add(controllerForFoodsXML.getFoodByIndexAsString(index));
                nutritionalValueListView.getItems().add(controllerForFoodsXML.getProteinByIndexAsString(index));
                nutritionalValueListView.getItems().add(controllerForFoodsXML.getCarbohydrateByIndexAsString(index));
                nutritionalValueListView.getItems().add(controllerForFoodsXML.getFatByIndexAsString(index));
                nutritionalValueListView.getItems().add(controllerForFoodsXML.getCalorieByIndexAsString(index));
            }
        });


        saveButton.setOnMousePressed((MouseEvent event) ->{
            if(event.getButton() == MouseButton.PRIMARY) {
                if (controllerForNutritionCalculators.getCalorieCounter() != 0) {

                    try {
                        controllerForConsumptionsXML.saveConsumptions(controllerForNutritionCalculators.getProteinCounter(),
                                controllerForNutritionCalculators.getCarbohydrateCounter(),
                                controllerForNutritionCalculators.getFatCounter(),
                                controllerForNutritionCalculators.getCalorieCounter());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (!consumptionHistoryCBox.getItems().isEmpty()) {
                        consumptionHistoryCBox.getItems().remove(0, consumptionHistoryCBox.getItems().size());
                    }
                    try {
                        for (String dates : controllerForConsumptionsXML.loadDates()) {
                            consumptionHistoryCBox.getItems().add(dates);
                        }
                    } catch (Exception e) {
                        System.err.println("Exception");
                    }
                }

                else{
                    errorMessage.setTitle("Error: No data for save!");
                    errorMessage.setContentText("Data is missing...");
                    errorMessage.show();
                }
            }
        });


        consumptionHistoryCBox.setOnAction((ActionEvent event) ->{
            if(!consumptionHistoryCBox.getSelectionModel().isEmpty()){
                int index = consumptionHistoryCBox.getSelectionModel().getSelectedIndex();

                consumptionHistoryListWiew.getItems().remove(0,consumptionHistoryListWiew.getItems().size());

                consumptionHistoryListWiew.getItems().add(controllerForConsumptionsXML.getProteinByDateAsString(index));
                consumptionHistoryListWiew.getItems().add(controllerForConsumptionsXML.getCarbohydrateByDateAsString(index));
                consumptionHistoryListWiew.getItems().add(controllerForConsumptionsXML.getFatByDateAsString(index));
                consumptionHistoryListWiew.getItems().add(controllerForConsumptionsXML.getCalorieByDateAsString(index));

                seriesProtein.getData().clear();
                seriesCarbohydrate.getData().clear();
                seriesFat.getData().clear();
                seriesCalorie.getData().clear();

                seriesProtein.getData().add(new XYChart.Data<>("",
                        controllerForConsumptionsXML.getProteinByDate(consumptionHistoryCBox.getSelectionModel().getSelectedIndex())));

                seriesCarbohydrate.getData().add(new XYChart.Data<>("",
                        controllerForConsumptionsXML.getCarbohydrateByDate(consumptionHistoryCBox.getSelectionModel().getSelectedIndex())));

                seriesFat.getData().add(new XYChart.Data<>("",
                        controllerForConsumptionsXML.getFatByDate(consumptionHistoryCBox.getSelectionModel().getSelectedIndex())));
            }
        });



        /*
        Daily Calculator screen events:
         */

        dailyBackButton.setOnMousePressed((MouseEvent event) -> {
            if (event.getButton() == MouseButton.PRIMARY){
                primaryStage.setScene(firstScreen);
            }

        });


        dailyCalculateButton.setOnMousePressed((MouseEvent event) -> {
            if(event.getButton() == MouseButton.PRIMARY){
                if(ageTextField.getText().isEmpty() || genderCBox.getSelectionModel().isEmpty() ||
                        heightTextField.getText().isEmpty() || weightTextField.getText().isEmpty() ||
                        trainTextField.getText().isEmpty())
                {

                    errorMessage.setTitle("Error: Not enough data!");
                    errorMessage.setContentText("Data is missing...");
                    errorMessage.show();
                }

                else if(unitCBOX.getSelectionModel().getSelectedItem().equals("kg - cm"))
                {
                    try{

                        controllerForDailyCalorieCalculators.metricBMRFormula(Integer.parseInt(ageTextField.getText()),
                                genderCBox.getSelectionModel().getSelectedItem(),
                                Integer.parseInt(weightTextField.getText()),
                                Integer.parseInt(heightTextField.getText()),
                                Integer.parseInt(trainTextField.getText()));

                        calorieToMaintainWeightTextField.setText(controllerForDailyCalorieCalculators.getCalorieToMaintainWeightAsString());
                        proteinToMaintainWeightTextField.setText(controllerForDailyCalorieCalculators.getProteinToMaintainWeightAsString());
                        carbohydrateToMaintainWeightTextField.setText(controllerForDailyCalorieCalculators.getCarbohydrateToMaintainWeightAsString());
                        fatToMaintainWeightTextField.setText(controllerForDailyCalorieCalculators.getFatToMaintainWeightAsString());

                        calorieToLoseWeightTextField.setText(controllerForDailyCalorieCalculators.getCalorieToLoseWeightAsString());
                        proteinToLoseWeightTextField.setText(controllerForDailyCalorieCalculators.getProteinToLoseWeightAsString());
                        carbohydrateToLoseWeightTextField.setText(controllerForDailyCalorieCalculators.getCarbohydrateToLoseWeightAsString());
                        fatToLoseWeightTextField.setText(controllerForDailyCalorieCalculators.getFatToLoseWeightAsString());

                        calorieToGainWeightTextField.setText(controllerForDailyCalorieCalculators.getCalorieToGainWeightAsString());
                        proteinToGainWeightTextField.setText(controllerForDailyCalorieCalculators.getProteinToGainWeightAsString());
                        carbohydrateToGainWeightTextField.setText(controllerForDailyCalorieCalculators.getCarbohydrateToGainWeighAsString());
                        fatToGainWeightTextField.setText(controllerForDailyCalorieCalculators.getFatToGainWeightAsString());

                        bmrTextField.setText(controllerForDailyCalorieCalculators.getBMRAsString());

                    }
                    catch(NumberFormatException e)
                    {
                        errorMessage.setTitle("Error: Wrong data!");
                        errorMessage.setContentText("You have entered wrong data.Please correct it.");
                        errorMessage.show();
                    }
                }

                else
                {
                    try{

                        controllerForDailyCalorieCalculators.englishBMRFormula(Integer.parseInt(ageTextField.getText()),
                                genderCBox.getSelectionModel().getSelectedItem(),
                                Integer.parseInt(weightTextField.getText()),
                                Integer.parseInt(heightTextField.getText()),
                                Integer.parseInt(trainTextField.getText()));

                        calorieToMaintainWeightTextField.setText(controllerForDailyCalorieCalculators.getCalorieToMaintainWeightAsString());
                        proteinToMaintainWeightTextField.setText(controllerForDailyCalorieCalculators.getProteinToMaintainWeightAsString());
                        carbohydrateToMaintainWeightTextField.setText(controllerForDailyCalorieCalculators.getCarbohydrateToMaintainWeightAsString());
                        fatToMaintainWeightTextField.setText(controllerForDailyCalorieCalculators.getFatToMaintainWeightAsString());

                        calorieToLoseWeightTextField.setText(controllerForDailyCalorieCalculators.getCalorieToLoseWeightAsString());
                        proteinToLoseWeightTextField.setText(controllerForDailyCalorieCalculators.getProteinToLoseWeightAsString());
                        carbohydrateToLoseWeightTextField.setText(controllerForDailyCalorieCalculators.getCarbohydrateToLoseWeightAsString());
                        fatToLoseWeightTextField.setText(controllerForDailyCalorieCalculators.getFatToLoseWeightAsString());

                        calorieToGainWeightTextField.setText(controllerForDailyCalorieCalculators.getCalorieToGainWeightAsString());
                        proteinToGainWeightTextField.setText(controllerForDailyCalorieCalculators.getProteinToGainWeightAsString());
                        carbohydrateToGainWeightTextField.setText(controllerForDailyCalorieCalculators.getCarbohydrateToGainWeighAsString());
                        fatToGainWeightTextField.setText(controllerForDailyCalorieCalculators.getFatToGainWeightAsString());

                        bmrTextField.setText(controllerForDailyCalorieCalculators.getBMRAsString());

                    }
                    catch(NumberFormatException e)
                    {
                        errorMessage.setTitle("Error: Wrong data!");
                        errorMessage.setContentText("You have entered wrong data.Please correct it.");
                        errorMessage.show();
                    }
                }

            }
        } );

        dailyCleanButton.setOnMousePressed((MouseEvent event) -> {
            if(event.getButton() == MouseButton.PRIMARY)
            {
                ageTextField.setText("");
                genderCBox.getSelectionModel().clearSelection();
                weightTextField.setText("");
                heightTextField.setText("");
                unitCBOX.getSelectionModel().selectFirst();
                trainTextField.setText("");

                calorieToMaintainWeightTextField.setText("");
                proteinToMaintainWeightTextField.setText("");
                carbohydrateToMaintainWeightTextField.setText("");
                fatToMaintainWeightTextField.setText("");

                calorieToLoseWeightTextField.setText("");
                proteinToLoseWeightTextField.setText("");
                carbohydrateToLoseWeightTextField.setText("");
                fatToLoseWeightTextField.setText("");

                calorieToGainWeightTextField.setText("");
                proteinToGainWeightTextField.setText("");
                carbohydrateToGainWeightTextField.setText("");
                fatToGainWeightTextField.setText("");

                bmrTextField.setText("");
            }
        });


        primaryStage.setScene(firstScreen);
        primaryStage.setResizable(false);
        primaryStage.show();

    }


    /**
     * Main függvény a Java Applikáció fordításához és futtatásához.
     * @param args A parancssori argumentum.
     */
    public static void main(String[] args) {
        launch(args);
    }
}


