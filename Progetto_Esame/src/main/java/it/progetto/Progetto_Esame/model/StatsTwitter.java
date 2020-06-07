package it.progetto.Progetto_Esame.model;

/**
 * <p>
 * 	<b>Classe</b> <i>StatsTwitter</i> per la creazione di oggetti StatsTwitter
 * </p>
 * @author Saraceno Alberto Zaccaria
 * @author Totta Giovanni
 * @version 1.0
 */
public class StatsTwitter {
	/**
	 * Indica il campo sul quale calcolare le statistiche
	 */
	private String field;
	/**
	 * Indica la media dei valori
	 */
	private Long average;
	/**
	 * Indica il minimo tra i valori
	 */
	private Long min;
	/**
	 * Indica il massimo tra i valori
	 */
	private Long max;
	/**
	 * Indica la somma dei valori
	 */
	private Long sum;
	/**
	 * Indica il numero di tweet analizzati
	 */
	private Long count;
	/**
	 * Indica la deviazione standard dei valori
	 */
	private double standardDeviation;
	/**
	 * Indica la moda dei valori
	 */
	private Long moda;
	
	/**
	 * Costruttore
	 * @param field
	 */
	public StatsTwitter(String field) {
		super();
		this.field = field;
	}
	
	public StatsTwitter(String field, Long average, Long min, Long max, Long sum, Long count, double standardDeviation, Long moda) {
		super();
		this.field = field;
		this.average = average;
		this.min = min;
		this.max = max;
		this.sum = sum;
		this.count = count;
		this.standardDeviation = standardDeviation;
		this.moda = moda;
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
	public double getStandardDeviation() {
		return standardDeviation;
	}
	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
	public Long getModa() {
		return moda;
	}

	public void setModa(Long moda) {
		this.moda = moda;
	}
}
