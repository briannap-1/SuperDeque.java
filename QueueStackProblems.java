/**
 * @author Brianna Penkala
 * This class shows the functionality of the SuperDeque class
 */
public class QueueStackProblems {

    /** A field that initializes a deque to be used in the methods */
    static SuperDeque<String> dequeString = new SuperDeque<>();

    /** A method that evaluates a postfix expression
     * @param postfix the postfix expression to be evaluated
     * @return the integer result of the expression
     * */
    public static int evaluatePostFix(String postfix) {
        SuperDeque<Integer> dequeInteger = new SuperDeque<>();
        int i = 0;
        while (i < postfix.length()) {
            char character = postfix.charAt(i);
            if (Character.isDigit(character)) { //adds the operand if it is a number
                int number = 0;
                while (Character.isDigit(character)) { //adds multi-digit number
                    number = (number * 10) + Character.getNumericValue(character);
                    if (Character.isDigit(postfix.charAt(i + 1))) //if the next character is a number
                        i++;
                    else
                        break;
                    character = postfix.charAt(i);
                }
                dequeInteger.push(number);
            } else {
                if (character == ' ')
                    ;
                else {
                    int first = dequeInteger.pop();
                    int second = dequeInteger.pop();
                    switch (character) {
                        case '+':
                            dequeInteger.push(second + first);
                            break;
                        case '-':
                            dequeInteger.push(second - first);
                            break;
                        case '*':
                            dequeInteger.push(second * first);
                            break;
                        case '/':
                            dequeInteger.push(second / first);
                            break;
                    }
                }
            }
            i++;
        }
        return dequeInteger.pop();
    }

    /** A method that reverses the words in a string
     * @param s the string to be reversed
     * @return the string with reversed words
     * */
    public static String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) { //pushing the characters will automatically reverse them
            dequeString.push(String.valueOf(s.charAt(i)));
        }
        for (int i = 0; i < s.length(); i++) //popping the characters will keep the reversed order
            builder.append(dequeString.pop());
        return builder.toString();
    }

    /** A method that reverses a specified number of elements in a deque
     * @param dq the deque with the elements to be reversed
     * @param k the number of elements to reverse
     * @return the deque with a specified number of reversed elements
     * */
    public static <E> SuperDeque<E> reverseK(SuperDeque<E> dq, int k) {
        SuperDeque<E> reverseDeque = new SuperDeque<>();
        int i = 0;
        for (; i < k && i < dq.getDQLength(); i = (i + 1) % dq.getDQLength()) { //pushing the elements will automatically reverse them
            reverseDeque.push(dq.pop());
        }
        for (; i < dq.getDQLength() - 1; i = (i + 1) % dq.getDQLength()) { //enqueuing the rest of the elements will keep them in original order
            reverseDeque.enqueue(dq.pop());
        }
        return reverseDeque;
    }
}
