import java.util.*;

public class CheckingAccount extends Account
{
	private int checksWritten;
	
	public CheckingAccount(double initBalance)
	{
		super(initBalance);
		this.checksWritten = 0;	
	}

	public int getChecksWritten()
	{
		return checksWritten;
	}

	public void writeCheck(double amt)
	{
		checksWritten++;
		withdraw(amt);
	}
}
