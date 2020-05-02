/*
 * Copyright 2020 The Catty Project
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pink.catty.core.meta;

import pink.catty.core.service.ServiceMeta;

public class ConsumerMeta extends ClientMeta {

  private static final int DEFAULT_HEALTH_CHECK_PERIOD = 10 * 1000;

  private String version;
  private String group;
  private String serviceName;
  private int healthCheckPeriod = DEFAULT_HEALTH_CHECK_PERIOD;
  private transient ServiceMeta serviceMeta;

  public ConsumerMeta() {
    super(MetaType.CONSUMER);
  }

  protected ConsumerMeta(MetaType metaType) {
    super(metaType);
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public int getHealthCheckPeriod() {
    return healthCheckPeriod;
  }

  public void setHealthCheckPeriod(int healthCheckPeriod) {
    this.healthCheckPeriod = healthCheckPeriod;
  }

  public ServiceMeta getServiceMeta() {
    return serviceMeta;
  }

  public void setServiceMeta(ServiceMeta serviceMeta) {
    this.serviceMeta = serviceMeta;
  }
}