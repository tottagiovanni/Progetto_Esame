package it.progetto.Progetto_Esame.model;

public class StatsTwitter {
	private String field;
	private Long average;
	private Long min;
	private Long max;
	private Long sum;
	private Long count;
	
	public StatsTwitter(String field, Long average, Long min, Long max, Long sum, Long count) {
		super();
		this.field = field;
		this.average = average;
		this.min = min;
		this.max = max;
		this.sum = sum;
		this.count = count;
	}
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Long getAverage() {
		return average;
	}
	public void setAverage(Long average) {
		this.average = average;
	}
	public Long getMin() {
		return min;
	}
	public void setMin(Long min) {
		this.min = min;
	}
	public Long getMax() {
		return max;
	}
	public void setMax(Long max) {
		this.max = max;
	}
	public Long getSum() {
		return sum;
	}
	public void setSum(Long sum) {
		this.sum = sum;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
}
