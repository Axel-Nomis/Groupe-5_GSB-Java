package gsb.modele;

public class Medicament {
	protected String MedDepotLegal;
	protected String MedNomCommercial;
	protected String MedComposition;
	protected String MedEffets;
	protected String MedContreIndic;
	protected String MedPrixEchantillon;
	protected String FamCode;
	protected String FamLibelle;

	/**
	 * @param MedDepotLegal
	 * @param MedNomCommercial
	 * @param MedComposition
	 * @param MedEffets
	 * @param MedContreIndic
	 * @param MedPrixEchantillon
	 * @param FamCode
	 * @param FamLibelle
	 */
	public Medicament(String MedDepotLegal, String MedNomCommercial, String MedComposition, String MedEffets,
			String MedContreIndic, String MedPrixEchantillon, String FamCode, String FamLibelle) {
		this.MedDepotLegal = MedDepotLegal;
		this.MedNomCommercial = MedNomCommercial;
		this.MedComposition = MedComposition;
		this.MedEffets = MedEffets;
		this.MedContreIndic = MedContreIndic;
		this.MedPrixEchantillon = MedPrixEchantillon;
		this.FamCode = FamCode;
		this.FamLibelle = FamLibelle;
	}

	public String getMedDepotLegal() {
		return MedDepotLegal;
	}

	public void setMedDepotLegal(String medDepotLegal) {
		MedDepotLegal = medDepotLegal;
	}

	public String getMedNomCommercial() {
		return MedNomCommercial;
	}

	public void setMedNomCommercial(String medNomCommercial) {
		MedNomCommercial = medNomCommercial;
	}

	public String getMedComposition() {
		return MedComposition;
	}

	public void setMedComposition(String medComposition) {
		MedComposition = medComposition;
	}

	public String getMedEffets() {
		return MedEffets;
	}

	public void setMedEffets(String medEffets) {
		MedEffets = medEffets;
	}

	public String getMedContreIndic() {
		return MedContreIndic;
	}

	public void setMedContreIndic(String medContreIndic) {
		MedContreIndic = medContreIndic;
	}

	public String getMedPrixEchantillon() {
		return MedPrixEchantillon;
	}

	public void setMedPrixEchantillon(String medPrixEchantillon) {
		MedPrixEchantillon = medPrixEchantillon;
	}

	public String getFamCode() {
		return FamCode;
	}

	public void setFamCode(String famCode) {
		FamCode = famCode;
	}

	public String getFamLibelle() {
		return FamLibelle;
	}

	public void setFamLibelle(String famLibelle) {
		FamLibelle = famLibelle;
	}

}
