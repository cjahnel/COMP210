package assn04;
import java.util.LinkedList;
import java.util.Queue;

public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {
		_left = new EmptyBST<T>();
		_right = new EmptyBST<T>();
		_element = element;
	}

	@Override
	public BST<T> insert(T element){
		if (element.compareTo(getElement()) < 0) {
			_left = getLeft().insert(element);
		} else if (element.compareTo(getElement()) > 0){
			_right = getRight().insert(element);
		}

		return this;
	}

	@Override
	public BST<T> remove(T element) {
		if (element.compareTo(getElement()) < 0) {
			_left = getLeft().remove(element);
			return this;
		} else if (element.compareTo(getElement()) > 0) {
			_right = getRight().remove(element);
			return this;
		}

		if (getLeft().isEmpty()) {
			return getRight();
		} else if (getRight().isEmpty()) {
			return getLeft();
		} else {
			T successorElement = getRight().findMin();
			_element = successorElement;
			_right = getRight().remove(successorElement);
			return this;
		}
	}

	@Override
	public BST<T> remove_range(T start, T end) {
		_left = getLeft().remove_range(start, end);
		_right = getRight().remove_range(start, end);

		if (start.compareTo(getElement()) <= 0 && getElement().compareTo(end) <= 0) {
			return remove(getElement());
		}

		return this;
	}

	@Override
	public void printPreOrderTraversal() {
		System.out.print(getElement() + " ");
		getLeft().printPreOrderTraversal();
		getRight().printPreOrderTraversal();
	}

	@Override
	public void printPostOrderTraversal() {
		getLeft().printPostOrderTraversal();
		getRight().printPostOrderTraversal();
		System.out.print(getElement() + " ");
	}

	// The findMin method returns the minimum value in the tree.
	@Override
	public T findMin() {
		if(_left.isEmpty()) {
			return _element;
		}
		return _left.findMin();
	}

	@Override
	public int getHeight() {
		   return Math.max(_left.getHeight(), _right.getHeight())+1;
	}

	@Override
	public BST<T> getLeft() {
		return _left;
	}

	@Override
	public BST<T> getRight() {
		return _right;
	}

	@Override
	public T getElement() {
		return _element;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
