package br.com.aurum.bitcoin.fabio.quotation;

public enum QuotationType {

	SELL(1, "sell"),
	BUY(2, "buy");
	
	private int id;
	private String description;
	
	private QuotationType(int id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	
	public String getDescription () {
		return description;
	}
	
	@SuppressWarnings({ "static-access", "unlikely-arg-type" })
	public static QuotationType toEnum(String name) {
		
		if (name == null) {
			return null;
		}
		
		for (QuotationType quotationType : QuotationType.values()) {
			if (name.equals(quotationType.valueOf(name))) {
				return quotationType;
			}
		}
		
		throw new IllegalArgumentException("Inválid type: " + name);
	}	
	
}
