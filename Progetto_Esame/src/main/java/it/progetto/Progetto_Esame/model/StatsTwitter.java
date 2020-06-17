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
	 * Indica il numero di tweets analizzati
	 */
	private Long count;
	/**
	 * Indica la deviazione standard dei valori
	 */
	private double standardDeviation;
	/**
	 * Indica la moda dei valori
	 */
	private Long mode;
	
	/**
	 * Costruttore che inizializza l'attributo field della classe
	 * @param field nome del campo
	 */
	public StatsTwitter(String field) {
		super();
		this.field = field;
	}
	
	/**
	 * Costruttore che inizializza gli attributi della classe
	 * @param field nome del campo 
	 * @param average media dei valori
	 * @param min minimo dei valori
	 * @param max massimo dei valori
	 * @param sum somma dei valori
	 * @param count numero di tweets
	 * @param standardDeviation deviazione standard dei valori
	 * @param mode moda dei valori
	 */
	public StatsTwitter(String field, Long average, Long min, Long max, Long sum, Long count, double standardDeviation, Long mode) {
		super();
		this.field = field;
		this.average = average;
		this.min = min;
		this.max = max;
		this.sum = sum;
		this.count = count;
		this.standardDeviation = standardDeviation;
		this.mode = mode;
	}
	
	/**
	 * Metodo get per l'attributo field
	 * @return attributo field di tipo <code>String</code> 
	 */
	public String getField() {
		return field;
	}
	
	/**
	 * Metodo set per l'attributo field
	 * @param field nome del campo
	 */
	public void setField(String field) {
		this.field = field;
	}
	
	/**
	 * Metodo get per l'attributo average
	 * @return attributo average di tipo <code>Long</code> 
	 */
	public Long getAverage() {
		return average;
	}
	
	/**
	 * Metodo set per l'attributo average
	 * @param average media dei valori
	 */
	public void setAverage(Long average) {
		this.average = average;
	}
	
	/**
	 * Metodo get per l'attributo min
	 * @return attributo min di tipo <code>Long</code> 
	 */
	public Long getMin() {
		return min;
	}
	
	/**
	 * Metodo set per l'attributo min
	 * @param min minimo dei valori
	 */
	public void setMin(Long min) {
		this.min = min;
	}
	
	/**
	 * Metodo get per l'attributo max
	 * @return attributo max di tipo <code>Long</code> 
	 */
	public Long getMax() {
		return max;
	}
	
	/**
	 * Metodo set per l'attributo max
	 * @param max massimo dei valori
	 */
	public void setMax(Long max) {
		this.max = max;
	}
	
	/**
	 * Metodo get per l'attributo sum
	 * @return attributo sum di tipo <code>Long</code> 
	 */
	public Long getSum() {
		return sum;
	}
	
	/**
	 * Metodo set per l'attributo sum
	 * @param sum somma dei valori
	 */
	public void setSum(Long sum) {
		this.sum = sum;
	}
	
	/**
	 * Metodo get per l'attributo count
	 * @return attributo count di tipo <code>Long</code> 
	 */
	public Long getCount() {
		return count;
	}
	
	/**
	 * Metodo set per l'attributo count
	 * @param count numero di tweets
	 */
	public void setCount(Long count) {
		this.count = count;
	}
	
	/**
	 * Metodo get per l'attributo standardDeviation
	 * @return attributo standardDeviation di tipo <code>Long</code> 
	 */
	public double getStandardDeviation() {
		return standardDeviation;
	}
	
	/**
	 * Metodo set per l'attributo standardDeviation
	 * @param standardDeviation deviazione standard dei valori
	 */
	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
	
	/**
	 * Metodo get per l'attributo mode
	 * @return attributo mode di tipo <code>Long</code> 
	 */
	public Long getMode() {
		return mode;
	}

	/**
	 * Metodo set per l'attributo mode
	 * @param mode moda dei valori
	 */
	public void setMode(Long mode) {
		this.mode = mode;
	}
}
