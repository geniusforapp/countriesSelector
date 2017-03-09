
package com.geniusforapp.countries.entites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EntityCountry implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("topLevelDomain")
    @Expose
    private List<String> topLevelDomain = new ArrayList<String>();
    @SerializedName("alpha2Code")
    @Expose
    private String alpha2Code;
    @SerializedName("alpha3Code")
    @Expose
    private String alpha3Code;
    @SerializedName("currencies")
    @Expose
    private List<String> currencies = new ArrayList<String>();
    @SerializedName("callingCodes")
    @Expose
    private List<String> callingCodes = new ArrayList<String>();
    @SerializedName("capital")
    @Expose
    private String capital;
    @SerializedName("altSpellings")
    @Expose
    private List<String> altSpellings = new ArrayList<String>();
    @SerializedName("relevance")
    @Expose
    private String relevance;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("subregion")
    @Expose
    private String subregion;
    @SerializedName("languages")
    @Expose
    private List<String> languages = new ArrayList<String>();
    @SerializedName("translations")
    @Expose
    private Translations translations;
    @SerializedName("population")
    @Expose
    private double population;
    @SerializedName("latlng")
    @Expose
    private List<Double> latlng = new ArrayList<Double>();
    @SerializedName("demonym")
    @Expose
    private String demonym;
    @SerializedName("area")
    @Expose
    private double area;
    @SerializedName("gini")
    @Expose
    private Object gini;
    @SerializedName("timezones")
    @Expose
    private List<String> timezones = new ArrayList<String>();
    @SerializedName("borders")
    @Expose
    private List<String> borders = new ArrayList<String>();
    @SerializedName("nativeName")
    @Expose
    private String nativeName;

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The topLevelDomain
     */
    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    /**
     * @param topLevelDomain The topLevelDomain
     */
    public void setTopLevelDomain(List<String> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    /**
     * @return The alpha2Code
     */
    public String getAlpha2Code() {
        return alpha2Code;
    }

    /**
     * @param alpha2Code The alpha2Code
     */
    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    /**
     * @return The alpha3Code
     */
    public String getAlpha3Code() {
        return alpha3Code;
    }

    /**
     * @param alpha3Code The alpha3Code
     */
    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    /**
     * @return The currencies
     */
    public List<String> getCurrencies() {
        return currencies;
    }

    /**
     * @param currencies The currencies
     */
    public void setCurrencies(List<String> currencies) {
        this.currencies = currencies;
    }

    /**
     * @return The callingCodes
     */
    public List<String> getCallingCodes() {
        return callingCodes;
    }

    /**
     * @param callingCodes The callingCodes
     */
    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    /**
     * @return The capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     * @param capital The capital
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * @return The altSpellings
     */
    public List<String> getAltSpellings() {
        return altSpellings;
    }

    /**
     * @param altSpellings The altSpellings
     */
    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    /**
     * @return The relevance
     */
    public String getRelevance() {
        return relevance;
    }

    /**
     * @param relevance The relevance
     */
    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    /**
     * @return The region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region The region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return The subregion
     */
    public String getSubregion() {
        return subregion;
    }

    /**
     * @param subregion The subregion
     */
    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    /**
     * @return The languages
     */
    public List<String> getLanguages() {
        return languages;
    }

    /**
     * @param languages The languages
     */
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    /**
     * @return The translations
     */
    public Translations getTranslations() {
        return translations;
    }

    /**
     * @param translations The translations
     */
    public void setTranslations(Translations translations) {
        this.translations = translations;
    }

    /**
     * @return The population
     */
    public Double getPopulation() {
        return population;
    }

    /**
     * @param population The population
     */
    public void setPopulation(Double population) {
        this.population = population;
    }

    /**
     * @return The latlng
     */
    public List<Double> getLatlng() {
        return latlng;
    }

    /**
     * @param latlng The latlng
     */
    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }

    /**
     * @return The demonym
     */
    public String getDemonym() {
        return demonym;
    }

    /**
     * @param demonym The demonym
     */
    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    /**
     * @return The area
     */
    public double getArea() {
        return area;
    }

    /**
     * @param area The area
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * @return The gini
     */
    public Object getGini() {
        return gini;
    }

    /**
     * @param gini The gini
     */
    public void setGini(Object gini) {
        this.gini = gini;
    }

    /**
     * @return The timezones
     */
    public List<String> getTimezones() {
        return timezones;
    }

    /**
     * @param timezones The timezones
     */
    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    /**
     * @return The borders
     */
    public List<String> getBorders() {
        return borders;
    }

    /**
     * @param borders The borders
     */
    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    /**
     * @return The nativeName
     */
    public String getNativeName() {
        return nativeName;
    }

    /**
     * @param nativeName The nativeName
     */
    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }


    @Override
    public String toString() {
        return "EntityCountry{" +
                "name='" + name + '\'' +
                ", topLevelDomain=" + topLevelDomain +
                ", alpha2Code='" + alpha2Code + '\'' +
                ", alpha3Code='" + alpha3Code + '\'' +
                ", currencies=" + currencies +
                ", callingCodes=" + callingCodes +
                ", capital='" + capital + '\'' +
                ", altSpellings=" + altSpellings +
                ", relevance='" + relevance + '\'' +
                ", region='" + region + '\'' +
                ", subregion='" + subregion + '\'' +
                ", languages=" + languages +
                ", translations=" + translations +
                ", population=" + population +
                ", latlng=" + latlng +
                ", demonym='" + demonym + '\'' +
                ", area=" + area +
                ", gini=" + gini +
                ", timezones=" + timezones +
                ", borders=" + borders +
                ", nativeName='" + nativeName + '\'' +
                '}';
    }
}
