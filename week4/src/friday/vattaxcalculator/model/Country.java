package friday.vattaxcalculator.model;

public final class Country {
	private final String mCountryName;
	private final int mVatRate;
	private final int mCountryCode;
	private final boolean mIsDefault;
	private final CurrencyCourse mCurrency;

	public Country(String countryName, int vat, int countryCode,
			boolean isDefault, CurrencyCourse currency) {
		this.mCountryName = countryName;
		this.mVatRate = vat;
		this.mCountryCode = countryCode;
		this.mIsDefault = isDefault;
		this.mCurrency = currency;
	}

	public int getVat() {
		return mVatRate;
	}

	public int getCountryCode() {
		return mCountryCode;
	}

	public boolean isDefault() {
		return mIsDefault;
	}

	public CurrencyCourse getCurrency() {
		return mCurrency;
	}

	public String getCountryName() {
		return mCountryName;
	}

	@Override
	public String toString() {
		return mCountryName + " [vat=" + mVatRate + ", code=" + mCountryCode
				+ ", isDefault=" + mIsDefault + ", currency=" + mCurrency + "]";
	}
}
