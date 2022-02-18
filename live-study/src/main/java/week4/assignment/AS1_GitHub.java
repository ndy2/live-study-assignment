package week4.assignment;

import org.kohsuke.github.*;

import java.io.*;
import java.util.*;

public class AS1_GitHub {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/token"));

        String id = "ndy2";
        String token = br.readLine();

        GitHub github = GitHub.connect(id,token);
        GHRepository repository = github.getRepository("whiteship/live-study");


        List<GHIssue> issues = repository.getIssues(GHIssueState.ALL);
        long numIssues = issues.stream().filter(i -> !i.isPullRequest()).count();
        System.out.println("numIssues = " + numIssues);
        
        Map<String,Integer> participationCountMap = new HashMap<>();
        for (GHIssue issue : issues) {
            System.out.println(String.format("Issue %d : %s", issue.getNumber(),issue.getTitle()));
            List<GHIssueComment> comments = issue.getComments();

            for (GHIssueComment comment : comments) {
                String username = comment.getUser().getLogin();
                System.out.println("username = " + username);
                if (participationCountMap.containsKey(username)) {
                    participationCountMap.put(username, participationCountMap.get(username)+1);
                }else{
                    participationCountMap.put(username,1);
                }
            }
        }

        for (String username : participationCountMap.keySet()) {
            float participationRate = (float)participationCountMap.get(username)*100 / numIssues;
            System.out.println(String.format("user: %s has participated in %.2f",username, participationRate));
        }

        br.close();
    }
}
