
package simplilearn.java.phase1;
import java.io.*;

public class MyFilenameFilter implements FilenameFilter {
	String initials;
	
	public MyFilenameFilter(String initials) {
		this.initials=initials;
	}
	public boolean accept( File dir, String name) {
		return name.startsWith(initials);
	}

	


}
