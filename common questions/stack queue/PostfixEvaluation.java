public class PostfixEvaluation {
    public static void main(String[] args) {
        
        // 7 6 5 - * 
        // assumption all the numbers is one digit
        String prefix = "765-*";
        MyStack<Double> stack = new MyStack<>();
        String operators = "+-*/";

        for(int i=0; i<prefix.length(); i++) {
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