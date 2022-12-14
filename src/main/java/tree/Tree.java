package tree;

public class Tree {

    private static final String ZERO = "0";

    private Node root;

    public Tree() {
        this.root = null;
    }

    public void add(String value) {
        Node newNode = new Node(value);

        if (this.root == null) {
            this.root = newNode;
            return;
        }

        Node current = this.root;

        while (true) {

            final int valueLength = value.length();

            if (valueLength == 2) {
                final String leftDigit = value.substring(0, 1);
                final String rightDigit = value.substring(1, 2);

                if (current.getLeft() == null) {

                    if (ZERO.equals(rightDigit)) {
                        current.setLeft(new Node(leftDigit));
                        current.getLeft().setRight( new Node(ZERO));
                    } else {
                        current.setLeft(new Node(leftDigit));
                        current.getLeft().setRight(new Node(ZERO));
                        add(rightDigit);
                    }

                    break;
                }
                current = current.getLeft();
            }

            if (valueLength == 1) {
                if (current.getLeft() == null) {
                    current.setLeft(newNode);
                    break;
                }
                current = current.getLeft();
            }

        }
    }

    public Node getRoot() {
        return root;
    }
}

