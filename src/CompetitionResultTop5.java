//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

    public class CompetitionResultTop5 {

        public ArrayList<Double> getTimes(MemberCompetitive memberID, SwimDisciplin disciplin) {
            ArrayList<Double> times = new ArrayList<Double>();

            for (CompetitionResult result : memberID.getCompetitionResults()) {
                if (result.getDisciplin() == disciplin) {
                    times.add(result.getTime());
                }
            }

            return times;
        }

        public ArrayList<Double> getTop5(ArrayList<Double> allTimes) {
            ArrayList<Double> sorted = new ArrayList<Double>(allTimes);
            Collections.sort(sorted);

            ArrayList<Double> top5 = new ArrayList<Double>();
            for (int i = 0; i < sorted.size() && i < 5; i++) {
                top5.add(sorted.get(i));
            }
            return top5;
        }
    }
