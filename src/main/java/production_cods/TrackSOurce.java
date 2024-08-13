//package production_cods;
//
//import com.example.najehfxsoftware.TrackerControll;
//import javafx.animation.Animation;
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.application.Application;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//
//import java.io.*;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.time.temporal.ChronoUnit;
//
//
//
//import javafx.application.Application;
//
//import java.io.*;
//
//public class TrackSOurce extends Application {
//
//    private static final int DEFAULT_DAYS = 6;
//    private static final int SHORT_DAYS = 3;
//    private static final String END_TIME_FILE = "end_time.txt";
//    private static String durationChoice = "6";
//
//    private LocalDateTime endTime;
//    private Label timerLabel; // Reference to the timer label
//
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Initialize the timer label
//        timerLabel = new Label();
//        timerLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #000000;");
//
//        // Set up the VBox layout and add the label
//        VBox vbox = new VBox(timerLabel);
//        vbox.setAlignment(Pos.CENTER); // Center the label in the VBox
//        vbox.setSpacing(10);
//
//        // Load or set end time based on the input choice
//        endTime = loadOrSetEndTime(durationChoice);
//
//        // Timeline to update the label every second
//        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
//            LocalDateTime now = LocalDateTime.now();
//            long secondsRemaining = ChronoUnit.SECONDS.between(now, endTime);
//
//            if (secondsRemaining > 0) {
//                long days = secondsRemaining / (24 * 3600);
//                long hours = (secondsRemaining % (24 * 3600)) / 3600;
//                long minutes = (secondsRemaining % 3600) / 60;
//                long seconds = secondsRemaining % 60;
//                timerLabel.setText(String.format("Time remaining: %d days, %02d:%02d:%02d", days, hours, minutes, seconds));
//            } else {
//                timerLabel.setText("Time's up!");
//                ((Timeline) event.getSource()).stop();
//            }
//        }));
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play();
//
//        // Set up the scene with the VBox layout
//        Scene scene = new Scene(vbox, 400, 200);
//
//        // Set up the stage
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Countdown Timer");
//        primaryStage.show();
//    }
//
//    private LocalDateTime loadOrSetEndTime(String durationChoice) {
//        File file = new File(END_TIME_FILE);
//        int days = durationChoice.matches("[1-5]") ? SHORT_DAYS : DEFAULT_DAYS;
//
//        if (file.exists()) {
//            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//                String line = reader.readLine();
//                if (line != null && line.contains(",")) {
//                    String[] data = line.split(",");
//                    if (data.length == 2) {
//                        String endTimeString = data[0];
//                        int storedDays = Integer.parseInt(data[1]);
//
//                        if (storedDays != days) {
//                            LocalDateTime newEndTime = LocalDateTime.now().plusDays(days);
//                            saveEndTime(newEndTime, days);
//                            return newEndTime;
//                        }
//
//                        return LocalDateTime.parse(endTimeString);
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        LocalDateTime newEndTime = LocalDateTime.now().plusDays(days);
//        saveEndTime(newEndTime, days);
//        return newEndTime;
//    }
//
//    private void saveEndTime(LocalDateTime endTime, int days) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(END_TIME_FILE))) {
//            writer.write(endTime.toString() + "," + days);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void setDurationChoice(String durationChoice) {
//        TrackSOurce.durationChoice = durationChoice;
//    }
//}
