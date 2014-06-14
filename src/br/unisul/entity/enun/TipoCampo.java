package br.unisul.entity.enun;

public enum TipoCampo {

	SOCIETY, FUTSAL;

	public static TipoCampo getByString(String value) {

		try {

			return TipoCampo.valueOf(value);

		} catch (Exception e) {

			return null;
		}
	}
}
