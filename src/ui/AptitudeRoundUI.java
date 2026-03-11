package ui;

import java.util.*;

import dao.QuestionDAO;
import model.Question;
import model.ScoreManager;

public class AptitudeRoundUI {

    public void startRound(){

        Scanner sc = new Scanner(System.in);

        QuestionDAO dao = new QuestionDAO();

        List<Question> questions = dao.getQuestionsByRound("APTITUDE");

        int score = 0;

        for(int i=0;i<5 && i<questions.size();i++){

            Question q = questions.get(i);

            System.out.println("\n" + q.getQuestion());
            System.out.println("A. " + q.getOptionA());
            System.out.println("B. " + q.getOptionB());
            System.out.println("C. " + q.getOptionC());
            System.out.println("D. " + q.getOptionD());

            System.out.println("You have 10 seconds...");

            long start = System.currentTimeMillis();

            System.out.print("Answer: ");
            String ans = sc.nextLine();

            long end = System.currentTimeMillis();

            if((end-start) > 10000){
                System.out.println("Time up!");
            }
            else{
                if(ans.equalsIgnoreCase(q.getCorrectAnswer())){
                    score++;
                }
            }
        }

        System.out.println("\nAptitude Score: "+score+"/5");

        ScoreManager.aptitudeScore = score;
    }
}