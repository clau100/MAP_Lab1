public class MultiplyExpression extends ComplexExpression{
    MultiplyExpression(Operation op, ComplexNumber[] ar) {
        super(op, ar);
    }

    ComplexNumber executeOneOperation(ComplexNumber t1, ComplexNumber t2){
        return t1.multiply(t2);
    }
}
