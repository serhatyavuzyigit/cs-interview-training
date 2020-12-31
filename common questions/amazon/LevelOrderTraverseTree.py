def level_order_traversal(root):
    queue = []
    queue.append(root)

    while len(queue) != 0:
        node = queue.pop()
        print(node.val)
        
        if node.left != None:
            queue.append(node.left)
        if node.right != None:
            queue.append(node.right)
        
