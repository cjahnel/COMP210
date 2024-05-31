package assn06;

public class AVLTree<T extends Comparable<T>> implements SelfBalancingBST<T> {
    // Fields
    private T _value;
    private AVLTree<T> _left;
    private AVLTree<T> _right;
    private int _height;
    private int _size;
    
    public AVLTree() {
        _value = null;
        _left = null;
        _right = null;
        _height = -1;
        _size = 0;
    }

    private void updateHeightAndSize() {
        _size = 1 + _left.size() + _right.size();
        _height = 1 + Math.max(_left.height(), _right.height());
    }

    private int getBalance() {
        return _left.height() - _right.height();
    }

    /**
     * Rotates the tree left and returns
     * AVLTree root for rotated result.
     */
     private AVLTree<T> rotateLeft() {
        // You should implement left rotation and then use this
        // method as needed when fixing imbalances.
        //
        if (isEmpty()) {
            return this;
        }
        AVLTree<T> y = _right;
        AVLTree<T> z = this;
        z._right = y._left;
        z.updateHeightAndSize();
        y._left = z;
        y.updateHeightAndSize();
        return y;
     }
    
    /**
     * Rotates the tree right and returns
     * AVLTree root for rotated result.
     */
     private AVLTree<T> rotateRight() {
        // You should implement right rotation and then use this
        // method as needed when fixing imbalances.
        if (isEmpty()) {
             return this;
        }
        AVLTree<T> y = _left;
        AVLTree<T> z = this;
        z._left = y._right;
        z.updateHeightAndSize();
        y._right = z;
        y.updateHeightAndSize();
        return y;
     }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int height() {
        return _height;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public SelfBalancingBST<T> insert(T element) {
        if (isEmpty()) {
            _value = element;
            _left = new AVLTree<>();
            _right = new AVLTree<>();
            updateHeightAndSize();
            return this;
        }

        if (element.compareTo(getValue()) < 0) {
            _left = (AVLTree<T>) getLeft().insert(element);
        } else if (element.compareTo(getValue()) > 0){
            _right = (AVLTree<T>) getRight().insert(element);
        } // could implement else if we want to handle duplicates

        updateHeightAndSize();

        int balance = getBalance();

        if (balance > 1 && element.compareTo(getLeft().getValue()) < 0) {
            return rotateRight();
        } else if (balance < -1 && element.compareTo(getRight().getValue()) > 0) {
            return rotateLeft();
        } else if (balance > 1 && element.compareTo(getLeft().getValue()) > 0) {
            _left = _left.rotateLeft();
            return rotateRight();
        } else if (balance < -1 && element.compareTo(getRight().getValue()) < 0) {
            _right = _right.rotateRight();
            return rotateLeft();
        } // Might need equals case if we want to handle duplicates

        return this;
    }

    @Override
    public SelfBalancingBST<T> remove(T element) {
        if (isEmpty()) return this;

        if (element.compareTo(getValue()) < 0) {
            _left = (AVLTree<T>) getLeft().remove(element);
        } else if (element.compareTo(getValue()) > 0) {
            _right = (AVLTree<T>) getRight().remove(element);
        } else {
            if (getLeft().isEmpty()) {
                return getRight();
            } else if (getRight().isEmpty()) {
                return getLeft();
            } else {
                T successorElement = getRight().findMin();
                _value = successorElement;
                _right = (AVLTree<T>) getRight().remove(successorElement);
            }
        }

        updateHeightAndSize();

        int balance = getBalance();

        if (balance > 1 && element.compareTo(getLeft().getValue()) > 0) {
            return rotateRight();
        } else if (balance < -1 && element.compareTo(getRight().getValue()) < 0) {
            return rotateLeft();
        } else if (balance > 1 && element.compareTo(getLeft().getValue()) < 0) {
            _left = _left.rotateLeft();
            return rotateRight();
        } else if (balance < -1 && element.compareTo(getRight().getValue()) > 0) {
            _right = _right.rotateRight();
            return rotateLeft();
        }

        return this;
    }

    @Override
    public T findMin() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal operation on empty tree");
        }
        if (getLeft().isEmpty()) {
            return getValue();
        }
        return getLeft().findMin();
    }

    @Override
    public T findMax() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal operation on empty tree");
        }
        if (getRight().isEmpty()) {
            return getValue();
        }
        return getRight().findMax();
    }

    @Override
    public boolean contains(T element) {
        if (element.compareTo(getValue()) < 0) {
            if (getLeft().isEmpty()) {
                return false;
            }
            return getLeft().contains(element);
        } else if (element.compareTo(getValue()) > 0){
            if (getRight().isEmpty()) {
                return false;
            }
            return getRight().contains(element);
        } else {
            return true;
        }
    }

    @Override
    public boolean rangeContain(T start, T end) {
        if (start.compareTo(getValue()) > 0) {
            if (getRight().isEmpty()) {
                return false;
            }
            return getRight().rangeContain(start, end);
        } else if (end.compareTo(getValue()) < 0) {
            if (getLeft().isEmpty()) {
                return false;
            }
            return getLeft().rangeContain(start, end);
        } else {
            return true;
        }
    }

    @Override
    public T getValue() {
        return _value;
    }

    @Override
    public SelfBalancingBST<T> getLeft() {
        if (isEmpty()) {
            return null;
        }
        return _left;
    }

    @Override
    public SelfBalancingBST<T> getRight() {
        if (isEmpty()) {
            return null;
        }
        return _right;
    }
}
