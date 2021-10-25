/**
 * Interface for a stack of primitive doubles.
 * 
 *          NOTE: You will need to provide much better descriptive
 *          comments than the ones provided in this interface
 */
public interface BKStack {
    
    /**
     * is empty?
     */
    public boolean isEmpty();

    /**
     * push
     */
    public void push(double d);

    /**
     * pop
     * 
     * @return the deleted value
     * @throws EmptyStackException if stack is empty
     *             
     */
    public double pop();

    /**
     * peek
     * 
     * @throws EmptyStackException if stack is empty
     *             
     */
    public double peek();
}
