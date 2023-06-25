package lc107;

import java.util.HashMap;

/**
 * 
 * 给你一个下标从 0 开始的数组 words ，数组中包含 互不相同 的字符串。
 * 如果字符串 words[i] 与字符串 words[j] 满足以下条件，我们称它们可以匹配：
 * 字符串 words[i] 等于 words[j] 的反转字符串 
 * 0 <= i < j < words.length
 * 请你返回数组 words 中的 最大 匹配数目。
 * 注意，每个字符串最多匹配一次。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/find-maximum-number-of-string-pairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A {
    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        
        var map = new HashMap<String, Integer>();
        for(String word : words){
            var sb = new StringBuilder(word);
            if(map.containsKey(sb.reverse().toString())){
                ans++;
            }
            else{
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
                
        }
        return ans;
    }
}
