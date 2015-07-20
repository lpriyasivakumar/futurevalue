import java.io.Serializable;


public class FutureValue implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int years;
	private double amount;
	private String futureValue;
		
	public FutureValue(){
		years=0;
		amount = 0;			
	}
	public FutureValue(int years, double amount){
		this.years = years;
		this.amount = amount;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getFutureValue() {
		return futureValue;
	}
	public void setFutureValue(String futureValue) {
		this.futureValue = futureValue;
	}
	

}
