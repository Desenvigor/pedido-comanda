package entidades;

public enum OrderStatus {
	PENDING_PAYMENT(0), PROCESSING(1), SHIPPED(2), DELIVERED(3);

	@SuppressWarnings(value =  { "unused" })
	private int value;
	
	OrderStatus(int i) {
		value = i;
	}
}
