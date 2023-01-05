package com.company;

public class Main {

    public static void main(String[] args) {
        String x = "5 1 * 9 4 3 + - /";
        solvePostfix3(x);
        infixToPostifx("((5*1)/(9-(4+3)))");

//        infixToPostifx("(30+12)/(54-13)*7");
        var y = new Stack<Integer>();
        y.push(5); y.push(4); y.push(3); y.push(2); y.push(1);
        y.print();
        for (Object i : y) {
            System.out.println(i);
        }
    }

    public static boolean checkBalance(String expr){
        Stack<Character> x = new Stack<>();

        char c;
        for (int i = 0; i < expr.length(); i++) {
            c = expr.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                x.push(c);
            else if (c == ')') {
                if (x.pop() != '(')
                    return false;
            } else if (c == '}') {
                if (x.pop() != '{')
                    return false;
            } else if (c == ']') {
                if (x.pop() != '[')
                    return false;
            }
        }
        return x.isEmpty();

    }
    public static void solvePostfix(String expr){
        Stack<Integer> x = new Stack<>();
        for(int i=0; i<expr.length();i++){
            char c = expr.charAt(i);

            if (Character.isDigit(c)) {
                x.push(Character.getNumericValue(c));
                continue;
            }
            if (c==' ')
                continue;

            int v1 = x.pop();
            int v2 = x.pop();
            switch (c) {
                case '+' -> x.push(v2 + v1);
                case '-' -> x.push(v2 - v1);
                case '*' -> x.push(v2 * v1);
                case '/' -> x.push(v2 / v1);
            }
        }
        System.out.println(x.pop());
    } //solve integers even without spaces but can take <9
    public static void solvePostfix2(String expr){
        String[] arr = expr.split(" ");
        Stack<Integer> x = new Stack<>();

        for (String i: arr){
            try{
                x.push(Integer.parseInt(i));
            }catch (NumberFormatException a) {
                int v1 = x.pop();
                int v2 = x.pop();
                switch (i) {
                    case "+" -> x.push(v2 + v1);
                    case "-" -> x.push(v2 - v1);
                    case "*" -> x.push(v2 * v1);
                    case "/" -> x.push(v2 / v1);
                    default -> System.out.println("wrong input occured");
                }
            }
        }
        System.out.println(x.pop());
    } //solve integers can take >9 but spaces are required
    public static void solvePostfix3(String expr){
        Stack<String> x = new Stack<>();//5 1 * 9 4 3 + - /
        for(int i=0; i<expr.length();i++){
            String c = expr.substring(i,i+1);

            if (c.equals(" "))
                continue;

            if(!(c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/"))) {
                x.push(c);
                continue;
            }

            String v1 = x.pop();
            String v2 = x.pop();
            switch (c) {
                case "+" -> x.push("("+v2 +"+"+ v1+")");
                case "-" -> x.push("("+v2 +"-"+ v1+")");
                case "*" -> x.push("("+v2 +"*"+ v1+")");
                case "/" -> x.push("("+v2 +"/"+ v1+")");
            }
        }
        System.out.println(x.pop());
    } //can solve anything but <9
    public static void infixToPostifx(String expr){
        Stack<Character> x = new Stack<>();
        for (int i=0; i<expr.length();i++){
            char c = expr.charAt(i);
            switch (c){
                case ')' -> {
                    while(x.top()!='(')
                        System.out.print(x.pop()+" "); //pop and print anything between the ()
                    x.pop(); // pop (
                }
                case '(' -> x.push('(');
                case '+','-' -> {
                    while (!x.isEmpty()&&x.top() != '(') // && (x.top() == '+' || x.top() == '*' || x.top() == '-' || x.top() == '/')
                        System.out.print(x.pop() + " ");

                    x.push(c);
                }
                case '*','/' -> {
                    while (!x.isEmpty()&&x.top() != '(' && (x.top() == '*' || x.top() == '/'))
                        System.out.print(x.pop() + " ");
                    x.push(c);
                }
                default -> { if(c!=' ') System.out.print(c + " "); }
            }
        }
        while (!x.isEmpty())
            System.out.print(x.pop()+" ");
    }
}
class Stackk<E> {
    Node<E> head;

    public Stackk(){
        head = null;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void push(E x){
        Node<E> temp = new Node<>(x);
        temp.next = head;
        head = temp;
    }
    public E pop(){
        if (isEmpty())
            return null;
        E tmp = head.data;
        head = head.next;
        return tmp;
    }
    public E top(){
        if (isEmpty())
            return null;
        return head.data;
    }
}