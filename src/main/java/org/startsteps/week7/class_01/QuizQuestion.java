package org.startsteps.week7.class_01;

class QuizQuestion {
    private String questionText;
    private String correctAnswer;
    private int score;

    public QuizQuestion(String questionText, String correctAnswer, int score) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.score = score;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getScore() {
        return score;
    }
}
