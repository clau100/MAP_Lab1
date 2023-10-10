public class Main {

    public static void main(String[] args) {
        ExpressionParser Parser = ExpressionParser.getInstance();
        System.out.println(Parser.parse(args).toString());
    }
}