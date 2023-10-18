package org.startsteps.week7.class_01;

import java.util.List;

class QuizGameEngine {
    public int startGame(List<QuizQuestion> questions, int numberOfQuestions, int timeLimit) {
        int totalScore = 0;
        int remainingTime = timeLimit;
        int questionsAsked = 0;

        for (QuizQuestion question : questions) {
            if (questionsAsked >= numberOfQuestions || remainingTime <= 0) {
                break;
            }

            System.out.println("Question " + (questionsAsked + 1) + ": " + question.getQuestionText());
            System.out.print("Your answer: ");

            // Simulate getting player's answer (replace with real input logic)
            String playerAnswer = "Paris"; // Replace with user input

            if (playerAnswer.equalsIgnoreCase(question.getCorrectAnswer())) {
                totalScore += question.getScore();
                System.out.println("Correct! You earned " + question.getScore() + " points.");
            } else {
                System.out.println("Incorrect. The correct answer is: " + question.getCorrectAnswer());
            }

            questionsAsked++;
            remainingTime -= 10; // Simulate time for each question (replace with real timer logic)
        }

        return totalScore;
    }
}
