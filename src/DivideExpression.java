public class DivideExpression extends ComplexExpression{
    DivideExpression(Operation op, ComplexNumber[] ar) {
        super(op, ar);
    }

    ComplexNumber executeOneOperation(ComplexNumber t1, ComplexNumber t2){
        return t1.divide(t2);
    }
}