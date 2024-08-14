class Fibonacci:
    def fibonacci(n):
        if n <= 1:
            return n
        return Fibonacci.fibonacci(n - 1) + Fibonacci.fibonacci(n - 2)
    def recursive(n):
        result = []
        for i in range(n):
            result.append(Fibonacci.fibonacci(i))
        print(" ".join(map(str, result)))
    def iterative(n):
        a1, a2 = 0, 1
        result = [a1, a2]
        for _ in range(2, n):
            a3 = a1 + a2
            a1, a2 = a2, a3
            result.append(a2)
        print(" ".join(map(str, result)))
if __name__ == "__main__":
    recursive_count = int(input("Enter the number of Fibonacci numbers for recursive method: "))
    Fibonacci.recursive(recursive_count)
    iterative_count = int(input("Enter the number of Fibonacci numbers for iterative method: "))
    Fibonacci.iterative(iterative_count)
