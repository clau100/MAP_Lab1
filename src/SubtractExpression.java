public class SubtractExpression extends ComplexExpression{
    SubtractExpression(Operation op, ComplexNumber[] ar) {
        super(op, ar);
    }

    ComplexNumber executeOneOperation(ComplexNumber t1, ComplexNumber t2){
        return t1.subtract(t2);
    }
}
