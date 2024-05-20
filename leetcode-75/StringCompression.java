public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a','a','a','a','a','a','a','a','a','a','b','b','c','c','c'};
        int pointer = compress(chars);

        for(int i=0; i<pointer; i++) {
            System.out.print(chars[i] + " ");
        }
    }

    public static int compress(char[] chars) {
        if(chars == null || chars.length == 0) {
            return 0;
        }

        char curChar = chars[0];
        int counter = 1;
        int pointer = 0;

        for(int i=1; i<chars.length; i++) {
            if(chars[i] == curChar) {
                counter++;
            }
            else {
                chars[pointer++] = curChar;
                if(counter >= 10) {
                    String counterStr = counter + "";
                    for(int j=0; j<counterStr.length(); j++) {
                        char ch = counterStr.charAt(j);
                        chars[pointer++] = ch;
                    }
                }
                else if(counter > 1) {
                    chars[pointer++] = (counter + "").charAt(0);
                }
                curChar = chars[i];
                counter = 1;
            }
        }

        chars[pointer++] = curChar;
        if(counter >= 10) {
            String counterStr = counter + "";
            for(int j=0; j<counterStr.length(); j++) {
                char ch = counterStr.charAt(j);
                chars[pointer++] = ch;
            }
        }
        else if(counter > 1) {
            chars[pointer++] = (counter + "").charAt(0);
        }

        return pointer;
    }
}
