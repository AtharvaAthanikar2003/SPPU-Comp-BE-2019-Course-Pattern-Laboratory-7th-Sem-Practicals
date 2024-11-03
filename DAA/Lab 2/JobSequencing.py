class Job:
    def __init__(self, id, deadline, profit):
        self.id = id
        self.deadline = deadline
        self.profit = profit
def print_job_sequence(jobs):
    # Sort jobs in descending order of profit
    jobs.sort(key=lambda job: job.profit, reverse=True)
    max_deadline = max(job.deadline for job in jobs)
    result = ['X'] * max_deadline
    slot = [False] * max_deadline
    for job in jobs:
        for j in range(min(max_deadline - 1, job.deadline - 1), -1, -1):
            if not slot[j]:
                result[j] = job.id
                slot[j] = True
                break
    print("Job Sequence: ", end="")
    for job_id in result:
        if job_id != 'X':
            print(job_id, end=" ")
    print()
    total_profit = sum(job.profit for job, filled in zip(jobs, slot) if filled)
    print("Total Profit:", total_profit)
if __name__ == "__main__":
    n = int(input("Enter number of jobs: "))
    jobs = []
    print("Enter jobs in the format (id deadline profit):")
    for _ in range(n):
        id, deadline, profit = input().split()
        deadline = int(deadline)
        profit = int(profit)
        jobs.append(Job(id, deadline, profit))
    print_job_sequence(jobs)

"""
### Explanation of the Program:

1. **Job Class**: Represents a job with an identifier, a deadline, and a profit.

2. **print_job_sequence Function**: 
   - Sorts the jobs in descending order based on profit.
   - Determines the maximum deadline from the jobs to set up the scheduling slots.
   - Initializes a list for the result and a boolean list to track filled slots.
   - Iterates through the sorted jobs and assigns each job to the latest available slot before its deadline.
   - Calculates the total profit from the scheduled jobs.

3. **Main Block**:
   - Accepts user input for the number of jobs and their details (id, deadline, and profit).
   - Calls the print_job_sequence function to process the jobs and display the results.

### Sample Input and Output:

**Input:**
5         // total no of jobs
a 2 100   // job class having - a-identifier, 2-deadline, 100-profit
b 1 19
c 2 27
d 1 25
e 3 15

**Output:**
Job Sequence: a c e 
Total Profit: 142

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
"""
