package org.startsteps.week7;

import java.lang.annotation.Documented;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // Create an instance of the QuizGameEngine
        QuizGameEngine gameEngine = new QuizGameEngine();

  /*      // Use reflection to find and initialize the quiz game
        Class<?> quizGameClass = GeographyQuizGame.class;
        Annotation quizGameAnnotation = quizGameClass.getAnnotation(QuizGame.class);

        if (quizGameAnnotation != null) {
            QuizGame quizGameInfo = (QuizGame) quizGameAnnotation;

            // Get attributes from the @QuizGame annotation
            String gameName = quizGameInfo.gameName();
            int numberOfQuestions = quizGameInfo.numberOfQuestions();
            int timeLimit = quizGameInfo.timeLimit();

            System.out.println("Welcome to the " + gameName);
            System.out.println("You have " + timeLimit + " seconds to answer " + numberOfQuestions + " questions.\n");

            // Use reflection to find and initialize quiz questions
            List<QuizQuestion> questions = new ArrayList<>();
            Field[] fields = quizGameClass.getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(QuizQuestion.class)) {
                    QuizQuestion questionAnnotation = field.getAnnotation(QuizQuestion.class);
                    questions.add(new Question(field.getName(), questionAnnotation));
                }
            }

            // Start the quiz
            int totalScore = gameEngine.startGame(questions, numberOfQuestions, timeLimit);

            System.out.println("\nGame Over! Your total score is: " + totalScore);
        } else {
            System.out.println("No @QuizGame annotation found. Game cannot be started.");
        }*/


        Member member = new Member();
        member.setEmail("");

        // @ , 2344,

        System.out.println(member.getEmail());


        Field[] fields = member.getClass().getDeclaredFields();
        for (Field field: fields) {
            if (field.isAnnotationPresent(Email.class)) {
                Pattern pattern = Pattern.compile("^(.+)@(.+)$");
                Matcher matcher = pattern.matcher(member.getEmail());
                if(matcher.find()) {
                    System.out.println("email is valid");
                } else {
                    System.out.println("email is invalid");
                }
            }
        }





    }

    @SafeVarargs
    public final <T> void printAll(T... elements) {
        for (T element: elements) {
            System.out.println(element);
        }
    }

    // documentation
    @Deprecated
    void oldMethod() {

    }

    @SuppressWarnings("unused")
    int unusedVariable;

//    public void processUserData(@NonNull Member member) {}

    // hibernation validation




}

@FunctionalInterface
interface MyFunctionalInterface {
    void someMethod();
}

