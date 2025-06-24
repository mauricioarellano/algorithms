

class StringCompression {
    public int compress(char[] chars) {
        String s = "";
        char currentChar = ' ';
        int count = 0;

        for(int i=0; i<chars.length; i++){
            if(count==0){
                currentChar = chars[i];
            }
            if(currentChar==chars[i]){
                count++;
            } else {
                s = s + currentChar;
                if(count > 1){
                    s = s + count;
                }
                currentChar = chars[i];
                count = 1;
            }
        }
        s = s + currentChar;
        if(count > 1){
            s = s + count;
        }
        chars = s.toCharArray();
        
        return chars.length;
    }
}
