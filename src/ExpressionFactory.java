public class ExpressionFactory{
    private static final ExpressionFactory instance = new ExpressionFactory();

    private ExpressionFactory(){}

    public static ExpressionFactory getInstance(){
        return instance;
    }

    public ComplexExpression createExpression(ComplexExpression.Operation operation, ComplexNumber[] args){
        return switch (operation) {
            case ADDITION -> new AddExpression(ComplexExpression.Operation.ADDITION, args);
            case SUBTRACTION -> new SubtractExpression(ComplexExpression.Operation.SUBTRACTION, args);
            case MULTIPLICATION -> new MultiplyExpression(ComplexExpression.Operation.MULTIPLICATION, args);
            case DIVISION -> new DivideExpression(ComplexExpression.Operation.DIVISION, args);
        };
    }
}