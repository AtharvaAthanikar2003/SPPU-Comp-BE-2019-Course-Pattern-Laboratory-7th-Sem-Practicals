import java.util.*;
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
        Arrays.sort(jobs, new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                return Integer.compare(j2.profit, j1.profit);
            }
        });
        int n = jobs.length;
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }
        char[] result = new char[maxDeadline];
        boolean[] slot = new boolean[maxDeadline];
        Arrays.fill(result, 'X');
        Arrays.fill(slot, false);
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(maxDeadline - 1, jobs[i].deadline - 1); j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = jobs[i].id;
                    slot[j] = true;
                    break;
                }
            }
        }
        System.out.print("Job Sequence: ");
        for (char jobId : result) {
            if (jobId != 'X') {
                System.out.print(jobId);
            }
        }
        System.out.println();
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of jobs:");
        int n = scanner.nextInt();
        Job[] jobs = new Job[n];
        System.out.println("Enter jobs in the format (id deadline profit):");
        for (int i = 0; i < n; i++) {
            char id = scanner.next().charAt(0);
            int deadline = scanner.nextInt();
            int profit = scanner.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }
        printJobSequence(jobs);
    }
}

/*
### Explanation of the Program:

1. **Job Class**: Represents a job with an identifier, a deadline, and a profit.

2. **printJobSequence Method**: 
   - Sorts the jobs in descending order based on profit.
   - Determines the maximum deadline from the jobs to set up the scheduling slots.
   - Initializes an array for the result and a boolean array to track filled slots.
   - Iterates through the sorted jobs and assigns each job to the latest available slot before its deadline.
   - Calculates the total profit from the scheduled jobs.

3. **Main Method**:
   - Accepts user input for the number of jobs and their details (id, deadline, and profit).
   - Calls the `printJobSequence` method to process the jobs and display the results.

### Sample Input and Output:

**Input:**
```
5         // total no of jobs
a 2 100   // job class having - a-identifier, 2-deadline, 100-profit
b 1 19
c 2 27
d 1 25
e 3 15
```

**Output:**
```
Job Sequence: a c e 
Total Profit: 142
```

### Breakdown of Output:

- **Job Sequence**: 
  - **a**: Scheduled in slot 1 (deadline 2).
  - **c**: Scheduled in slot 2 (also has a deadline of 2, but slot 1 was filled by 'a').
  - **e**: Scheduled in slot 3 (fits within its deadline).

- **Total Profit**: 
  - From the scheduled jobs:
    - Job 'a' (profit 100)
    - Job 'c' (profit 27)
    - Job 'e' (profit 15)
  - Total Profit = 100 + 27 + 15 = 142.

### Summary:
This program effectively schedules jobs to maximize profit while respecting their deadlines, providing a clear view of which jobs were chosen and the total profit generated.
*/
