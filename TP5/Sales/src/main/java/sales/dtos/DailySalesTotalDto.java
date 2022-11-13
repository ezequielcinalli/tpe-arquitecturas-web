package sales.dtos;

import java.util.Date;

public class DailySalesTotalDto {
	
	public Date date;
	
	public double total;

	public DailySalesTotalDto(Date date, double total) {
		super();
		this.date = date;
		this.total = total;
	}
	
}
