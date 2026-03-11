package ui;

import java.util.*;

import dao.QuestionDAO;
import model.Question;
import model.ScoreManager;

public class HRRoundUI {

    public void startRound(){

        Scanner sc = new Scanner(System.in);

        QuestionDAO dao = new QuestionDAO();

        List<Question> questions = dao.getQuestionsByRound("HR");

        for(int i=0;i<5 && i<questions.size();i++){

            Question q = questions.get(i);

            System.out.println("\nHR Question:");
            System.out.println(q.getQuestion());

            System.out.print("Your Answer: ");
            sc.nextLine();
        }

        ScoreManager.hrScore = 5;

        System.out.println("\nHR Round Completed.");
    }
}