package assn05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxBinHeapER  <V, P extends Comparable<P>> implements BinaryHeap<V, P> {

    private List<Prioritized<V,P>> _heap;

    /**
     * Constructor that creates an empty heap of hospital.Prioritized objects.
     */
    public MaxBinHeapER() {
        _heap = new ArrayList<>();
    }

    @Override
    public int size() {
        return _heap.size();
    }

    static int leftChildIndex(int index) {
        return 2*index + 1;
    }

    static int rightChildIndex(int index) {
        return 2*index + 2;
    }

    static int parentIndex(int index) {
        return Math.floorDiv(index - 1, 2);
    }

    boolean validIndex(int index) {
        return (index >= 0) && (index < size() - 1);
    }

    boolean hasLeftChild(int index) {
        return validIndex(leftChildIndex(index));
    }

    boolean hasRightChild(int index) {
        return validIndex(rightChildIndex(index));
    }

    void bubbleUp(int index) {
        if (index == 0) {
            return;
        }

        Prioritized<V, P> child = _heap.get(index);
        Prioritized<V, P> parent = _heap.get(parentIndex(index));
        if(child.getPriority().compareTo(parent.getPriority()) > 0) {
            _heap.set(parentIndex(index), child);
            _heap.set(index, parent);
            bubbleUp(parentIndex(index));
        }
    }

    void bubbleDown(int index) {
        Prioritized<V, P> parent = _heap.get(index);
        if (!hasLeftChild(index) && !hasRightChild(index)) {
            return;
        } else if (!hasRightChild(index)) {
            // only has left child
            Prioritized<V, P> child = _heap.get(leftChildIndex(index));
            if (parent.getPriority().compareTo(child.getPriority()) < 0) {
                _heap.set(leftChildIndex(index), parent);
                _heap.set(index, child);
            }
        } else {
            // has two children
            // a) Find max of left/right & swap if needed
            // b) Recurse downwards
            Prioritized<V, P> leftChild = _heap.get(leftChildIndex(index));
            Prioritized<V, P> rightChild = _heap.get(rightChildIndex(index));
            if (leftChild.getPriority().compareTo(rightChild.getPriority()) > 0) {
                if (parent.getPriority().compareTo(leftChild.getPriority()) < 0) {
                    _heap.set(leftChildIndex(index), parent);
                    _heap.set(index, leftChild);
                    bubbleDown(leftChildIndex(index));
                }
            } else {
                if (parent.getPriority().compareTo(rightChild.getPriority()) < 0) {
                    _heap.set(rightChildIndex(index), parent);
                    _heap.set(index, rightChild);
                    bubbleDown(rightChildIndex(index));
                }
            }
        }
    }

    // TODO (Task 2A): enqueue
    public void enqueue(V value) {
        Prioritized<V, P> newPatient = new Patient<>(value);
        _heap.add(newPatient);
        bubbleUp(size() - 1);
    }

    // TODO (Task 2A): enqueue
    @Override
    public void enqueue(V value, P priority) {
        Prioritized<V, P> newPatient = new Patient<>(value, priority);
        _heap.add(newPatient);
        bubbleUp(size() - 1);
    }

    // TODO (Task 2A): dequeue
    @Override
    public V dequeue() {
        if (_heap.isEmpty()) {
            return null;
        } else if (size() == 1) {
            return _heap.remove(0).getValue();
        }
        V dequeuedPatientValue = _heap.get(0).getValue();
        _heap.set(0, _heap.remove(_heap.size() - 1));
        bubbleDown(0);
        return dequeuedPatientValue;
    }

    // TODO (Task 2A): getMax
    @Override
    public V getMax() {
        if (_heap.size() == 0) {
            return null;
        }
        return _heap.get(0).getValue();
    }

    // TODO (part 2B) : updatePriority
    public void updatePriority(V value, P newPriority) {
       for (int i = 0; i < _heap.size(); i++) {
           Patient<V, P> node = (Patient) _heap.get(i);
           if (node.getValue() == value) {
               P oldPriority = node.getPriority();
               node.setPriority(newPriority);
               if (oldPriority.compareTo(newPriority) > 0) {
                   bubbleDown(i);
               } else {
                   bubbleUp(i);
               }
           }
       }
    }

    /**
     * Constructor that builds a heap given an initial array of hospital.Prioritized objects.
     */
    // TODO (Task 3): overloaded constructor
    public MaxBinHeapER(Prioritized<V, P>[] initialEntries ) {
        _heap = new ArrayList<>();
        for (Prioritized<V, P> initialEntry : initialEntries) {
            enqueue(initialEntry.getValue(), initialEntry.getPriority());
        }

//        _heap = new ArrayList<>(Arrays.asList(initialEntries));
//        for (int i = parentIndex(size() - 1); i >= 0; i--) {
//            bubbleDown(i);
//        }
    }

    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }

}
