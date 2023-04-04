import java.util.Scanner;

public class OnlineExam {
    private static final String CORRECT_ANSWER = "A"; 
    
    private static Scanner scanner = new Scanner(System.in);
    private static String username;
    private static String password;

    public static void main(String[] args) {
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Enter username: ");
            username = scanner.nextLine();
            System.out.print("Enter password: ");
            password = scanner.nextLine();
            if (login(username, password)) {
                System.out.println("Login successful!");
                loggedIn = true;
            } else {
                System.out.println("Incorrect username or password. Please try again.");
            }
        }

        updateProfile();

        System.out.println("Welcome to the online exam!");
        System.out.println("You will have 10 minutes to answer 10 multiple choice questions.");
        System.out.println("Press enter to start the exam.");
        scanner.nextLine(); 

        long startTime = System.currentTimeMillis();
        int score = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.printf("Question %d:\n", i);
            String answer = selectAnswer();
            if (answer.equals(CORRECT_ANSWER)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect.");
            }
        }
        long endTime = System.currentTimeMillis();

        int durationSeconds = (int) ((endTime - startTime) / 1000);
        System.out.printf("You scored %d out of 10.\n", score);
        System.out.printf("You completed the exam in %d minutes and %d seconds.\n", durationSeconds / 60, durationSeconds % 60);

        logout();
    }

    private static boolean login(String username, String password) {
        
        return username.equals("admin") && password.equals("password");
    }

    private static void updateProfile() {
        System.out.print("Do you want to update your profile (y/n)? ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("y")) {
            System.out.print("Enter new username : ");
            String newUsername = scanner.nextLine();
            if (!newUsername.isEmpty()) {
                username = newUsername;
            }
            System.out.print("Enter new password : ");
            String newPassword = scanner.nextLine();
            if (!newPassword.isEmpty()) {
                password = newPassword;
            }
        }
    }

    private static String selectAnswer() {
        System.out.println("A) Option A");
        System.out.println("B) Option B");
        System.out.println("C) Option C");
        System.out.println("D) Option D");
        System.out.print("Enter your answer (A/B/C/D): ");
        return scanner.nextLine().toUpperCase();
    }

    private static void logout() {
        System.out.println("Closing session and logging out...");
        scanner.close();
    }
}
