/*
* Class that keeps track of current minimum value using two stacks
* the current minimum value is pushed to min stack, and the stack
* both stacks maintain the same size, so then pop method removes from both
* */
public class MinValueStack<T> {
    private NewStack<Integer> stack = new NewStack<Integer>();
    private NewStack<Integer> min = new NewStack<Integer>();

    /*
    * Add item as last into stack and min, the min stack gets the
    * current minimum value which is held into integer
    * @param int x which is item to be pushed onto stack min and stack
    * @return x which is item on sack and min
    * */
    public Integer push(int x) {

        Integer currentMin = 0;

        if(stack.isEmpty()) {
            stack.push(x);
            min.push(x);
            return x;
        }

        currentMin=min.peek();

        if(currentMin < x){
            min.push(currentMin);
        } else {
            min.push(x);
        }
        stack.push(x);

        return x;
    }

    /*
    * remove item from minimum stack, then remove from stack
    * @return stack.pop()
    * */
    public Integer pop() {
        if (stack.isEmpty()){
            return null;
        }
        min.pop();
        return stack.pop();
    }

    /*
    * get minimum value by getting the top item from min stack
    * @return min.peek() which is a top value in the min stack
    * */
    public Integer getMinimum()
    {
        if(min.isEmpty()) {
            return null;
        }
        return min.peek();
    }


}
