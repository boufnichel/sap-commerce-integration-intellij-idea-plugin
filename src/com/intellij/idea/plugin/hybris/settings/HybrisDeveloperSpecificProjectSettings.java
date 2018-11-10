package com.intellij.idea.plugin.hybris.settings;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HybrisDeveloperSpecificProjectSettings {

    protected String activeRemoteConnectionID;
    protected List<HybrisRemoteConnectionSettings> remoteConnectionSettingsList = new ArrayList<>();
    protected SolrConnectionSettings solrRemoteConnectionSettings;

    public List<HybrisRemoteConnectionSettings> getRemoteConnectionSettingsList() {
        return remoteConnectionSettingsList;
    }

    public void setRemoteConnectionSettingsList(final List<HybrisRemoteConnectionSettings> remoteConnectionSettingsList) {
        this.remoteConnectionSettingsList = remoteConnectionSettingsList;
    }

    public String getActiveRemoteConnectionID() {
        return activeRemoteConnectionID;
    }

    public void setActiveRemoteConnectionID(final String activeRemoteConnectionID) {
        this.activeRemoteConnectionID = activeRemoteConnectionID;
    }

    public SolrConnectionSettings getSolrConnectionSettings() {
        return solrRemoteConnectionSettings;
    }

    public void setSolrConnectionSettings(final SolrConnectionSettings solrRemoteConnectionSettings) {
        this.solrRemoteConnectionSettings = solrRemoteConnectionSettings;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final HybrisDeveloperSpecificProjectSettings that = (HybrisDeveloperSpecificProjectSettings) o;
        return getActiveRemoteConnectionID().equals(that.getActiveRemoteConnectionID()) &&
               Objects.equals(getRemoteConnectionSettingsList(), that.getRemoteConnectionSettingsList()) &&
               Objects.equals(getSolrConnectionSettings(), that.getSolrConnectionSettings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActiveRemoteConnectionID(), getRemoteConnectionSettingsList());
    }
}
