public class Problem3_21 {
    public class Stack {
        // Data Fields
        public static final int INITIAL_CAPACITY = 32;
        public static final int SCALE_FACTOR = 2;
        private int[] data;
        private int size = 0;
    
        // Constructor
        Stack() { data = new double[INITIAL_CAPACITY]; }
    
        // Resizes the data array.
        private void resize(int newSize) {
            int[] newData = new int[newSize];
            for (int i = 0; i < size; i++)
                newData[i] = data[i];
            data = newData;
        }
        
        // Checks if the stack is empty
        public boolean isEmpty() { return size == 0; }
    
        // Returns the value of the top element without removing
        public int peek()        { return data[size - 1]; }
    
        // Adds a value to the top of the stack
        public void push(int i) {
            if (size == data.length)
                resize(size * SCALE_FACTOR);
            data[size++] = i;
        }
    
        // Removes a value from the top of the stack
        public int pop() {
            if (data.length >= SCALE_FACTOR * SCALE_FACTOR * size)
                resize(data.length / SCALE_FACTOR);
            return data[--size];
        }
    }
    public static void main(String[] x) {
        int lang, error;
        String sentence;
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("Enter String to check for balancing: ");
        sentence = input.nextLine();
        do {
            System.out.print("Select a language (1 - Pascal, 2 - Java): ")
            lang = input.nextInt();
            if (lang < 1 && lang > 2)
                System.out.println("Invalid input");
        } while (lang != 1 && lang != 2);

        error = checkBalancing(sentence, lang);
        if (error == -2)
            System.out.println("The string does not close all opening characters");
        else if (error == -1) 
            System.out.println("The string is perfectly balanced (as all things should be)");
        else
            System.out.printf("The string returned an error at index: %d\n", error);
    }

    public static int checkBalancing(String input, int lang) {
            Stack balance = new Stack();

            for (int i = 0; i < input.length(); i++) {
                if (input[i] == 'b' && lang == 1) {
                    if (input.substring(i, i + 4) == "begin")
                        balance.push(1);
                }
                else if (input[i] == '/' && lang == 2) {
                    if (input.substring(i, i + 1) == "/*")
                        balance.push(1);
                }
                else if (input[i] == '(')
                    balance.push(2);
                else if (input[i] == '[')
                    balance.push(3);
                else if (input[i] == '{')
                    balance.push(4); 
                else if (input[i] == '}') {
                    if (balance.peek() == 4)
                        balance.pop();
                    else return i;
                }
                else if (input[i] == ']') {
                    if (balance.peek() == 3)
                        balance.pop();
                    else return i;
                }
                else if (input[i] == ')') {
                    if (balance.peek() == 2)
                        balance.pop();
                    else return i;
                }
            }
            return -1;
        }

    }
}
