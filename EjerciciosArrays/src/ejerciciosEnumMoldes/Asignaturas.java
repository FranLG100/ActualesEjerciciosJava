package ejerciciosEnumMoldes;

public enum Asignaturas {
		MATEMATICAS("MAT"),
		LENGUAJE("LG"),
		SOCIALES("SOC"), 
		PLASTICA("PLA"),
		BIOLOGIA("BIO");
		
		private String abreviatura;
	
		Asignaturas(String abreviatura){
			this.abreviatura=abreviatura;
		}
		
		public String getAbreviatura() {
			return abreviatura;
		}
}
