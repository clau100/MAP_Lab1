public abstract class ComplexExpression{
    enum Operation{
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION
    }
    public ComplexNumber[] args;
    Operation operation;

    ComplexExpression(Operation op, ComplexNumber[] ar){
        this.operation = op;
        this.args = ar;
    }
    public ComplexNumber execute(){
        ComplexNumber result = args[0];
        for(int i=1; i<args.length; ++i){
            result = executeOneOperation(result, args[i]);
        }
        return result;
    }

    abstract ComplexNumber executeOneOperation(ComplexNumber t1, ComplexNumber t2);

}