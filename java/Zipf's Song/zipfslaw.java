import java.util.*;
import java.util.regex.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.*;


class Song implements Comparable<Song>{
	double qi;
	String title;
	double position;
	
	public Song(double qi, String title, double position){
		this.title=title;
		this.qi=qi;
		this.position=position;
	}
	
	public String toString(){return ("song '"+title+"' with qi "+qi); }
	
	@Override
	public int compareTo(Song other){
		if(this.qi > other.qi) //puts higher quality first
			return -1;
		else if (this.qi == other.qi) //if quality is the same
			return (this.position < other.position) ? -1 : 1; //puts lower album num first
		else
			return 1;
	}
}

public class zipfslaw {
	public static void main (String[] args){
		Kattio io = new Kattio(System.in, System.out);
		Song[] songs; 
		int n, m = 0;
		double position, fi, qi=0;
		String title="";
		n=io.getInt();
		m=io.getInt();
		songs = new Song[n];
		
		for(int i=0; i<n; i++){
			fi=io.getDouble();
			qi=fi*(i+1);
			title=io.getWord();
			songs[i]=new Song(qi, title, i);
		}
		
		Arrays.sort(songs);
		for(int i=0; i<m; i++){
			io.println(songs[i].title);
		}
		io.close();
	}
	
	static class Kattio extends PrintWriter {
		public Kattio(InputStream i) {
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public Kattio(InputStream i, OutputStream o) {
			super(new BufferedOutputStream(o));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public boolean hasMoreTokens() {
			return peekToken() != null;
		}

		public int getInt() {
			return Integer.parseInt(nextToken());
		}

		public double getDouble() {
			return Double.parseDouble(nextToken());
		}

		public long getLong() {
			return Long.parseLong(nextToken());
		}

		public String getWord() {
			return nextToken();
		}

		private BufferedReader r;
		private String line;
		private StringTokenizer st;
		private String token;

		private String peekToken() {
			if (token == null)
				try {
					while (st == null || !st.hasMoreTokens()) {
						line = r.readLine();
						if (line == null)
							return null;
						st = new StringTokenizer(line);
					}
					token = st.nextToken();
				} catch (IOException e) {
				}
			return token;
		}

		private String nextToken() {
			String ans = peekToken();
			token = null;
			return ans;
		}
	}
}