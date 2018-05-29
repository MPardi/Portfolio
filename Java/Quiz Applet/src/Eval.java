package project04;
//original algorithm created by stack overflow user Boann
//algorithm has been released to public domain and has zero copyright
//https://stackoverflow.com/a/26227947
//https://creativecommons.org/publicdomain/zero/1.0/
//modified by Tain Henning
public class Eval 
{
	public static double Eval(final String str) 
	{
	    return new Object() 
	    {
	        int pos = -1, ch;

	        public void next() 
	        {
	        	if(++pos < str.length())
	        		ch = str.charAt(pos);
	        	else
	        		ch = -1;
	        }

	        public boolean skip(int charToEat) 
	        {
	            while (ch == ' ') 
	            	next();
	            if (ch == charToEat) 
	            {
	                next();
	                return true;
	            }
	            return false;
	        }

	        public double parse() 
	        {
	            next();
	            return parseExpression();
	        }

	        public double parseExpression() 
	        {
	            double x = parseTerm();
	            while(true) 
	            {
	                if(skip('+')) 
	                	x += parseTerm();
	                else if (skip('-')) 
	                	x -= parseTerm();
	                else return x;
	            }
	        }

	        public double parseTerm() 
	        {
	            double x = parseFactor();
	            while(true) 
	            {
	                if (skip('*')) 
	                	x *= parseFactor();
	                else if (skip('/')) 
	                	x /= parseFactor();
	                else if (skip('%'))
	                	x = x % parseFactor();
	                else return x;
	            }
	        }

	        double parseFactor() 
	        {
	            if (skip('+')) 
	            	return parseFactor();
	            if (skip('-')) 
	            	return -parseFactor();

	            double x;
	            int startPos = this.pos;
	            if (skip('(')) 
	            { 
	                x = parseExpression();
	                skip(')');
	            } 
	            else if ((ch >= '0' && ch <= '9') || ch == '.') 
	            { 
	                while ((ch >= '0' && ch <= '9') || ch == '.') 
	                	next();
	                x = Double.parseDouble(str.substring(startPos, this.pos));
	            }
	            else if (ch >= 'a' && ch <= 'z') 
	            { 
	                while (ch >= 'a' && ch <= 'z') 
	                	next();
	                String func = str.substring(startPos, this.pos);
	                x = parseFactor();
	                if (func.equals("s")) 
	                	x = Math.sqrt(x);
	                else 
	                	throw new RuntimeException("Unknown function: " + func);
	            } 
	            else
	                throw new RuntimeException("Unexpected: " + (char)ch);
	            if (skip('^')) 
	            	x = Math.pow(x, parseFactor());
	            return x;
	        }
	    }.parse();
	}
}