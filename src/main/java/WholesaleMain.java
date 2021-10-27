public class WholesaleMain {

    /**
     * Main method of program creates instances of TransactionSystem and SystemInputOutput
     * Calls the initialize method of TransactionSystem using the instance of SystemInputOutput
     * as parameter.
     */
    public static void main(String[] args) {

        TransactionSystem ts = new TransactionSystem();
        SystemInputOutput io = new SystemInputOutput();
        io.initialize(ts);

    }

}
