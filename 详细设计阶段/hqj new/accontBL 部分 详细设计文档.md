#### 4.1.7 AccountBL模块 ####
---

#### （1）模块概述 ####
 AccountBL模块承担的需求，及职责和接口如下：

    1. 需求：账户管理（增、删、改、查）
    2. 职责：负责实现账户管理界面所需要的服务
    3. 接口： AccountBLService && AccountDataService

#### （2）整体结构  ####

AccountBL模块设计如图：
![AccountBL 模块设计图](.\AccountBL 模块设计图.png)


| **类**             |                  **职责**                  |
| ----------------- | :--------------------------------------: |
| Account           |                 是顾客的实体类                  |
| AccountManage         |          负责维护系统中的账户，功能有增删改查等           |
| AccountController | 负责实现AccountBLService 接口，并作为控制器，分配职责，控制协作 |


| **接口** | 操作方法 | 职责   |
| ------ | ---- | ---- |
|        |      |      |
|        |      |      |

#### （3）模块内部类的接口规范 ####

**AccountController 类的接口：**


| 供接口                                  |                                          |      |
| ------------------------------------ | ---------------------------------------- | ---- |
|                                      |                                          |      |
| **AccountController.newAccount**            |                                          |      |
| 语法                                   | public boolean newAccount(AccountVO newAccount) |      |
| 前置条件                                 | 已创建一个AccountBL领域对象，并且输入符合规则              |      |
| 后置条件                                 | 调用AccountBL里的newAccount方法顺序图：                |      |
| **AccountController.getAccountList** |                                          |      |
| 语法                                   | public ArrayList<AccountVO> getAccountList() |      |
| 前置条件                                 | 已创建一个AccountBL领域对象，并且输入符合规则              |      |
| 后置条件                                 | 调用AccountBL里的getAccountList方法            |      |
| **AccountController.getAccount**     |                                          |      |
| 语法                                   | public AccountVO getAccount(String id) |      |
| 前置条件                                 | 已创建一个AccountBL领域对象，并且输入符合规则              |      |
| 后置条件                                 | 调用AccountBL里的getAccount方法                |      |
| **AccountController.searchAccount**     |                                          |      |
| 语法                                   | public ArrayList<AccountVO> searchAccount(KeyForSearchAccount key) |      |
| 前置条件                                 | 已创建一个AccountBL领域对象，并且输入符合规则              |      |
| 后置条件                                 | 调用AccountBL里的searchAccount方法         |      |
| **AccountController.editAccount**         |                                          |      |
| 语法                                   | public boolean editAccount(AccountVO newAccount) |      |
| 前置条件                                 | 已创建一个AccountBL领域对象，并且输入符合规则              |      |
| 后置条件                                 | 调用AccountBL里的editAccount方法             |      |
| **AccountController.deleteAccount**         |                                          |      |
| 语法                                   | public boolean deleteAccount(String id) |      |
| 前置条件                                 | 已创建一个AccountBL领域对象，并且输入符合规则              |      |
| 后置条件                                 | 调用AccountBL里的deleteAccount方法             |      |
| **AccountController.changeMoney**         |                                          |      |
| 语法                                   | public boolean changeMoney(String id, double money) |      |
| 前置条件                                 | 已创建一个AccountBL领域对象，并且输入符合规则              |      |
| 后置条件                                 | 调用AccountBL里的changeMoney方法             |      |

| **需接口**                         |      |            |
| ------------------------------- | ---- | ---------- |
| 服务名                             |      | 服务         |
| **accountBL.getAccountList**    |      | 获得所有账户对象列表 |
| **accountBL.getAccount**        |      | 获得指定账户对象   |
| **accountBL.searchAccountList** |      | 获得相关账户对象列表 |
| **accountBL.newAccount**        |      | 新增一个账户对象   |
| **accountBL.editAccount**     |      | 修改一个账户对象   |
| **accountBL.deleteAccount**     |      | 删除一个账户对象   |
| **accountBL.changeMoney**     |      | 修改一个账户对象的金额  |


**AccountBL 类的接口：**


| 供接口                          |                                          |      |
| ---------------------------- | ---------------------------------------- | ---- |
|                              |                                          |      |
| **AccountBL.newAccount**     |                                          |      |
| 语法                           | public boolean newAccount(AccountVO newAccount) |      |
| 前置条件                         | 已创建一个AccountDataService领域对象，并且输入符合规则     |      |
| 后置条件                         | 调用StockDataService里的addAccount方法         |      |
| **AccountBL.getAccountList** |                                          |      |
| 语法                           | public ArrayList<AccountVO> getAccountList() |      |
| 前置条件                         | 已创建一个AccountDataService领域对象，并且输入符合规则     |      |
| 后置条件                         | 调用AccountDataService里的searchAccount方法   |      |
| **AccountBL.getAccount**     |                                          |      |
| 语法                           | public AccountVO getAccount(String id) |      |
| 前置条件                         | 已创建一个AccountDataService领域对象，并且输入符合规则     |      |
| 后置条件                         | 调用AccountDataService里的getAccount方法       |      |
| **AccountBL.editAccount**  |                                          |      |
| 语法                           | public boolean editAccount(AccountVO newAccount) |      |
| 前置条件                         | 已创建一个AccountDataService领域对象，并且输入符合规则     |      |
| 后置条件                         | 调用AccountDataService里的editAccount方法    |      |
| **AccountBL.deleteAccount**  |                                          |      |
| 语法                           | public boolean delete(String id) |      |
| 前置条件                         | 已创建一个AccountDataService领域对象，并且输入符合规则     |      |
| 后置条件                         | 调用AccountDataService里的deleteAccount方法    |      |

| **需接口**                               |      |          |
| ------------------------------------- | ---- | -------- |
| 服务名                                   |      | 服务       |
| **accountDataService.searchAccount** |      | 获得账户对象列表 |
| **accountDataService.getAccount**     |      | 获得账户对象   |
| **accountDataService.addAccount**     |      | 新增一个账户对象 |
| **accountDataService.editAccount**  |      | 修改一个账户对象 |
| **accountDataService.deleteAccount**  |      | 删除一个账户对象 |


#### （4）业务逻辑层的动态模型 ####

AccountBL顺序图：
![AccountBL 顺序图](.\AccountBL 顺序图.png)
AccountBL状态图：
![AccountBL 状态图](.\AccountBL 状态图.png)
#### （5）业务逻辑层的设计原理 ####

## 5.依赖视角 ##
客户端和服务器端的开发包图