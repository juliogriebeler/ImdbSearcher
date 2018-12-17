package br.com.juliogriebeler.imdbsearcher.batch.model;

import java.util.List;

/**
 * The Class Trade.
 * 
 * @author Julio
 */
public class TitleBasicProcessed {
	private String tconst;
	private String titleType;
	private String primaryTitle;
	private String originalTitle;
	private boolean isAdult;
	private Long startYear;
	private Long endYear;
	private Long runtimeMinutes;
	private List<String> genres;

	public TitleBasicProcessed() {
	}

	/**
	 * @param tconst
	 * @param titleType
	 * @param primaryTitle
	 * @param originalTitle
	 * @param isAdult
	 * @param startYear
	 * @param endYear
	 * @param runtimeMinutes
	 * @param genres
	 */
	public TitleBasicProcessed(String tconst, String titleType, String primaryTitle, String originalTitle,
			boolean isAdult, Long startYear, Long endYear, Long runtimeMinutes, List<String> genres) {
		super();
		this.tconst = tconst;
		this.titleType = titleType;
		this.primaryTitle = primaryTitle;
		this.originalTitle = originalTitle;
		this.isAdult = isAdult;
		this.startYear = startYear;
		this.endYear = endYear;
		this.runtimeMinutes = runtimeMinutes;
		this.genres = genres;
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
	public boolean isAdult() {
		return isAdult;
	}

	/**
	 * @param isAdult
	 *            the isAdult to set
	 */
	public void setAdult(boolean isAdult) {
		this.isAdult = isAdult;
	}

	/**
	 * @return the startYear
	 */
	public Long getStartYear() {
		return startYear;
	}

	/**
	 * @param startYear
	 *            the startYear to set
	 */
	public void setStartYear(Long startYear) {
		this.startYear = startYear;
	}

	/**
	 * @return the endYear
	 */
	public Long getEndYear() {
		return endYear;
	}

	/**
	 * @param endYear
	 *            the endYear to set
	 */
	public void setEndYear(Long endYear) {
		this.endYear = endYear;
	}

	/**
	 * @return the runtimeMinutes
	 */
	public Long getRuntimeMinutes() {
		return runtimeMinutes;
	}

	/**
	 * @param runtimeMinutes
	 *            the runtimeMinutes to set
	 */
	public void setRuntimeMinutes(Long runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}

	/**
	 * @return the genres
	 */
	public List<String> getGenres() {
		return genres;
	}

	/**
	 * @param genres
	 *            the genres to set
	 */
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	@Override
	public String toString() {
		return "TitleBasicProcessed [tconst = " + tconst + ", titleType = " + titleType + ", primaryTitle = "
				+ primaryTitle + ", originalTitle = " + originalTitle + ", isAdult = " + isAdult + ", startYear = "
				+ startYear + ", endYear = " + endYear + ", runtimeMinutes = " + runtimeMinutes + ", genres = " + genres
				+ " ]";
	}
}
