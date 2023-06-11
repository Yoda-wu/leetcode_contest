package lc349;

public class B {
    private char[] map = {'z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public String smallestString(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i = 0; i < s.length() && s.charAt(i) == 'a'; i++){
            sb.append(s.charAt(i));
            idx++;
        }
        boolean op = false;
        boolean flag = false;
        for(int i = idx; i < s.length() ; i++){
            char ch = s.charAt(i);
            if( ch != 'a' && !flag){
                sb.append(map[ch-'a']);
                op = true;
            }else {
                flag = true;
            }
            if(flag){
                sb.append(ch);
            }
        }
        if(!op){
            char  h = sb.charAt(sb.length()- 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(map[h-'a']);
        }
        return sb.toString();
    }
}
