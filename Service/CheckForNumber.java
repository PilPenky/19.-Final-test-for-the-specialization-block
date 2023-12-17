package Service;

public class CheckForNumber {
    public boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}