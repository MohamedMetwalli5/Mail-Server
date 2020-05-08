package eg.edu.alexu.csd.datastructure.mailServer;

public class filter implements IFilter {
	private String kindfilter;
	private String namefilter;
	public void Setkindfilter(String name) {
		kindfilter=name;
	}
	public String getkindfilter() {
		return kindfilter;
	}
	public void Setnamefilter(String name) {
		namefilter=name;
	}
	public String getnamefilter() {
		return namefilter;
	}
	// Returns true if s1 is substring of s2 
    public int isSubstring(String s1, String s2) 
    { 
        int M = s1.length(); 
        int N = s2.length(); 
      
        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) { 
            int j; 
      
            /* For current index i, check for 
            pattern match */
            for (j = 0; j < M; j++) 
                if (s2.charAt(i + j) != s1.charAt(j)) 
                    break; 
      
            if (j == M) 
                return i; 
        } 
      
        return -1; 
    } 

}
