package beans;

public class ConversorCF {
	
	private float celsius;
	private float fahrenheit;
	
	public ConversorCF(float temp, char tipo) {
		if (tipo == 'c') {
			celsius = temp;
			fahrenheit = celsius * 9/5 + 32;
		}
		if (tipo == 'f') {
			fahrenheit = temp;
			celsius = (fahrenheit - 32) * 5/9;
		}
	}

	public float getCelsius() {
		return celsius;
	}

	public float getFahrenheit() {
		return fahrenheit;
	}
}
