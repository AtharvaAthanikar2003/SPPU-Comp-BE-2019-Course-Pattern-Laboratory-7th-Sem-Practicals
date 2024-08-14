import heapq
class Node:
    def __init__(self, val, symbol):
        self.val = val
        self.symbol = symbol
        self.huffman = ""
        self.left = None
        self.right = None
    def __lt__(self, other):
        return self.val < other.val
def build_huffman_tree(characters, frequencies):
    nodes = []
    for i in range(len(characters)):
        heapq.heappush(nodes, Node(frequencies[i], characters[i]))
    while len(nodes) > 1:
        left = heapq.heappop(nodes)
        right = heapq.heappop(nodes)
        left.huffman = "0"
        right.huffman = "1"
        new_node = Node(left.val + right.val, left.symbol + right.symbol)
        new_node.left = left
        new_node.right = right
        heapq.heappush(nodes, new_node)
    return nodes[0]
def print_huffman_codes(node):
    huffman_decimal = {}
    traverse(node, "", huffman_decimal)
    print("Huffman Codes (Decimal):")
    for symbol, code in huffman_decimal.items():
        print(f"{symbol} -> {code}")
def traverse(node, current_code, huffman_decimal):
    if node.left is None and node.right is None:
        huffman_decimal[node.symbol] = int(current_code, 2)
    else:
        if node.left is not None:
            traverse(node.left, current_code + node.left.huffman, huffman_decimal)
        if node.right is not None:
            traverse(node.right, current_code + node.right.huffman, huffman_decimal)
if __name__ == "__main__":
    input_chars = input("Enter characters (separated by space): ")
    characters = input_chars.split()
    input_freqs = input("Enter corresponding frequencies (separated by space): ")
    frequencies = list(map(int, input_freqs.split()))
    root = build_huffman_tree(characters, frequencies)
    print_huffman_codes(root)
