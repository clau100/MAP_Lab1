public class AddExpression extends ComplexExpression{
    AddExpression(Operation op, ComplexNumber[] ar) {
        super(op, ar);
    }

    ComplexNumber executeOneOperation(ComplexNumber t1, ComplexNumber t2){
        return t1.add(t2);
    }
}