import java.util.Objects;
import java.util.Stack;

public class ExpressionParser {
    private static final ExpressionParser instance = new ExpressionParser();
    private ExpressionParser(){}
    public static ExpressionParser getInstance(){
        return instance;
    }

    public ComplexNumber parse(String[] args){
        if(args.length % 2 == 0)
            throw(new ArithmeticException("Parameter length must be odd!"));

        Stack<String> AddSubStack = new Stack<>();
        boolean multiplication = false;
        boolean division = false;
        boolean negative = false;
        ComplexNumber result = new ComplexNumber(0, 0);
        for(int i=0; i<args.length; ++i){
            // if the operation is not placed correctly, throw error
            if (i % 2 == 0 && (Objects.equals(args[i], "-") || Objects.equals(args[i], "+") || Objects.equals(args[i], "*") || Objects.equals(args[i], "/"))) {
                throw (new ArithmeticException("Number expected at postition: " + i));
            }

            // do addition and subtraction later, using the stack
            if (Objects.equals(args[i], "-")){
                negative = true;
                continue;
            }
            if(Objects.equals(args[i], "+")){
                negative = false;
                continue;
            }

            // if multiplication, then mark that, do not put it on the stack
            if(Objects.equals(args[i], "*")){
                multiplication = true;
                continue;
            }

            // do the same for division
            if(Objects.equals(args[i], "/")){
                division = true;
                continue;
            }

            // handle the numbers
            if (i % 2 != 0 && ComplexNumber.checkIfNumberIsOk(args[i])){
                throw(new ArithmeticException("Operator expected at position: " + i));
            }
            if (!ComplexNumber.checkIfNumberIsOk(args[i])){
                throw(new NumberFormatException("Invalid number at position: " + i));
            }
            ComplexNumber[] ar = new ComplexNumber[2];
            ar[0] = new ComplexNumber(args[i]);
            if(multiplication){
                ar[1] = new ComplexNumber(AddSubStack.pop());
                ComplexNumber aux = ExpressionFactory.getInstance().createExpression(ComplexExpression.Operation.MULTIPLICATION, ar).execute();
                AddSubStack.push(aux.toString());
                multiplication = false;
                continue;
            }
            if(division){
                ar[1] = new ComplexNumber(AddSubStack.pop());
                ComplexNumber aux = ExpressionFactory.getInstance().createExpression(ComplexExpression.Operation.DIVISION, ar).execute();
                AddSubStack.push(aux.toString());
                division = false;
                continue;
            }
            if(negative){
                ar[0].re *= -1;
                ar[0].im *= -1;
                negative = false;
            }
            AddSubStack.push(ar[0].toString());
        }
        ComplexNumber[] ar = new ComplexNumber[2];
        while(!AddSubStack.empty()){
            ar[0] = result;
            ar[1] = new ComplexNumber(AddSubStack.pop());
            result = ExpressionFactory.getInstance().createExpression(ComplexExpression.Operation.ADDITION, ar).execute();
        }
        return result;
    }
}
