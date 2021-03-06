/*
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.market.curve;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;
import org.joda.beans.impl.direct.DirectPrivateBeanBuilder;

import com.opengamma.strata.data.MarketDataId;
import com.opengamma.strata.data.ObservableSource;

/**
 * An identifier used to access a curve group by name.
 * <p>
 * This is used when there is a need to obtain an instance of {@link CurveGroup}.
 */
@BeanDefinition(builderScope = "private", cacheHashCode = true)
public final class CurveGroupId
    implements MarketDataId<CurveGroup>, ImmutableBean, Serializable {

  /**
   * The curve group name.
   */
  @PropertyDefinition(validate = "notNull")
  private final CurveGroupName curveGroupName;
  /**
   * The source of observable market data.
   */
  @PropertyDefinition(validate = "notNull")
  private final ObservableSource observableSource;

  //-------------------------------------------------------------------------
  /**
   * Obtains an instance used to obtain a curve group by name.
   *
   * @param groupName  the curve group name
   * @return the identifier
   */
  public static CurveGroupId of(String groupName) {
    return new CurveGroupId(CurveGroupName.of(groupName), ObservableSource.NONE);
  }

  /**
   * Obtains an instance used to obtain a curve group by name.
   *
   * @param groupName  the curve group name
   * @return the identifier
   */
  public static CurveGroupId of(CurveGroupName groupName) {
    return new CurveGroupId(groupName, ObservableSource.NONE);
  }

  /**
   * Obtains an instance used to obtain a curve group by name, specifying the source of observable market data.
   *
   * @param groupName  the curve group name
   * @param obsSource  source of observable market data
   * @return the identifier
   */
  public static CurveGroupId of(CurveGroupName groupName, ObservableSource obsSource) {
    return new CurveGroupId(groupName, obsSource);
  }

  //-------------------------------------------------------------------------
  @Override
  public Class<CurveGroup> getMarketDataType() {
    return CurveGroup.class;
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code CurveGroupId}.
   * @return the meta-bean, not null
   */
  public static CurveGroupId.Meta meta() {
    return CurveGroupId.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(CurveGroupId.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The cached hash code, using the racy single-check idiom.
   */
  private int cachedHashCode;

  private CurveGroupId(
      CurveGroupName curveGroupName,
      ObservableSource observableSource) {
    JodaBeanUtils.notNull(curveGroupName, "curveGroupName");
    JodaBeanUtils.notNull(observableSource, "observableSource");
    this.curveGroupName = curveGroupName;
    this.observableSource = observableSource;
  }

  @Override
  public CurveGroupId.Meta metaBean() {
    return CurveGroupId.Meta.INSTANCE;
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
   * Gets the curve group name.
   * @return the value of the property, not null
   */
  public CurveGroupName getCurveGroupName() {
    return curveGroupName;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the source of observable market data.
   * @return the value of the property, not null
   */
  public ObservableSource getObservableSource() {
    return observableSource;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      CurveGroupId other = (CurveGroupId) obj;
      return JodaBeanUtils.equal(curveGroupName, other.curveGroupName) &&
          JodaBeanUtils.equal(observableSource, other.observableSource);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = cachedHashCode;
    if (hash == 0) {
      hash = getClass().hashCode();
      hash = hash * 31 + JodaBeanUtils.hashCode(curveGroupName);
      hash = hash * 31 + JodaBeanUtils.hashCode(observableSource);
      cachedHashCode = hash;
    }
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("CurveGroupId{");
    buf.append("curveGroupName").append('=').append(curveGroupName).append(',').append(' ');
    buf.append("observableSource").append('=').append(JodaBeanUtils.toString(observableSource));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code CurveGroupId}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code curveGroupName} property.
     */
    private final MetaProperty<CurveGroupName> curveGroupName = DirectMetaProperty.ofImmutable(
        this, "curveGroupName", CurveGroupId.class, CurveGroupName.class);
    /**
     * The meta-property for the {@code observableSource} property.
     */
    private final MetaProperty<ObservableSource> observableSource = DirectMetaProperty.ofImmutable(
        this, "observableSource", CurveGroupId.class, ObservableSource.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "curveGroupName",
        "observableSource");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -382645893:  // curveGroupName
          return curveGroupName;
        case 1793526590:  // observableSource
          return observableSource;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends CurveGroupId> builder() {
      return new CurveGroupId.Builder();
    }

    @Override
    public Class<? extends CurveGroupId> beanType() {
      return CurveGroupId.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code curveGroupName} property.
     * @return the meta-property, not null
     */
    public MetaProperty<CurveGroupName> curveGroupName() {
      return curveGroupName;
    }

    /**
     * The meta-property for the {@code observableSource} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ObservableSource> observableSource() {
      return observableSource;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -382645893:  // curveGroupName
          return ((CurveGroupId) bean).getCurveGroupName();
        case 1793526590:  // observableSource
          return ((CurveGroupId) bean).getObservableSource();
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
   * The bean-builder for {@code CurveGroupId}.
   */
  private static final class Builder extends DirectPrivateBeanBuilder<CurveGroupId> {

    private CurveGroupName curveGroupName;
    private ObservableSource observableSource;

    /**
     * Restricted constructor.
     */
    private Builder() {
      super(meta());
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -382645893:  // curveGroupName
          return curveGroupName;
        case 1793526590:  // observableSource
          return observableSource;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -382645893:  // curveGroupName
          this.curveGroupName = (CurveGroupName) newValue;
          break;
        case 1793526590:  // observableSource
          this.observableSource = (ObservableSource) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public CurveGroupId build() {
      return new CurveGroupId(
          curveGroupName,
          observableSource);
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(96);
      buf.append("CurveGroupId.Builder{");
      buf.append("curveGroupName").append('=').append(JodaBeanUtils.toString(curveGroupName)).append(',').append(' ');
      buf.append("observableSource").append('=').append(JodaBeanUtils.toString(observableSource));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
