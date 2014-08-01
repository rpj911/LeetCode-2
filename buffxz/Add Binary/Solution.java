public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        
        String aa = new StringBuilder(a).reverse().toString();
        String bb = new StringBuilder(b).reverse().toString();
        
        int i = 0;
        int carry = 0;
        
        while (i < aa.length() && i < bb.length()) {
            if (aa.charAt(i) == bb.charAt(i)) {
                builder.append(carry);
                carry = aa.charAt(i) == '1' ? 1 : 0;
            } else {
                builder.append( (carry == 0) ? '1' : '0' );
            }
            i++;
        }
        
        while (i < bb.length()) {
            if (bb.charAt(i) == '0') {
                builder.append(carry);
                carry = 0;
            } else {
                builder.append( (carry == 0) ? '1' : '0' );
            }
            i++;
        }
        
        while (i < aa.length()) {
            if (aa.charAt(i) == '0') {
                builder.append(carry);
                carry = 0;
            } else {
                builder.append( (carry == 0) ? '1' : '0' );
            }
            i++;
        }
        
        if (carry == 1) builder.append(1);
        
        return builder.reverse().toString();
        
    }
}