package Trees;

public class BasicsTrees {

    // format
    // Node (nameOfNode, rightNode, leftNode);

    /*
    Node("Flower",
        Node("Daisy",
            Node("Orchid", Empty, Empty),
            Node("Rose", Empty, Empty)),
        Node("Tulip",
             Empty,
             Node ("Lilac", Empty ,Empty)));
    */
}

/*
Node(i, lt, rt) -> 1 + max (height lt) (height rt)


write a function called sumT that adds all numbers in the tree:

let rec sumT = function
| Empty -> 0
| Node(i, lt, rt) -> i + (sumT lt.data) + (sumT rt.data)        [ i holds the value of the root]

write a function called isEmpty that returns true if the tree is empty:



inorder(r):
    if r!= null then
        inorder(r.left())
        print(r.key())
        inorder(r.right())

search(key, node):    --> for BST, key is the searched item and node is a pointer 0(logn)
    if node == NULL or key = node.key
        return node
    if key < node.key
        return search(key, node.left)
    else
        return search(key, node.right)

        best case: O(1)
        average case: O(logn)
        worst case: 0(n)


insert(key, node):     --> when you insert a node, it is permanent, cannot be changed
    if node == NULL
        node.key = key
    if key < node.key
        return insert (key, node.left)
    else
        return insert(ket, node.right)

        avg runtime: O(logn)
        worst case: O(n)

delete node in BST:
three cases to consider when deletion node v:
1. v is a leaf node
    remove v by setting the reference to its parent node null
2. v is an internal node with a single child
    assign v's child to v
3. v is an internal node with two children
    find inorder successor of v named w
    swap v with w and remove v


successor(root, x):    --> find successor of x node
    if x.right != null
        return min(x.right)
    node successor = null
    while root != null
        if x.data < root.data
            successor = root
            root = root.left
        else if x.data > root.data
            root = root.right
        else
            break;
    return successor
 */
