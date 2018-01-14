
#### 4.1.6 CustomerBL模块 ####
---

#### （1）模块概述 ####
 CustomerBL模块承担的需求，及职责和接口如下：

    1. 需求：顾客管理（增、删、改、查）
    2. 职责：负责实现顾客管理界面所需要的服务
    3. 接口： CustomerBLService && CustomerDataService

#### （2）整体结构  ####
该模块需要实现BLService层的CustomerBLService，通过CustomerBL类完成数据操作，CustomerBLController类实现了隔离数据逻辑职责与逻辑控制职责。与Bl层通过CustomerPO通信,与界面通过CustomerVO通信。customerBL 负责维护系统中的顾客，并提供这些信息条目的增删改操作。<br/><br/>**设计如图所示**<br/><br/>**各个类的职责**<br/>
CustomerBL模块设计如图：
![customerBL 模块设计图 ](.\customerBL 模块设计图 .png)


| **类**              |                  **职责**                  |
| ------------------ | :--------------------------------------: |
| Customer           |                 是顾客的实体类                  |
| CustomerBL         |           负责维护系统中的顾客，功能有增删改查等            |
| CustomerController | 负责实现CustomerBLService 接口，并作为控制器，分配职责，控制协作 |


| **接口** | 操作方法 | 职责   |
| ------ | ---- | ---- |
|        |      |      |
|        |      |      |

#### （3）模块内部类的接口规范 ####

**CustomerController 类的接口：**


| 供接口                                      |                                          |      |
| ---------------------------------------- | ---------------------------------------- | ---- |
|                                          |                                          |      |
| **CustomerController.addCustomer**       |                                          |      |
| 语法                                       | public boolean addCustomer(CustomerVO newCustomer) |      |
| 前置条件                                     | 已创建一个CustomerBL领域对象，并且输入符合规则             |      |
| 后置条件                                     | 调用CustomerBL里的addCustomer方法              |      |
| **CustomerController.getCustomerList**   |                                          |      |
| 语法                                       | public ArrayList<CustomerVO> getCustomerList() && ArrayList<CustomerVO> getCustomerList(KeyForSearchCustomer key) |      |
| 前置条件                                     | 已创建一个CustomerBL领域对象，并且输入符合规则             |      |
| 后置条件                                     | 调用CustomerBL里的getCustomerList方法          |      |
| **CustomerController.getCustomer**       |                                          |      |
| 语法                                       | public CustomerVO getCustomer(String id) |      |
| 前置条件                                     | 已创建一个CustomerBL领域对象，并且输入符合规则             |      |
| 后置条件                                     | 调用CustomerBL里的getCustomer方法              |      |
| **CustomerController.modifyCustomer**    |                                          |      |
| 语法                                       | public boolean modifyCustomer(CustomerVO newCustomer) |      |
| 前置条件                                     | 已创建一个CustomerBL领域对象，并且输入符合规则             |      |
| 后置条件                                     | 调用CustomerBL里的modifyCustomer方法           |      |
| **CustomerController.deleteCustomer**    |                                          |      |
| 语法                                       | public boolean deleteCustomer(CustomerVO newCustomer) |      |
| 前置条件                                     | 已创建一个CustomerBL领域对象，并且输入符合规则             |      |
| 后置条件                                     | 调用CustomerBL里的deleteCustomer方法           |      |
| **CustomerController.modifyReceiveAmount** |                                          |      |
| 语法                                       | public boolean modifyReceiveAmount(String id, double receiveAmount) |      |
| 前置条件                                     | 已创建一个CustomerBL领域对象，并且输入符合规则             |      |
| 后置条件                                     | 调用CustomerBL里的modifyReceiveAmount方法      |      |
| **CustomerController.modifyPayAmount**   |                                          |      |
| 语法                                       | public boolean modifyPayAmount(String id, double PayAmount) |      |
| 前置条件                                     | 已创建一个CustomerBL领域对象，并且输入符合规则             |      |
| 后置条件                                     | 调用CustomerBL里的modifyPayAmount方法          |      |
| **CustomerController.getCustomerByID**   |                                          |      |
| 语法                                       | public Customer getCustomerByID(String id) |      |
| 前置条件                                     | 已创建一个CustomerBL领域对象，并且输入符合规则             |      |
| 后置条件                                     | 调用CustomerBL里的getCustomerByID方法          |      |



| **需接口**                            |      |             |
| ---------------------------------- | ---- | ----------- |
| 服务名                                |      | 服务          |
| **customerBL.getCustomerList**     |      | 获得所有客户对象列表  |
| **customerBL.getCustomer**         |      | 获得指定客户对象    |
| **customerBL.getCustomerByID**     |      | 获得指定客户对象    |
| **customerBL.addCustomer**         |      | 新增一个客户对象    |
| **customerBL.modifyCustomer**      |      | 修改一个客户对象    |
| **customerBL.deleteCustomer**      |      | 删除一个客户对象    |
| **customerBL.modifyReceiveAmount** |      | 修改一个客户对象的应收 |
| **customerBL.modifyPayAmount**     |      | 修改一个客户对象的应付 |


**CustomerBL 类的接口：**


| 供接口                                |                                          |      |
| ---------------------------------- | ---------------------------------------- | ---- |
|                                    |                                          |      |
| **CustomerBL.addCustomer**         |                                          |      |
| 语法                                 | public boolean addCustomer(CustomerVO newCustomer) |      |
| 前置条件                               | 已创建一个CustomerDataService领域对象，并且输入符合规则    |      |
| 后置条件                               | 调用StockDataService里的addCustomer方法        |      |
| **CustomerBL.getCustomerList**     |                                          |      |
| 语法                                 | public ArrayList<CustomerVO> getCustomerList(KeyForSearchCustomer key) |      |
| 前置条件                               | 已创建一个CustomerDataService领域对象，并且输入符合规则    |      |
| 后置条件                               | searchCustomer调用CustomerDataService里的searchCustomer方法 |      |
| **CustomerBL.getCustomer**         |                                          |      |
| 语法                                 | public CustomerVO getCustomer(String id) |      |
| 前置条件                               | 已创建一个CustomerDataService领域对象，并且输入符合规则    |      |
| 后置条件                               | 调用CustomerDataService里的getCustomer方法     |      |
| **CustomerBL.getCustomerByID**     |                                          |      |
| 语法                                 | public Customer getCustomerByID(String id) |      |
| 前置条件                               | 已创建一个CustomerDataService领域对象，并且输入符合规则    |      |
| 后置条件                               | 调用CustomerDataService里的getCustomer方法     |      |
| **CustomerBL.modifyCustomer**      |                                          |      |
| 语法                                 | public boolean modifyCustomer(CustomerVO newCustomer) |      |
| 前置条件                               | 已创建一个CustomerDataService领域对象，并且输入符合规则    |      |
| 后置条件                               | 调用CustomerDataService里的modifyCustomer方法  |      |
| **CustomerBL.deleteCustomer**      |                                          |      |
| 语法                                 | public boolean delete(String id)         |      |
| 前置条件                               | 已创建一个CustomerDataService领域对象，并且输入符合规则    |      |
| 后置条件                               | 调用CustomerDataService里的deleteCustomer方法  |      |
| **CustomerBL.modifyReceiveAmount** |                                          |      |
| 语法                                 | public boolean modifyReceiveAmount(String id, double receiveAmount) |      |
| 前置条件                               | 已创建一个CustomerDataService领域对象，并且输入符合规则    |      |
| 后置条件                               | 调用CustomerDataService里的modifyCustomer方法  |      |
| **CustomerBL.modifyPayAmount**     |                                          |      |
| 语法                                 | public boolean modifyPayAmount(String id, double PayAmount) |      |
| 前置条件                               | 已创建一个CustomerDataService领域对象，并且输入符合规则    |      |
| 后置条件                               | 调用CustomerDataService里的modifyCustomer方法  |      |

| **需接口**                                |      |              |
| -------------------------------------- | ---- | ------------ |
| 服务名                                    |      | 服务           |
| **customerDataService.searchCustomer** |      | 搜索相应条件客户对象列表 |
| **customerDataService.getCustomer**    |      | 获得客户对象       |
| **customerDataService.addCustomer**    |      | 新增一个客户对象     |
| **customerDataService.modifyCustomer** |      | 修改一个客户对象     |
| **customerDataService.deleteCustomer** |      | 删除一个客户对象     |


#### （4）业务逻辑层的动态模型 ####
CustomerBL顺序图：
![customerBL 顺序图](.\customerBL 顺序图.png)

CustomerBL状态图：
![customerBL  状态图](.\customerBL 状态图 .png)

#### （5）业务逻辑层的设计原理 ####
