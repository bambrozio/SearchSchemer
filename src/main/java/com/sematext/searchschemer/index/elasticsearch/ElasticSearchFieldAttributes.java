package com.sematext.searchschemer.index.elasticsearch;

import com.sematext.searchschemer.client.ConfigurationType;
import com.sematext.searchschemer.index.AbstractFieldAttributes;

/**
 * Fields from ElasticSearch mappings.
 * 
 * @author Sematext
 * 
 */
public final class ElasticSearchFieldAttributes extends AbstractFieldAttributes {
  private String analyzed = "analyzed";
  private String stored = "no";

  /**
   * Constructor.
   */
  public ElasticSearchFieldAttributes() {
    super();
  }

  /**
   * Create field attribute.
   * 
   * @param name
   *          field name
   * @param type
   *          attribute type
   * @param stored
   *          is field stored (value 'no' or 'yes')
   * @param analyzed
   *          is field analyzed (value 'no', 'analyzed' or 'not_analyzed')
   */
  public ElasticSearchFieldAttributes(String name, String type, String stored, String analyzed) {
    this();
    this.name = name;
    this.type = type;
    this.stored = stored;
    this.analyzed = analyzed;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean analyzed() {
    if (Analyzed.ANALYZED.toString().compareTo(analyzed.toUpperCase()) == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean store() {
    if (Stored.YES.toString().compareTo(stored.toUpperCase()) == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean indexed() {
    if (Analyzed.NO.toString().compareTo(analyzed.toUpperCase()) == 0) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean multiValued() {
    return true; // this is always true in case of ElasticSearch as in Lucene
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ConfigurationType getConfigurationType() {
    return ConfigurationType.ELASTICSEARCH;
  }
  
  public void setAnalyzed(String analyzed) {
    this.analyzed = analyzed;
  }

  public void setStored(String stored) {
    this.stored = stored;
  }
}
