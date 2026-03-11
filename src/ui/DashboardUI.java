package ui;

import java.util.Scanner;

import dao.ResultDAO;
import model.ScoreManager;

public class DashboardUI {

    public void showMenu() {

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n===== DASHBOARD =====");
            System.out.println("1. Aptitude Round");
            System.out.println("2. Technical Round");
            System.out.println("3. HR Interview");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1){

                new AptitudeRoundUI().startRound();

            }
            else if(choice == 2){

                new TechnicalRoundUI().startRound();

            }
            else if(choice == 3){

                new HRRoundUI().startRound();

            }
            else if(choice == 4){

                int aptitude = ScoreManager.aptitudeScore;
                int technical = ScoreManager.technicalScore;
                int hr = ScoreManager.hrScore;

                int finalScore = aptitude + technical + hr;

                System.out.println("\n===== INTERVIEW RESULT =====");

                System.out.println("Aptitude Score: " + aptitude + "/5");
                System.out.println("Technical Score: " + technical + "/5");
                System.out.println("HR Score: " + hr + "/5");

                System.out.println("Final Score: " + finalScore + "/15");

                if(finalScore >= 12){
                    System.out.println("Excellent performance!");
                }
                else if(finalScore >= 8){
                    System.out.println("Good performance.");
                }
                else if(finalScore >= 5){
                    System.out.println("Average performance.");
                }
                else{
                    System.out.println("Needs improvement.");
                }

                if(aptitude == 0 && technical == 0 && hr == 0)
                    {
                        System.out.println("Interview not completed. No result saved.");
                    }
                else{
                        ResultDAO.saveResult(1, aptitude, technical, hr);
                    }

                System.out.println("\nInterview completed. Results saved!");

                ResultDAO.showTopResults();

                break;
            }
        }
    }
}