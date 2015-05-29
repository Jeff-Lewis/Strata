/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.market.curve.config;

import java.time.LocalDate;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.strata.basics.BuySell;
import com.opengamma.strata.basics.market.ObservableKey;
import com.opengamma.strata.finance.Trade;
import com.opengamma.strata.finance.rate.fra.FraTemplate;

/**
 * A curve node whose instrument is a forward rate agreement (FRA).
 */
@BeanDefinition
public final class FraCurveNode implements CurveNode, ImmutableBean {

  /** The template for the FRA associated with this node. */
  @PropertyDefinition(validate = "notNull")
  private final FraTemplate template;

  /** The provider of the rate used for building a trade from the template. */
  @PropertyDefinition(validate = "notNull")
  private final CurveNodeRateProvider rateProvider;

  /**
   * Returns a node whose instrument is built from the template and whose rate is provided by the rate provider.
   *
   * @param template  the template used for building the instrument for the node
   * @param rateProvider  provides the rate used when building the instrument for the node
   * @return a node whose instrument is built from the template and whose rate is provided by the rate provider
   */
  public static FraCurveNode of(FraTemplate template, CurveNodeRateProvider rateProvider) {
    return FraCurveNode.builder().template(template).rateProvider(rateProvider).build();
  }

  /**
   * Returns a node whose instrument is built from the template using a market rate.
   *
   * @param template  the template used for building the instrument for the node
   * @param rateKey  the key identifying the market rate used when building the instrument for the node.
   * @return a node whose instrument is built from the template using a market rate
   */
  public static FraCurveNode ofMarketRate(FraTemplate template, ObservableKey rateKey) {
    CurveNodeMarketRateProvider rateProvider = CurveNodeMarketRateProvider.of(rateKey);
    return FraCurveNode.builder()
        .template(template)
        .rateProvider(rateProvider)
        .build();
  }

  /**
   * Returns a node whose instrument is built from the template using a fixed rate.
   *
   * @param template  the template used for building the instrument for the node
   * @param fixedRate  the rate used when building the instrument
   * @return a node whose instrument is built from the template using a fixed rate
   */
  public static FraCurveNode ofFixedRate(FraTemplate template, double fixedRate) {
    CurveNodeFixedRateProvider rateProvider = CurveNodeFixedRateProvider.of(fixedRate);
    return FraCurveNode.builder()
        .template(template)
        .rateProvider(rateProvider)
        .build();
  }

  @Override
  public Set<ObservableKey> requirements() {
    return rateProvider.requirements();
  }

  @Override
  public Trade buildTrade(LocalDate valuationDate, Map<ObservableKey, Double> marketData) {
    BuySell buySell = BuySell.BUY;
    double notional = 1;
    double fixedRate = rateProvider.rate(marketData);
    return template.toTrade(valuationDate, buySell, notional, fixedRate);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code FraCurveNode}.
   * @return the meta-bean, not null
   */
  public static FraCurveNode.Meta meta() {
    return FraCurveNode.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(FraCurveNode.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static FraCurveNode.Builder builder() {
    return new FraCurveNode.Builder();
  }

  private FraCurveNode(
      FraTemplate template,
      CurveNodeRateProvider rateProvider) {
    JodaBeanUtils.notNull(template, "template");
    JodaBeanUtils.notNull(rateProvider, "rateProvider");
    this.template = template;
    this.rateProvider = rateProvider;
  }

  @Override
  public FraCurveNode.Meta metaBean() {
    return FraCurveNode.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the template for the FRA associated with this node.
   * @return the value of the property, not null
   */
  public FraTemplate getTemplate() {
    return template;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the provider of the rate used for building a trade from the template.
   * @return the value of the property, not null
   */
  public CurveNodeRateProvider getRateProvider() {
    return rateProvider;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      FraCurveNode other = (FraCurveNode) obj;
      return JodaBeanUtils.equal(getTemplate(), other.getTemplate()) &&
          JodaBeanUtils.equal(getRateProvider(), other.getRateProvider());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getTemplate());
    hash = hash * 31 + JodaBeanUtils.hashCode(getRateProvider());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("FraCurveNode{");
    buf.append("template").append('=').append(getTemplate()).append(',').append(' ');
    buf.append("rateProvider").append('=').append(JodaBeanUtils.toString(getRateProvider()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code FraCurveNode}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code template} property.
     */
    private final MetaProperty<FraTemplate> template = DirectMetaProperty.ofImmutable(
        this, "template", FraCurveNode.class, FraTemplate.class);
    /**
     * The meta-property for the {@code rateProvider} property.
     */
    private final MetaProperty<CurveNodeRateProvider> rateProvider = DirectMetaProperty.ofImmutable(
        this, "rateProvider", FraCurveNode.class, CurveNodeRateProvider.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "template",
        "rateProvider");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -1321546630:  // template
          return template;
        case -787949839:  // rateProvider
          return rateProvider;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public FraCurveNode.Builder builder() {
      return new FraCurveNode.Builder();
    }

    @Override
    public Class<? extends FraCurveNode> beanType() {
      return FraCurveNode.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code template} property.
     * @return the meta-property, not null
     */
    public MetaProperty<FraTemplate> template() {
      return template;
    }

    /**
     * The meta-property for the {@code rateProvider} property.
     * @return the meta-property, not null
     */
    public MetaProperty<CurveNodeRateProvider> rateProvider() {
      return rateProvider;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -1321546630:  // template
          return ((FraCurveNode) bean).getTemplate();
        case -787949839:  // rateProvider
          return ((FraCurveNode) bean).getRateProvider();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code FraCurveNode}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<FraCurveNode> {

    private FraTemplate template;
    private CurveNodeRateProvider rateProvider;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(FraCurveNode beanToCopy) {
      this.template = beanToCopy.getTemplate();
      this.rateProvider = beanToCopy.getRateProvider();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -1321546630:  // template
          return template;
        case -787949839:  // rateProvider
          return rateProvider;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -1321546630:  // template
          this.template = (FraTemplate) newValue;
          break;
        case -787949839:  // rateProvider
          this.rateProvider = (CurveNodeRateProvider) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public FraCurveNode build() {
      return new FraCurveNode(
          template,
          rateProvider);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code template} property in the builder.
     * @param template  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder template(FraTemplate template) {
      JodaBeanUtils.notNull(template, "template");
      this.template = template;
      return this;
    }

    /**
     * Sets the {@code rateProvider} property in the builder.
     * @param rateProvider  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder rateProvider(CurveNodeRateProvider rateProvider) {
      JodaBeanUtils.notNull(rateProvider, "rateProvider");
      this.rateProvider = rateProvider;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(96);
      buf.append("FraCurveNode.Builder{");
      buf.append("template").append('=').append(JodaBeanUtils.toString(template)).append(',').append(' ');
      buf.append("rateProvider").append('=').append(JodaBeanUtils.toString(rateProvider));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
