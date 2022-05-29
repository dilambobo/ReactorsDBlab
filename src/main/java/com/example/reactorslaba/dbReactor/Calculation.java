package com.example.reactorslaba.dbReactor;

import java.util.ArrayList;

public class Calculation {

    public Calculation(DBConnector dbConnector) {
        calcSite(dbConnector);
        calcCompany(dbConnector);
        calcCountry(dbConnector);
        calcRegion(dbConnector);
    }

    public void calcSite(DBConnector dbConnector) {

        ArrayList<Unit> units = dbConnector.getUnits();
        ArrayList<Site> sites = dbConnector.getSites();

        for (Site site: sites) {
            for (Unit unit : units) {
                if (site.getId() == unit.getSiteID()) {
                    site.setConsumption(unit.getConsumption());
                    site.setCol(1);
                }
            }
        }
    }

    public void calcCompany(DBConnector dbConnector) {

        ArrayList<Site> sites = dbConnector.getSites();
        ArrayList<Company> companies = dbConnector.getCompanies();

        for (Site site: sites) {
            for (Company company : companies) {
                if (company.getId() == site.getCompanyID()) {
                    company.setConsumption(site.getConsumption());
                    company.setCol(1);
                }
            }
        }
    }

    public void calcCountry(DBConnector dbConnector) {

        ArrayList<Site> sites = dbConnector.getSites();
        ArrayList<Country> countries = dbConnector.getCountries();

        for (Site site: sites) {
            for (Country country : countries) {
                if (site.getCountryID() == country.getId()) {
                    country.setConsumption(site.getConsumption());
                    country.setCol(1);
                }
            }
        }
    }

    public void calcRegion(DBConnector dbConnector) {

        ArrayList<Region> regions = dbConnector.getRegions();
        ArrayList<Country> countries = dbConnector.getCountries();

        for (Region region: regions) {
            for (Country country : countries) {
                if (region.getId() == country.getRegionID()) {
                    region.setConsumption(country.getConsumption());
                    region.setCol(1);
                }
            }
        }
    }
}
