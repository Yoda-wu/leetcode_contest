package lc1600_1700.dp;

/**
 * 这道题考虑道路的一侧就好，因为道理两旁的房屋放置不影响
 * 那么对于第i个地块，有两种情况：
 *  不放房子 ： f[i] = f[i-1]那么第i-1个地块可放也可不放
 *  放房子: 那么第i-1个地块必须不放，那么第i-2个地块可放也可不放f[i] = f[i-2];
 * 故 f[i] = f[i-1] + f[i-2]
 */
public class CountHousePlacements {
    static final int MOD = (int)1e9 + 7, MX = (int) 1e4 + 1;
    static final int[] f = new int[MX];
    static {
        f[0] = 1;
        f[1] = 2;
        for (var i = 2; i < MX; ++i)
            f[i] = (f[i - 1] + f[i - 2]) % MOD;
    }
    public int countHousePlacements(int n) {
        return(int)((long)f[n]*f[n] % MOD);
    }
}
