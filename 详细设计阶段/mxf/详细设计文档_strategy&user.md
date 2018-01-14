#详细设计文档#

##strategy模块，user模块
---------------------------
         
#### 4.1.4 strategyBL模块 ####

---

#### （1）模块概述 ####
 strategyBL模块承担的需求，及职责和接口如下：

    1. 需求：负责制定销售策略，实现对销售策略的增删改查等操作。
    2. 职责：负责实现销售策略界面所需要的服务
    3. 接口： strategyBLService && strategyDataService（详见体系结构文档）


#### （2）整体结构  ####
strategyBL模块设计如图：


| **类**              |                  **职责**                  |
| ------------------ | :--------------------------------------: |
| strategyList       |          负责维护系统中的策略列表，功能有增删改查等           |
| strategyController | 负责实现strategyBLService 接口，并作为控制器，分配职责，控制协作 |


#### （3）模块内部类的接口规范 ####

**StrategyController 类的接口：**

**供接口：**

| **StrategyController.createStrategy**|                                      |
| -------------------------------     | ------------------------------------ |
| 语法                               | public String createStrategy(StrategyVO newer) |                   
| 前置条件                            | strategyList 已经创建                    |
| 后置条件                            | 调用strategyList里的createStrategy方法                
| **StrategyController.updateStrategy** |                                      |
| 语法                               | public boolean updateStrategy(StrategyVO newSrtategy)   
| 前置条件                            | strategyList 已经创建                    |
| 后置条件                            | 调用strategyList里的updateStrategy方法             |
| **StrategyController.deleteStrategy**  |                                      |
| 语法                               | public boolean deleteStrategy(String id)   |
| 前置条件                            | strategyList 已经创建                    |
| 后置条件                            | 调用strategyList里的deleteStrategy方法             |
| **StrategyController.searchStrategy**   |                                      |
| 语法                               | public StrategyVO searchStrategy(String id) |
| 前置条件                            | strategyList 已经创建                    |
| 后置条件                                  | 调用strategyList里的searchStrategy方法   |
| **StrategyController.getAllStrategy**   |                                      |
| 语法                               | public ArrayList<StrategyVO> getAllStrategy()  |
| 前置条件                            | strategyList 已经创建                    |
| 后置条件                                  | 调用strategyList里的getAllStrategy方法 

**需接口：**

| 服务名                     | 服务                     |
| -------------------------- | ---------------------- |
| strategyList.createStrategy| 增加一个新的销售策略,返回ID            |
| strategyList.updateStrategy | 编辑一个销售策略的信息            |
| strategyList.deleteStrategy | 删除一个已有的销售策略            |
| strategyList.searchStrategy | 根据一个销售策略的ID查看销售策略的详细信息 |
| strategyList.getAllStrategy| 得到所有的销售策略          |
  


**StrategyList 类的接口：**

**供接口：**

| **StrategyList..createStrategy**    |                                          |
| -----------------------             | ---------------------------------------- |
| 语法                               | public String createStrategy(strategyVO s)  |
| 前置条件                           | strategyDataService已经被创建                 |
| 后置条件                          | 调用strategyDataService里的createStrategy方法                         |
| **StrategyList.updateStrategy** |                                          |
| 语法                              | public boolean updateStrategy(StrategyVO newSrtategy)     |
| 前置条件                          | strategyDataService已经被创建                 |
| 后置条件                          | 调用strategyDataService里的updateStrategy方法          |
| **StrategyList.deleteStrategy** |                                          |
| 语法                             | public boolean deleteStrategy(String ID)      |
| 前置条件                         | strategyDataService已经被创建                 |
| 后置条件                         | 调用strategyDataService里的deleteStrategy方法          |
| **StrategyList.searchStrategy** |                                          |
| 语法                             | public ArrayList<strategyVO> searchStrategy(String ID) |
| 前置条件                         | strategyDataService已经被创建                 |
| 后置条件                          | 调用strategyDataService里的searchStrategy方法          |
| **StrategyList.getAllStrategy**   |                                      |
| 语法                               | public ArrayList<StrategyVO> getAllStrategy()  |
| 前置条件                            | strategyDataService已经被创建                  |
| 后置条件                            | 调用strategyDataService里的getAllStrategy方法   


**需接口：**

| 服务名                        | 服务                     |
| -------------------------- | ---------------------- |
| strategyDataService.createStrategy| 增加一个新的销售策略,返回ID            |
| strategyDataService.updateStrategy | 编辑一个销售策略的信息            |
| strategyDataService.deleteStrategy | 删除一个已有的销售策略            |
| strategyDataService.searchStrategy | 根据一个销售策略的ID查看销售策略的详细信息 |
| strategyDataService.getAllStrategy| 得到所有的销售策略          |



#### 4.1.5 userBL模块 ####

---

#### （1）模块概述 ####

   userBL模块承担的需求参见需求规格说明文档功能需求及相关非功能需求
   userBL模块的职责及接口参见体系结构文档


#### （2）整体结构  ####
userBL模块设计如图：




| **类**          |                **职责**                 |
| -------------- | :-----------------------------------: |
| userController | 负责实现userBLService 接口，并作为控制器，分配职责，控制协作 |
| userList       |            负责维护系统中的用户信息列表             |
| user           |   系统用户的领域模型对象，拥有用户数据的id与密码，可以解决登录问题   |


#### （3）模块内部类的接口规范 ####

**userController 类的接口：**

**供接口：**

|**userController.login**||
|------|------|
|语法         |public UserVO login(String id, String password)|
|前置条件     |userList已经被创建| 
|后置条件    | 调用userList的login方法 |
|**userController.addUser**     |                    |
|语法         |public boolean addUser(UserVO newer)  |
|前置条件      |userList已经被创建                    |
|后置条件      |调用userList中的addUser方法           |
|**userController.deleteUser**     |                    |
|语法         |public boolean deleteUser(String id)  |
|前置条件      |userList已经被创建                    |
|后置条件      |调用userList中的deleteUser方法           |
|**userController.updateUser**     |                    |
|语法         |public boolean updateUser(UserVO newer)  |
|前置条件      |userList已经被创建                    |
|后置条件      |调用userList中的updateUser方法           |
|**userController.getUserById**     |                    |
|语法         |public User getUserByID(String id) |
|前置条件      |userList已经被创建                    |
|后置条件      |调用userList中的getUserById方法           |
|**userController.searchUserByRole**     |                    |
|语法         |public ArrayList<UserVO> searchUserByRole(RoleOfUser role)  |
|前置条件      |userList已经被创建                    |
|后置条件      |调用userList中的searchUserByRole方法           |

**需接口：**

| 服务名                     | 服务                         |
| ----------------------- | --------------------------     |
|userList.login    | 根据ID查找是否存在相应的用户，根据输入的password返回登录验证的结果，如果通过验证，则记录当前用户。
|userList.addUser    |添加一个新用户
|userList.deleteUser    |删除一个已有的用户
|userList.updateUser    |修改用户的信息
|userList.getUserByID    |根据id查找用户信息
|userList.searchUserByRole |根据用户身份，查找某一身份的所有用户|


**userList类的接口**

**供接口**

|**userList.login**|     |
|------       |------|
|语法         |public User login(String id, String password)|
|前置条件     |userDataService 已经被创建
| 后置条件    | 调用userDataService的login方法 |
|**userList.addUser**  |                    |
|语法         |public boolean addUser(UserVO newer)  |
|前置条件      |userDataService 已经被创建                    |
|后置条件      |调用userDataService中的addUser方法           |
|**userList.deleteUser**     |                    |
|语法         |public boolean deleteUser(String id)  |
|前置条件      |userDataService 已经被创建                    |
|后置条件      |调用userDataService中的deleteUser方法           |
|**userList.updateUser**     |                    |
|语法         |public boolean updateUser(UserVO newer)  |
|前置条件      |userDataService 已经被创建                    |
|后置条件      |调用userDataService中的updateUser方法           |
|**userList.getUserById**     |                    |
|语法         |public User getUserByID(String id) |
|前置条件      |userDataService 已经被创建                    |
|后置条件      |调用userDataService中的getUserById方法           |
|**userList.searchUserByRole**     |                    |
|语法         |public ArrayList<UserVO> searchUserByRole(RoleOfUser role)  |
|前置条件      |userDataService 已经被创建                    |
|后置条件      |调用userDataService中的searchUserByRole方法           |




**需接口：**

| 服务名                     | 服务                         |
| ----------------------- | --------------------------     |
|userDataService.login    | 根据ID查找是否存在相应的用户，根据输入的password返回登录验证的结果，如果通过验证，则记录当前用户。|
|userDataService.addUser    |添加一个新用户                 |
|userDataService.deleteUser    |删除一个已有的用户           |
|userDataService.updateUser    |修改用户的信息              |
|userDataService.getUserByID    |根据id查找用户信息。        |
|userDataService.searchUserByRole |根据用户身份，查找相关用户|

