import java.util.Arrays;
import java.util.Comparator;

class Job {
    char id;
    int deadline;
    int profit;

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {
    public static void printJobSequence(Job[] jobs) {
        // Sort jobs in descending order of profit
        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                return Integer.compare(j2.profit, j1.profit);
            }
        });

        int n = jobs.length;
        // Find the maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        // Initialize result array and slot array
        char[] result = new char[maxDeadline];
        boolean[] slot = new boolean[maxDeadline];

        // Fill result array with 'X' and slot array with false
        Arrays.fill(result, 'X');
        Arrays.fill(slot, false);

        // Iterate through all jobs
        for (int i = 0; i < n; i++) {
            // Find a free slot for this job (we start from the last possible slot)
            for (int j = Math.min(maxDeadline - 1, jobs[i].deadline - 1); j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = jobs[i].id;
                    slot[j] = true;
                    break;
                }
            }
        }

        // Print the result
        System.out.print("Job Sequence: ");
        for (char jobId : result) {
            if (jobId != 'X') {
                System.out.print(jobId + " ");
            }
        }
        System.out.println();

        // Calculate and print the total profit
        int totalProfit = 0;
        for (int i = 0; i < maxDeadline; i++) {
            if (slot[i]) {
                for (Job job : jobs) {
                    if (job.id == result[i]) {
                        totalProfit += job.profit;
                        break;
                    }
                }
            }
        }
        System.out.println("Total Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job('a', 2, 100),
            new Job('b', 1, 19),
            new Job('c', 2, 27),
            new Job('d', 1, 25),
            new Job('e', 3, 15)
        };

        System.out.println("Job Sequencing with Deadlines:");
        printJobSequence(jobs);
    }
}