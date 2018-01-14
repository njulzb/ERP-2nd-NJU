##### 5.2.3.1 CustomerData模块

###### （1）模块概述

CustomerData模块承担客户的数据需求，主要是对顾客信息的增删改查。详见需求规格说明文档<br/>模块的职责是提供对顾客数据的增删改查操作，以及这些数据的序列化保存。<br/>接口部分详见体系结构设计文档。<br/><br/>

###### （2）整体结构

该模块需要实现DataService层的CustomerDataService，通过CustomerBL类完成数据操作，CustomerDataController类实现了隔离数据逻辑职责与逻辑控制职责。与Bl层通过CustomerPO通信。customerSqlHelper记录了所有的顾客信息条目，并提供这些信息条目的增删改操作。<br/><br/>**设计如图所示**<br/><br/>**各个类的职责**<br/>

| 模块                     | 职责                                       |
| ---------------------- | ---------------------------------------- |
| CustomerDataController | 负责实现DataService层的CustomerDataService，通过CustomerBL类完成数据操作 |
| CustomerSqlHelper      | 库存类单据的集合，持有所有库存类单据，同时负责增删改查与序列化读写。是data层的核心类 |

<br/>

###### （3）模块内部类的接口规范

<br/>

**CustomerController供需接口：**<br/>

| 供接口                                      |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
|                                          |      |                                          |
| **CustomerController.getCustomer**       | 语法   | public CustomerPO getCustomer(String id) |
|                                          | 前置条件 | 已创建一个Customer领域对象，并且输入符合规则               |
|                                          | 后置条件 | 调用CustomerData的getCustomer方法             |
| **CustomerController.addCustomer**       | 语法   | public boolean addCustomer(CustomerPO toPush) |
|                                          | 前置条件 | 已创建一个Customer领域对象，并且输入符合规则               |
|                                          | 后置条件 | 调用CustomerData的addCustomer方法             |
| **CustomerController.modifyCustomer**    | 语法   | public boolean modifyCustomer(CustomerPO toPush) |
|                                          | 前置条件 | 已创建一个Customer领域对象，并且输入符合规则               |
|                                          | 后置条件 | 调用CustomerData的modifyCustomer方法          |
| **CustomerController.deleteCustomer**    | 语法   | public boolean deleteCustomer(CustomerPO toPush) |
|                                          | 前置条件 | 已创建一个Customer领域对象，并且输入符合规则               |
|                                          | 后置条件 | 调用CustomerData的deleteCustomer方法          |
| **CustomerController.searchCustomerList** | 语法   | public boolean searchCustomerList(String idOrName) |
|                                          | 前置条件 | 已创建一个Customer领域对象，并且输入符合规则               |
|                                          | 后置条件 | 调用CustomerData的searchCustomerList方法      |
| **CustomerController.getCustomerList**   | 语法   | public customerPO getCustomerList()      |
|                                          | 前置条件 | 已创建一个Customer领域对象                        |
|                                          | 后置条件 | 调用CustomerData的getCustomerList方法         |
| **需接口**                                  |      |                                          |
| 服务名                                      |      | 服务                                       |
| **CustomerList.getCustomer**             |      | 获取一个顾客信息                                 |
| **CustomerList.addCustomer**             |      | 添加一个顾客信息                                 |
| **CustomerList.modifyCustomer**          |      | 编辑一个顾客信息                                 |
| **CustomerList.deleteCustomer**          |      | 删除一个顾客信息                                 |
| **CustomerList.searchCustomer**          |      | 搜索得到所有符合条件的顾客信息                          |
| **CustomerList.getCustomerList**         |      | 获取一份客户数据表                                |

<br/><br/><br/>

**CustomerBL供需接口：**

<br/>

| 供接口                                 |      |                                          |
| ----------------------------------- | ---- | ---------------------------------------- |
|                                     |      |                                          |
| **CustomerBL.getForm**              | 语法   | public CustomerPO getCustomer(String id) |
|                                     | 前置条件 | 已创建一个Customer领域对象，并且输入符合规则               |
|                                     | 后置条件 | 调用CustomerBL的getCustomer方法               |
| **CustomerBL.addForm**              | 语法   | public boolean addCustomer(CustomerPO toPush) |
|                                     | 前置条件 | 已创建一个Customer领域对象，并且输入符合规则               |
|                                     | 后置条件 | 调用CustomerBL的addCustomer方法               |
| **CustomerList.modifyCustomer**     | 语法   | public boolean modifyCustomer(CustomerPO toPush) |
|                                     | 前置条件 | 已创建一个Customer领域对象，并且输入符合规则               |
|                                     | 后置条件 | 调用CustomerList的modifyCustomer方法          |
| **CustomerList.searchCustomerList** | 语法   | public boolean searchCustomerList(CustomerPO form) |
|                                     | 前置条件 | 已创建一个Customer领域对象，并且输入符合规则               |
|                                     | 后置条件 | 调用CustomerList的searchCustomerList方法      |
| **CustomerList.getCustomerList**    | 语法   | public customerPO getCustomerList()      |
|                                     | 前置条件 | 已创建一个Customer领域对象                        |
|                                     | 后置条件 | 调用CustomerList的getCustomerList方法         |
|                                     |      |                                          |
| **需接口**                             |      |                                          |
| 服务名                                 |      | 服务                                       |
| **customerData.getCustomerList**    |      | 获取一份客户清单                                 |
| **CustomerList.getCustomer**        |      | 获取一份客户信息                                 |
| **CustomerList.addCustomer**        |      | 添加一份客户信息                                 |
| **CustomerList.searchCustomer**     |      | 搜索得到所有符合条件的客户信息                          |
| **CustomerList.modifyCustomer**     |      | 修改一份客户信息                                 |

<br/>

###### （4）业务逻辑层的动态模型

<br/>

如图所示

<br/><br/>

###### （5）业务逻辑层的设计原理

利用委托式的设计风格，每种操作分派给不同的对象来完成。同时尽量减少通信次数，提高速度

<br/>



##### 5.2.4.1 AccountData模块

###### （1）模块概述

AccountData模块承担账户的数据需求，主要是对账户信息的增删改查。详见需求规格说明文档<br/>模块的职责是提供对账户数据的增删改查操作，以及这些数据的序列化保存。<br/>接口部分详见体系结构设计文档。<br/><br/>

###### （2）整体结构

该模块需要实现DataService层的AccountDataService，通过AccountBL类完成数据操作，AccountController类实现了隔离数据逻辑职责与逻辑控制职责。与Bl层通过AccountPO通信。accountList记录了所有的账户信息条目，并提供这些信息条目的增删改操作。account是账户信息，包含编号、分类、级别、姓名、电话、地址、邮编、电子邮箱、应收额度、应收、应付、默认业务员，并提供get与set方法。<br/><br/>**设计如图所示**<br/><br/>**各个类的职责**<br/>

| 模块                | 职责                                       |
| ----------------- | ---------------------------------------- |
| AccountController | 负责实现库存类单据界面与层间接口StockInfo对应的服务           |
| Account           | 库存类单据的领域模型对象，拥有一张库存类单据的编号、时间、账户、操作员、商品条目表信息，帮助库存类单据界面完成所需要的服务 |
| AccountList       | 库存类单据的集合，持有所有库存类单据，同时负责增删改查与序列化读写。是data层的核心类 |

<br/>

###### （3）模块内部类的接口规范

<br/>

**AccountController供需接口：**<br/>

| 供接口                                     |      |                                          |
| --------------------------------------- | ---- | ---------------------------------------- |
|                                         |      |                                          |
| **AccountController.getAccount**        | 语法   | public AccountPO getAccount(String id)   |
|                                         | 前置条件 | 已创建一个Account领域对象，并且输入符合规则                |
|                                         | 后置条件 | 调用AccountData的getAccount方法               |
| **AccountController.addAccount**        | 语法   | public boolean addAccount(AccountPO toPush) |
|                                         | 前置条件 | 已创建一个Account领域对象，并且输入符合规则                |
|                                         | 后置条件 | 调用AccountData的addAccount方法               |
| **AccountController.modifyAccount**     | 语法   | public boolean modifyAccount(AccountPO toPush) |
|                                         | 前置条件 | 已创建一个Account领域对象，并且输入符合规则                |
|                                         | 后置条件 | 调用AccountData的modifyAccount方法            |
| **AccountController.deleteAccount**     | 语法   | public boolean deleteAccount(AccountPO toPush) |
|                                         | 前置条件 | 已创建一个Account领域对象，并且输入符合规则                |
|                                         | 后置条件 | 调用AccountData的deleteAccount方法            |
| **AccountController.searchAccountList** | 语法   | public boolean searchAccountList(String idOrName) |
|                                         | 前置条件 | 已创建一个Account领域对象，并且输入符合规则                |
|                                         | 后置条件 | 调用AccountData的searchAccountList方法        |
| **AccountController.getAccountList**    | 语法   | public accountPO getAccountList()        |
|                                         | 前置条件 | 已创建一个Account领域对象                         |
|                                         | 后置条件 | 调用AccountData的getAccountList方法           |

| **需接口**                                 |      |                                          |
| 服务名                                     |      | 服务                                       |
| **AccountList.getAccount**               |      | 获取一个账户信息                                |
| **AccountList.addAccount**               |      | 添加一个账户信息                               |
| **AccountList.modifyAccount**            |      | 编辑一个账户信息                                |
| **AccountList.deleteAccount**            |      | 删除一个账户信息                                |
| **AccountList.searchAccount**            |      | 搜索得到所有符合条件的账户信息                         |
| **AccountList.getAccountList**       |      | 获取一份账户数据表                                |

<br/><br/><br/>

**AccountBL供需接口：**

<br/>

| 供接口                               |      |                                          |
| --------------------------------- | ---- | ---------------------------------------- |
|                                   |      |                                          |
| **AccountBL.getForm**             | 语法   | public AccountPO getAccount(String id)   |
|                                   | 前置条件 | 已创建一个Account领域对象，并且输入符合规则                |
|                                   | 后置条件 | 调用AccountBL的getAccount方法                 |
| **AccountBL.addForm**             | 语法   | public boolean addAccount(AccountPO toPush) |
|                                   | 前置条件 | 已创建一个Account领域对象，并且输入符合规则                |
|                                   | 后置条件 | 调用AccountBL的addAccount方法                 |
| **AccountList.modifyAccount**     | 语法   | public boolean modifyAccount(AccountPO toPush) |
|                                   | 前置条件 | 已创建一个Account领域对象，并且输入符合规则                |
|                                   | 后置条件 | 调用AccountList的modifyAccount方法            |
| **AccountList.searchAccountList** | 语法   | public boolean searchAccountList(AccountPO form) |
|                                   | 前置条件 | 已创建一个Account领域对象，并且输入符合规则                |
|                                   | 后置条件 | 调用AccountList的searchAccountList方法        |
| **AccountList.getAccountList**    | 语法   | public accountPO getAccountList()        |
|                                   | 前置条件 | 已创建一个Account领域对象                         |
|                                   | 后置条件 | 调用AccountList的getAccountList方法           |
|                                   |      |                                          |
| **需接口**                           |      |                                          |
| 服务名                               |      | 服务                                       |
| **accountData.getAccountList**    |      | 获取一份账户清单                                 |
| **AccountList.getAccount**        |      | 获取一份账户信息                                 |
| **AccountList.addAccount**        |      | 添加一份账户信息                                 |
| **AccountList.searchAccount**     |      | 搜索得到所有符合条件的账户信息                          |
| **AccountList.modifyAccount**     |      | 修改一份账户信息                                 |

<br/>

###### （4）业务逻辑层的动态模型

<br/>

如图所示

<br/><br/>

###### （5）业务逻辑层的设计原理

利用委托式的设计风格，每种操作分派给不同的对象来完成。同时尽量减少通信次数，提高速度

<br/>