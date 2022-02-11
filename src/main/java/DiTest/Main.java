package DiTest;

import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;

public class Main {

    interface GitHubService {
        GitHub connect() throws IOException;
    }
    class DefaultGitHubService implements GitHubService{
        @Override
        public GitHub connect() throws IOException {
            return GitHub.connect();
        }
    }
    private GitHubService gitHubService;

    public Main(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    public int getPoint(String repositoryName) throws IOException {
        GitHub gitHub = gitHubService.connect();
        GHRepository repository = gitHub.getRepository(repositoryName);

        int points = 0;
        if (repository.hasIssues()) {
            points += 1;
        }

        if(repository.getReadme() != null) {
            points += 1;
        }

        if(repository.getPullRequests(GHIssueState.CLOSED).size() > 0) {
            points += 1;
        }
        points += repository.getStargazersCount();
        points += repository.getForksCount();

        return points;
    }

    public static void main(String[] args) throws IOException {
        Main spring = new Main();
        int point = spring.getPoint("sungjaecho/react-springboot-test");
        System.out.println(point);
    }
}
