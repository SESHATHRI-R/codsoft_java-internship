package task4;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class quiz_app {

    private static int score = 0;
    private static final int TIME_LIMIT = 30; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("\nTime's up! Your final score is: " + score);
                System.exit(0);
            }
        };

        timer.schedule(task, TIME_LIMIT * 1000);
        System.out.println("Welcome to the quiz! You have " + TIME_LIMIT + " seconds to answer the questions.");
        System.out.println("Let's start!");

        askQuestion("What is the capital of India?", "New Delhi", scanner);
        askQuestion("Who is the father of quantum physics?", "Max Planck", scanner);
        askQuestion("Who designed the java programming?", "James Gosling", scanner);

        System.out.println("You have completed the quiz! Your final score is: " + score);
        scanner.close();
        timer.cancel();
    }

    private static void askQuestion(String question, String correctAnswer, Scanner scanner) {
        System.out.println(question);
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase(correctAnswer)) {
            score++;
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect. The correct answer is: " + correctAnswer);
        }
    }
}

  

