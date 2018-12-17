package br.com.juliogriebeler.imdbsearcher.batch.model;

/**
 * The Class TitleBasic.
 * 
 * @author Julio
 */
public class TitleBasicIn {

	private String tconst;
	private String titleType;
	private String primaryTitle;
	private String originalTitle;
	private String isAdult;
	private String startYear;
	private String endYear;
	private String runtimeMinutes;
	private String genres;

	public TitleBasicIn() {
	}

	/**
	 * @return the tconst
	 */
	public String getTconst() {
		return tconst;
	}

	/**
	 * @param tconst
	 *            the tconst to set
	 */
	public void setTconst(String tconst) {
		this.tconst = tconst;
	}

	/**
	 * @return the titleType
	 */
	public String getTitleType() {
		return titleType;
	}

	/**
	 * @param titleType
	 *            the titleType to set
	 */
	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	/**
	 * @return the primaryTitle
	 */
	public String getPrimaryTitle() {
		return primaryTitle;
	}

	/**
	 * @param primaryTitle
	 *            the primaryTitle to set
	 */
	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}

	/**
	 * @return the originalTitle
	 */
	public String getOriginalTitle() {
		return originalTitle;
	}

	/**
	 * @param originalTitle
	 *            the originalTitle to set
	 */
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	/**
	 * @return the isAdult
	 */
	public String getIsAdult() {
		return isAdult;
	}

	/**
	 * @param isAdult
	 *            the isAdult to set
	 */
	public void setIsAdult(String isAdult) {
		this.isAdult = isAdult;
	}

	/**
	 * @return the startYear
	 */
	public String getStartYear() {
		return startYear;
	}

	/**
	 * @param startYear
	 *            the startYear to set
	 */
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	/**
	 * @return the endYear
	 */
	public String getEndYear() {
		return endYear;
	}

	/**
	 * @param endYear
	 *            the endYear to set
	 */
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	/**
	 * @return the runtimeMinutes
	 */
	public String getRuntimeMinutes() {
		return runtimeMinutes;
	}

	/**
	 * @param runtimeMinutes
	 *            the runtimeMinutes to set
	 */
	public void setRuntimeMinutes(String runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}

	/**
	 * @return the genres
	 */
	public String getGenres() {
		return genres;
	}

	/**
	 * @param genres
	 *            the genres to set
	 */
	public void setGenres(String genres) {
		this.genres = genres;
	}

	@Override
	public String toString() {
		return "TitleBasic [tconst = " + tconst + ", titleType = " + titleType + ", primaryTitle = " + primaryTitle
				+ ", originalTitle = " + originalTitle + ", isAdult = " + isAdult + ", startYear = " + startYear
				+ ", endYear = " + endYear + ", runtimeMinutes = " + runtimeMinutes + ", genres = " + genres.toString()
				+ " ]";
	}
}
