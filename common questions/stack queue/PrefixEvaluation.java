public class PrefixEvaluation {
    public static void main(String[] args) {
        
        // * - 5 6 7 
        // assumption all the numbers is one digit
        String prefix = "*-567";
        MyStack<Double> stack = new MyStack<>();
        String operators = "+-*/";

        for(int i=prefix.length()-1; i>=0; i--) {
            char c = prefix.charAt(i);
            if(operators.indexOf(c) != -1) {
                double leftOperand = stack.pop();
                double rightOperand = stack.pop();
                switch(c){
                    case '*':
                        stack.push(leftOperand*rightOperand);
                        break;
                    case '-':
                        stack.push(leftOperand-rightOperand);
                        break;
                    case '+':
                        stack.push(leftOperand+rightOperand);
                        break;
                    case '/':
                        stack.push(leftOperand/rightOperand);
                        break;
                }
                
            } else {
                Double d = Double.parseDouble(""+c);
                stack.push(d);
            }
        }

        System.out.println(stack.pop());
    }
}